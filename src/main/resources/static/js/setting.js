$(document).ready(function () {
    $('#addIncomeCategoryButton').click(function () {
        var categoryName = $('#newIncomeCategory').val();
        var categoryColor = $('#newIncomeCategoryColor').val();
        insertCategoryName("I",categoryName,categoryColor)
    });

    $('#addExpenseCategoryButton').click(function () {
        var categoryName = $('#newExpenseCategory').val();
        var categoryColor = $('#newExpenseCategoryColor').val();
        insertCategoryName("E",categoryName,categoryColor)
    });

    //카테고리 추가
    function insertCategoryName(gubun ,categoryName ,color){

        $.ajax({
            url: '/insertCategoryName.do', // 실제 아이디 중복 확인 URL로 변경
            method: 'POST',
            data: { id: "wat", categoryName: categoryName, gubun: gubun, color: color},
            success: function (response) {
                if (response.result == "S") {
                    // 성공한 경우 카테고리 입력란 초기화
                    if(gubun =='I'){
                        $('#newIncomeCategory').val("");
                    }else{
                        $('#newExpenseCategory').val("");
                    }
                    alert(response.message);
                } else {
                    alert(response.message);
                }
            },
            error: function () {
                alert('카테고리 추가에 실패하였습니다.');
            }
        });
    }

});