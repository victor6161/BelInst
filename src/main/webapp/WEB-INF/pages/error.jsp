<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <title><spring:message code="error"/></title>
</head>
<body>
<div class="text-center" style="margin-top: 100px">
  <b>  <spring:message code="error"/> <br></b>
    <b>  <spring:message code="${error}"/><br></b>
    <a href="/user/my_news"><spring:message code="go_to_home_page"/></a>
</div>
</body>
</html>
