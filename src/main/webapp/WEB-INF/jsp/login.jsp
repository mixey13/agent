<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">

<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="start">Приложение торгового представителя</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form:form class="navbar-form" role="form" action="spring_security_check" method="post">
                        <div class="form-group">
                            <input type="text" placeholder="Name" class="form-control" name="username">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control" name="password">
                        </div>
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                        </button>
                    </form:form>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="jumbotron">
    <div class="container">
        <c:if test="${param.error}">
            <div class="error">
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
        <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('root', 'root')">ROOT</button>
        <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('admin', 'admin')">Администратор</button>
        <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('operator', 'operator')">Оператор</button>
        <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('agent', 'agent')">Агент</button>
        <button type="submit" class="btn btn-lg btn-primary" onclick="setCredentials('user', 'user')">Пользователь</button>
    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
<script type="text/javascript">
    <c:if test="${not empty param.username}">
    setCredentials("${param.username}", "");
    </c:if>
    function setCredentials(username, password) {
        $('input[name="username"]').val(username);
        $('input[name="password"]').val(password);
    }
</script>
</body>
<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
</html>
