$(function() {
    $("#uploadform").ajaxForm({
        beforeSubmit: function (msg) {
            $("#accordion").empty();
            $("body").addClass("loading");

        },
        success: function(msg) {
            $("body").removeClass("loading");

            //alert("File has been uploaded successfully");
            var textLabels = JSON.parse(msg)[1];

            var heading = $("<h3>").text('Words:').addClass("alert alert-info heading");
            $("#accordion").append(heading);
            var list = $("<ul>").addClass("list");
            $("#accordion").append(list);

            for (var i = 0, len = textLabels.length; i < len; i++) {
                var textlabel = textLabels[i];
                if (textlabel[1].type === "WORD")
                {
                    console.log(textlabel[1].confidence);
                    list.append($("<li>").addClass("text-primary item").text(`${textlabel[1].detectedText}`));
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