/**
 * common-codes.js
 */

document.addEventListener("DOMContentLoaded", function () {
    loadCommonCodes();
});

// 부서 목록을 담을 변수
let departments = [];

// 공통 코드 데이터 불러오는 함수
function loadCommonCodes() {
    fetch('/hr/rest/emp/common-codes')
        .then(response => response.json())
        .then(data => {
            console.log("공통 코드 로드됨:", data); // 데이터 확인용
            if (!data || !data.departments) {
                console.error("⚠ No department data received.");
                return;
            }
            
            // ✅ 전역 변수에 저장
            departments = data.departments;
            populateDepartmentSelect(data.departments);
            populateSubDepartments(data.departments);
            populatePositionSelect(data.positions || []);
            populateStatusButtons(data.statuses || []);
            populateEmploymentButtons(data.employmentTypes || []);
        })
        .catch(error => console.error("❌ Error loading common codes:", error));
}

// 부서 목록 동적으로 추가
function populateDepartmentSelect(departments) {
    const departmentSelect = document.getElementById("searchDepartment");
    departmentSelect.innerHTML = '<option value="">선택</option>'; // 초기화

    // 1️⃣ 최상위 부서 (부모 없는 부서)만 추가
    let parentDepartments = departments.filter(dept => !dept.PARENT_DEPARTMENT_NUM);
    parentDepartments.forEach(dept => {
        departmentSelect.innerHTML += `<option value="${dept.DEPARTMENT_NUM}">${dept.DEPARTMENT_NAME}</option>`;
    });

    // 2️⃣ 부서 선택 시, 하위 부서 필터링
    departmentSelect.addEventListener("change", function () {
        const selectedDeptCode = this.value;
        populateSubDepartments(selectedDeptCode);
    });
}

// 하위 부서 필터링 함수
function populateSubDepartments(parentCode) {
    const subDepartmentSelect = document.getElementById("searchSubDepartment");
    subDepartmentSelect.innerHTML = '<option value="">선택</option>'; // 🔥 초기화

    if (!parentCode) return; // 상위 부서 선택 안 한 경우

    // ✅ 선택한 부서의 `DEPARTMENT_NUM`과 일치하는 `PARENT_DEPARTMENT_NUM`을 가진 부서들 필터링
    let subDepartments = departments.filter(dept => dept.PARENT_DEPARTMENT_NUM == parentCode);

    subDepartments.forEach(dept => {
        subDepartmentSelect.innerHTML += `<option value="${dept.DEPARTMENT_NUM}">${dept.DEPARTMENT_NAME}</option>`;
    });

    console.log(`✅ 하위 부서 (${parentCode}) 목록:`, subDepartments);
}

// 직급 목록 동적으로 추가
function populatePositionSelect(positions) {
    const positionSelect = document.getElementById('searchPosition');
    positionSelect.innerHTML = '<option value="">선택</option>';

    if (!positions) {
        console.error("⚠ positions 데이터가 없습니다.");
        return;
    }

    positions.forEach(pos => {
        positionSelect.innerHTML += `<option value="${pos.CMMNCODE}">${pos.CMMNNAME}</option>`;
    });

    console.log("✅ 직급 목록 로드 완료:", positions);
}

// 재직 상태 버튼 동적으로 추가
function populateStatusButtons(statuses) {
    const statusGroup = document.getElementById('statusGroup');
    statusGroup.innerHTML = ''; // 기존 버튼 초기화

    // ✅ "전체" 버튼 추가
    statusGroup.innerHTML += `
        <input type="radio" class="btn-check" name="searchStatus" id="statusAll" checked value="">
        <label class="btn btn-outline-primary" for="statusAll">전체</label>
    `;
    
    // ✅ 상태 버튼 추가 (예상 데이터: ["재직", "퇴직", "휴직"])
    if (statuses && Array.isArray(statuses)) {
        statuses.forEach((status, index) => {
            const statusId = `status${index}`;
            statusGroup.innerHTML += `
                <input type="radio" class="btn-check" name="searchStatus" id="${statusId}" value="${status}">
                <label class="btn btn-outline-primary" for="${statusId}">${status}</label>
            `;
        });
    } else {
        console.error("⚠ 상태 목록 데이터가 비어있음:", statuses);
    }

    // ✅ 상태 필터 버튼 변경 시 자동 검색 실행
    document.querySelectorAll("input[name='searchStatus']").forEach(btn => {
        btn.addEventListener("change", function () {
            searchEmployees();
        });
    });
}

// 근무 유형 버튼 동적으로 추가
function populateEmploymentButtons(employmentTypes) {
    const employmentGroup = document.getElementById('employmentTypeGroup');
    employmentGroup.innerHTML = ''; // 초기화

    console.log("✅ 근무 유형 데이터 확인:", employmentTypes);

    // ✅ 데이터가 undefined이거나 비어있는 경우 처리
    if (!employmentTypes || employmentTypes.length === 0) {
        console.error("❌ 근무 유형 데이터가 비어있음!");
        return;
    }

    // ✅ "전체" 버튼 추가
    employmentGroup.innerHTML += `
        <input type="radio" class="btn-check" name="employmentType" id="employmentTypeAll" checked value="">
        <label class="btn btn-outline-primary" for="employmentTypeAll">전체</label>
    `;

    // ✅ `employmentTypes`가 배열이 아닐 경우 단일 값 처리
    if (!Array.isArray(employmentTypes)) {
        const typeId = `employmentType_${employmentTypes.CMMNCODE}`;
        employmentGroup.innerHTML += `
            <input type="radio" class="btn-check" name="employmentType" id="${typeId}" value="${employmentTypes.CMMNCODE}">
            <label class="btn btn-outline-primary" for="${typeId}">${employmentTypes.CMMNNAME}</label>
        `;
    } else {
        // ✅ `employmentTypes`가 배열인 경우 forEach 사용
        employmentTypes.forEach(type => {
            const typeId = `employmentType_${type.CMMNCODE}`;
            employmentGroup.innerHTML += `
                <input type="radio" class="btn-check" name="employmentType" id="${typeId}" value="${type.CMMNCODE}">
                <label class="btn btn-outline-primary" for="${typeId}">${type.CMMNNAME}</label>
            `;
        });
    }
    

    // ✅ 근무 유형 선택 시 자동 검색 실행
    document.querySelectorAll("input[name='employmentType']").forEach(btn => {
        btn.addEventListener("change", function () {
            searchEmployees();
        });
    });
}


