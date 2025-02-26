const empBox = document.getElementById('emp-box')
const msgList = document.getElementById('msgList')
let sessionEmployeeNum = document.getElementById("sessionEmployeeNum").value;

msgList.addEventListener('click', function (event) {
    event.preventDefault(); // 기본 이벤트 차단 방지
    console.log("msgList 클릭됨!");
});

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
        console.log(data)

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
