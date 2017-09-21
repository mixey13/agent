var form;

function makeEditable() {
    form = $('#detailsForm');

    form.submit(function () {
        save();
        return false;
    });
}

function add() {
    getAdditionalJSON();
    form.find("input").val("");

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

function updateRowDefault(id) {
    getAdditionalJSON();
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
            form.find("select[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
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
