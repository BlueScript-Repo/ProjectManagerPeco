<!DOCTYPE html>
<html dir="ltr" lang="zxx">

<head>
  <meta charset="utf-8">
  <title>PECO Projects</title>
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

  <!-- The Project's core CSS file -->
  <!-- Use css/rtl_style.css for RTL version -->
  <link href="css/style.css" rel="stylesheet" >
  <!-- The Project's Typography CSS file, includes used fonts -->
  <!-- Used font for body: Roboto -->
  <!-- Used font for headings: Raleway -->
  <!-- Use css/rtl_typography-default.css for RTL version -->
  <link href="css/typography-default.css" rel="stylesheet" >
  <!-- Color Scheme (In order to change the color scheme, replace the blue.css with the color scheme that you prefer) -->
  <link href="css/skins/light_blue.css" rel="stylesheet">

  <!-- Custom css -->
  <link href="css/custom.css" rel="stylesheet">

</head>

<!-- body classes:  -->
<!-- "boxed": boxed layout mode e.g. <body class="boxed"> -->
  <!-- "pattern-1 ... pattern-9": background patterns for boxed layout mode e.g. <body class="boxed pattern-1"> -->
    <!-- "transparent-header": makes the header transparent and pulls the banner to top -->
    <!-- "gradient-background-header": applies gradient background to header -->
    <!-- "page-loader-1 ... page-loader-6": add a page loader to the page (more info @components-page-loaders.html) -->
    <body class="" >
      <!-- scrollToTop -->
      <!-- ================ -->
      <div class="scrollToTop circle"><i class="fa fa-angle-up"></i></div>
      <!-- page wrapper start -->
      <!-- ================ -->
      <div class="page-wrapper">
        <#include "./header.ftl">
    <section class="main-container">

      <div class="container">
        <div class="row">

          <!-- main start -->
          <!-- ================ -->
          <div class="main col-lg-8">

            <!-- page-title start -->
            <!-- ================ -->
            <h3 class="page-title">PO Details</h3>
            <div class="separator-2"></div>
            <!-- page-title end -->

            <form action="generateOrder" method="POST">
              <div class="form-row">
                <div class="form-group col-md-4">
                  <label>Vendor Name</label>
                  <select class='form-control' name='vendorName' id='vendorName' onChange='getCompanyDetails($(this));'>
                    <option></option>
                  </select>
                </div>
                <div class="form-group col-md-4">
                 <label>Vendor Location</label>
                 <input type="text" class="form-control" name="location">
               </div>
               <div class="form-group col-md-4">
                <label>Add Vendor</label>
                <br/>
                <button type="button" data-toggle="modal" data-target="#addVeenderModel" >+</button>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-4">
                <label>Contact Name</label>
                <input type="text" class="form-control" name="contactName">
              </div>
              <div class="form-group col-md-4">
                <label>Contact Number</label>
                <input type="text" class="form-control" name="contactNumber">
              </div>
              <div class="form-group col-md-4">
                <label>Contact Email</label>
                <input type="text" class="form-control" name="contactEmail">
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-4">
                <label>Vendor Gst</label>
                <input type="text" class="form-control" name="vendorGst">
              </div>
              <div class="form-group col-md-4">
                <label>Vendor Pan</label>
                <input type="text" class="form-control" name="vendorPan">
              </div>
             
            </div>
            <div class="form-group form-row" id="terms">
             <div class="form-group col-md-6">
              <label for="inputAddress">Terms :</label>
            </div>
            <div class="form-group col-md-6">
              <button type="button" onClick="addTerm();">+</button>
            </div>
            <br>    
            <input type="text" class="form-control" id="inputAddress" name="term">
          </div>
          <input type="hidden" name="lineItem" value='${lineItemData}' >
          <input type="hidden" name="lineItemSimple" value='${lineItemDataSimple}' >
          <input type="hidden" name="projectId" value='${projectId}' >
          <button type="submit" class="btn btn-primary">Generate PO</button>
        </form>
        <!-- Forms -->
        <!-- ============================================================================== -->
      </div>
    </div>
  </div>
</section>

<div class="modal fade bd-example-modal-lg" id="addVeenderModel" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
 <div class="modal-dialog modal-lg" role="document">
  <div class="modal-content">
   <div class="modal-header">
    <h4 class="modal-title" >Add New Vender</h4>
  </div>
  <div class="modal-body">

    <div class="form-row">
      <div class="form-group col-md-4">
        <label>Vendor Name</label>
        <input type="text" class="form-control" name="vendorNameStr"> 
      </div>
      <div class="form-group col-md-4">
        <label>Vendor Location</label>
        <input type="text" class="form-control" name="vendorAddress">
      </div>
      <div class="form-group col-md-4">
        <label>Contact Name</label>
        <input type="text" class="form-control" name="vendorContactName">
      </div>
    </div>
     <div class="form-row"> 
      <div class="form-group col-md-4">
        <label>Vendor Gst No. </label>
        <input type="text" class="form-control" name="vendorGst"> 
      </div>
      <div class="form-group col-md-4">
        <label>Vendor Pan No.</label>
        <input type="text" class="form-control" name="vendorPan">
      </div>
     </div>
    <div class="form-row">    
      <div class="form-group col-md-4">
        <label>Contact Number</label>
        <input type="text" class="form-control" name="vendorNumber">
      </div>
      <div class="form-group col-md-4">
        <label>Contact Email</label>
        <input type="text" class="form-control" name="vendorEmail">
      </div>
      <div class="form-group col-md-4">
        <label></label>
        <button type="button" class="btn btn-default" onClick="addVendor();">Add</button>
      </div>
    </div>              

  </div>
