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
        $(function() {
            $("a").click(function () {
                if(this.id=='antext') {
                    $("#box").load("detecttext");
                }
                else if(this.id=='anobject'){
                    $("#box").load("detectobjects");
                }
                else if(this.id=='anface'){
                    $("#box").load("detectfaces");
                }
                else if(this.id=='ancele'){
                    $("#box").load("detectcelebs");
                }
            });

        });
    </script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid sample">
    <div class="row">
        <%--<div class="col-md-12">--%>
            <%--<p>dcceccrecrevevvvvvvfgggrtvt</p>--%>
        <%--</div>--%>
    </div>
    <div class="container-fluid text-center">
        <div class="row content">
            <div class="col-sm-2 sidenav">
                <p><a id="antext">Text Detection</a></p>
                <p><a id="anobject">Object Detection</a></p>
                <p><a id="anface">Face Detection</a></p>
                <p><a id="ancele">Celebrity Detection</a></p>
            </div>
            <div class="col-sm-10 text-left" id="box">

            </div>
        </div>
    </div>
    <footer class="container-fluid text-center">
        <p>Footer Text</p>
    </footer>

</div>
</body>
</html>
