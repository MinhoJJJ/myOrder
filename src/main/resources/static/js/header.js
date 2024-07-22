$(document).ready(function() {
    var currentPage = window.location.pathname.split('/').pop().split('.')[0];
    console.log(currentPage);
    console.log(document.baseURI);

    if (document.baseURI.includes(currentPage)) {
        $('#'+currentPage).addClass('active');
        $('#'+currentPage).css('font-weight', '900');
    } else {
        $(this).removeClass('active');
    }
});