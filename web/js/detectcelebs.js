$(function() {
    $("#uploadform").ajaxForm({
        success: function(msg) {
            alert("File has been uploaded successfully");
            var celebs = JSON.parse(msg)[1];
            console.log(celebs);
            for (var i = 0, len = celebs.length; i < len; i++) {
                var celeb = celebs[i];
                $("#resultsDiv").html($("#resultsDiv").html() + "Name: " + celeb[1].name+ "<br/>" + "Matching Confidence: " + celeb[1].matchConfidence + "<br/>");
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