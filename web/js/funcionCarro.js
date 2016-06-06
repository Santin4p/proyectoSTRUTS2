/**
 * Created by MRCOGUSA on 06/06/2016.
 */
$(function(){

    function getData(form) {
        var ar = form.serializeArray();
        var out = {};

        $.map(ar, function (item) {
            out[item['name']] = item['value'];
        });

        return out;
    }


    function sendToCart( event ) {
        event.preventDefault();
        var formData = getData($(this));
        var that = this;

        $.getJSON('AjaxAction.action', formData, function(data) {
            var tr = that.parentNode;
            if(data.cantidad === 0)
            {
                tr.remove();
            }
        });
    }


    $('form[name="formularioCarro"]').each(function(){
        $(this).submit(sendToCart);
    });
});