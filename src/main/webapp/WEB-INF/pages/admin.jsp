<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="admin_page"/></title>
    <script type="text/javascript">
    $(document).ready(function() {
        $('#example').DataTable( {
    });
    });
    </script>
</head>
<body>
<%@ include file="inline_page/nav.jsp" %>
<div class="container text-center" style="margin-bottom: 100px;margin-top: 100px">
    <h2><spring:message code="admin_comments"/></h2>
    <table id="example" class="display" width="100%" cellspacing="0" style="margin-top:100px ">
        <thead>

    <tr>
       <div class="hidden-lg"><th></th></div>
        <th><spring:message code="author_comment"/></th>
        <th><spring:message code="text_comment"/></th>
        <th><spring:message code="date_comment"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listComment}" var="comment">
    <tr>
        <div class="hidden-lg"><th>${comment.id}</th></div>
        <th><a href="/user/news?username=${comment.author}">${comment.author}</a></th>
        <th>${comment.text}</th>
        <th>${comment.date}</th>
    </tr>
    </c:forEach>


    </tbody>
</table>
</div>
<%@ include file="inline_page/footer.jsp" %>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
