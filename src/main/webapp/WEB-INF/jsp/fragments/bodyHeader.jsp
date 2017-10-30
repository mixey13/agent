<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="start">Приложение торгового представителя</a>
            <ul class="nav navbar-nav">
                <sec:authorize access="hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN', 'ROLE_OPERATOR')">
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">Справочники<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="hasRole('ROLE_ROOT')">
                                <li><a class="dropdown-item" href="/admins">Администраторы</a></li>
                                <li><a class="dropdown-item" href="/organizations">Организации</a></li>
                                <li><a class="dropdown-item" href="/clients">Клиенты</a></li>
                            </sec:authorize>
                            <sec:authorize access="hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')">
                                <li><a class="dropdown-item" href="/users">Пользователи</a></li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_OPERATOR')">
                                <li><a class="dropdown-item" href="/products">Продукты</a></li>
                                <li><a class="dropdown-item" href="/pc">Категории прайс-листов</a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                </sec:authorize>

                <sec:authorize access="hasAnyRole('ROLE_OPERATOR', 'ROLE_AGENT')">
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">Документы<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <sec:authorize access="hasRole('ROLE_OPERATOR')">
                                <li><a class="dropdown-item" href="/contracts">Контракты</a></li>
                                <li><a class="dropdown-item" href="/prices">Прайс-листы</a></li>
                                <li><a class="dropdown-item" href="/productions">Выходы продукции</a></li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_AGENT')">
                                <li><a class="dropdown-item" href="/orders">Заказы</a></li>
                            </sec:authorize>
                            <li><a class="dropdown-item" href="/balance">Остаток</a></li>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <form:form class="navbar-form navbar-right" action="logout" method="post">
                <sec:authorize access="isAuthenticated()">
                    <button class="btn btn-primary" type="submit">
                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                    </button>
                </sec:authorize>
            </form:form>
        </div>
    </div>
</div>