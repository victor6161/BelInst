<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css"
          href="/resources/jquery/jquery-ui.min.css">
    <script src="https:/code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">

    <title><spring:message code="add_photo"/></title>
    <script>
        function uploadJqueryForm() {
            $('#result').html('');
            $('#fileName').html('');
            $("#addPhoto").ajaxForm({
                success: function (data) {
                    $('#result').html(data);
                    $("#dialog").dialog();
                },
                dataType: "text"
            }).submit();
            $('#descriptionPicture').val('');
            return false;
        }
        $(document).on('change', ':file', function () {
            var input = $(this),
                numFiles = input.get(0).files ? input.get(0).files.length : 1,
                label = input.val()/*.replace(/\\/g, '/').replace(/.*\//, '')*/;
            input.trigger('fileselect', [numFiles, label]);
        });
        $(document).ready(function () {
            $(':file').on('fileselect', function (event, numFiles, label) {
                console.log(numFiles);
                console.log(label);
                $('#fileName').html(label);
            });
            $("#uploadSubmit").button().click(function (e) {
                uploadJqueryForm();
                e.preventDefault();
                return false;
            });
        });

    </script>
</head>
<body>
<div class="b-container">
    <%@ include file="inline_page/nav.jsp" %>
    <br><br><br><br>
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-2">

            <form id="addPhoto" enctype="multipart/form-data" method="post" action="addPhotoAction">
                <p class="text-center">
                    <span class="btn btn-default btn-file">
                        <spring:message code="browse"/> <input type="file" name="file">
                    </span>
                    <br>
                    <span id="fileName">
                    </span>
                    <br><br>
                    <b><spring:message code="description"/></b>
                    <br><br>
                    <textarea id="descriptionPicture" name="descriptionPicture" cols="40" rows="5" form="addPhoto"
                              class="form-control"></textarea>
                    <br><br>
                    <button class="btn btn-green" id="uploadSubmit"><spring:message code="load_picture"/></button>


                </p>
            </form>
        </div>
    </div>

    <div class="hidden-lg">
        <div id="dialog">
            <div id="result"></div>

        </div>
    </div>

    <%@ include file="inline_page/footer.jsp" %>
</div>

<script src="/resources/js/bootstrap.min.js"></script>
<%--<script src="/resources/jquery/jquery.form.js"></script>
<script src="/resources/jquery/jquery-1.10.2.min.js"></script>
<script src="/resources/jquery/jquery-ui.min.js"></script>--%>
</body>
</html>
