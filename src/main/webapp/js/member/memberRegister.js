document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form');

    form.addEventListener('submit', function (e) {
        const memberId = document.getElementById('memberId').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirm-password').value;
        const name = document.getElementById('name').value;
        const nickName = document.getElementById('nickName').value;
        const height = document.getElementById('height').value;
        const birthDay = document.getElementById('birthDay').value;
        const weightLossGoal = document.getElementById('weightLossGoal').value;
        const answer = document.getElementById('answer').value;

        // 각 필드의 유효성 검사
        if (!validateMemberId(memberId) ||
            !validatePassword(password) ||
            !validateConfirmPassword(password, confirmPassword) ||
            !validateName(name) ||
            !validateNickName(nickName) ||
            !validateHeight(height) ||
            !validateBirthDay(birthDay) ||
            !validateWeightLossGoal(weightLossGoal) ||
            !validateAnswer(answer)) {
            e.preventDefault(); // 폼 제출 방지
        }
    });

    function validateMemberId(memberId) {
        // memberId 유효성 검사 로직 추가
        return /^\w{4,}$/.test(memberId);
    }

    function validatePassword(password) {
        // password 유효성 검사 로직 추가
        return /[A-Za-z\d!@#$%]{4,}/.test(password);
    }

    function validateConfirmPassword(password, confirmPassword) {
        // confirmPassword 유효성 검사 로직 추가
        return password === confirmPassword;
    }

    function validateName(name) {
        // name 유효성 검사 로직 추가
        return /^[가-힣]{2,}$/.test(name);
    }

    function validateNickName(nickName) {
        // nickName 유효성 검사 로직 추가
        // 여기서는 닉네임이 필수이면서 특별한 조건이 있다고 가정합니다.
        return nickName.trim() !== '';
    }

    function validateHeight(height) {
        // height 유효성 검사 로직 추가
        // 예: 숫자인지 확인
        return /^\d+$/.test(height);
    }

    function validateBirthDay(birthDay) {
        // birthDay 유효성 검사 로직 추가
        // 여기서는 간단한 형식만 확인한다고 가정합니다.
        return /^\d{4}-\d{2}-\d{2}$/.test(birthDay);
    }

    function validateWeightLossGoal(weightLossGoal) {
        // weightLossGoal 유효성 검사 로직 추가
        // 예: 숫자인지 확인
        return /^\d+$/.test(weightLossGoal);
    }

    function validateAnswer(answer) {
        // answer 유효성 검사 로직 추가
        // 여기서는 답이 비어있지 않은지만 확인한다고 가정합니다.
        return answer.trim() !== '';
    }
});
