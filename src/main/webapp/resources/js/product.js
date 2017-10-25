var ajaxUrl = 'ajax/products/';
var datatableApi;

function updateTable() {
     $.get(ajaxUrl, updateTableByData);
}

function updateRow(id) {
    updateRowDefault(id);
}

function getAdditionalJSON() {
}

function createJSON() {
    var productTo = {};
    productTo.id = form.find("input[name='id']").val();
    productTo.title = form.find("input[name='title']").val();
    productTo.description = form.find("input[name='description']").val();
    return JSON.stringify(productTo);
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
                "data": "organizationName"
            },
            {
                "data": "title"
            },
            {
                "data": "description"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
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