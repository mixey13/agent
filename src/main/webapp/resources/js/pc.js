var ajaxUrl = 'ajax/pc/';
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
    var priceCategoryTo = {};
    priceCategoryTo.id = form.find("input[name='id']").val();
    priceCategoryTo.name = form.find("input[name='name']").val();
    priceCategoryTo.description = form.find("input[name='description']").val();
    return JSON.stringify(priceCategoryTo);
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
                "data": "name"
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