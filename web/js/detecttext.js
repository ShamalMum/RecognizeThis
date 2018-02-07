$(function() {
    $("#uploadform").ajaxForm({
        success: function(msg) {
            alert("File has been uploaded successfully");
            // $("#sourceImage").attr('src',msg);
            var textLabels = JSON.parse(msg)[1];
            for (var i = 0, len = textLabels.length; i < len; i++) {
                var textlabel = textLabels[i];
                if (textlabel[1].type === "WORD")
                {
                    $("#resultsDiv").html($("#resultsDiv").html() + textlabel[1].detectedText + " | ");
                    console.log(textlabel[1].detectedText);
                    // console.log(textlabel[1].confidence);
                }
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