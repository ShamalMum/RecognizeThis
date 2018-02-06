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
    <link href="css/layout.css" rel="stylesheet">
    <script type="text/javascript">
        $(document).ready(function () {
            $("button").click(function () {
                $("#box").load("item");
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
                <li class="active"><a data-toggle="pill" href="#home">Home</a></li>
                <li><a data-toggle="pill">Menu 1</a></li>
                <li><a data-toggle="pill" href="#menu2">Menu 2</a></li>
                <li><a data-toggle="pill" href="#menu3">Menu 3</a></li>
                <li>
                    <button id="hello">hello</button>
                </li>
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
