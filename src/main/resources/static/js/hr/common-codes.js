/**
 * common-codes.
 */

 document.addEventListener("DOMContentLoaded", function () {
    loadCommonCodes();
});

// 공통 코드 데이터 불러오는 함수
function loadCommonCodes() {
    fetch('/hr/rest/emp/common-codes')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            if (!data || !data.departments) {
                console.error("No department data received.");
                return;
            }
            populateDepartmentSelect(data.departments);
            populatePositionSelect(data.positions || []);
            populateStatusButtons(data.statuses || []);
            populateEmploymentButtons(data.employmentTypes || []);
        })
        .catch(error => console.error("Error loading common codes:", error));
}

// 부서 목록 동적으로 추가
function populateDepartmentSelect(departments) {
    if (!Array.isArray(departments)) {
        console.error("Invalid department data:", departments);
        return;
    }

    const departmentSelect = document.getElementById('searchDepartment');
    departmentSelect.innerHTML = '<option value="">부서 선택</option>'; // 초기화

    departments.forEach(dept => {
        departmentSelect.innerHTML += `<option value="${dept}">${dept}</option>`;
    });
}

// 직급 목록 동적으로 추가
function populatePositionSelect(positions) {
    const positionSelect = document.getElementById('searchPosition');
    positionSelect.innerHTML = '<option value="">직급 선택</option>'; // 초기화
    positions.forEach(pos => {
        positionSelect.innerHTML += `<option value="${pos}">${pos}</option>`;
    });
}

// 재직 상태 버튼 동적으로 추가
function populateStatusButtons(statuses) {
    const statusGroup = document.getElementById('statusGroup');
    statusGroup.innerHTML = ''; // 초기화

    statusGroup.innerHTML += `
        <input type="radio" class="btn-check" name="searchStatus" id="statusAll" checked>
        <label class="btn btn-outline-primary" for="statusAll">전체</label>
    `;
    statuses.forEach((status, index) => {
        const statusId = `status${index}`;
        statusGroup.innerHTML += `
            <input type="radio" class="btn-check" name="searchStatus" id="${statusId}">
            <label class="btn btn-outline-primary" for="${statusId}">${status}</label>
        `;
    });

    document.querySelectorAll('input[name="searchStatus"]').forEach(btn => {
        btn.addEventListener("click", () => searchEmployees());
    });
}

// 근무 유형 버튼 동적으로 추가
function populateEmploymentButtons(employmentTypes) {
    const employmentGroup = document.getElementById('employmentTypeGroup');
    employmentGroup.innerHTML = ''; // 초기화

    employmentGroup.innerHTML += `
        <input type="radio" class="btn-check" name="employmentType" id="typeAll" checked>
        <label class="btn btn-outline-primary" for="typeAll">전체</label>
    `;
    employmentTypes.forEach((type, index) => {
        const typeId = `type${index}`;
        employmentGroup.innerHTML += `
            <input type="radio" class="btn-check" name="employmentType" id="${typeId}">
            <label class="btn btn-outline-primary" for="${typeId}">${type}</label>
        `;
    });

    document.querySelectorAll('input[name="employmentType"]').forEach(btn => {
        btn.addEventListener("click", () => searchEmployees());
    });
}
