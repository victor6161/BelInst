<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <title><spring:message code="registration"/></title>

</head>
<body>
<jsp:include page="inline_page/nav.jsp"/>





<div class="row registration-block">
    <div class="col-lg-5"></div>
    <div class="col-lg-2">
        <br><br><br>
        <form:form modelAttribute="user" action="registration"  method="post" accept-charset="UTF-8">
            <p class="text-center">
                <form:label path="fullName"><spring:message code="full_name"/></form:label>
                <form:input path="fullName" maxlength="30" class="form-control"/>
                <span class="bg-danger"> <form:errors path="fullName"/></span>
                <br>
                <form:label path="login"><spring:message code="username"/></form:label>
                <br>
                <form:input path="login" maxlength="30" class="form-control"/>
                <span class="bg-danger"> <form:errors path="login"/></span>
                <br>
                <form:label path="password"><spring:message code="password"/> </form:label>
                <br>
                <form:input path="password" maxlength="30" type="password" class="form-control"/>
                <span class="bg-danger"> <form:errors path="password"/></span>
                <br>
                <form:label path="confirmPassword"><spring:message code="confirm_password"/> </form:label>
                <br>
                <form:input path="confirmPassword" maxlength="30" type="password" class="form-control"/>
                <span class="bg-danger">   <form:errors path="confirmPassword"/></span>
                <br>
                <form:label path="email"><spring:message code="email"/> </form:label>
                <br>
                <form:input path="email" maxlength="30" class="form-control"/>
                <span class="bg-danger">   <form:errors path="email"/></span>
                <br>
                <input type="submit" value="<spring:message code="signup"/> " class="btn btn-green">
            </p>
        </form:form>
        <p class="small-text text-center"><spring:message code="have_account"/> <a href="/"><spring:message code="signin"/> </a></p>

    </div>
</div>
<jsp:include page="inline_page/footer.jsp"/>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
