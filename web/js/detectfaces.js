$(function () {
    $("#uploadform").ajaxForm({

        success: function (data) {
            $("#accordion").empty();
            alert("File has been uploaded successfully");
            var faceDetail = JSON.parse(data)[1];
            for (var i = 0; i < faceDetail.length; i++) {
                var heading = $("<h3>").text(`Person ${i}`).addClass("heading");
                $("#accordion").append(heading);
                var list = $("<ul>").addClass("list");
                $("#accordion").append(list);

                var arryface = faceDetail[i]
                var object = arryface[1]

                var low = object.ageRange[1].low;
                var high = object.ageRange[1].high;

                list.append($("<li>").addClass("item").
                                text(`Age Range: ${object.ageRange[1].low} - ${object.ageRange[1].high} years old.`));
                list.append($("<li>").addClass("item").
                                text(`Similing: ${object.smile[1].value} , Accuracy: ${String(object.smile[1].confidence).slice(0, 5)}%`));
                list.append($("<li>").addClass("item").
                                text(`Eye Glasses: ${object.eyeglasses[1].value} , Accuracy: ${String(object.eyeglasses[1].confidence).slice(0, 5)}%`));
                list.append($("<li>").addClass("item").
                                text(`Sun Glasses: ${object.sunglasses[1].value} , Accuracy: ${String(object.sunglasses[1].confidence).slice(0, 5)}%`));
                list.append($("<li>").addClass("item").
                                text(`Gender: ${object.gender[1].value} , Accuracy: ${String(object.gender[1].confidence).slice(0, 5)}%`));

                list.append($("<li>").addClass("item").
                                text(`Beard: ${object.beard[1].value} , Accuracy: ${String(object.beard[1].confidence).slice(0, 5)}%`));
                list.append($("<li>").addClass("item").
                                text(`Mustache: ${object.mustache[1].value} , Accuracy: ${String(object.mustache[1].confidence).slice(0, 5)}%`));
                list.append($("<li>").addClass("item").
                                text(`Eyes Opened: ${object.eyesOpen[1].value} , Accuracy: ${String(object.eyesOpen[1].confidence).slice(0, 5)}%`));
                list.append($("<li>").addClass("item").
                                text(`Mouth Opened : ${object.mouthOpen[1].value} , Accuracy: ${String(object.mouthOpen[1].confidence).slice(0, 5)}%`));


            }
            collapese();

        },
        error: function (data) {
            $("accordion").empty();
            $("#uploadform").text("Couldn't upload file");
        }
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

    $("#file").change(function () {
        readURL(this);
    });

    function collapese() {

        var accordion = $("#accordion");
        var headings = $("#accordion h3");
        var paragraphs = $("#accordion ul");

        var animateAccordion = function (elem, duration, easing) {
            paragraphs.stop(true, true).slideUp(duration, easing);
            $(elem).stop(true, true).slideDown(duration, easing);
        }

        paragraphs.not(":first").hide();
        accordion.on("click", "h3", function () {
            var t = $(this);
            var tPara = t.next();
            if (!tPara.is(":visible")) {
                tPara.trigger("showParagraph");
            }
        });

        accordion.on("showParagraph", "ul", function () {
            animateAccordion(this, 600, "easeInCirc");
        });
    }
});