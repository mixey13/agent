var ajaxUrl = 'ajax/users/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function updateRow(id) {
    updateRowDefault(id);
}

function getAdditionalJSON() {
    $.getJSON('ajax/organizations/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownOrg').empty().append(option).val("");
    });
}

function createJSON() {
    var userTo = {};
    userTo.id = form.find("input[name='id']").val();
    userTo.name = form.find("input[name='name']").val();
    userTo.password = form.find("input[name='password']").val();
    userTo.organization = form.find("select[name='organization']").val();
    userTo.administrator = form.find(":checkbox[name='administrator']").prop("checked");
    userTo.operator = form.find(":checkbox[name='operator']").prop("checked");
    userTo.agent = form.find(":checkbox[name='agent']").prop("checked");
    return JSON.stringify(userTo);
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
                "data": "password"
            },
            {
                "data": "organizationName"
            },
            {
                "data": "administrator",
                "render": function (data) {
                    return (data === true) ? '<span class="glyphicon glyphicon-ok"></span>' : '<span class="glyphicon glyphicon-remove"></span>';
                }
            },
            {
                "data": "operator",
                "render": function (data) {
                    return (data === true) ? '<span class="glyphicon glyphicon-ok"></span>' : '<span class="glyphicon glyphicon-remove"></span>';
                }
            },
            {
                "data": "agent",
                "render": function (data) {
                    return (data === true) ? '<span class="glyphicon glyphicon-ok"></span>' : '<span class="glyphicon glyphicon-remove"></span>';
                }
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