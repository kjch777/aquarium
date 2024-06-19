$(document).ready(function() {
    $('#login-form').submit(function(event) {
        event.preventDefault();

        var username = $('#username').val();
        var password = $('#password').val();

        function validateUsername(username) {
            var re = /^[a-zA-Z0-9]{5,}$/;
            return re.test(username);
        }

        function validatePassword(password) {
            var re = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
            return re.test(password);
        }

        if (!validateUsername(username)) {
            alert('아이디는 5자 이상의 숫자와 영어(대소문자 가능)로 입력해주세요.');
            return;
        }

        if (!validatePassword(password)) {
            alert('비밀번호는 8자 이상의 영어, 숫자, 특수문자(@$!%*#?&)를 포함해야 합니다.');
            return;
        }

        console.log('아이디:', username);
        console.log('비밀번호:', password);

        if (username === 'user' && password === 'password') {
            alert('로그인 성공!');
        } else {
            $('#error-message').text('아이디 또는 비밀번호가 틀렸습니다.').show();
        }
    });

    $('#find-username').click(function(event) {
        event.preventDefault();
        alert('아이디를 찾기 기능이 준비 중입니다.');
        
    });

    $('#find-password').click(function(event) {
        event.preventDefault();
        alert('비밀번호를 찾기 기능이 준비 중입니다.');
        
    });

    $('#register').click(function(event) {
        event.preventDefault();
        window.location.href = "회원가입.html"; 
    });
});
