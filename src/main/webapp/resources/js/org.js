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

function createJSON() {
    var clientTo = {};
    clientTo.id = form.find("input[name='id']").val();
    clientTo.name = form.find("input[name='name']").val();
    clientTo.fullName = form.find("input[name='fullName']").val();
    clientTo.inn = form.find("input[name='inn']").val();
    clientTo.address = form.find("input[name='address']").val();
    return JSON.stringify(clientTo);
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