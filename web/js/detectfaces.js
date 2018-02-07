$(function() {
    $("#uploadform").ajaxForm({
        success: function(data) {
            alert("File has been uploaded successfully");
            var faceDetail=JSON.parse(data)[1];

            for(var i=0;i<faceDetail.length;i++)
            {
                var arryA=faceDetail[i]

                for(var j=0; j<arryA.length;j++){
                        var x=arryA[j];
                }

                var low=x.ageRange[1].low;
                var high=x.ageRange[1].high;

                var sex=x.gender[1].value;
                var confi=x.gender[1].confidence;

                $('#age').text("Age is between"+low+" and"+high);

                $('#sex').text("SEX is "+sex+" and confidential ="+confi);

            }

            //// var faceDetail2=faceDetail[0];
            //
            // var faceDetail3=faceDetail2[1];
            // var faceDetail4=faceDetail3.boundingBox;
            // var faceDetail5=faceDetail4[1].width;
            //
            // console.log(faceDetail5);


        },
        error: function(data) {
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

    $("#file").change(function(){
        readURL(this);
    });

    var accordion = $("#accordion");
    var headings = $("h3");
    var paragraphs = $("p");

    var animateAccordion = function(elem, duration, easing) {
        paragraphs.stop(true, true).slideUp(duration, easing);
        $(elem).stop(true, true).slideDown(duration, easing);
    }

    paragraphs.not(":first").hide();
    accordion.on("click", "h3", function() {
        var t = $(this);
        var tPara = t.next();
        if(!tPara.is(":visible")) {
            tPara.trigger("showParagraph");
        }
    });

    accordion.on("showParagraph", "p", function() {
        animateAccordion(this, 600, "easeInCirc");
    });
});