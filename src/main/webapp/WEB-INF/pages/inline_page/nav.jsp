<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<!--Navigation bar-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <p class="navbar-brand"><a href="/user/my_news">BEL<span>INST</span></a></p>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                    <li><a href="/user/addPhotoPage"><spring:message code="add_photo"/> </a></li>
                    <li><a href="/user/my_news"><spring:message code="my_news"/></a></li>
                    <li><a href="/user/friends_news"><spring:message code="news_friend"/> </a></li>
                    <li><a href="/user/following"><spring:message code="following"/> </a></li>
                    <li>
                        <ul>
                             <li><spring:message code="hello"/><span style="color: #985f0d"> ${login}</span></li>
                            <li><a href="/logout"><spring:message code="logout"/></a></li>
                        </ul>
                    </li>
                </sec:authorize>
                    <li class="dropdown">
                        <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <spring:message code="language"/>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="?lang=ru">Русский</a></li>
                            <li><a href="?lang=en">English</a></li>
                        </ul>
                    </li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="btn-trial">
                        <a href="/admin/page"><spring:message code="admin_page"/></a>

                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>

<%--<script src="/resources/js/bootstrap.min.js"></script>--%>


