$(function() {
    $("#uploadform").ajaxForm({
        beforeSubmit: function (msg) {
            $("#accordion").empty();
            $("body").addClass("loading");

        },
        success: function(msg) {
            $("body").removeClass("loading");
            //alert("File has been uploaded successfully");
            var celebs = JSON.parse(msg)[1];

            var heading = $("<h3>").text('Celebrities:').addClass("alert alert-info heading");
            $("#accordion").append(heading);
            var list = $("<ul>").addClass("list");
            $("#accordion").append(list);

            console.log(celebs);
            for (var i = 0, len = celebs.length; i < len; i++) {
                var celeb = celebs[i];
                //var face = celeb[1].face;
                console.log($('#sourceImage').width());
                var thumpWidth = parseFloat($('#sourceImage').width()) * parseFloat(celeb[1].face[1].boundingBox[1].width);
                var thumpHeight = parseFloat($('#sourceImage').height()) * parseFloat(celeb[1].face[1].boundingBox[1].height);
                var thumpTop = celeb[1].face[1].boundingBox[1].top;
                var thumpLeft = celeb[1].face[1].boundingBox[1].left;
                console.log($("#sourceImage").attr("src"));
                // list.append($("<img>").width(thumpWidth + "px").height(thumpHeight + "px").attr("src",$("#sourceImage").attr("src")).addClass("thumbnail"));

                //$("#resultsDiv").html($("#resultsDiv").html() + "Name: " + celeb[1].name+ "<br/>" + "Matching Confidence: " + celeb[1].matchConfidence + "<br/>");
                list.append($("<li>").addClass("text-primary item").text(`Name: ${celeb[1].name} Accuracy: ${String(celeb[1].matchConfidence).slice(0, 5)}%`));

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