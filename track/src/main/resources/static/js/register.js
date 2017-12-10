/**
 * Created with IntelliJ IDEA.
 * User: radu.miron
 * Date: 12/2/15
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
function registerUser() {
    var criteria = new registerCriteria();
    jQuery.ajax({
        type: 'put',
        url: "http://localhost:8085/" + "user/register?" + $.param(criteria),
        data: null,
        accepts: "application/json",

        success: function (data, status, jqXHR) {
            getUserRegisterSuccessHandler(data);
        },

        error: function (jqXHR, status) {
            getUserRegisterErrorHandler(status);
        }
    });
    // sendRequest("GET", "user?" + $.param(criteria), null, getUserSuccessHandler, getUserErrorHandler);
}

function registerCriteria() {
    var email = $('#emailRegister_modal').val().trim(); // select data from input and trim it
    if (email.length > 0) {
        this.email = email;
    }

    var password = $('#passwordRegister_modal').val().trim(); // select data from input and trim it
    if (password.length > 0) {
        this.password = password;
    }
}

function getUserRegisterSuccessHandler(respData) {
    goToPage('index.html')

    // $("#result").append("<br>" + JSON.stringify(respData));
    //$("#result").text(respData); // appends the json to the 'result' div. see index.html
}

function getUserRegisterErrorHandler(status) {
    alert("err response: " + status); // popup on err.
}