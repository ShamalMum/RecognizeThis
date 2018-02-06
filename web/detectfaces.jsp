<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Face Detection</title>
    <script src="js/detectfaces.js"></script>
</head>
<body>
<div id="container">
    <h1 class="title">Face Detection</h1>
    <form action="detectfaces" method="post" id="uploadform" enctype="multipart/form-data">
        <div class="form-group">
            <label for="exampleInputFile">File input</label>
            <input type="file" id="file" name="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
            <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
