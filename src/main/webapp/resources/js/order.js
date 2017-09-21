var ajaxUrl = 'ajax/orders/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function updateRow(id) {
    getAdditionalJSON();
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
            form.find("select[name='" + key + "']").val(value);
            if (key == 'orderProductTos') {
                form.find("input[name='cost']").val("");
                form.find("input[name='amount']").val("");
                $.each(value, function (k, v) {
                    var tabl = form.find("tr[id='" + v.product + "']");
                    $(tabl).find("input[name = 'cost']").val(v.cost);
                    $(tabl).find("input[name = 'amount']").val(v.amount);
                });
            }
        });
        $('#editRow').modal();
    });
}

function getAdditionalJSON() {
    $.getJSON('ajax/organizations/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownOrg').empty().append(option).val("");
    });

    $.getJSON('ajax/clients/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownClient').empty().append(option).val("");
    });

    $.getJSON('ajax/products/', function (data) {
        var prod = [];
        $.each(data, function (key, value) {
            prod.push(value);
        });
        var td = '<thead><tr><th>Наименование</th><th>Цена</th><th>Количество</th></tr></thead>';
        for(var i = 0; i < prod.length; i++) {
            td += '<tr class="orderProductTos" id="' + prod[i].id + '">';
            td += '<td>' + prod[i].title + '</td>';
            td += '<td><input type="text" class="form-control" name="cost"></td>';
            td += '<td><input type="text" class="form-control" name="amount"></td>';
            td += '</tr>';
        }
        $('#productsTable').empty().append(td);
    });
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