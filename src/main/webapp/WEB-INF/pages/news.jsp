<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title><spring:message code="news"/> </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script>
        function addComment() {
            console.log("sendCommentBegin");
            $.ajax({
                url: 'comment',
                data: (
                    {
                        comment: $(this).siblings(".textCom").val(),
                        reference: $(this).siblings(".ref").text()
                    }
                )
            })
            if($(this).siblings(".textCom").val().trim()!='') {
                $(this).parent(".new-comment").parent(".comment-all-block").children(".comment:last").append('<div class="t9">' + $(this).siblings(".author").text() + ': '
                    + $(this).siblings(".textCom").val() + '</div>');
            }
            $(this).siblings(".textCom").val('');

            console.log("sendCommentEnd");
        }
        function deleteComment() {
            console.log("sendDeleteCommentBegin");
            $.ajax({
                url: '/admin/deleteComment',
                data: (
                    {
                        id: $(this).siblings(".id").text(),
                    }
                )
            })
            $(this).siblings(".t9").css("color", "red" );
            $(this).remove();
            console.log("sendDeleteCommentEnd");
        }
        $(document).ready(function () {
            $(".new-comment").on("click", ".addComment", addComment);
            $(".comment").on("click", ".deleteComment", deleteComment);
        })
    </script>
</head>
<body>
<br><br><br><br>
<%@ include file="inline_page/nav.jsp" %>

<div class="row news-block">
    <p class="text-center big-text" style="color: black">  ${nothing}  </p>
    <div class="col-lg-3"></div>
    <div class="col-lg-6">

        <c:forEach items="${pictureList}" var="picture">
            <section>
                <p class="text-center">
                    <a href="news?username=${picture.author}" class="candidatesName">${picture.author}</a>
                    <br>
                    <img src="images/${picture.ref}" alt="pictureUser" style="max-width:400px;height:auto;">
                    <br>
                        ${picture.description}
                    <br>
                        ${picture.date}
                    <br>
                    <b><spring:message code="comments"/></b>
                    <br>
                <div class="comment-all-block">
                <div class="comment text-center"></div>
                    <c:forEach items="${picture.comments}" var="comment">
                        <div class="comment text-center">
                            <div class="t9">${comment.author}: ${comment.text}</div>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <div class="ref hidden-lg hidden-md">${picture.ref}</div>
                                <div class="id hidden-lg">${comment.id}</div>
                                <div class="date hidden-lg">${comment.date}</div>
                                <img  class="deleteComment" style="cursor: pointer" src="/resources/images/andr_krest.png"/>
                            </sec:authorize>
                        </div>
                    </c:forEach>

                <div class="new-comment text-center">

                    <div class="author hidden-lg hidden-md">${login}</div>
                    <div class="ref hidden-lg">${picture.ref}</div>
                    <textarea class="textCom form-control" maxlength="200"></textarea>
                    <br>
                    <button class="addComment btn btn-green"><spring:message code="add_comment"/></button>
                </div>
            </div>
            </section>

        </c:forEach>
    </div>
</div>
<%@ include file="inline_page/footer.jsp" %>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
