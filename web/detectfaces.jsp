<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Face Detection</title>
    <script src="js/detectfaces.js"></script>
</head>
<body>
<div class="row content">
    <div class="col-sm-7">
        <h1 class="title">Face Detection</h1>
        <img src="img/avatar.jpg" id="sourceImage"class="img-responsive" alt="No Image">
        <form action="detectfaces" method="post" id="uploadform" enctype="multipart/form-data">
        <div class="form-group">
            <label for="file">File input</label>
            <input type="file" id="file" name="file" class="form-control-file" aria-describedby="fileHelp">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    </div>
    <div class="col-sm-5">
        <div id="accordion">
            <h3>Age Range</h3>
            <p id="age">ssssss</p>

            <h3>Gender</h3>
            <p id="sex"></p>

            <h3>Eye Glasses</h3>
            <p>Lorem ipsum dolor</p>
    </div>
</div>
</body>
</html>
