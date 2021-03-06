var map, infoWindow;
function initMap() {
    var styledMapType = new google.maps.StyledMapType(
        [
            {elementType: 'geometry', stylers: [{color: '#ebe3cd'}]},
            {elementType: 'labels.text.fill', stylers: [{color: '#523735'}]},
            {elementType: 'labels.text.stroke', stylers: [{color: '#f5f1e6'}]},
            {
                featureType: 'administrative',
                elementType: 'geometry.stroke',
                stylers: [{color: '#c9b2a6'}]
            },
            {
                featureType: 'administrative.land_parcel',
                elementType: 'geometry.stroke',
                stylers: [{color: '#dcd2be'}]
            },
            {
                featureType: 'administrative.land_parcel',
                elementType: 'labels.text.fill',
                stylers: [{color: '#ae9e90'}]
            },
            {
                featureType: 'landscape.natural',
                elementType: 'geometry',
                stylers: [{color: '#dfd2ae'}]
            },
            {
                featureType: 'poi',
                elementType: 'geometry',
                stylers: [{color: '#dfd2ae'}]
            },
            {
                featureType: 'poi',
                elementType: 'labels.text.fill',
                stylers: [{color: '#93817c'}]
            },
            {
                featureType: 'poi.park',
                elementType: 'geometry.fill',
                stylers: [{color: '#a5b076'}]
            },
            {
                featureType: 'poi.park',
                elementType: 'labels.text.fill',
                stylers: [{color: '#447530'}]
            },
            {
                featureType: 'road',
                elementType: 'geometry',
                stylers: [{color: '#f5f1e6'}]
            },
            {
                featureType: 'road.arterial',
                elementType: 'geometry',
                stylers: [{color: '#fdfcf8'}]
            },
            {
                featureType: 'road.highway',
                elementType: 'geometry',
                stylers: [{color: '#f8c967'}]
            },
            {
                featureType: 'road.highway',
                elementType: 'geometry.stroke',
                stylers: [{color: '#e9bc62'}]
            },
            {
                featureType: 'road.highway.controlled_access',
                elementType: 'geometry',
                stylers: [{color: '#e98d58'}]
            },
            {
                featureType: 'road.highway.controlled_access',
                elementType: 'geometry.stroke',
                stylers: [{color: '#db8555'}]
            },
            {
                featureType: 'road.local',
                elementType: 'labels.text.fill',
                stylers: [{color: '#806b63'}]
            },
            {
                featureType: 'transit.line',
                elementType: 'geometry',
                stylers: [{color: '#dfd2ae'}]
            },
            {
                featureType: 'transit.line',
                elementType: 'labels.text.fill',
                stylers: [{color: '#8f7d77'}]
            },
            {
                featureType: 'transit.line',
                elementType: 'labels.text.stroke',
                stylers: [{color: '#ebe3cd'}]
            },
            {
                featureType: 'transit.station',
                elementType: 'geometry',
                stylers: [{color: '#dfd2ae'}]
            },
            {
                featureType: 'water',
                elementType: 'geometry.fill',
                stylers: [{color: '#b9d3c2'}]
            },
            {
                featureType: 'water',
                elementType: 'labels.text.fill',
                stylers: [{color: '#92998d'}]
            }
        ],
        {name: 'Styled Map'});

    // Create a map object, and include the MapTypeId to add
    // to the map type control.
    var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 55.647, lng: 37.581},
        zoom: 14,
        mapTypeControl: false,
        fullscreenControl: false
    });

    //Associate the styled map with the MapTypeId and set it to display.
    map.mapTypes.set('styled_map', styledMapType);
    map.setMapTypeId('styled_map');
    infoWindow = new google.maps.InfoWindow;

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            infoWindow.open(map);
            map.setCenter(pos);
        }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
    infoWindow.open(map);
}

$("#searchBtn").click(function(){
    var cityName = $("#city-name").val();
    if(cityName===""){
        cityName="sydney";
    }
    $("#city-name-label").text(cityName);
    alert(cityName);
    getWeather(cityName);
});
function getWeather(city) {
    var weatherAPI="https://openweathermap.org/data/2.5/weather?q="+city+"&appid=b6907d289e10d714a6e88b30761fae22";
    $.get(weatherAPI, function (data) {
        console.log(data);
        var temp=data.main.temp;
        var icon = data.weather[0].icon;
        var iconAddress = "http://openweathermap.org/img/wn/"+icon+"@2x.png";
        var humidity = "Humidity:"+data.main.humidity;
        var wind = "Wind:"+data.wind.speed+"km/h";
        $("#temp-label").text(temp);
        $("#temp-label").append("&#8451;");
        $("#weather-icon").attr("src",iconAddress);
        $("#wind-label").text(wind);
        $("#humidity-label").text(humidity);
        
        var description ="hello";
        if(temp<0){
        	description="you need to keep your head and ears warm when you are inactive with at least two layers, such as a beanie or balaclava under the hood of your jacket";
        }else if(temp>=0&&temp<10){
        	description="\nOuterwear: Padded or Puffer Coat, Overcoats (Trench Coats, Fur or Faux Fur Coats), Down Jackets\n"+"Tops: Sweaters, Jumpers, Turtlenecks\n"+"Bottoms: Jeans, Trousers";
        }else if(temp>=10&&temp<20){
        	description="\nTops (for Layering): Shirts, Hoodies, Dresses\n"+"Lightweight Outerwear: Leather jackets, Biker jackets, Parkas, Pea Coats\n"+"Bottoms: Jeans, Trousers, Skirts Shoes: Sneakers, Boots";
        }else if(temp>=20&&temp<30){
        	description="This is summer weather – no need to wear layers of clothing or thick fabric. Instead, find something that will keep you fresh. It can get humid at this time of the year too, which will make you feel even hotter. ";
        }else if(temp>=30&&temp<40){
        	description="You need to adjust your wardrobe and wear airy clothes. Avoid wearing tight garments as they may lead to skin irritation due to friction and heat.";
        }else if(temp>=40){
        	description="You need to adjust your wardrobe and wear airy clothes. Avoid wearing tight garments as they may lead to skin irritation due to friction and heat.";
        }else{
        	description="Extreme Weather Condition! DANGEROUS!!"
        }
        $("#description").text(description);
    });
    
}
$(window).on('load',function(){
    var d = new Date();

    var month = d.getMonth()+1;
    var day = d.getDate();

    var output = d.getFullYear() + '/' +
        (month<10 ? '0' : '') + month + '/' +
        (day<10 ? '0' : '') + day;
    $("#current-time-label").text(output);
    getWeather("sydney");
});
$("#wearsubmit").click(function(event){
	var city = $("#city-name").val();

	 var weatherAPI="https://openweathermap.org/data/2.5/weather?q="+city+"&appid=b6907d289e10d714a6e88b30761fae22";
	    $.get(weatherAPI, function (data) {
	        console.log(data);
	        var temp=data.main.temp;
	        $.ajax({
	        	type:"POST",
	        	url:"/outfit",
	        	data:{"temp":temp},
	        	success:function(response){
	        	alert("hello, world");},
	        	error:function(){
	        		alert("shit");
	        	}
	        	
	      
	        });
	        
	        
	        
	    });
	
	
});

