$(function () {
        //page is loaded this is first page request

        $("#box").load("detecttext");

        $("a").click(function () {
            if (this.id == 'anchrtext') {
                $("#box").load("detecttext #container");
            }
            else if (this.id == 'anchobject') {
                $("#box").load("detectobjects #container");
            }
            else if (this.id == 'anchface') {
                $("#box").load("detectfaces #container");
            }
            else if (this.id == 'anchcele') {
                $("#box").load("detectcelebs #container");
            }
        });

    });
