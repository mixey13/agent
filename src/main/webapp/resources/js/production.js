var ajaxUrl = 'ajax/productions/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function updateRow(id) {
    getAdditionalJSON();
    var ppt = [];
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
            form.find("select[name='" + key + "']").val(value).change();
            if (key == 'productionProductTos') {
                form.find("input[name='amount']").val("");
                $.each(value, function (k, v) {
                    ppt.push(v);
                });
            }
        });
        $('#editRow').modal();
    });
    setTimeout(function () {
        for(var i = 0; i < ppt.length; i++){
            var tabl = form.find("tr[id='" + ppt[i].product + "']");
            $(tabl).find("input[name = 'amount']").val(ppt[i].amount);
            $('#editRow').modal();
        }
    }, 500);
}

function getAdditionalJSON() {
    $.getJSON('ajax/products/', function (data) {
        var prod = [];
        $.each(data, function (key, value) {
            prod.push(value);
        });
        var td = '<thead><tr><th>Наименование</th><th>Количество</th></tr></thead>';
        for(var i = 0; i < prod.length; i++) {
            td += '<tr class="productionProductTos" id="' + prod[i].id + '">';
            td += '<td>' + prod[i].title + '</td>';
            td += '<td><input type="text" class="form-control" name="amount"></td>';
            td += '</tr>';
        }
        $('#productsTable').empty().append(td);
    });
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
});