$(document).ready(function () {
    $('#addIncomeCategoryButton').click(function () {
        var categoryName = $('#newIncomeCategory').val();
        insertCategoryName("I",categoryName,)
    });

    $('#addExpenseCategoryButton').click(function () {
        var categoryName = $('#newExpenseCategory').val();
        insertCategoryName("E",categoryName)
    });

    //카테고리 만들기

    function insertCategoryName(gubun,categoryName){
        $.ajax({
            url: '/insertCategoryName.do', // 실제 아이디 중복 확인 URL로 변경
            method: 'POST',
            data: { categoryName: categoryName, gubun: gubun},
            success: function (response) {
                if (response.isDuplicate) {
                    alert('이미 사용 중인 아이디입니다.');
                } else {
                    alert('사용 가능한 아이디입니다.');
                }
            },
            error: function () {
                alert('중복 확인 중 오류가 발생했습니다.');
            }
        });
    }

});