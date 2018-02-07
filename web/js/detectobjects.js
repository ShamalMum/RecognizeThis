$(function() {
    $("#uploadform").ajaxForm({
        beforeSubmit: function (msg) {
            $("#accordion").empty();
            $("body").addClass("loading");

        },
        success: function(msg) {
            $("body").removeClass("loading");
            //alert("File has been uploaded successfully");
            var objects = JSON.parse(msg)[1];

            var heading = $("<h3>").text('Objects:').addClass("heading");
            $("#accordion").append(heading);
            var list = $("<ul>").addClass("list");
            $("#accordion").append(list);

            //console.log(objects);
            for (var i = 0, len = objects.length; i < len; i++) {
                var object = objects[i];
                //$("#resultsDiv").html($("#resultsDiv").html() + "Object Name: " + object[1].name+ "<br/>" + "Matching Confidence: " + object[1].confidence + "<br/>");

                list.append($("<li>").addClass("item").text(`Object Name: ${object[1].name} Accuracy: ${String(object[1].confidence).slice(0, 5)}%`));
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