var ajaxUrl = 'ajax/prices/';
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
            if (key == 'priceProductTos') {
                form.find("input[name='value']").val("");
                $.each(value, function (k, v) {
                    var tabl = form.find("tr[id='" + v.product + "']");
                    $(tabl).find("input[name = 'value']").val(v.value);
                });
            }
        });
        $('#editRow').modal();
    });
}

function getAdditionalJSON() {
    $.getJSON('ajax/pc/', function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownPC').empty().append(option).val("");
    });

    $.getJSON('ajax/products/', function (data) {
        var prod = [];
        $.each(data, function (key, value) {
            prod.push(value);
        });
        var td = '';
        td += '<thead><tr><th>Наименование</th><th>Цена</th></tr></thead>';
        for(var i = 0; i < prod.length; i++) {
            td += '<tr class="priceProductTos" id="' + prod[i].id + '">';
            td += '<td>' + prod[i].title + '</td>';
            td += '<td><input type="text" class="form-control" name="value"></td>';
            td += '</tr>';
        }
        $('#productsTable').empty().append(td);
    });
}

function createJSON() {
    var priceTo = {};
    priceTo.id = form.find("input[name='id']").val();
    priceTo.number = form.find("input[name='number']").val();
    priceTo.priceCategory = form.find("select[name='priceCategory']").val();
    priceTo.date = form.find("input[name='date']").val();
    priceTo.priceProductTos = [];
    $.each(form.find('tr.priceProductTos'), function () {
        var p = {};
        p.product = this.id;
        p.value = $(this).find("input[name='value']").val();
        priceTo.priceProductTos.push(p);
    });
    return JSON.stringify(priceTo);
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