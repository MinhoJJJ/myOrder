$(document).ready(function() {
    console.log("나실행")
    var currentPage = window.location.pathname.split('/').pop().split('.')[0];
    console.log(currentPage);
    console.log(document.baseURI);

    if (document.baseURI.includes(currentPage)) {
        console.log("나실행1")
        $('#'+currentPage).addClass('active');
    } else {
        console.log("나실행2")
        $(this).removeClass('active');
    }
});