/**
 * emp_register_modal.js - 사원 등록 모달 관리
 */

document.addEventListener("DOMContentLoaded", function () {
    applyCommonCodesToModal(); // 모달 공통 코드 적용
    setupEventListeners(); // 이벤트 리스너 연결
	
    // ✅ 초기화 버튼 이벤트 리스너 연결 (id 일치 확인)
    let resetBtn = document.getElementById("resetBtn");
    if (resetBtn) {
        resetBtn.addEventListener("click", resetEmployeeForm);
        console.log("✅ 초기화 버튼 이벤트 연결 완료");
    } else {
        console.error("❌ resetBtn을 찾을 수 없습니다.");
    }

    // ✅ 모달이 열릴 때마다 초기화
    let empRegisterModal = document.getElementById("empRegisterModal");
    if (empRegisterModal) {
        empRegisterModal.addEventListener("shown.bs.modal", resetEmployeeForm);
        console.log("✅ 모달 이벤트 리스너 연결 완료");
    } else {
        console.error("❌ empRegisterModal을 찾을 수 없습니다.");
    }
    
    
    // ✅ 등록 버튼 이벤트 리스너 추가
/*    let registerBtn = document.getElementById("registerEmployeeBtn");
    if (registerBtn) {
        registerBtn.addEventListener("click", function (event) {
            event.preventDefault(); // 기본 동작 방지

            Swal.fire({
                title: "📌 사원 등록",
                text: "정말 등록하시겠습니까?",
                icon: "warning",
                showCancelButton: true,
                confirmButtonText: "네, 등록합니다",
                cancelButtonText: "아니요, 취소",
            }).then((result) => {
                if (result.isConfirmed) {
                    registerEmployee(); // ✅ 사원 등록 처리 함수 호출
                    Swal.fire("✅ 등록 완료!", "사원이 성공적으로 등록되었습니다.", "success");
                } else {
                    Swal.fire("🚫 등록 취소", "사원 등록이 취소되었습니다.", "error");
                }
            });
        });
        console.log("✅ 등록 버튼 이벤트 리스너 연결 완료");
    } else {
        console.error("❌ registerEmployeeBtn 요소를 찾을 수 없습니다.");
    }*/
    
});


// ✅ 예금주 조회 기능
function checkAccountOwner() {
    const bankCode = document.getElementById("bankSelect").value;
    const accountNumber = document.getElementById("accountNumber").value;

    if (!bankCode || !accountNumber) {
        alert("⚠️ 은행 및 계좌번호를 입력하세요.");
        return;
    }

    fetch(`/api/iamport/account-holder?bankCode=${bankCode}&accountNumber=${accountNumber}`)
        .then(response => response.text())
        .then(data => {
            document.getElementById("accountHolderName").value = data;
        })
        .catch(error => console.error("❌ 예금주 조회 실패:", error));
}

// ✅ 모달 초기화 함수 (사원 등록 필드 초기화)
function resetEmployeeForm() {
    console.log("🟢 사원 등록 모달 초기화 실행됨");

    // 1️⃣ 모든 입력 필드 초기화
    document.querySelectorAll("#empRegisterModal input").forEach(input => {
        if (input.type === "text" || input.type === "email" || input.type === "number" || input.type === "date") {
            input.value = "";
        }
    });

    // 2️⃣ select 요소 초기화
    document.querySelectorAll("#empRegisterModal select").forEach(select => {
        select.selectedIndex = 0;
    });

    // 3️⃣ 라디오 버튼 초기화 (첫 번째 값으로 선택)
    let radioButtons = document.querySelectorAll("#empRegisterModal input[type='radio']");
    if (radioButtons.length > 0) {
        radioButtons[0].checked = true;
    }
    
    // 4️⃣ 하위 부서 초기화
    populateSubDepartments("");  // ✅ 하위 부서 필터링 함수 호출

    // 5️⃣ 메모 필드 초기화
    document.getElementById("memo").value = "";  // ✅ textarea는 수동 초기화 필요

    // 4️⃣ 프로필 이미지 기본 이미지로 변경
    let profilePreview = document.getElementById("profilePreview");
    if (profilePreview) {
        profilePreview.src = "https://ssl.pstatic.net/static/pwe/address/img_profile.png";
    }

    // 5️⃣ 예금주 필드 초기화
    let accountHolderName = document.getElementById("accountHolderName");
    if (accountHolderName) {
        accountHolderName.value = "";
    }

    // 6️⃣ 새 사원번호 가져오기
    fetchNewEmployeeId();

    console.log("✅ 초기화 완료");
}



// ✅ 이메일 입력 방식 초기화 함수
function initializeEmailInput() {
    let emailInput = document.getElementById("emailInput");
    let emailAt = document.getElementById("emailAt");
    let emailDomainSelect = document.getElementById("emailDomainSelect");

    if (!emailInput || !emailAt || !emailDomainSelect) {
        console.error("❌ 이메일 입력 요소가 존재하지 않습니다.");
        return;
    }

    emailDomainSelect.addEventListener("change", function () {
        let selectedValue = emailDomainSelect.value;

        if (selectedValue === "custom") {
            // ✅ "직접 입력" 선택 시 전체 입력 가능하도록 설정
            emailAt.style.display = "none"; // @ 숨기기
            emailInput.placeholder = "이메일 주소 전체 입력"; // 힌트 제공
            emailInput.value = ""; // 기존 값 초기화
        } else {
            // ✅ 특정 도메인을 선택하면 아이디 + 도메인 형태로 변경
            emailAt.style.display = "inline"; // @ 보이기
            emailInput.placeholder = "아이디 입력"; // 힌트 변경

            if (selectedValue !== "") {
                emailInput.value = ""; // 아이디 부분만 입력 가능하게 초기화
            }
        }
    });
    
}



