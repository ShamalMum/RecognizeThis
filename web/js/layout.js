$(function () {
        //page is loaded this is first page request

        $("#box").load("detecttext");

        $("a").click(function () {
            if (this.id == 'anchrtext') {
                $("#box").load("detecttext #container");
            }
            else if (this.id == 'anchobject #container') {
                $("#box").load("detectobjects");
            }
            else if (this.id == 'anchface #container') {
                $("#box").load("detectfaces");
            }
            else if (this.id == 'anchcele #container') {
                $("#box").load("detectcelebs");
            }
        });

    });
