/**
 * employee.js
 */

let grid;

document.addEventListener("DOMContentLoaded", function () {
    initializeGrid();
    setupEventListeners();
});

// 전화번호 포맷 함수 (01012345678 → 010-1234-5678)
function formatPhoneNumber({ value }) {
    if (!value) return ""; // 값이 없으면 빈 문자열 반환
    value = value.replace(/\D/g, ""); // 숫자 이외 문자 제거

    if (value.length === 11) {
        return value.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");
    } else if (value.length === 10) {
        return value.replace(/(\d{3})(\d{3})(\d{4})/, "$1-$2-$3");
    }
    return value; // 위 조건에 해당하지 않으면 원본 반환
}

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
            { header: "연락처", name: "phone", align: "center", sortable: true, width: 150, formatter: formatPhoneNumber  },
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

// 검색 필터 적용
function getFilterParams() {
    const departmentSelect = document.getElementById("searchDepartment");
    const subDepartmentSelect = document.getElementById("searchSubDepartment");

    let selectedDeptNum = departmentSelect.value; // 상위 부서 선택 값
    let selectedSubDeptNum = subDepartmentSelect.value; // 하위 부서 선택 값
    let selectedPosition = document.getElementById("searchPosition")?.value || "";
    let selectedStatus = document.querySelector("input[name='searchStatus']:checked")?.value || "";
if (selectedStatus === "on") selectedStatus = ""; // "전체" 선택 시 공백 처리
	let selectedEmploymentType = document.querySelector("input[name='employmentType']:checked")?.value || "";
	
    // 🔹 "검색 기준" 선택 값 가져오기
    let searchType = document.getElementById("searchCategory")?.value || "전체";
	let searchKeyword = document.getElementById("searchKeyword")?.value || "";
	searchKeyword = searchKeyword.trim(); // 앞뒤 공백 제거


    if (selectedStatus === "on") selectedStatus = ""; // "전체" 선택 시 공백 처리




    let params = {
        departmentNum: selectedDeptNum !== "all" ? selectedDeptNum : "",
        subDepartmentNum: selectedSubDeptNum !== "" ? selectedSubDeptNum : "",
        position: selectedPosition, // 직급 값 반영
        status: selectedStatus,
        employmentType: document.querySelector("input[name='employmentType']:checked")?.value === "on" ? "" : document.querySelector("input[name='employmentType']:checked")?.value,
        searchType: searchType,
        searchKeyword: searchKeyword,
    };
    
    
    // 🔹 검색어가 입력되었을 경우 처리
    if (searchKeyword !== "") {
        if (searchType === "전체") {
            // ✅ 검색어가 있으면 OR 조건으로 검색 (사원명 OR 사원ID OR 연락처)
            params.searchType = "전체";
            params.searchKeyword = searchKeyword;
        } else {
            // ✅ 특정 검색 기준 선택 시 해당 필드만 검색
            params.searchType = searchType;
            params.searchKeyword = searchKeyword;
        }
    }

    // 전체 부서 선택 시 모든 부서 표시
    if (selectedDeptNum === "all" || selectedDeptNum === "") {
        params.departmentNum = "";
    } else {
        params.departmentNum = selectedDeptNum;
    }

    // 하위 부서 선택 시 해당 부서만 필터링
    if (selectedSubDeptNum !== "") {
        params.subDepartmentNum = selectedSubDeptNum;
    }

    console.log("getFilterParams() 결과:", params);
    return params;
}


// Toast Grid 데이터 새로고침
function searchEmployees(page = 1) {
    const params = getFilterParams(); // 검색 필터 적용
    console.log("🔍 검색 요청 파라미터:", params);  // ✅ 파라미터 확인용 로그
    params.page = page; // 현재 페이지 값 추가

    // URLSearchParams 사용 (불필요한 중복 제거)
    const urlParams = new URLSearchParams(params);
    
    console.log("🔍 API 요청 URL:", `/hr/rest/emp/list?${urlParams.toString()}`);

    // Toast Grid 검색 필터 적용 후 데이터 새로 불러오기
    grid.readData(page, params, true);
}


// 필터 이벤트 리스너 설정
function setupEventListeners() {
    const searchBtn = document.getElementById("searchBtn");
    const resetBtn = document.getElementById("resetBtn");
    const searchKeywordInput = document.getElementById("searchKeyword");

    if (searchBtn) {
        searchBtn.addEventListener("click", function () {
            searchEmployees();
        });
    } else {
        console.error("❌ searchBtn 요소를 찾을 수 없음!");
    }

    if (resetBtn) {
        resetBtn.addEventListener("click", function () {
            resetFilters();
        });
    } else {
        console.error("❌ resetBtn 요소를 찾을 수 없음!");
    }

    if (searchKeywordInput) {
        searchKeywordInput.addEventListener("keyup", function (event) {
            console.log("Key pressed:", event.key);
            if (event.key === "Enter") {
                console.log("Enter pressed. Searching...");
                searchEmployees();
            }
        });
    } else {
        console.error("❌ searchKeyword 요소를 찾을 수 없음!");
    }

    document.querySelectorAll("#searchDepartment, #searchPosition,#searchSubDepartment, input[name='searchStatus'], input[name='employmentType']").forEach(filter => {
        if (filter) {
            filter.addEventListener("change", searchEmployees);
        } else {
            console.error("❌ 필터 요소를 찾을 수 없음:", filter);
        }
    });
}


// 초기화 버튼 기능
function resetFilters() {
    document.getElementById("searchCategory").value = "전체";
    document.getElementById("searchKeyword").value = "";
    document.getElementById("searchDepartment").value = "";
    document.getElementById("searchSubDepartment").value = "";
    document.getElementById("searchPosition").value = "";
    document.querySelectorAll("input[name='searchStatus']").forEach(btn => btn.checked = false);
    document.querySelectorAll("input[name='employmentType']").forEach(btn => btn.checked = false);

    searchEmployees(); // ✅ 모든 필터 초기화 후 전체 데이터 조회
}


document.getElementById("searchDepartment").addEventListener("change", function () {
    let selectedDeptNum = this.value; // 선택한 부서의 `DEPARTMENT_NUM`
    populateSubDepartments(selectedDeptNum); // 하위 부서 필터링
    searchEmployees(); // 부서 선택 후 자동 검색 실행
});

document.getElementById("searchSubDepartment").addEventListener("change", function () {
    searchEmployees(); // 하위 부서 선택 후 자동 검색 실행
});

// 직급 선택 시 자동 검색 실행
document.getElementById("searchPosition").addEventListener("change", function(){
	 searchEmployees();
});


// ✅ 상태 필터(재직, 퇴직, 휴직) 변경 시 검색 실행
document.querySelectorAll("input[name='searchStatus']").forEach(btn => {
    btn.addEventListener("change", function () {
        searchEmployees();
    });
});