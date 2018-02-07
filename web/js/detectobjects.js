$(function() {
    $("#uploadform").ajaxForm({
        success: function(msg) {
            alert("File has been uploaded successfully");
            // $("#sourceImage").attr('src',msg);
            var objects = JSON.parse(msg)[1];
            console.log(objects);
            for (var i = 0, len = objects.length; i < len; i++) {
                var object = objects[i];
                $("#resultsDiv").html($("#resultsDiv").html() + "Object Name: " + object[1].name+ "<br/>" + "Matching Confidence: " + object[1].confidence + "<br/>");
            }
        },
        error: function(msg) {
            $("#uploadform").text("Couldn't upload file");
        }
    });
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#sourceImage').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#file").change(function(){
    readURL(this);
});