
/*function waitForProductGrid() {
    const observer = new MutationObserver(() => {
        const productGridElement = document.getElementById('productGrid');
        if (productGridElement) {
            console.log("✅ productGrid 요소가 동적으로 생성됨. 초기화 시작.");
            initProductGrid();
            observer.disconnect(); // 더 이상 감지할 필요 없음
        }
    });

    observer.observe(document.body, { childList: true, subtree: true });
}

document.addEventListener("DOMContentLoaded", function () {
const header = document.querySelector('meta[name="_csrf_header"]').content;
const token = document.querySelector('meta[name="_csrf"]').content;
const companyNum = document.getElementById("companyNum").value;
    console.log("✅ 발주서 등록 페이지 스크립트 실행됨");
	console.log("✅ 현재 companyNum 값:", companyNum);
  
    if (!window.purchaseGrid) {
        initPurchaseGrid();
    } else {
        console.warn("⚠️ purchaseGrid가 이미 선언되었습니다.");
    }

    waitForProductGrid(); // productGrid 동적 감지 시작
});*/



document.addEventListener("DOMContentLoaded", function () {
const header = document.querySelector('meta[name="_csrf_header"]').content;
const token = document.querySelector('meta[name="_csrf"]').content;
const companyNum = document.getElementById("companyNum").value;
    console.log("✅ 발주서 등록 페이지 스크립트 실행됨");
	console.log("✅ 현재 companyNum 값:", companyNum);
	
    // ✅ Toast Grid가 렌더링된 후 모달이 실행되도록 순서 조정
    if (!window.purchaseGrid) {
        initPurchaseGrid();
    }else {
        console.warn("⚠️ purchaseGrid가 이미 선언되었습니다.");
    }
    
    // ✅ 일정 시간 후 productGrid 초기화 시도
    /*setTimeout(function () {
        if (!window.productGrid) {
            initProductGrid();
        } else {
            console.warn("⚠️ productGrid가 이미 선언되었습니다.");
        }
    }, 500);*/ // 0.5초 지연

  /*if (!window.productGrid) {
        initProductGrid();
    }else {
        console.warn("⚠️ productGrid가 이미 선언되었습니다.");
    }*/
});

// ✅ 발주서 등록 Toast Grid 초기화


function initPurchaseGrid() {
    console.log("✅ 발주서 Grid 초기화");

    window.purchaseGrid = new tui.Grid({
        el: document.getElementById('grid'),
        columns: [
            { header: '상품코드', name: 'goodsCode' },
            { header: '상품명', name: 'goodsName' },
            { header: '옵션코드', name: 'optionCode' },
            { header: '옵션명', name: 'optionName' },
            { header: '거래처명', name: 'vendorName' },
            { header: '규격', name: 'goodsStandard' },
            { header: '수량', name: 'puchaseQuantity' },
            { header: '단가', name: 'puchaseUnitPrice' },
            { header: '공급가격', name: 'puchaseSupplyPrice' },
            { header: '부가세', name: 'puchaseVat' }
        ],
        rowHeaders: ['checkbox'],
        data: [],
        scrollX: true,
        scrollY: 300
    });

    document.getElementById("bttAdd").addEventListener("click", function () {
        purchaseGrid.appendRow({}, { at: 0 });
    });
}


// ✅ 제품 목록 Toast Grid 설정

/*function initProductGrid() {
    // ✅ 모달이 존재할 때만 초기화
    const productGridElement = document.getElementById('productGrid');
    if (!productGridElement) {
        console.warn("⚠️ productGrid 요소를 찾을 수 없습니다. 초기화 중단.");
        return;
    }

    window.productGrid = new tui.Grid({
        el: productGridElement,
        data: {
            api: {
                readData: {
                    url: 'http://localhost:81/purchs/rest/product/list',
                    method: 'GET',
                    requestOptions: {
                        headers: { 'Content-Type': 'application/json' },
                        credentials: 'same-origin'
                    },
                    initParams: {
                        page: 1,
                        perPage: 5,
                        companyNum: companyNum
                    }
                }
            },
            contentType: 'application/json',
            serverSidePagination: true
        },
        pageOptions: { useClient: false, perPage: 5 },
        bodyHeight: 'auto',
        columns: [
            { header: "상품명", name: "goodsName", rowSpan: true },
            { header: "상품코드", name: "goodsCode", rowSpan: true },
            { header: "옵션명", name: "optionName" },
            { header: "옵션번호", name: "optionCode" },
            { header: "브랜드", name: "brandName" },
            { header: "규격", name: "goodsStandard" },
            { header: "대표이미지", name: "goodsImage", align: "center", rowSpan: true }
        ]
    });

    console.log("✅ 제품 목록 Toast Grid 설정 완료");
}
*/


