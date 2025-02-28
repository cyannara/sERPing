const empBox = document.getElementById('emp-box')
const sendBtn = document.getElementsByClassName('send-btn')[0]
const chatContainer = document.getElementById("chatMessages");
const textarea = document.getElementById('textarea')
let sessionEmployeeNum = document.getElementById("sessionEmployeeNum").value;
let empList = document.getElementById("empList")

let sessionEmployeeName = document.getElementById("sessionEmployeeName").value;
let roomId = 0

const addMsg = (sentMsg) => {
    const messageDiv = document.createElement("div");
    let isSender = sentMsg.employeeNum === Number(sessionEmployeeNum)

    messageDiv.classList.add(
        "chat-message",
        `${isSender ? 'sent' : 'received'}`
    );

    messageDiv.innerHTML = `
                <span class="sender-name">${sentMsg.employeeName}</span>
                <div class="message-box ${isSender ? 'dark' : 'yellow'}">
                    ${sentMsg.msgContent}
                </div>
                <span class="message-time">${formatDateTime(new Date())}</span>
            `;

    chatContainer.appendChild(messageDiv);
    chatContainer.scrollTo({ top: chatContainer.scrollHeight, behavior: "smooth" });
}

const storeMsg = (msgContent, message) => {
    const url = '/api/chat/msg'
    const msg = {
        roomId,
        msgContent
    }
    fetch(url, {
        method: 'POST',
        headers: {
            'header': header_csrf,
            "Content-Type": "application/json",
            'X-CSRF-Token': token_csrf
        },
        body: JSON.stringify(msg)
    }).then((result) => {
        return result.json()
    }).then((data) => {
        if(Object.keys(data.data)[0]) {
            // 메세지를 서버로 보냄
            // 서버가 메세지를 받고 해당 메세지를 /topic/public 채널에 브로드캐스트
            // stompClient.subscribe() 실행됨
            stompClient.send(`/app/chat.sendMessage/${roomId}`, {}, JSON.stringify(message));
        }
    })
}

const sendMsg = () => {
    if (!stompClient || !stompClient.connected) {
        console.error("WebSocket is not connected yet.");
        return;
    }
    const msgContent = textarea.value
    // type: 'CHAT',
    let message = {
        sender: sessionEmployeeName,
        content: msgContent,
        senderEmpNum: sessionEmployeeNum,
    };

    storeMsg(msgContent, message)
    textarea.value = ''
}

sendBtn.addEventListener('click', () => {
    sendMsg()
})

textarea.addEventListener('keydown', (event) => {
    if (event.key === 'Enter' && !event.shiftKey) {  // Shift+Enter 제외
        event.preventDefault();  // 줄 바꿈 방지
        sendMsg();
    }
});

const showChats = (chats) => {
    let messages = chats.map((chat) => {
        return {
            sender: chat.employeeName,
            msgContent: chat.msgContent,
            sendDate: chat.sendDate,
            type: chat.employeeNum === Number(sessionEmployeeNum) ? 'sent' : 'received'
        }
    })

    chatContainer.innerHTML = ""

    messages.forEach(message => {
        const messageDiv = document.createElement("div");
        messageDiv.classList.add("chat-message", message.type);

        messageDiv.innerHTML = `
                <span class="sender-name">${message.sender}</span>
                <div class="message-box ${message.type === "received" ? "yellow" : "dark"}">
                    ${message.msgContent}
                </div>
                <span class="message-time">${formatDateTime(message.sendDate)}</span>
            `;

        chatContainer.appendChild(messageDiv);
    });
}

const openChatRoom = (employeeNum) => {
    const url = `/api/chat/start/${employeeNum}`
    fetch(url, {
        method: 'get',
        headers: {
            "Content-Type": "application/json",
        }
    }).then((result) => {
        return result.json()
    }).then((data) => {
        roomId = Object.keys(data)[0]

        stompClient.subscribe(`/topic/public/${roomId}`, function (message) {
            const parsedMsg = JSON.parse(message.body)
            addMsg({
                    employeeName: parsedMsg.sender,
                    msgContent: parsedMsg.content,
                    employeeNum: parsedMsg.senderEmpNum
                })
        });

        let chats = Object.values(data)[0]
        showChats(chats)

        // Bootstrap의 탭 기능을 활용
        $(document).ready(function() {
            let goback = document.getElementById("goback")
            $('#room-tab').tab('show');
            chatContainer.scrollTop = chatContainer.scrollHeight;
            empList.classList.add('hide')
            goback.classList.add('show')
            empList.classList.remove('show')
            goback.classList.remove('hide')


            goback.addEventListener('click', () => {
                console.log(goback)
                $(document).ready(function() {
                    $('#todo-tab').tab('show');
                    empList.classList.add('show')
                    empList.classList.remove('hide')
                    goback.classList.add('hide')
                    goback.classList.remove('show')
                });
            })
        });
    })
}

const startChat = (employeeNum) => {
    let socket = new SockJS('/ws');

    stompClient = Stomp.over(socket);
    stompClient.debug = null;
    stompClient.connect({}, function () {
        stompClient.send(
            `/app/chat.addUser/${roomId}`,
            {},
            JSON.stringify({sender: sessionEmployeeName})
        );
        openChatRoom(employeeNum)
    }, function (error) {
        console.error("WebSocket 연결 실패:", error);
    });
}


const setEmpList = (empList) => {
    empBox.innerHTML = "";
    empList.forEach((emp, idx) => {
        const div = document.createElement("div");
        div.classList.add("emp-item"); // 스타일을 위해 클래스 추가

        if(idx === 0) {
            div.classList.add("me");
        }

        // 이미지 태그 생성
        const img = document.createElement("img");
        img.src = emp.profileImage || '/file/image/mypage/profile/noProfileImg.jpg';

        // when emp.profileImage has a value but no image existed
        img.onerror = function () {
            this.onerror = null; // 무한 루프 방지
            this.src = "/file/image/mypage/profile/noProfileImg.jpg";
        };

        img.alt = emp.employeeName;

        // 이름 태그 생성
        const span = document.createElement("span");
        span.textContent = emp.employeeName;

        // div 내부에 이미지와 이름 추가
        div.appendChild(img);
        div.appendChild(span);

        // `empBox`에 추가
        empBox.appendChild(div);

        div.addEventListener('click', () => {
            startChat(emp.employeeNum)
        })
    });
}


const getEmpList = () => {
    const url = '/api/chat/employees'
    fetch(url, {
        method: 'get',
        headers: {
            "Content-Type": "application/json",
        },
    }).then((result) => {
        return result.json()
    }).then((data) => {
        // when no other employees in the same company
        if(!data.length) {
            return
        }
        const me = data.find(emp => emp.employeeNum === Number(sessionEmployeeNum))
        const notMe = data.filter(emp => emp.employeeNum !== Number(sessionEmployeeNum))

        const employees = [me, ...notMe]
        setEmpList(employees)
    })
}

if(sessionEmployeeNum) {
    getEmpList()
} else {
    showAlert('세션이 만료되었습니다. 다시 로그인해주세요.', 'danger')
    setTimeout(() => {
        window.location.href = "/login";
    }, 2000)
}
