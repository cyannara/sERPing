const getApprovalType = () => {
    const url = `/mainpage/rest/approval/type`;
    fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
        .then(result => result.json())
        .then(data => {
            const docType = data.map((doc) => {
                return doc.documentType
            })

            const selectElement = document.getElementById("documentType");

            // populate는 "채우다", "입력하다", "삽입하다" 등의 의미
            function populateSelect(options, select) {
                options.forEach(optionText => {
                    const option = document.createElement("option");
                    option.value = optionText;  // value 값 설정
                    option.textContent = optionText; // 표시할 텍스트
                    select.appendChild(option); // select 요소에 추가
                });
            }

            populateSelect(docType, selectElement);
        })
        .catch(error => console.error("Error fetching data:", error));
}

getApprovalType()

function reset(){
    let documentType = document.querySelector('#documentType');
    let employeeName = document.querySelector('#employeeName');

    documentType.value = '';
    employeeName.value = '';

    grid.setRequestParams({ "documentType" : documentType.value, "employeeName" : employeeName.value })
    grid.readData();
}

function search(){
    let documentType = document.querySelector('#documentType').value.toString();
    let employeeName = document.querySelector('#employeeName').value.toString();
    grid.setRequestParams({"documentType" : documentType, "employeeName" : employeeName })
    grid.readData();
}

function changeDisplay() {
    let gap = parseInt(document.querySelector('#display_amount').value);
    grid.setPerPage(gap, dataSource)
}

async function downloadPDF(dataset) {
    const { jsPDF } = window.jspdf;
    const doc = new jsPDF();

    const container = document.createElement("div"); // 임시 컨테이너 생성
    container.innerHTML = dataset.content;
    const paragraphElement = container.firstElementChild;
    document.body.appendChild(paragraphElement); // 요소를 body에 추가

    // html2canvas로 요소 캡처
    const canvas = await html2canvas(paragraphElement, { scale: 2 });
    const imgData = canvas.toDataURL('image/png');

    // PDF에 이미지 추가
    doc.addImage(imgData, 'PNG', 10, 10, 180, 0);
    doc.save("결재 요청 서류.pdf"); // PDF 저장
}

const processApproval = (inApprovalId, processStr) => {
    const url = `/mainpage/rest/approval/${inApprovalId}/process/${processStr}`;
    fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
        .then(result => result.json())
        .then(data => {
            if(data) {
                if(processStr === 'approve') {
                    showAlert('결재 승인처리 되었습니다.', 'success')
                } else {
                    showAlert('결재 반려처리 되었습니다.', 'success')
                }
            } else {
                showAlert('결재 처리 실패', 'danger')
            }
            grid.reloadData();
        })
        .catch(error => console.error("Error fetching data:", error));
}