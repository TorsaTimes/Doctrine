



//-------------------------------------------------------------------------


$(document).ready(function()
{
$("#eingabefeld").keyup(function()
{
var box=$(this).val();
var main = box.length;
var value= (main / 145);
var count= 145 - box.length;

if(box.length <= 145)
{
$("#count").html(count);
}else
{
alert(' Maximale Anzahl der Zeichen wurde erriecht!!! ');
}
return false;
});
});

//------------------------------------------------------------------


function locateMe() {
    window.navigator.geolocation.getCurrentPosition(geolocationSuccesss);
}

function geolocationSuccesss(position) {
    var coords = position.coords;
    var url = 'https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=' +
        coords.latitude + '&lon=' + coords.longitude;

    fetch(url).then(function (response) {
        return response.json();
    }).then(function (json) {
        var city = json.address.city;
        var cityElement = document.getElementById("standort");
        cityElement.value = city;
		
		console.log.city;
    });
}

//-----------------------------------------------------------------

$(document).ready(domReady);
function domReady() {

$("input").powerTip();
}








//$("textEingabe").keyup(function(){
//$("textLaenge").html($(this).val().length-7)});
