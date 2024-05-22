$(document).ready(function() {
        // 엑셀 다운로드 버튼 클릭 이벤트 처리
        document.querySelector('.excel-download-btn').addEventListener('click', function () {
            const reportMonth = document.getElementById('reportMonth').innerText;
            const totalExpense = document.getElementById('totalExpense').innerText;
            const foodExpense = document.getElementById('foodExpense').innerText;
            const transportExpense = document.getElementById('transportExpense').innerText;
            const entertainmentExpense = document.getElementById('entertainmentExpense').innerText;

            const data = [
                ['월별 지출 보고서'],
                [reportMonth],
                [totalExpense],
                ['카테고리별 지출:'],
                [foodExpense],
                [transportExpense],
                [entertainmentExpense]
            ];

            // 엑셀 파일 생성
            const sheet = XLSX.utils.aoa_to_sheet(data);
            const workbook = XLSX.utils.book_new();
            XLSX.utils.book_append_sheet(workbook, sheet, '보고서');

            // 파일 저장
            XLSX.writeFile(workbook, 'report.xlsx', {
                bookType: 'xlsx',
                bookSST: true,
                type: 'array'
            });
        });

    // 차트 생성
    new Chart(document.getElementById("myChart"), {
        type: 'bar',
        data: {
            labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
            datasets: [
                {
                    label: "Population (millions)",
                    backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
                    data: [2478,5267,734,784,433]
                }
            ]
        },
        options: {
            legend: { display: false },
            title: {
                display: true,
            }
        }
    });
});