<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <%--<div class="container">
        <a href="meals" class="navbar-brand">&lt;%&ndash;<fmt:message key="app.title"/>&ndash;%&gt;</a>

        <div class="collapse navbar-collapse">
            <form:form class="navbar-form navbar-right" action="logout" method="post">
                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="btn btn-info" role="button" href="users">&lt;%&ndash;<fmt:message key="users.title"/>&ndash;%&gt;</a>
                    </sec:authorize>
                    <a class="btn btn-info" role="button" href="profile">${userTo.name} profile</a>
                    <input type="submit" class="btn btn-primary" value="&lt;%&ndash;<fmt:message key="app.logout"/>&ndash;%&gt;">
                </sec:authorize>
            </form:form>
        </div>
    </div>--%>
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Приложение торгового представителя</a>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">Справочники<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/products">Продукты</a></li>
                            <li><a class="dropdown-item" href="/organizations">Организации</a></li>
                            <li><a class="dropdown-item" href="/clients">Клиенты</a></li>
                            <li><a class="dropdown-item" href="/pc">Категории прайс-листов</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">Документы<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/prices">Прайс-листы</a></li>
                            <li><a href="/productions">Выходы продукции</a></li>
                            <li><a href="/orders">Заказы</a></li>
                        </ul>
                    </li>
                    <li><a href="/users">Пользователи</a></li>
                </ul>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" placeholder="Email" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Password" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success">Sign in</button>
                </form>
            </div>
        </div>
</div>