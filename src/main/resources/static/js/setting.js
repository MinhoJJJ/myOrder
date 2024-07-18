$(document).ready(function () {
    $('#addIncomeCategoryButton').click(function () {
        const categoryName = $('#newIncomeCategory').val();
        console.log(categoryName)


        // 카테고리 만들기
        $.ajax({
            url: '/insertCategoryName.do', // 실제 아이디 중복 확인 URL로 변경
            method: 'POST',
            data: { categoryName: categoryName },
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
    });
});