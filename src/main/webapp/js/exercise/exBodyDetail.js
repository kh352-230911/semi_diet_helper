const changeText = () => {
    const button = document.querySelector('.scrapButton');
    button.innerHTML = '스크랩 해제';
};

const defaultText = () => {
    const button = document.querySelector('.scrapButton');
    button.innerHTML = '스크랩 중'
};

const submitCheckbox = () => {
    const form = document.getElementById("checkboxFrm");
    form.submit();
};