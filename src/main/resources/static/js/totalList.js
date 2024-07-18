$(document).ready(function() {
    let grid;
    const transactions = [
        { id: 1, date: '2024-05-19', description: '지하철 요금', category: '교통비', amount: '₩2,500', type: '지출' },
        { id: 2, date: '2024-05-20', description: '점심 식사', category: '식비', amount: '₩10,000', type: '지출' },
        { id: 3, date: '2024-05-21', description: '월급', category: '수입', amount: '₩3,000,000', type: '수입' },
    ];

    function initGrid() {
        const el = document.getElementById('grid');

        grid = new tui.Grid({
            el: el,
            data: transactions,
            presetName: 'clean',  // Clean Theme 적용
            columns: [
                {
                    header: '날짜',
                    name: 'date',
                    width: 120,
                    filter: 'date'
                },
                {
                    header: '설명',
                    name: 'description',
                    width: 688,
                    filter: 'text'
                },
                {
                    header: '카테고리',
                    name: 'category',
                    width: 170,
                    filter: 'text'
                },
                {
                    header: '금액',
                    name: 'amount',
                    width: 140,
                    filter: 'number'
                },
                {
                    header: '거래 구분',
                    name: 'type',
                    width: 120,
                    filter: 'text',
                    align: 'center',
                    formatter: function(cell) {
                        if (cell.value === '지출') {
                            return '<span style="color: red;">' + cell.value + '</span>';
                        } else if (cell.value === '수입') {
                            return '<span style="color: blue;">' + cell.value + '</span>';
                        }
                        return cell.value;
                    }
                }
            ],
            bodyHeight: 'auto',
            columnOptions: {
                resizable: true
            },
            width: 'auto',
            rowHeaders: ['checkbox'],
            treeColumnOptions: {
                name: 'description',
                useCascadingCheckbox: true
            }
        });
    }

    function searchTransactions() {
        const startDate = $('#start-date').val();
        const endDate = $('#end-date').val();
        console.log('Searching transactions:', startDate, endDate);
        // 여기에 검색 로직을 구현하세요
    }

    function deleteSelectedTransactions() {
        const checkedRows = grid.getCheckedRows();
        if (checkedRows.length === 0) {
            alert('삭제할 항목을 선택해주세요.');
            return;
        }

        const idsToDelete = checkedRows.map(row => row.id);
        console.log('Deleting transactions:', idsToDelete);

        // 여기에 실제 삭제 로직을 구현하세요
        // 예: 서버에 삭제 요청을 보내고, 성공하면 그리드에서 행을 제거합니다.
        idsToDelete.forEach(id => {
            const rowKey = grid.getRowById(id).rowKey;
            grid.removeRow(rowKey);
        });
    }

    // 이벤트 리스너 설정
    $('#searchForm').on('submit', function(e) {
        e.preventDefault();
        searchTransactions();
    });

    // 삭제 버튼 추가 및 이벤트 리스너 설정
    $('<button id="deleteButton" class="btn btn-danger mt-3">선택 항목 삭제</button>').insertBefore('#grid');
    $('#deleteButton').on('click', deleteSelectedTransactions);

    // 그리드 초기화
    initGrid();
});