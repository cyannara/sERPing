// HTML이 로드된 후 실행
document.addEventListener("DOMContentLoaded", async function () {
    if (sessionData.companyNum) {
        try {
            showLoadingIndicator(); // 로딩 표시

            // 모든 데이터를 병렬로 요청 후 대기
            await Promise.all([
                subscriptionlist(sessionData.companyNum),
                subcontactlist(sessionData.companyNum),
                subgpoptionlist(sessionData.companyNum)
            ]);

            updateUI(); // 데이터가 로드된 후 UI 업데이트

        } catch (error) {
            console.error("데이터 로드 중 오류 발생:", error);
        } finally {
            hideLoadingIndicator(); // 로딩 완료 후 숨김
        }
    } else {
        console.error("회사 번호가 없습니다.");
    }
});

var subscriptionState;

// 로딩 표시 함수
function showLoadingIndicator() {
    document.body.insertAdjacentHTML("afterbegin", '<div id="loading">Loading...</div>');
}

// 로딩 숨김 함수
function hideLoadingIndicator() {
    let loadingElement = document.getElementById("loading");
    if (loadingElement) {
        loadingElement.remove();
    }
}

// UI 업데이트 함수
function updateUI() {
    console.log("구독 정보:", subscriptionState);
    // 화면 업데이트 로직 추가 가능
}

// 그룹웨어 옵션 현황 불러오기 (재시도 기능 추가)
async function subgpoptionlist(companyNum, retryCount = 3) {
    const url = "/erp/rest/subgp/" + companyNum;
    
    for (let attempt = 1; attempt <= retryCount; attempt++) {
        try {
            //console.log(`그룹웨어 옵션 데이터 요청 (시도 ${attempt}/${retryCount})`);

            let response = await fetch(url, { method: "GET", headers: { "Content-Type": "application/json" } });
            
            if (!response.ok) {
                throw new Error(`서버 오류: ${response.status}`);
            }

            let data = await response.text();

            //console.log("그룹웨어 옵션 데이터 응답:", data);

            if (!data || data === "0") {
                console.warn("그룹웨어 옵션 데이터가 없음, 기본값 50 설정");
                data = "50"; // 기본값 설정
            }

            subscriptionState = subscriptionState || {};
            subscriptionState.gpOption = data;

            //console.log("최종 설정된 gpOption 값:", subscriptionState.gpOption);
            return; // 성공 시 종료

        } catch (error) {
            console.error(`그룹웨어 옵션 불러오기 실패 (시도 ${attempt}/${retryCount}):`, error);

            if (attempt === retryCount) {
                console.error("최대 재시도 횟수 도달. 기본값 50 적용");
                subscriptionState = subscriptionState || {};
                subscriptionState.gpOption = "50";
            }
        }
        
        await new Promise(resolve => setTimeout(resolve, 1000)); // 재시도 전 1초 대기
    }
}

// 계약서 서명 정보 불러오기 (재시도 기능 추가)
async function subcontactlist(companyNum, retryCount = 3) {
    const url = "/erp/rest/subcontact/" + companyNum;

    for (let attempt = 1; attempt <= retryCount; attempt++) {
        try {
            let response = await fetch(url, { method: "GET", headers: { "Content-Type": "application/json" } });
            let data = await response.text();

            if (!data || data === "0") {
                //console.warn("계약서 서명 데이터 없음, 기본값 0 설정");
                data = "0";
            }

            subscriptionState = subscriptionState || {};
            subscriptionState.subcon = data;

            //console.log("계약서 서명 정보:", subscriptionState.subcon);
            return;

        } catch (error) {
            console.error(`계약서 서명 데이터 불러오기 실패 (시도 ${attempt}/${retryCount}):`, error);

            if (attempt === retryCount) {
                console.error("최대 재시도 횟수 도달. 기본값 0 적용");
                subscriptionState = subscriptionState || {};
                subscriptionState.subcon = "0";
            }
        }

        await new Promise(resolve => setTimeout(resolve, 1000)); // 재시도 전 1초 대기
    }
}

// 구독 정보 불러오기 (재시도 기능 추가)
async function subscriptionlist(companyNum, retryCount = 3) {
    const url = "/erp/rest/subList/" + companyNum;

    for (let attempt = 1; attempt <= retryCount; attempt++) {
        try {
            let response = await fetch(url, { method: "GET", headers: { "Content-Type": "application/json" } });
            let data = await response.json();
            subManagement(data);
            return;

        } catch (error) {
            console.error(`구독 정보 불러오기 실패 (시도 ${attempt}/${retryCount}):`, error);

            if (attempt === retryCount) {
                console.error("최대 재시도 횟수 도달, 기본값 적용");
                subscriptionState = subscriptionState || {};
            }
        }

        await new Promise(resolve => setTimeout(resolve, 1000)); // 재시도 전 1초 대기
    }
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

    // 🚨 subscriptionState가 undefined면 빈 객체로 초기화
    subscriptionState = subscriptionState || {};

    // 기존 subscriptionState를 유지하면서 값 업데이트
    subscriptionState = {
        ...subscriptionState,  // 기존 값 유지
        subObj: "date",
        subObjdate: 0,
        groupObj: "date",
        groupObjdate: 0,
        hrObj: "date",
        hrObjdate: 0,
        pointObj: "date",
        pointObjdate: 0,
        accountObj: "date",
        accountObjdate: 0,
        subcon: subscriptionState.subcon || 0, // 기존 subcon 값 유지
        gpOption: subscriptionState.gpOption || 50, // 기존 gpOption 값 유지
    };

    data.forEach(ele => {
        let baseNum = (ele.subscriptionNameNum - 1) % 5 + 1;
        let isPeriodic = ele.subscriptionNameNum > 5;
        let remainingDays = modDate(ele.subscriptionEndDate);

        if (subscriptionMap[baseNum]) {
            let { key, dateKey } = subscriptionMap[baseNum];

            subscriptionState[key] = isPeriodic ? "per" : "date";
            subscriptionState[dateKey] = remainingDays;
        }
    });

    //console.log("최종 구독 상태:", subscriptionState);
}
