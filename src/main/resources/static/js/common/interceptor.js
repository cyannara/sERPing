
(function () {
    const originalFetch = window.fetch;
    const originalXHR = window.XMLHttpRequest;

    window.fetch = async function (url, options) {
        const response = await originalFetch(url, {
            ...options,
            credentials: "include"
        });


        if (response.status === 401) {
            showAlert("세션이 만료되었거나 로그인이 필요합니다.", 'danger');
            setTimeout(() => {
                window.location.href = "/login";
            }, 3000)
        }

        return response;
    };

    // XMLHttpRequest 감지
    window.XMLHttpRequest = function () {
        const xhr = new originalXHR();

        xhr.addEventListener("readystatechange", function () {
            if (xhr.readyState === 4 && xhr.status === 401) {
                showAlert("세션이 만료되었습니다. 로그인 페이지로 이동합니다.", 'danger');
                setTimeout(() => {
                    window.location.href = "/login";
                }, 3000)
            }
        });

        return xhr;
    };
})();