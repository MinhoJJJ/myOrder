$(document).ready(function () {
    $('#checkDuplicateId').click(function () {
        var userId = $('#signupId').val();
        console.log("userId: "+userId)
        if (userId === '') {
            alert('아이디를 입력하세요.');
            return;
        }
        var isValid = /^[a-z0-9]*$/.test(userId);
        if (!isValid) {
            // 유효하지 않은 문자가 포함된 경우 처리 (예: 경고 메시지 표시)
            alert('영어 소문자와 숫자만 입력할 수 있습니다.');
            $('#signupId').val("");
            return;
        }

        // AJAX 요청으로 아이디 중복 확인
        $.ajax({
            url: '/checkDuplicateIdAjax.do', // 실제 아이디 중복 확인 URL로 변경
            method: 'POST',
            data: { Id: userId },
            success: function (response) {
                 console.log("result: "+response.result);
                if (response.result =="S") {
                    alert('이미 사용 중인 아이디입니다.');
                    $('#signupId').val("");
                } else {
                    alert('사용 가능한 아이디입니다.');
                }
            },
            error: function () {
                alert('중복 확인 중 오류가 발생했습니다.');
            }
        });
    });

    $('#signupForm').submit(function (e) {
        var email = $('#signupEmail').val();
        if (!validateEmail(email)) {
            alert('유효한 이메일 주소를 입력하세요.');
            e.preventDefault();
        }
    });

    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    }
});