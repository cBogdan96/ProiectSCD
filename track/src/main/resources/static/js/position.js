/**
 * Created with IntelliJ IDEA.
 * User: radu.miron
 * Date: 12/2/15
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
function getPositions() {
    var criteria = new Criteria();
    sendRequest("GET", "position?" + $.param(criteria), null, getPositionsSuccessHandler, getPositionsErrorHandler);
}

function Criteria() {
    var deviceId = $('#deviceId').val().trim(); // select data from input and trim it
    if (deviceId.length > 0) {
        this.terminalId = deviceId;
    }

    var startDate = $('#startDate').val().trim(); // select data from input and trim it
    if (startDate.length > 0) {
        this.startDate = startDate;
    }

    var endDate = $('#endDate').val().trim(); // select data from input and trim it
    if (endDate.length > 0) {
        this.endDate = endDate;
    }
}

function getPositionsSuccessHandler(respData) {
    for(var i in respData)
        addMarker({lat:parseFloat(respData[i].latitude) ,lng: parseFloat(respData[i].longitude)})

    // $("#result").append("<br>" + JSON.stringify(respData));
    //$("#result").text(respData); // appends the json to the 'result' div. see index.html
}

function getPositionsErrorHandler(status) {
    alert("err response: " + status); // popup on err.
}