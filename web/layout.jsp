<%--
  Created by IntelliJ IDEA.
  User: shama
  Date: 2/5/2018
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Layout</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script src="scripts.js"></script>
    <link href="css/layout.css" rel="stylesheet">
    <script type="text/javascript">
        $(document).ready(function () {
            $("button").click(function () {
                if(this.id=='btntext') {
                    $("#box").load("detecttext");
                }
                else if(this.id=='btnobject'){
                    $("#box").load("detectobjects");
                }
                else if(this.id=='btnface'){
                    $("#box").load("detectfaces");
                }
                else if(this.id=='btncele'){
                    $("#box").load("detectcelebs");
                }
            });
        });
    </script>
</head>
<body>
<div class="container-fluid sample">
    <div class="row">
        <div class="col-md-12">
            <p>dcceccrecrevevvvvvvrtvt</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked">
                <%--<li class="active"><a data-toggle="pill" href="#home">Home</a></li>--%>
                <%--<li><a data-toggle="pill">Menu 1</a></li>--%>
                <%--<li><a data-toggle="pill" href="#menu2">Menu 2</a></li>--%>
                <%--<li><a data-toggle="pill" href="#menu3">Menu 3</a></li>--%>
                <%--<li>--%>
                    <%--<button id="hello">Text Detection</button>--%>
                <%--</li>--%>

                <li> <button id="btntext">Text Detection</button></li>
                <li><button id="btnobject">Object Detection</button></li>
                <li><button id="btnface">Face Detection</button></li>
                <li><button id="btncele">Celebrity Detection</button></li>
            </ul>
        </div>
        <div class="col-md-9" id="box">
            <div class="tab-content">


            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <p>dcceccrecrevevvvvvvrtvt</p>
        </div>
    </div>

</div>
</body>
</html>
