// JavaScript에서 세션 데이터 활용
document.addEventListener("DOMContentLoaded", function () {
    if (employeeInfo) {
        console.log("세션 데이터:", employeeInfo);
        sessionStorage.setItem("employeeInfo", JSON.stringify(employeeInfo)); // 세션스토리지 저장
        
        const logouttag = `<li><a href="/erp/logout">로그아웃</a></li>`;
        
       	document.querySelector(".navmenu ul").insertAdjacentHTML("beforeend", logouttag);
       	
       	const erpemployeeinfotag = `[${employeeInfo.job}팀] <b>${employeeInfo.employeeName}</b> ${employeeInfo.position}님 반갑습니다.`;
       	
       	document.querySelector(".erpemployeeinfo").insertAdjacentHTML("beforeend", erpemployeeinfotag);
       	
    } else {
        console.warn("세션 데이터가 없습니다.");
        window.location.href = "/erp/login";
    }
});