// HTML이 로드된 후 실행
document.addEventListener("DOMContentLoaded", function () {
    if (sessionData.companyNum) {
        subscriptionlist(sessionData.companyNum);
    } else {
        console.error("회사 번호가 없습니다.");
    }
});

var subscriptionState;

// 구독 정보 불러오기
function subscriptionlist(companyNum) {
    const url = "/erp/rest/subList/" + companyNum;
    //console.log("호출 주소:", url);

    fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => response.json())
    .then(data => {
        //console.log("구독 정보 가져오기 완료");
        subManagement(data);
    })
    .catch(error => console.error("API 호출 오류:", error));
}

// 남은 기간 반환 함수
function modDate(endDateStr) {
    if (!endDateStr) return 0;

    let today = new Date();
    let endDate = new Date(endDateStr);

    if (isNaN(endDate.getTime())) {
        console.error("유효하지 않은 날짜 값:", endDateStr);
        return 0;
    }

    let timeDiff = endDate.getTime() - today.getTime();
    return Math.ceil(timeDiff / (1000 * 60 * 60 * 24));
}

// 구독정보 처리
function subManagement(data) {
    const subscriptionMap = [
        null,
        { name: "구독형태", key: "subObj", dateKey: "subObjdate" },
        { name: "그룹웨어", key: "groupObj", dateKey: "groupObjdate" },
        { name: "인사관리", key: "hrObj", dateKey: "hrObjdate" },
        { name: "지점관리", key: "pointObj", dateKey: "pointObjdate" },
        { name: "회계관리", key: "accountObj", dateKey: "accountObjdate" }
    ];

    subscriptionState = {
        subObj: "date",
        subObjdate: 0,
        groupObj: "date",
        groupObjdate: 0,
        hrObj: "date",
        hrObjdate: 0,
        pointObj: "date",
        pointObjdate: 0,
        accountObj: "date",
        accountObjdate: 0
    };

    data.forEach(ele => {
        let baseNum = (ele.subscriptionNameNum - 1) % 5 + 1;
        let isPeriodic = ele.subscriptionNameNum > 5;
        let remainingDays = modDate(ele.subscriptionEndDate);

        if (subscriptionMap[baseNum]) {
            let { name, key, dateKey } = subscriptionMap[baseNum];

            //console.log(`${name} ${isPeriodic ? "정기구독" : "기간제구독"} (남은기간: ${remainingDays}일)`);
            subscriptionState[key] = isPeriodic ? "per" : "date";
            subscriptionState[dateKey] = remainingDays;
        }
    });

    //console.log("최종 구독 상태:", subscriptionState);
}
