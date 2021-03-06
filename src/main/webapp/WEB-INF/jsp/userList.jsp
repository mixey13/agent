<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3>Пользователи</h3>

            <div class="view-box">
                <a class="btn btn-sm btn-info" onclick="add()">Добавить пользователя</a>

                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Имя</th>
                        <th>Пароль</th>
                        <th>Организация</th>
                        <th>Администратор</th>
                        <th>Оператор</th>
                        <th>Агент</th>
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
                        <label for="name" class="control-label col-xs-3">Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="control-label col-xs-3">Password</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="password" name="password" placeholder="Password">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="dropdownOrg" class="control-label col-xs-3">Organization</label>

                        <div class="col-xs-9">
                            <select class="dropdown form-control" id="dropdownOrg" name="organization"></select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="administrator" class="control-label col-xs-3">Администратор</label>

                        <div class="col-xs-1">
                            <input type="checkbox" class="form-control checkbox-inline" id="administrator" name="administrator">
                        </div>

                        <label for="operator" class="control-label col-xs-3">Оператор</label>

                        <div class="col-xs-1">
                            <input type="checkbox" class="form-control checkbox-inline" id="operator" name="operator">
                        </div>

                        <label for="agent" class="control-label col-xs-3">Агент</label>

                        <div class="col-xs-1">
                            <input type="checkbox" class="form-control checkbox-inline" id="agent" name="agent">
                        </div>
                    </div>

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
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="resources/js/util.js"></script>
<script type="text/javascript" src="resources/js/user.js"></script>
</html>
