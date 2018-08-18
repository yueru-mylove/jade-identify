$(".std_li").click(function () {
    $(".std_li").removeClass("std_active");
    $(this).addClass("std_active");

    $.ajax({
        url : "/silver.html",
        type : "GET",
        success : function (data) {
            $("#main-r").empty();
            $("#main-r").add(data);
        }
    })
});