let documentId = document.getElementById('documentId').value
const getDocUrl = `/api/stdr/document/${documentId}`;
fetch(getDocUrl, {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
    }
})
    .then(result => {
        return result.json()
    })
    .then(data => {
        getTemplate(data)
    })
    .catch(error => console.error("Error fetching data:", error));

let editorObj = {}
const getTemplate = (data) => {
    const editor = document.getElementById('editor')
    editor.innerHTML = data.documentTemplate;
    const Editor = toastui.Editor;
    editorObj = new Editor({
        el: document.querySelector('#editor'),
        previewStyle: 'vertical',
        height: '500px',
        initialEditType: 'wysiwyg',
        hooks: {
            addImageBlobHook: async (blob, callback) => {
                try {
                    const formData = new FormData();
                    formData.append("image", blob);

                    const response = await fetch('/api/stdr/document/img', {
                        method: "POST",
                        headers: {
                            'header': header_csrf,
                            'X-CSRF-Token': token_csrf
                        },
                        body: formData
                    });

                    const result = await response.json();
                    const imageUrl = result.imageUrl;

                    callback(imageUrl, "이미지 설명");
                } catch (error) {
                    showAlert("이미지 업로드에 실패했습니다.", 'danger');
                }
            }
        }
    });
}

const submitBtn = document.getElementById('submit')
submitBtn.addEventListener('click', () => {
    submitApproval()
})

const submitUrl = `/api/mypage/approval`

const setSubmitBody = () => {
    let documentTemplate = ''
    if(Object.keys(editorObj).length) {
        documentTemplate  = editorObj.getHTML({ sanitize: false })
    }

    return {
        documentId,
        documentTemplate
    }
}

const submitApproval = () => {
    fetch(submitUrl,{
        method: "POST",
        headers: {
            'header': header_csrf,
            "Content-Type": "application/json",
            'X-CSRF-Token': token_csrf
        },
        body: JSON.stringify(setSubmitBody())
    }).then(result => result.json())
        .then(data => {
            if(data.message === 'success') {
                showAlert('결제서를 제출했습니다.', 'success')
                window.location = '/mypage/approval?menu=mypage'
            } else {
                showAlert('결제서를 제출 실패', 'danger')
            }
        })
        .catch(error => console.error("Error submitApproval:", error));
}