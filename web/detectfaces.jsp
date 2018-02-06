<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Face Detection</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script src="scripts.js"></script>
</head>
<body>
<form action="detectfaces" method="post" id="uploadform" enctype="multipart/form-data">
    <div class="form-group">
        <label for="exampleInputFile">File input</label>
        <input type="file" id="file" name="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
        <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
