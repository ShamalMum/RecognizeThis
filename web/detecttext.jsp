<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Text Detection</title>
    <script src="js/detecttext.js"></script>
</head>
<body>
    <h1 class="title">Text Detection</h1>
    <img id="sourceImage" src="" class="main-img" alt="Source image">
    <form action="detecttext" method="post" id="uploadform" enctype="multipart/form-data">
        <div class="form-group">
            <label for="exampleInputFile">File input</label>
            <input type="file" id="file" name="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
            <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</body>
</html>
