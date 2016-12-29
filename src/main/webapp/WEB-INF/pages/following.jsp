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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="following"/></title>

    <script type="text/javascript">
        function addFriend() {
            console.log("addFriendBegin");
            $.ajax({
                url: 'addFriend',
                data: ({name: $(this).siblings(".candidatesName").text()}),
            })
            $(this).siblings(".candidatesName").css("color", "blue" );
            $(this).css("color", "blue" );
            console.log("addFriendEnd");
        }
        function removeFriend() {
            console.log("removeFriendBegin");
            $.ajax({
                url: 'removeFriend',
                data: ({name: $(this).siblings(".friendsName").text()}),
            })
            $(this).siblings(".friendsName").css("color", "#F5F5F5" );;
            $(this).css("color", "#F5F5F5" );
            console.log("removeFriendEnd");
        }

        $(document).ready(function () {
            $(".rootCandidate").on("click", ".subscribe", addFriend);
            $(".rootFriend").on("click", ".unsubscribe", removeFriend);
        });


    </script>
</head>
<body>
<%@ include file="inline_page/nav.jsp" %>
<br><br><br><br>
<div class="row">
    <div class="col-lg-6">
        <p class="text-center">
            <b><spring:message code="following"/></b>
        <div class="rootFriend text-center">
    </div>
            <c:forEach items="${listFriend}" var="friend">
                    <div class="rootFriend text-center">
                        <a href="news?username=${friend.friend}" class="friendsName">${friend.friend}</a>
                        <br>
                        <button class="unsubscribe btn" >
                            <spring:message code="unsubscribe"/>
                        </button>
                    </div>
            </c:forEach>
        </p>
    </div>

    <div class="col-lg-6">
        <p class="text-center">
            <b><spring:message code="search"/>:</b>
            <br>
        <center>
        <form action="search" method="get">
            <input class="form-control" name="user" type="text" maxlength="30" autocomplete="on" style="width: 200px;margin-bottom: 10px;" >
            <input type="submit" class="btn btn-green" value="<spring:message code="search_user"/>">
        </form>
        </center>
            <div class="rootCandidate text-center"></div>
            <c:forEach items="${listCandidates}" var="candidate">
                <div class="rootCandidate text-center">
                    <a href="news?username=${candidate.login}" class="candidatesName">${candidate.login}</a>
                    <br>
                        <button class="subscribe btn" >
                            <spring:message code="subscribe"/>
                        </button>
                </div>
            </c:forEach>

        </p>
    </div>
</div>
<%@ include file="inline_page/footer.jsp" %>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
