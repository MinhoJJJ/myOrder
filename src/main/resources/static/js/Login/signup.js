$(document).ready(function () {
    $('#checkDuplicateId').click(function () {
        var userId = $('#signupId').val();
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

    $('#signUpBtn').click(function () {

        var userId = $('#signupId').val();
        var password = $('#Password').val();
        var birthday = $('#Birthday').val();
        var email = $('#Email').val();
        var name = $('#Name').val();
        console.log("userId: "+userId);
        console.log("password: "+password);
        console.log("birthday: "+birthday);
        console.log("email: "+email);
        console.log("name: "+name);



        // var writeForm = $('#signupForm');
        // var other_data = writeForm.serializeArray();
        // var formData  = new FormData();

        // $.each(other_data,function(key,input){
        //     console.log(input.name+"= "+input.value);
        //     form.append(input.name, input.value);
        // });


        // AJAX 요청으로 아이디 중복 확인
        $.ajax({
            url: '/signUp.do', // 실제 아이디 중복 확인 URL로 변경
            method: 'POST',
            data: { Id: userId, Password:password,
                Birthday:birthday,Name:name, Email:email
            },
            success: function (response) {
                if (response.result =="S") {
                    alert('회원가입에 성공하셨습니다.');
                    $('#signupId').val("");
                } else {
                    alert('회원가입에 실패하셨습니다.');
                }
            },
            error: function () {
                alert('중복 확인 중 오류가 발생했습니다.');
            }
        });
    });

    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    }
});