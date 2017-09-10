var form;

function makeEditable() {
    form = $('#detailsForm');

    form.submit(function () {
        save();
        return false;
    });
}

function add() {
    form.find("input[type='text']").val("");
    form.find("input[type='date']").val("");
    form.find("select").val("");

    $('#id').val(0);
    $('#editRow').modal();
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        contentType: 'application/json; charset=utf-8',
        data: createJSON(),
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
        }
    });
}

function updateRow(id) {
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
            form.find("select[name='" + key + "']").val(value);
            if (key == 'priceProductTos') {
                form.find("input[name='value']").val("");
                myEach(value);
            }
            if (key == 'orderProductTos') {
                form.find("input[name='cost']").val("");
                form.find("input[name='amount']").val("");
                myEach2(value);
            }
        });
        $('#editRow').modal();
    });
}

function myEach(data) {
    $.each(data, function (key, value) {
        var tabl = form.find("tr[id='" + value.product + "']");
        $(tabl).find("input[name = 'value']").val(value.value);
    });
}

function myEach2(data) {
    $.each(data, function (key, value) {
        var tabl = form.find("tr[id='" + value.product + "']");
        $(tabl).find("input[name = 'cost']").val(value.cost);
        $(tabl).find("input[name = 'amount']").val(value.amount);
    });
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
        }
    });
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ');">Edit</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ');">Delete</a>';
    }
    return data;
}
