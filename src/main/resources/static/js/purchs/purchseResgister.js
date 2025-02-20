// ✅ Thymeleaf 데이터를 JavaScript 변수로 변환
document.addEventListener("DOMContentLoaded", function(event){
	var csrfHeader = document.querySelector('meta[name="_csrf_header"]')?.content || '';
var csrfToken = document.querySelector('meta[name="_csrf"]')?.content || '';

// ✅ 발주서 등록 Toast Grid 설정
let purchaseGrid;


    console.log("✅ 발주서 등록 페이지 스크립트 실행됨");

    purchaseGrid = new tui.Grid({
        el: document.getElementById('purchaseGrid'),
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
        //userClient: true,
        scrollX: true,
        scrollY: 300
    });

/*    document.getElementById("bttAdd").addEventListener("click", function () {
        purchaseGrid.appendRow({}, { at: 0 });
    });

    // ✅ 상품 선택 시 적용될 데이터 처리
    purchaseGrid.on("click", (ev) => {
        if (['goodsName', 'goodsCode', 'optionName', 'optionCode'].includes(ev.columnName)) {
            openProductModal(ev.rowKey);
        }
    });

    // ✅ 상품 데이터 불러오기 (창고 모달)
    initProductGrid();*/


// ✅ 모달 열기 및 데이터 설정
/*function openProductModal(rowKey) {
    sessionStorage.setItem("selectedRowKey", rowKey);

    const modalElement = document.getElementById('goodsModal');
    if (!modalElement) {
        console.error("❌ goodsModal 요소를 찾을 수 없습니다.");
        return;
    }

    if (typeof productGrid !== 'undefined' && productGrid !== null) {
        console.log("📢 제품 모달: 데이터 초기화 및 새로고침 시작");

        productGrid.readData();
        setTimeout(() => {
            productGrid.refreshLayout();
        }, 500);

        productGrid.on("onGridUpdated", function () {
            console.log("✅ 제품 모달: 데이터 새로고침 완료");
            new bootstrap.Modal(modalElement).show();
        });
    } else {
        console.warn("⚠️ productGrid가 정의되지 않았습니다.");
    }
}*/

// ✅ 제품 목록 Toast Grid 설정
/*let productGrid;

function initProductGrid() {
    console.log("✅ 제품 목록 그리드 초기화");

    const productDataSource = {
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
                    companyNum: [[${session.companyNum}]]
                }
            }
        },
        contentType: 'application/json',
        serverSidePagination: true
    };

    productGrid = new tui.Grid({
        el: document.getElementById('productGrid'),
        data: productDataSource,
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

// ✅ 표시 수량 변경
function changeProductDisplay() {
    let perPage = parseInt(document.querySelector('#product_display_amount').value);
    productGrid.setPerPage(perPage);
    productGrid.reloadData();
}

// ✅ 검색 실행
function productSearch() {
    let goodsName = document.querySelector('#searchGoodsName').value;
    let brandName = document.querySelector('#searchBrandName').value;

    productGrid.setRequestParams({
        "companyNum": [[${session.companyNum}]],
        "goodsName": goodsName,
        "brandName": brandName
    });

    productGrid.reloadData();
}

// ✅ 필터 초기화
function resetFilters() {
    document.querySelector('#searchGoodsName').value = '';
    document.querySelector('#searchBrandName').value = '';
    document.querySelector('#product_display_amount').value = '5';

    productGrid.setRequestParams({
        "companyNum": companyNum,
        "goodsName": '',
        "brandName": ''
    });

    productGrid.reloadData();

}*/
})

