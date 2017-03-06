var ajaxUrl = 'ajax/prices/';
var ajaxUrl2 = 'ajax/pc/';
var ajaxUrl3 = 'ajax/products/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

$(function () {
    var str = $.getJSON(ajaxUrl2, function (data) {
        var option = '';
        $.each(data, function (key, value) {
            option += '<option value="' + value.id + '">' + value.name + '</option>';
        });
        $('#dropdownPC').append(option);
    });

    var str2 = $.getJSON(ajaxUrl3, function (data) {
         var prod = [];
         $.each(data, function (key, value) {
            prod.push(value);
        });
         var td = '';
         for(var i = 0; i < prod.length; i++) {
             // alert(prod[i].id + prod[i].title + prod[i].description);
             var name = 'priceProducts[' + i + ']';
             td += '<tr>';
             td += '<td><input type="text" class="form-control" id="target" name="' + name + '[0]" readonly></td>';
             td += '<td><input type="text" class="form-control" name="' + name + '[1]"></td>';
             td += '</tr>';
             $('#target').val("123");
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
                "data": "priceCategory"
            },
            {
                "data": "dateTime"
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

    $('#dateTime').datetimepicker({
        format: 'Y-m-d H:i'
    });
});