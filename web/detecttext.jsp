<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Text Detection</title>
    <script src="scripts.js"></script>
</head>
<body>
<div id="container">
    <h1 class="title">Text Detection</h1>
    <form action="detecttext" method="post" id="uploadform" enctype="multipart/form-data">
        <img id="sourceImage" src="" class="img-fluid" alt="Source image">
        <div class="form-group">
            <label for="fileupload">File input</label>
            <input type="file" id="fileupload" name="file" class="form-control-file" aria-describedby="fileHelp">
            <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the
                above input. It's a bit lighter and easily wraps to a new line.
            </small>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
