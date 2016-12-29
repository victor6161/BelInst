<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="authentication"/></title>
</head>
<body>

<%@ include file="inline_page/nav.jsp" %>

<div class="row">
            
        <div class="col-lg-5"></div>
           
        <div class="col-lg-2">
                    <br><br><br>

            <c:if test="${not empty error}">
                <div class="text-danger"><spring:message code="${error}"/></div>
            </c:if>
        <form action="/user/welcome" method="post">
            <p class="text-center">
                <span class="font_label"><spring:message code="username"/></span>

                <input type="text" name="login" maxlength="30" class="form-control"/>
                <br>

                <span><spring:message code="password"/></span>

                <input type="password" name="password" maxlength="30" class="form-control"/>
            </p>
            <br>
            <p class="text-center">
                <input type="submit" value="<spring:message code="signin"/>" class="btn btn-green btn-md">
            </p>
        </form>
    </div>
</div>
<p class="small-text text-center"><spring:message code="don't_have_account"/> <a href="/registrationPage"><spring:message code="signup"/></a></p>


<br><br>
<%@ include file="inline_page/footer.jsp" %>

<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>
