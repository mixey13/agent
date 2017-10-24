var ajaxUrl = 'ajax/admins/';
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
    var admin = {};
    admin.id = form.find("input[name='id']").val();
    admin.name = form.find("input[name='name']").val();
    admin.password = form.find("input[name='password']").val();
    return JSON.stringify(admin);
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