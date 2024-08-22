$(document).ready(function () {

    $('#addIncomeMainCategoryButton').click(function () {
        var userId = $('#userId').val();
        var mainCategory = $('#newIncomeMainCategory').val();
        var categoryColor = $('#newIncomeCategoryColor').val();
        insertCategoryName(userId,"I","M", mainCategory,"",categoryColor)
    });

    $('#addExpenseMainCategoryButton').click(function () {
        var userId = $('#userId').val();
        var mainCategory = $('#newExpenseMainCategory').val();
        var categoryColor = $('#newExpenseCategoryColor').val();
        insertCategoryName(userId,"E","M",mainCategory,"",categoryColor)
    });

    //카테고리 추가
    function insertCategoryName(id, type, gubun, mainCategory, subCategory ,color){

        $.ajax({
            url: '/addCategory.do', // 실제 아이디 중복 확인 URL로 변경
            method: 'POST',
            data: { id: id, gubun: gubun, main_category: mainCategory, sub_category: subCategory, type: type, color: color},
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
    function initMainCategory(id){
        $.ajax({
            url: '/findMyCategoryListById.do', // 실제 아이디 중복 확인 URL로 변경
            method: 'POST',
            data: { id: id},
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

    }

});