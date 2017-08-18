var ajaxUrl = 'ajax/prices/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function createJSON() {
    var priceTo = {};
    priceTo.id = form.find("input[name='id']").val();
    priceTo.number = form.find("input[name='number']").val();
    priceTo.priceCategory = form.find("select[name='priceCategory']").val();
    priceTo.date = form.find("input[name='date']").val();
    priceTo.priceProductTos = [];
    $.each(form.find("input[name='priceProductTos']"), function () {
        var p = {};
        p.product = this.id;
        p.value = this.value;
        priceTo.priceProductTos.push(p);
    });
    return JSON.stringify(priceTo);
}

$(function () {
    var str = $.getJSON('ajax/pc/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownPC').append(option);
    });

    var str2 = $.getJSON('ajax/products/', function (data) {
        var prod = [];
        $.each(data, function (key, value) {
            prod.push(value);
        });
        var td = '';
        for(var i = 0; i < prod.length; i++) {
            td += '<tr>';
            td += '<td>' + prod[i].title + '</td>';
            td += '<td><input type="text" class="form-control" name="priceProductTos" id="' + prod[i].id + '"></td>';
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
                "data": "number"
            },
            {
                "data": "priceCategoryName"
            },
            {
                "data": "date"
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
});