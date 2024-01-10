document.addEventListener("DOMContentLoaded", function() {
    const form = document.forms["memberRegisterFrm"];

    form.addEventListener("submit", function(event) {
        const memberId = form.elements["memberId"].value;
        const password = form.elements["password"].value;

        // Validate memberId
        if (memberId.trim().length < 5 || memberId.trim().length > 12) {
            alert("아이디는 5자 이상 12자 이하이어야 합니다.");
            event.preventDefault();
            return;
        }

        // Validate password
        const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{4,}$/;
        if (!passwordRegex.test(password)) {
            alert("비밀번호는 4자 이상이고, 영문자, 숫자, 특수문자를 모두 포함해야 합니다.");
            event.preventDefault();
        }
    });
});
