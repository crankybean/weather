<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>WeatherLike</title>
    <link rel="stylesheet" href="resources/css/main.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" integrity="sha384-KA6wR/X5RY4zFAHpv/CnoG2UW1uogYfdnP67Uv7eULvTveboZJg0qUpmJZb5VqzN" crossorigin="anonymous">
  </head>
  <body>
   <div class="container">
     <div class="row clearfix" id="header">
        <div class="col-sm">
          <div>
            <img src="resources/logo.png" alt="logo" height="60px" width="300px">
          </div>
        </div>
        <div class="col-sm" style="margin-top: 15px">
          <div class="input-group mb-3" id="city-form">
            <div class="input-group-prepend">
              <button class="btn btn-outline-secondary" id="searchBtn" style="border: 0"><i class="fas fa-search-location fa-lg"></i></button>
            </div>
            <input id="city-name" type="text" class="form-control" placeholder="" aria-label="" aria-describedby="basic-addon1">
          </div>
        </div>
        <div class="col-sm" style="margin-top: 15px">
          <div class="row float-right">
            
    			<button type="button" class="btn" data-toggle="modal" data-target="#changeProfileModal">${user.success}</button>
			
            <form action="logout" method="get">
   			 <input type="submit" name="logout" value="logout" />
			</form>
          </div>
        </div>
      </div>
     <div class="wrapper container">
       <div id="map">

       </div>
       <div class="content">
         <h1 id="city-name-label">Sydney</h1>
         <h8 id="current-time-label">hello</h8>
         <div class="row well">
           <div class="col text-center align-middle">
             <h3 id="temp-label" class="align-middle" style="display:inline-block"></h3>
           </div>
           <div class="col text-center">
             <img id="weather-icon" alt="weather-icon">
           </div>
         </div>
         <div class="row well">
           <div class="col text-center align-middle">
             <div class="col"><h3 id="humidity-label">Humidity</h3></div>
           </div>
           <div class="col text-center">
             <div class="col"><h3 id="wind-label">Wind Speed</h3></div>
             
           </div>
           
         </div>
         <div class="row well">
           <form action="outfit" type="button">
         	<button type="button" class="btn btn-danger" type="submit" id="wearsubmit">What to wear?</button>
         	</form>
         </div>
       </div>
     </div>
     <footer class="row">
       <div class="sozial col-xs-12 col-sm-6 col-sm-push-6">
         <ul class="row">
           <li class="col-xs-6 col-sm-2">
             <a href=" ">
               <img class="logo" src="https://cdn2.iconfinder.com/data/icons/black-white-social-media/32/online_social_media_facebook-128.png" alt="Facebook">
             </a>
           </li>
           <li class="col-xs-6 col-sm-2">
             <a href="#">
               <img class="logo" src="https://cdn2.iconfinder.com/data/icons/black-white-social-media/32/twitter_online_social_media-128.png" alt="Twitter">
             </a>
           </li>
           <li class="col-xs-6 col-sm-2">
             <a href="#">
               <img class="logo" src="https://cdn2.iconfinder.com/data/icons/black-white-social-media/32/instagram_online_social_media_photo-128.png" alt="Instgram">
             </a>
           </li>
           <li class="col-xs-6 col-sm-2">
             <a href="#">
               <img class="logo" src="https://cdn2.iconfinder.com/data/icons/black-white-social-media/32/online_social_media_google_plus-128.png" alt="Google">
             </a>
           </li>
         </ul>
       </div><!-- Ende Sozial media -->

       <div class="copyright col-xs-12 col-sm-3 col-sm-pull-6">
         <p> &copy; 2019 WeatherGram. All rights reserved.</p >
       </div><!-- Ende Copyright -->

       <div class="impressum col-xs-12 col-sm-3 col-sm-pull-6">
         <p> WeatherGram Powered by SpringMVC</p >
         <p> Hope you enjoy the convenience that WeatherGram brings to you</p >
       </div><!-- Ende Impressum -->
     </footer>
 <div class="modal fade right" id="changeProfileModal" tabindex="-1" role="dialog"
  aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
  <div class="modal-dialog modal-side modal-bottom-right modal-notify modal-info" role="document">
    <!--Content-->
    <div class="modal-content">
      <!--Header-->
      <div class="modal-header">
        <p class="heading">Profile</p >

        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" class="white-text">&times;</span>
        </button>
      </div>

      <!--Body-->
      
      <div class="modal-body">
					<div class="form-group">
						User Name:  <c:out value="${user.success}"/>
					</div>
					<div class="form-group">
						Email:  <c:out value="${user.email}"/>
					</div>
					<div class="form-group">
						Gender:  <c:out value="${user.gender}"/>
					</div>
      </div>
     
    </div>
    <!--/.Content-->
  </div>
</div>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script type="text/javascript" src="http://www.google.com/jsapi"></script>
   <script async defer
           src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBG6Dz2-h3rVSE0pzXZ7yBFq1Dmv7cixhc&callback=initMap">
   </script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   <script src="resources/js/main.js"></script>
   </body>
</html>