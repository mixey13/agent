<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="webjars/datetimepicker/2.5.4/jquery.datetimepicker.css">

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3>Выход продукции</h3>

            <div class="view-box">
                <a class="btn btn-sm btn-info" onclick="add()">Добавить выход</a>

                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Организация</th>
                        <th>Дата</th>
                        <th>Время</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Редактировать</h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="datePicker" class="control-label col-xs-3">Date</label>

                        <div class="col-xs-9">
                            <input type="date" class="form-control" id="datePicker" name="date" placeholder="date">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="timePicker" class="control-label col-xs-3">Time</label>

                        <div class="col-xs-9">
                            <input type="time" class="form-control" id="timePicker" name="time" placeholder="time">
                        </div>
                    </div>

                    <table class="table table-striped display" id="productsTable"></table>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="resources/js/util.js"></script>
<script type="text/javascript" src="resources/js/production.js"></script>
</html>
