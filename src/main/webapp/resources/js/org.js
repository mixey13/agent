var ajaxUrl = 'ajax/organizations/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function updateRow(id) {
    updateRowDefault(id);
}

function getAdditionalJSON() {
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
                "data": "id"
            },
            {
                "data": "name"
            },
            {
                "data": "inn"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtn
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ],
        "initComplete": makeEditable
    })
});