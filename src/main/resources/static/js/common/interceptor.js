/*
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

    class CustomXHR extends originalXHR {
        constructor() {
            super();
            console.log("[XHR Intercept] Created");

            this.addEventListener("readystatechange", function () {
                if (this.readyState === 4 && this.status === 401) {
                    showAlert("세션이 만료되었습니다. 로그인 페이지로 이동합니다.", 'danger');
                    setTimeout(() => {
                        window.location.href = "/login";
                    }, 3000);
                }
            });
        }

        open(method, url, async, user, password) {
            console.log("[XHR Intercept] Open:", method, url);
            super.open(method, url, async, user, password);
        }

        send(body) {
            console.log("[XHR Intercept] Sending Request...");
            console.log("[XHR Intercept] Body:", body || "(No Body - GET/DELETE request)");

            // 기존 onreadystatechange 유지
            const originalOnReadyStateChange = this.onreadystatechange;

            this.addEventListener("readystatechange", function () {
                console.log("[XHR Intercept] readyState:", this.readyState);
                console.log("[XHR Intercept] readyState:", this.readyState);
                if (this.readyState === 4) {
                    console.log("[XHR Intercept] Response Text:", this.responseText);
                    try {
                        // 기존 핸들러가 존재하면 실행
                        if (originalOnReadyStateChange && typeof originalOnReadyStateChange === "function") {
                            try {
                                originalOnReadyStateChange.apply(this);
                            } catch (e) {
                                console.log('originalOnReadyStateChange.apply(this); error')
                            }
                        }
                    } catch (error) {
                        console.error("[XHR Intercept] Error in onreadystatechange:", error);
                    }
                }
            });
            try {
                if (body === null) {
                    console.log("[XHR Intercept] Executing GET Request...");
                    super.send();
                } else {
                    console.log("[XHR Intercept] Executing POST Request...");
                    super.send(body);
                }
            } catch (error) {
                console.error("[XHR Intercept] super.send() error:", error);
            }
        }
    }

    window.XMLHttpRequest = CustomXHR;
})();
*/