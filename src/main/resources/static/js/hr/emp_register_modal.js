/**
 * emp_register_modal.js - 사원 등록 모달 관리
 */
document.addEventListener("DOMContentLoaded", function () {
    fetchNewEmployeeId(); // 사원번호 자동 생성
    loadDepartmentList(); // 부서 목록 로드
    loadPositionList(); // 직급 목록 로드
});

// ✅ 사원번호 자동 생성
function fetchNewEmployeeId() {
    fetch("/hr/rest/emp/new-employee-id")
        .then(response => response.text())
        .then(data => {
            document.getElementById("employeeIdInput").value = data;
        })
        .catch(error => console.error("❌ 사원번호 생성 오류:", error));
}

// ✅ 부서 목록 불러오기 (DB에서 가져오기)
function loadDepartmentList() {
    fetch("/hr/rest/emp/departments")
        .then(response => response.json())
        .then(data => {
            const departmentSelect = document.getElementById("modalDepartment");
            departmentSelect.innerHTML = '<option value="">선택</option>';
            data.forEach(dept => {
                departmentSelect.innerHTML += `<option value="${dept.id}">${dept.name}</option>`;
            });
        })
        .catch(error => console.error("❌ 부서 목록 로딩 실패:", error));
}

// ✅ Daum 주소 API - 우편번호 검색
function openPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 사용자가 주소를 선택하면 실행되는 부분
            document.getElementById("zipcode").value = data.zonecode; // 우편번호 입력
            document.getElementById("address").value = data.roadAddress || data.jibunAddress; // 기본 주소 입력
            document.getElementById("addressDetail").focus(); // 상세주소 입력란 포커스
        }
    }).open();
}
