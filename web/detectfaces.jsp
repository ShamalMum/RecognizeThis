<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Face Detection</title>
    <script src="js/detectfaces.js"></script>
    <link href="css/detectfaces.css" rel="stylesheet">
</head>
<body>
<div class="row content">
    <div class="col-sm-7">
        <h1 class="title">Face Detection</h1>
        <img src="img/avatar.jpg" id="sourceImage" class="img-responsive" alt="No Image">
        <form action="detectfaces" method="post" id="uploadform" enctype="multipart/form-data">
            <div class="form-group">
                <label for="file">File input</label>
                <input type="file" id="file" name="file" class="form-control-file" aria-describedby="fileHelp">
            </div>
            <button type="submit" class="btn btn-primary" id="submit">Submit</button>
        </form>
    </div>
    <div class="col-sm-5">
        <h2>Result:</h2>
        <div id="accordion">


        </div>
    </div>
</body>
</html>
