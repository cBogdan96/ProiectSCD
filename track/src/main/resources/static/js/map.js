/**
 * Created with IntelliJ IDEA.
 * User: radu.miron
 * Date: 12/2/15
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
var map;
var myLatLng = {lat: 46.7693924, lng: 23.5902006};
var markerArray = [];

function initialize() {
    var mapCanvas = document.getElementById('map');
    var mapOptions = {
        center: new google.maps.LatLng(myLatLng),
        zoom: 8,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }

    var styles = [{
        "featureType": "landscape",
        "stylers": [{
            "hue": "#FFBB00"
        }, {
            "saturation": 43.400000000000006
        }, {
            "lightness": 37.599999999999994
        }, {
            "gamma": 1
        }]
    }, {
        "featureType": "road.highway",
        "stylers": [{
            "hue": "#FFC200"
        }, {
            "saturation": -61.8
        }, {
            "lightness": 45.599999999999994
        }, {
            "gamma": 1
        }]
    }, {
        "featureType": "road.arterial",
        "stylers": [{
            "hue": "#FF0300"
        }, {
            "saturation": -100
        }, {
            "lightness": 51.19999999999999
        }, {
            "gamma": 1
        }]
    }, {
        "featureType": "road.local",
        "stylers": [{
            "hue": "#FF0300"
        }, {
            "saturation": -100
        }, {
            "lightness": 52
        }, {
            "gamma": 1
        }]
    }, {
        "featureType": "water",
        "stylers": [{
            "hue": "#0078FF"
        }, {
            "saturation": -13.200000000000003
        }, {
            "lightness": 2.4000000000000057
        }, {
            "gamma": 1
        }]
    }, {
        "featureType": "poi",
        "stylers": [{
            "hue": "#00FF6A"
        }, {
            "saturation": -1.0989010989011234
        }, {
            "lightness": 11.200000000000017
        }, {
            "gamma": 1
        }]
    }]
    map = new google.maps.Map(mapCanvas, mapOptions)
    map.set('styles', styles);

}

function addMarker(pos) {
    // var positions = getPositions()
    var markerImage = 'img/marker.png';
    var marker = new google.maps.Marker({
        position: pos,
        map: map,
        title: 'Hello World!',
        icon: markerImage
    });

    markerArray.push(marker);

}

function removeMarker(){
    while(markerArray.length) { markerArray.pop().setMap(null); }
}


function getRandomPosition(){
    var randLatLng = {lat: (myLatLng["lat"] + Math.floor(Math.random() * 5) + 1),
        lng: (myLatLng["lng"] + Math.floor(Math.random() * 5) + 1)};
    return randLatLng;
}
