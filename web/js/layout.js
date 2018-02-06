$(function () {
        //page is loaded this is first page request

        $("#box").load("detecttext");

        $("a").click(function () {
            if (this.id == 'anchrtext') {
                $("#box").load("detecttext");
            }
            else if (this.id == 'anchobject') {
                $("#box").load("detectobjects");
            }
            else if (this.id == 'anchface') {
                $("#box").load("detectfaces");
            }
            else if (this.id == 'anchcele') {
                $("#box").load("detectcelebs");
            }
        });
    });
