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
    <title>Recongnize This</title>
    <link href="img/camera.png" type="image/gif" rel="shortcut icon"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="css/layout.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script src="js/layout.js" type="text/javascript"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Recognize This</a>

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <ul class="nav nav-pills">
                <li role="presentation" class="nav-item">
                    <a id="anchrtext" class="nav-link active" data-toggle="pill">Text Detection</a>
                </li>
                <li role="presentation" class="nav-item">
                    <a id="anchobject" class="nav-link" data-toggle="pill">Object Detection</a>
                </li>
                <li role="presentation" class="nav-item">
                    <a id="anchface" class="nav-link" data-toggle="pill">Face Detection</a>
                </li>
                <li role="presentation" class="nav-item">
                    <a id="anchcele" class="nav-link" data-toggle="pill">Celebrity Detection</a>
                </li>
            </ul>
        </div>
        <div class="col-sm-10 text-left" id="box">

        </div>
    </div>
</div>
<footer class="container-fluid text-center">
    <p>&#x000A9;&nbsp;2018 Maharishi University of Management Fairfield IOWA All rights reserved.</p>
</footer>

</div>
</body>
</html>
