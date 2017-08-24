var ajaxUrl = 'ajax/products/';
var datatableApi;

function updateTable() {
     $.get(ajaxUrl, updateTableByData);
}

function createJSON() {
    var product = {};
    product.id = form.find("input[name='id']").val();
    product.title = form.find("input[name='title']").val();
    product.description = form.find("input[name='description']").val();
    return JSON.stringify(product);
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