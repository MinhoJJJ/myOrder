// static/js/header.js
document.addEventListener("DOMContentLoaded", function () {
    fetch("header.do")
        .then(response => response.text())
        .then(data => {
            document.getElementById("header").innerHTML = data;
        });

    function showUserGreeting(username) {
        document.getElementById('userGreeting').innerHTML = `${username} 님, 안녕하세요`;
    }

});
