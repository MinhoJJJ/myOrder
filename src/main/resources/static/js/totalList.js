$(document).ready(function() {
    var gridOptions = {
        columnDefs: [
            { headerName: "지출/수입", field: "type" },
            { headerName: "결제 종류", field: "paymentMethod" },
            { headerName: "카테고리", field: "category" },
            { headerName: "연월일", field: "date" },
            { headerName: "내용", field: "description" },
            { headerName: "금액", field: "amount" }
        ],
        defaultColDef: {
            flex: 1,
            minWidth: 100,
            sortable: true,
            resizable: true,
        }
    };

    // ag-Grid 초기화
    var myGrid = document.querySelector('#myGrid');
    new agGrid.Grid(myGrid, gridOptions);

    // 여기에 데이터를 가져와서 gridOptions.api.setRowData()를 사용하여 데이터를 추가합니다.
    // 예: gridOptions.api.setRowData(data);
});