</div>  
</div>  
</div>

<div class="space"></div>

<!-- footer start (Add "dark" class to #footer in order to enable dark footer) -->
<!-- ================ -->
<footer id="footer" class="clearfix ">
  <!-- .subfooter start -->
  <!-- ================ -->
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
  <!-- .subfooter end -->

</footer>
<!-- footer end -->
</div>
<!-- page-wrapper end -->

<!-- JavaScript files placed at the end of the document so the pages load faster -->
<!-- ================================================== -->
<!-- Jquery and Bootstap core js files -->
<script src="plugins/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Magnific Popup javascript -->
<script src="plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
<!-- Appear javascript -->
<script src="plugins/waypoints/jquery.waypoints.min.js"></script>
<script src="plugins/waypoints/sticky.min.js"></script>
<!-- Count To javascript -->
<script src="plugins/countTo/jquery.countTo.js"></script>
<!-- Slick carousel javascript -->
<script src="plugins/slick/slick.min.js"></script>
<!-- Initialization of Plugins -->
<script src="js/template.js"></script>
<!-- Custom Scripts -->
<script src="js/custom.js"></script>

<script>
  function showLoading()
  {
    $.blockUI({ css: { 
      border: 'none', 
      padding: '15px', 
      backgroundColor: '#fff', 
      '-webkit-border-radius': '10px', 
      '-moz-border-radius': '10px', 
      opacity: .5, 
      color: '#000',
      images : 'images/img/loading-blue.gif'
    } }); 

  }

  function hideLoading()
  {
    this.setTimeout($.unblockUI,1000);
    //$.unblockUI();
  }
</script>

<script>

  var i = 1;

  function addTerm()
  {

    var toAppend = "<br/><div class=\"separator-2\"></div><input type=\"text\" name=\"term\" class=\"form-control\" id=\"inputAddress\">";

    $('#terms').append(toAppend);

    i++;
  }
</script>
<script>

  function closeOverlay(overLayId)
  {
   var idVal = overLayId;
   document.getElementById(overLayId).style.display = "none";
 }

</script>


<script>
  jQuery(document).ready(function() {

    var searchToggle = true;    
    $(".addVendorForm").click(function(){
      if(searchToggle){
        document.getElementById("textOverlaySearch").style.display = "block";
      }else{
        document.getElementById("textOverlaySearch").style.display = "none";
      }
      searchToggle = !searchToggle;
    });

  });


</script>
<script>
  function addVendor()
  {

    showLoading();
    $.ajax({
     type : 'POST',
     data :  {'vendorName' : $('[name="vendorNameStr"]').val(), 'vendorAddress': $('[name="vendorAddress"]').val(), 'contactName': $('[name="vendorContactName"]').val(), 'contactNumber': $('[name="vendorNumber"]').val(), 'contactEmail': $('[name="vendorEmail"]').val(), 'vendorGst': $('[name="vendorGst"]').val(), 'vendorPan': $('[name="vendorPan"]').val()},
     url : 'saveVendor',
     success : function(data) 
     {
      var venderName = $('[name="vendorNameStr"]').val();
      $("[name='vendorName']").append("<option value='" + venderName + "''>" + venderName + "</option>");

      document.getElementById("textOverlaySearch").style.display = "none";     			       
    }
  });
  }
</script>
<script>
  function getCompanyDetails(thisObj)
  {
   var vendorName = $('#vendorName').val();

   $.ajax({
     type : 'POST',
     data :  {'vendorName' : vendorName},
     url : 'getVendorDetails',
     success : function(data) 
     {
      var inputArray = data.split(":");
      $.each(inputArray,function(i, el)
      {
       var pair = el.split('=');
       var ele = pair[0].trim();
       var valu = pair[1].trim();

       if(ele=='vendorAddress')
       {
         $('[name="location"]').val(valu);
       }
       else if(ele=='contactName')
       {
         $('[name="contactName"]').val(valu);
       }
       else if(ele=='contactNumber')
       {
         $('[name="contactNumber"]').val(valu);
       }
       else if(ele=='contactEmail')
       {
         $('[name="contactEmail"]').val(valu);
       } 
        else if(ele=='vendorGst')
       {
         $('[name="vendorGst"]').val(valu);
       } 
        else if(ele=='vendorPan')
       {
         $('[name="vendorPan"]').val(valu);
       }
     });       
    }
  });
 }
</script>
<script>
  $(document).ready(function() {
    $.ajax({
     type : 'POST',
     url  : 'getVendors',
     success : function(data) 
     {
      var vList = data.split(',');

      for(var i = 0; i < vList.length ; i++)
      {
       var venderName = vList[i];

       if(venderName != "")
        $("[name='vendorName']").append("<option value='" + venderName + "''>" + venderName + "</option>");
      }
  }

});


  });


</script>

</body>
</html>
