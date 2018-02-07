$(function() {
    $("#uploadform").ajaxForm({
        success: function(msg) {
            $("#accordion").empty();
            alert("File has been uploaded successfully");
            var celebs = JSON.parse(msg)[1];

            var heading = $("<h3>").text('Celebrities:').addClass("heading");
            $("#accordion").append(heading);
            var list = $("<ul>").addClass("list");
            $("#accordion").append(list);

            console.log(celebs);
            for (var i = 0, len = celebs.length; i < len; i++) {
                var celeb = celebs[i];
                //$("#resultsDiv").html($("#resultsDiv").html() + "Name: " + celeb[1].name+ "<br/>" + "Matching Confidence: " + celeb[1].matchConfidence + "<br/>");
                list.append($("<li>").addClass("item").text(`Name: ${celeb[1].name} Accuracy: ${String(celeb[1].matchConfidence).slice(0, 5)}%`));
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