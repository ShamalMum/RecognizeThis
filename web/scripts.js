$(function() {
    $('#uploadform').ajaxForm({
        success: function(msg) {
            alert("File has been uploaded successfully");
        },
        error: function(msg) {
            $("#uploadform").text("Couldn't upload file");
        }
    });
});