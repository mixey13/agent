var ajaxUrl = 'ajax/balance/';
var datatableApi;

function updateTable() {
    var filter = $('#datePicker').val();
    $.get(ajaxUrl + filter, updateTableByData);
}

function clearFilter() {
    $('#datePicker').val("");
    $.get(ajaxUrl, updateTableByData);
}

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "product"
            },
            {
                "data": "amount"
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ],
        "initComplete": makeEditable
    });

    $('#datePicker').datetimepicker({
        timepicker: false,
        lang: 'ru',
        format: 'Y-m-d'
    });
});