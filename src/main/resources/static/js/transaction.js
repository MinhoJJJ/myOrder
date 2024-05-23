$(document).ready(function() {
    console.log("gdgd");
    $('#expenseBtn').click(function() {
        console.log(" 클릭함")
        $(this).addClass('active');
        $('#incomeBtn').removeClass('active');
    });

    $('#incomeBtn').click(function() {
        $(this).addClass('active');
        $('#expenseBtn').removeClass('active');
    });
});