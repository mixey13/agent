var ajaxUrl = 'ajax/productions/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function createJSON() {
    var productionTo = {};
    productionTo.id = form.find("input[name='id']").val();
    productionTo.organization = form.find("select[name='organization']").val();
    productionTo.date = form.find("input[name='date']").val();
    productionTo.time = form.find("input[name='time']").val();
    productionTo.productionProductTos = [];
    $.each(form.find('tr.productionProductTos'), function () {
        var p = {};
        p.product = this.id;
        p.amount = $(this).find("input[name='amount']").val();
        productionTo.productionProductTos.push(p);
    });
    return JSON.stringify(productionTo);
}

$(function () {
    var str = $.getJSON('ajax/organizations/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownOrg').append(option);
    });

    var str2 = $.getJSON('ajax/products/', function (data) {
        var prod = [];
        $.each(data, function (key, value) {
            prod.push(value);
        });
        var td = '';
        for(var i = 0; i < prod.length; i++) {
            td += '<tr class="productionProductTos" id="' + prod[i].id + '">';
            td += '<td>' + prod[i].title + '</td>';
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