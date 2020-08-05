<!DOCTYPE html>
<html dir="ltr" lang="zxx">

<head>
  <meta charset="utf-8">
  <title>The Project | Icon Boxes</title>
  <meta name="description" content="The Project a Bootstrap-based, Responsive HTML5 Template">
  <meta name="author" content="author">

  <!-- Mobile Meta -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Favicon -->
  <link rel="shortcut icon" href="images/favicon.ico">

  <!-- Web Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=PT+Serif" rel="stylesheet">

  <!-- Bootstrap core CSS -->
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

  <!-- Font Awesome CSS -->
  <link href="fonts/font-awesome/css/font-awesome.css" rel="stylesheet">

  <!-- Plugins -->
  <link href="plugins/magnific-popup/magnific-popup.css" rel="stylesheet">
  <link href="css/animations.css" rel="stylesheet">
  <link href="plugins/slick/slick.css" rel="stylesheet">
  
  <link href="css/style.css" rel="stylesheet" >
  <link href="css/typography-default.css" rel="stylesheet" >
  <link href="css/skins/light_blue.css" rel="stylesheet">
  <link href="css/custom.css" rel="stylesheet">
  
</head>
<body class=" ">

  <div class="scrollToTop circle"><i class="fa fa-angle-up"></i></div>
  <div class="page-wrapper">
    <#include "./header.ftl">
    <section class="main-container padding-bottom-clear">
      <section class="light-gray-bg pv-30 padding-bottom-clear clearfix">
        <div class="container">           
         ${projects}
         <br>
         <br>
       </div>
     </section>     
   </section>
   <footer id="footer" class="clearfix ">
    <div class="subfooter">
      <div class="container">
        <div class="subfooter-inner">
          <div class="row">
            <div class="col-md-12">
              <p class="text-center">Powered By Social Angels Digital Solution Pvt Ltd.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
</div>
<script src="plugins/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="plugins/waypoints/jquery.waypoints.min.js"></script>
<script src="plugins/waypoints/sticky.min.js"></script>
<script src="plugins/countTo/jquery.countTo.js"></script>
<script src="plugins/slick/slick.min.js"></script>
<script src="js/template.js"></script>
<script src="js/custom.js"></script>
<script>
  $('.projects').hover(function(){
    $(this).css("background-color", "#09afdf");
  }, function(){
    $(this).css("background-color", "white");
  });
</script>
</body>
</html>
