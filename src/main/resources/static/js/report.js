document.addEventListener('DOMContentLoaded', function() {
    const ctx = document.getElementById('expenseChart').getContext('2d');
    const chart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ['주거비', '식비', '생활용품', '교통비', '문화', '의료'],
            datasets: [{
                data: [2650000, 373623, 259820, 254987, 169445, 70048],
                backgroundColor: ['#FF6384', '#FF9F40', '#FFCD56', '#4BC0C0', '#36A2EB', '#9966FF']
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    display: false
                }
            }
        }
    });

    // 지출/수입 선택 기능
    const typeButtons = document.querySelectorAll('.report-type-selector .btn');
    typeButtons.forEach(button => {
        button.addEventListener('click', function() {
            typeButtons.forEach(btn => btn.classList.remove('active'));
            this.classList.add('active');
            const type = this.dataset.type;
            updateReport(type);
        });
    });

    function updateReport(type) {
        const totalAmount = document.querySelector('.total-amount');
        if (type === 'expense') {
            totalAmount.textContent = '지출 3,777,930원';
            // 여기에 지출 데이터로 차트와 목록을 업데이트하는 로직 추가
        } else {
            totalAmount.textContent = '수입 5,000,000원';
            // 여기에 수입 데이터로 차트와 목록을 업데이트하는 로직 추가
        }
    }
});