<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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

</body>
</html>
