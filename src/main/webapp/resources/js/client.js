var ajaxUrl = 'ajax/clients/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function updateRow(id) {
    updateRowDefault(id);
}

function getAdditionalJSON() {
    $.getJSON('ajax/pc/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownPC').empty().append(option).val("");
    });
}

function createJSON() {
    var clientTo = {};
    clientTo.id = form.find("input[name='id']").val();
    clientTo.name = form.find("input[name='name']").val();
    clientTo.fullName = form.find("input[name='fullName']").val();
    clientTo.inn = form.find("input[name='inn']").val();
    clientTo.address = form.find("input[name='address']").val();
    clientTo.priceCategory = form.find("select[name='priceCategory']").val();
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