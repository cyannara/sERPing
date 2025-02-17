/**
 * employee.js
 */

let grid;

document.addEventListener("DOMContentLoaded", function () {
    initializeGrid();
    setupEventListeners();
});

// Toast Grid 초기화 함수
function initializeGrid() {
    var Grid = tui.Grid;
    const dataSource = {
        api: {
            readData: {
                url: 'http://localhost:81/hr/rest/emp/list',
                method: 'GET',
                initParams: { page: 1 }
            }
        },
        contentType: 'application/json',
    };

    Grid.applyTheme('stripe');

    grid = new Grid({
        el: document.getElementById('grid'),
        width: "100%",
        autoWidth: true,
        pageOptions: {
            useClient: false,
            perPage: 5,
        },
        rowHeaders: [{
            type: 'rowNum',
            header: "순번",
            width: 50,
        }],
        columns: [
            { header: "사원ID", name: "employeeId", align: "center", width: 100 },
            { header: "사원명", name: "employeeName", align: "center", sortable: true, width: 150 },
            { header: "부서", name: "departmentName", align: "center", sortable: true, width: 100 },
            { header: "직급", name: "position", align: "center", sortable: true, width: 100, formatter: formatCommonCode('position') },
            { header: "재직 상태", name: "status", align: "center", sortable: true, width: 100, formatter: formatCommonCode('status') },
            { header: "근무 유형", name: "employmentType", align: "center", sortable: true, width: 100, formatter: formatCommonCode('employmentType') },
            { header: "입사일", name: "hireDate", align: "center", sortable: true, width: 150, formatter: ({ value }) => value?.split('T')[0] || '' },
            { header: "연락처", name: "phone", align: "center", sortable: true, width: 150 },
            { header: "이메일", name: "email", align: "center", sortable: true, width: 200 }
        ],
        data: dataSource,
        rowHeaders: ['checkbox'],
        
    });
}

// 공통 코드 목록 불러오기 (동적 적용)
let commonCodes = {};
function loadCommonCodes() {
    fetch("http://localhost:81/hr/rest/emp/common-codes")
        .then(response => response.json())
        .then(data => {
            commonCodes = data;
            populateFilters(); // 필터 UI 업데이트
        })
        .catch(error => console.error("공통 코드 로딩 실패:", error));
}

// 공통 코드 포맷터
function formatCommonCode(type) {
    return ({ value }) => commonCodes[type]?.[value] || value;
}

// 필터 UI 동적 생성
function populateFilters() {
    const positionSelect = document.getElementById("positionFilter");
    const statusSelect = document.getElementById("statusFilter");
    const employmentTypeSelect = document.getElementById("employmentTypeFilter");
    const departmentSelect = document.getElementById("departmentFilter");

    // 기존 옵션 제거
    positionSelect.innerHTML = '<option value="">전체</option>';
    statusSelect.innerHTML = '<option value="">전체</option>';
    employmentTypeSelect.innerHTML = '<option value="">전체</option>';
    departmentSelect.innerHTML = '<option value="">전체</option>';

    // 공통 코드 옵션 추가
    Object.entries(commonCodes.position || {}).forEach(([key, value]) => {
        positionSelect.innerHTML += `<option value="${key}">${value}</option>`;
    });
    Object.entries(commonCodes.status || {}).forEach(([key, value]) => {
        statusSelect.innerHTML += `<option value="${key}">${value}</option>`;
    });
    Object.entries(commonCodes.employmentType || {}).forEach(([key, value]) => {
        employmentTypeSelect.innerHTML += `<option value="${key}">${value}</option>`;
    });
}

// ✅ 검색 필터 적용
function getFilterParams() {
    const departmentSelect = document.getElementById("searchDepartment");
    const subDepartmentSelect = document.getElementById("searchSubDepartment");

    let selectedDeptNum = departmentSelect.value; // 상위 부서 선택 값
    let selectedSubDeptNum = subDepartmentSelect.value; // 하위 부서 선택 값
    let selectedPosition = document.getElementById("searchPosition")?.value || "";
    let selectedStatus = document.querySelector("input[name='searchStatus']:checked")?.value || "";
if (selectedStatus === "on") selectedStatus = ""; // "전체" 선택 시 공백 처리

    let params = {
        departmentNum: selectedDeptNum !== "all" ? selectedDeptNum : "",
        subDepartmentNum: selectedSubDeptNum !== "" ? selectedSubDeptNum : "",
        position: selectedPosition, // ✅ 직급 값 반영
        status: selectedStatus,
        employmentType: document.querySelector("input[name='employmentType']:checked")?.value === "on" ? "" : document.querySelector("input[name='employmentType']:checked")?.value,
        searchType: document.getElementById("searchCategory")?.value || "",
        searchKeyword: document.getElementById("searchKeyword")?.value || "",
    };

    // ✅ 전체 부서 선택 시 모든 부서 표시
    if (selectedDeptNum === "all" || selectedDeptNum === "") {
        params.departmentNum = "";
    } else {
        params.departmentNum = selectedDeptNum;
    }

    // ✅ 하위 부서 선택 시 해당 부서만 필터링
    if (selectedSubDeptNum !== "") {
        params.subDepartmentNum = selectedSubDeptNum;
    }

    console.log("✅ getFilterParams() 결과:", params);
    return params;
}


// ✅ Toast Grid 데이터 새로고침
function searchEmployees(page = 1) {
    const params = getFilterParams(); // 검색 필터 적용
    params.page = page; // 현재 페이지 값 추가

    // ✅ URLSearchParams 사용 (불필요한 중복 제거)
    const urlParams = new URLSearchParams(params);
    
    console.log("🔍 API 요청 URL:", `/hr/rest/emp/list?${urlParams.toString()}`);

    // ✅ Toast Grid 검색 필터 적용 후 데이터 새로 불러오기
    grid.setRequestParams(params);
    grid.readData(page, params, true);
}


// 필터 이벤트 리스너 설정
function setupEventListeners() {
    document.getElementById("searchBtn").addEventListener("click", function () {
        grid.refreshData();
    });

    document.getElementById("resetBtn").addEventListener("click", function () {
        document.getElementById("departmentFilter").value = "";
        document.getElementById("positionFilter").value = "";
        document.getElementById("statusAll").checked = true;
        document.getElementById("employmentTypeAll").checked = true;
        document.getElementById("searchKeyword").value = "";
        grid.refreshData();
    });

    document.querySelectorAll(".filter").forEach(filter => {
        filter.addEventListener("change", function () {
            grid.refreshData();
        });
    });
    
    
// 필터가 변경될 때마다 자동 검색 실행
document.querySelectorAll("#searchDepartment, #searchPosition,#searchSubDepartment, input[name='searchStatus'], input[name='employmentType']").forEach(filter => {
    filter.addEventListener("change", searchEmployees);
});
}


document.getElementById("searchDepartment").addEventListener("change", function () {
    let selectedDeptNum = this.value; // 선택한 부서의 `DEPARTMENT_NUM`
    populateSubDepartments(selectedDeptNum); // 하위 부서 필터링
    searchEmployees(); // ✅ 부서 선택 후 자동 검색 실행
});

document.getElementById("searchSubDepartment").addEventListener("change", function () {
    searchEmployees(); // ✅ 하위 부서 선택 후 자동 검색 실행
});

// ✅ 직급 선택 시 자동 검색 실행
document.getElementById("searchPosition").addEventListener("change", function(){
	 searchEmployees();
});

document.getElementById("populateStatusButtons").addEventListener("change", function(){
	searchEmployees();
})