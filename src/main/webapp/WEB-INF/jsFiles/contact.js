$(function() {
    $("#selColor").on("change",function() {
        var selectedColor = $(this).children("option").filter(":selected").text();
        $(".hideable").hide();
        if(selectedColor=="Просмотр информации")
        {
            $("#test1").show();
        }
        else if(selectedColor=="Изменение данных")
        {
            $("#test2").show();
        }
        else if(selectedColor=="Изменение пароля")
        {
            $("#test3").show();
        }
    }).change();
});
