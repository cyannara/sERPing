const empBox = document.getElementById('emp-box')
const msgList = document.getElementById('msgList')
const sendBtn = document.getElementsByClassName('send-btn')[0]

let sessionEmployeeNum = document.getElementById("sessionEmployeeNum").value;
let roomId = 0

const sendMsg = () => {
    console.log(roomId)
    const textContent = document.getElementById('textarea').value
    console.log(textContent)
}

sendBtn.addEventListener('click', () => {
    sendMsg()
})

const startChat = (emp) => {
    const url = `/api/chat/start`
    fetch(url, {
        method: 'POST',
        headers: {
            'header': header_csrf,
            "Content-Type": "application/json",
            'X-CSRF-Token': token_csrf
        },
        body: JSON.stringify(emp)
    }).then((result) => {
        return result.json()
    }).then((data) => {
        roomId = Object.keys(data)[0]
        // Bootstrap의 탭 기능을 활용
        $(document).ready(function() {
            $('#room-tab').tab('show');
        });
        // 기존 채팅방이 있으면 대화 목록 들고 채팅방으로 이동
        // 채팅방이 없으면 새로 만들고 채팅방으로 이동
    })
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
            startChat(emp)
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
    }, 3000)
}
