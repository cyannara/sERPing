const getHqDeptList = () => {
    const url = `/api/stdr/dept`;
    fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    })
        .then(result => result.json())
        .then(data => {
            makeDeptList(data)
        })
        .catch(error => console.error("Error fetching data:", error));
}

const makeDeptList = (data) => {
    const dropdownMenu = document.getElementById('dropdownMenu')
    let deptList = ''
    data.forEach((dept) => {
        deptList += `<li><a class="dropdown-item" data-dept-id="${dept.deptNo}">${dept.deptName}</a></li>`
    })
    dropdownMenu.insertAdjacentHTML('beforeend', deptList)

    selectDropdownItem()
}

const selectDropdownItem = () => {
    // 드롭다운 메뉴 클릭 시 input 값 변경
    dropdownMenu.querySelectorAll(".dropdown-item").forEach(item => {
        item.addEventListener("click", function (e) {
            e.preventDefault();
            const deptName = document.getElementById('deptName')
            deptName.value = this.textContent;
            dropdownMenu.classList.remove("show");
        });
    });

    dropdownType.querySelectorAll(".dropdown-item").forEach(item => {
        item.addEventListener("click", function (e) {
            e.preventDefault();
            const approvalType = document.getElementById('approvalType')
            approvalType.value = this.textContent;
            dropdownType.classList.remove("show");
        });
    });
}

const addDocTemplate = () => {
    const documentType = document.getElementById('documentType')
    const documentName = document.getElementById('documentName')
    const deptName = document.getElementById('deptName')
    let approvalType = document.getElementById('approvalType')
    approvalType.value.includes('내부') ? approvalType.value = 'IN' : ''
    const documentTemplate = editor.getHTML({ sanitize: false })

    let isAllFilled = true
    if(!documentType.value || !documentName.value || !deptName.value || !approvalType.value || !documentTemplate) {
        showAlert('입력값을 모두 넣어주세요', 'danger')
        isAllFilled = false
    }

    if(!isAllFilled) {
        return false
    }

    const url = `/api/stdr/document`;
    fetch(url, {
        method: "POST",
        headers: {
            'header': header_csrf,
            "Content-Type": "application/json",
            'X-CSRF-Token': token_csrf
        },
        body: JSON.stringify({
            documentType: documentType.value,
            documentName: documentName.value,
            deptName: deptName.value,
            approvalType: approvalType.value,
            documentTemplate
        })
    })
        .then(result => result.json())
        .then(data => {
            console.log('data', data)
            showAlert('문서 템플릿이 추가되었습니다.', 'success')
            grid.readData();

            documentType.value = ''
            documentName.value = ''
            deptName.value = ''
            approvalType.value = ''
        })
        .catch(error => console.error("Error adding document:", error));
}