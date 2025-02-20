function formatDateTime(dateString) {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');

    return `${year}-${month}-${day} ${hours}:${minutes}`;
}

// alert
const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
// type:
// success: 초록색 danger: 빨간색 primary: 파란색
const showAlert = (message, type) => {
    const wrapper = document.createElement('div')

    let icon = ''
    if(type === 'success') {
        icon = `<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Success:">
            <use xlink:href="#check-circle-fill"/>
        </svg>`

    } else if (type === 'danger') {
        icon = `<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Danger:">
            <use xlink:href="#exclamation-triangle-fill"/>
        </svg>`

    } else if (type === 'primary') {
        icon = `<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Info:">
            <use xlink:href="#info-fill"/>
        </svg>`
    }

    wrapper.innerHTML = [
        `<div class="alert alert-${type} alert-dismissible fade show" role="alert">`,
        icon,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('');

    setTimeout(() => {
        wrapper.innerHTML = "";
    }, 3000);

    alertPlaceholder.append(wrapper)
}

//modal
const setModalContent = (title, contentEleId, dismissBtnName, saveBtnName, onSave) => {
    let titleEle = document.getElementById('commonModalLabel')
    titleEle.innerText = title

    let dismissBtn = document.getElementById('dismissBtn')
    dismissBtn.innerText = dismissBtnName

    let saveBtn = document.getElementById('saveBtn')
    saveBtn.innerText = saveBtnName
     
    // 기존 saveBtn에 이벤트가 계속 누적 등록돼서 똑같은 새 요소를 만듦
    saveBtn.replaceWith(saveBtn.cloneNode(true))
    saveBtn = document.getElementById('saveBtn')

    let contentEle = document.getElementById(contentEleId)
    contentEle.classList.add('show')
    saveBtn.addEventListener('click', () => {
        onSave()
    })

    let modal = document.getElementById('commonModal')
    modal.addEventListener('hidden.bs.modal', () => {
        titleEle.innerText = ''
        contentEle.classList.remove('show')
        const reason = document.getElementById('rejectReason')
        reason.value = ''
        const warningTxt = document.getElementsByClassName('warningTxt')[0]
        warningTxt.classList.remove('show')
    })

}
