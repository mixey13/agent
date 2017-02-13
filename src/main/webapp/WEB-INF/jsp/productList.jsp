<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>


<%--
<head>
    <title>Title</title>
</head>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
    </tr>
    </thead>
    <c:forEach items="${productList}" var="product">
        <jsp:useBean id="product" scope="page" type="mixey.agent.model.Product"/>
        <tr>
            <td>"${product.id}"</td>
            <td>"${product.title}"</td>
            <td>"${product.description}"</td>
        </tr>
    </c:forEach>
</table>
--%>

<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <%--<h3><fmt:message key="users.title"/></h3>--%>

            <div class="view-box">
                <a class="btn btn-sm btn-info" onclick="add()"><%--<fmt:message key="users.add"/>--%></a>

                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <c:forEach items="${productList}" var="product">
                        <jsp:useBean id="product" scope="page" type="mixey.agent.model.Product"/>
                        <tr>
                            <td>"${product.id}"</td>
                            <td>"${product.title}"</td>
                            <td>"${product.description}"</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>



</body>
</html>
