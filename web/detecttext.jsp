<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Text Detection</title>
    <script src="js/detecttext.js"></script>
</head>
<body>
<div id="container">
    <h1 class="title">Text Detection</h1>
    <div class="row">
        <div class="col" style="float: left">
            <img style="max-width:500px;" id="sourceImage" src="" class="img-fluid" alt="Source image">
            <form action="detecttext" method="post" id="uploadform" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <input type="file" id="file" name="file" class="form-control-file" id="exampleInputFile"
                           aria-describedby="fileHelp">
                    <small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for
                        the above input. It's a bit lighter and easily wraps to a new line.
                    </small>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col" id="resultsDiv">

        </div>
    </div>
</div>
</body>
</html>
