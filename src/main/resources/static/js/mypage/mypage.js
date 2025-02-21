
const deptFilter = document.getElementById("deptFilter");
const searchBtn = document.getElementById("searchBtn");
const filterButtons = document.querySelectorAll(".filter-btn");

// 더미 데이터
const approvals = [
    { id: 1, document: "근태_수정_요청", dept: "인사", status: "대기중" },
    { id: 2, document: "경력증명서_요청", dept: "인사", status: "반려" },
    { id: 3, document: "경력증명서_요청", dept: "인사", status: "승인" },
    { id: 4, document: "근태_수정_요청", dept: "인사", status: "승인" },
    { id: 5, document: "부대_비용_요청", dept: "회계", status: "승인" }
];

// 필터 및 조회
function filterData() {
    const selectedDept = deptFilter.value;
    const selectedStatus = document.querySelector(".filter-btn.active")?.dataset.status || "전체";

    const filteredData = approvals.filter(approval =>
        (selectedDept === "전체" || approval.dept === selectedDept) &&
        (selectedStatus === "전체" || approval.status === selectedStatus)
    );
}

// 상태 필터 버튼 클릭 이벤트
filterButtons.forEach(button => {
    button.addEventListener("click", function () {
        filterButtons.forEach(btn => btn.classList.remove("active"));
        this.classList.add("active");
        filterData();
    });
});

// 조회 버튼 클릭
searchBtn.addEventListener("click", filterData);

let Grid = tui.Grid;
let employeeNum = /*[[${session.employeeNum}]]*/ "default";
const dataSource = {
    api: {
        readData: {
            url: `http://localhost:81/api/mainpage/approval/list/${employeeNum}`,
            method: 'GET',
            initParams: { page: 1 }
        },
        contentType: 'application/json'
    },
};
const getMyApprovalList = () => {

}