/**
 * Created with IntelliJ IDEA.
 * User: radu.miron
 * Date: 12/2/15
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */

function sendRequest (type, resource, data, successHandler, errHandler) {
    jQuery.ajax({
        type: type,
        url: "http://localhost:8085/" + resource,
        data: data,
        dataType: "json",
        accepts: "application/json",

        success: function (data, status, jqXHR) {
            successHandler (data);
        },

        error: function (jqXHR, status) {
            errHandler(status);
        }
    });
}

function goToPage(url) {
    $(location).attr('href',url);
}