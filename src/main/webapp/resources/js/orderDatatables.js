var ajaxUrl = 'ajax/orders/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function createJSON() {
    var orderTo = {};
    orderTo.id = form.find("input[name='id']").val();
    orderTo.organization = form.find("select[name='organization']").val();
    orderTo.client = form.find("select[name='client']").val();
    orderTo.date = form.find("input[name='date']").val();
    orderTo.time = form.find("input[name='time']").val();
    orderTo.orderProductTos = [];
    $.each(form.find('tr.orderProductTos'), function () {
        var p = {};
        p.product = this.id;
        p.cost = $(this).find("input[name='cost']").val();
        p.amount = $(this).find("input[name='amount']").val();
        orderTo.orderProductTos.push(p);
    });
    return JSON.stringify(orderTo);
}

$(function () {
    var str = $.getJSON('ajax/organizations/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownOrg').append(option);
    });

    var str2 = $.getJSON('ajax/clients/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownClient').append(option);
    });

    var str3 = $.getJSON('ajax/products/', function (data) {
        var prod = [];
        $.each(data, function (key, value) {
            prod.push(value);
        });
        var td = '';
        for(var i = 0; i < prod.length; i++) {
            td += '<tr class="orderProductTos" id="' + prod[i].id + '">';
            td += '<td>' + prod[i].title + '</td>';
            td += '<td><input type="text" class="form-control" name="cost"></td>';
            td += '<td><input type="text" class="form-control" name="amount"></td>';
            td += '</tr>';
        }
        $('#productsTable').append(td);
    });

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
                "data": "clientName"
            },
            {
                "data": "total"
            },
            {
                "data": "date"
            },
            {
                "data": "time"
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
    });

    $('#datePicker').datetimepicker({
        timepicker: false,
        lang: 'ru',
        format: 'Y-m-d'
    });

    $('#timePicker').datetimepicker({
        datepicker: false,
        lang: 'ru',
        format: 'H:i'
    });
});