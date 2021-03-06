$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID

    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div> <select name="field_sity_tid" class="form-select">\n' +
                '                            <option value="103">Moscow</option>\n' +
                '                            <option value="104">Ufa</option>\n' +
                '                            <option value="105">Dolgoprudny</option>\n' +
                '                        </select><a href="#" class="remove_field">Удалить</a></div>'); //add input box
        }
    });

    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});


$(function() {
    $("#selColor").on("change",function() {
        var selectedColor = $(this).children("option").filter(":selected").text();
        $(".hideable").hide();
        if(selectedColor=="Добавление упаковки")
        {
            $("#test1").show();
        }
        else if(selectedColor=="Удаление упаковки")
        {
            $("#test2").show();
        }
        else if(selectedColor=="Green")
        {
            $("#test3").show();
        }
    }).change();
});
