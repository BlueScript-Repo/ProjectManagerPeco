<!DOCTYPE html>
<html dir="ltr" lang="zxx">

<head>
  <meta charset="utf-8">
  <title>PECO Project</title>
  <meta name="description" content="The Project a Bootstrap-based, Responsive HTML5 Template">
  <meta name="author" content="author">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=PT+Serif" rel="stylesheet">
  <link href="./bootstrap/css/bootstrap.css" rel="stylesheet">
  <link href="./fonts/font-awesome/css/font-awesome.css" rel="stylesheet">
  <link href="./plugins/magnific-popup/magnific-popup.css" rel="stylesheet">
  <link href="./plugins/rs-plugin-5/css/settings.css" rel="stylesheet">
  <link href="./plugins/rs-plugin-5/css/layers.css" rel="stylesheet">
  <link href="./plugins/rs-plugin-5/css/navigation.css" rel="stylesheet">
  <link href="./css/animations.css" rel="stylesheet">
  <link href="./plugins/slick/slick.css" rel="stylesheet">
  <link href="./css/style.css" rel="stylesheet" >
  <link href="./css/typography-default.css" rel="stylesheet" >
  <link href="./css/skins/light_blue.css" rel="stylesheet">
  <link href="./css/custom.css" rel="stylesheet">

</head>
<body class="front-page transparent-header">
  <div class="page-wrapper">
    <#include "./header.ftl">
    <div class="banner clearfix">
      <div class="slideshow">
      </div>
    </div>
    <div id="page-start"></div>
    <section class="light-gray-bg pv-30 clearfix">
      <div class="container">
        <div class="row justify-content-md-center">
          <div class="col-lg-8">
            <h2 class="text-center mt-4"><strong>Project & Inventory Management</strong></h2>
            <div class="separator"></div>
            <p class="large text-center">Manage the current projects and related inventory efficiantly. Use following links to Create/Search Project.</p>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-3">
            <div class="pv-30 ph-20 feature-box bordered shadow text-center object-non-visible" data-animation-effect="fadeInDownSmall" data-effect-delay="100" data-toggle="modal" data-target="#createProjectModal">
              <span class="icon default-bg circle"><i class="fa fa-diamond"></i></span>
              <h3>Create Project</h3>
              <div class="separator clearfix"></div>
              <p>Create a new project to generate BOQ or Quotation. The project created here can be viewed using <strong>Search project</strong> Option.</p>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="pv-30 ph-20 feature-box bordered shadow text-center object-non-visible" data-animation-effect="fadeInDownSmall" data-effect-delay="150" data-toggle="modal" data-target="#searchProjectModal">
              <span class="icon default-bg circle"><i class="fa fa-connectdevelop"></i></span>
              <h3>Search Project</h3>
              <div class="separator clearfix"></div>
              <p>Search a project using keyword. Use this link to go to the details of a particular project.</p>
              <br>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="pv-30 ph-20 feature-box bordered shadow text-center object-non-visible" data-animation-effect="fadeInDownSmall" data-effect-delay="200" onclick="$('#updateInv').submit();">
              <span class="icon default-bg circle"><i class="fa fa fa-snowflake-o"></i></span>
              <h3>Manage Inventory</h3>              
              <form id="updateInv" action="updateInvPO" method="GET"></form>              
              <div class="separator clearfix"></div>
              <p>Use this link to access Inventory page to update system when Inventory is received.</p>
              <br>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="pv-30 ph-20 feature-box bordered shadow text-center object-non-visible" data-animation-effect="fadeInDownSmall" data-effect-delay="200" onclick="$('#inventoryDet').submit();">
              <span class="icon default-bg circle"><i class="fa fa fa-snowflake-o"></i></span>
              <h3>Admin Section</h3>
              <form id="inventoryDet" action="inventoryDetails" method="GET"></form>              
              <div class="separator clearfix"></div>
              <p>Use this section to update the configuration and taxes applied.</p>
              <br>
            </div>
          </div>          
        </div>
      </div>
    </section>
    <div class="modal fade" id="createProjectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">Enter Project Details</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
          </div>
          <form action="createProject" method="POST">
            <div class="modal-body">
              <p>Project Name</p>
              <input type="text" style="color:#000000;width:100% !important;" class="form-control" placeholder="Type a project Name Here" name="projectName" required>
              <br/>
              <p>Company Name</p>
              <input type="text" style="color:#000000;width:100% !important;" class="form-control" placeholder="Enter Company Name Here" name="companyName" required>
              <br/>
              <p>Project Description</p>
              <input type="text" style="color:#000000;width:100% !important;" class="form-control" placeholder="Type in the description Here" name="projectDesc">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-sm btn-dark" data-dismiss="modal">Close</button>
              <button type="submit" class="btn btn-sm btn-default">Create</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <div class="modal fade" id="searchProjectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">Please enter any of the following details to search </h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
          </div>
          <form action="searchProject" method="POST">
            <div class="modal-body">
              <p>Project Name</p>
              <input type="text" style="color:#000000" class="form-control" placeholder="Type a project Name Here" name="projectName">
              <br/>
              <p>Company Name</p>
              <input type="text" style="color:#000000" class="form-control" placeholder="Enter Company Name Here" name="companyName">
              <br/>
              <p>Project Description</p>
              <input type="text" style="color:#000000" class="form-control" placeholder="Type in the description Here" name="projectDesc">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-sm btn-dark" data-dismiss="modal">Close</button>
              <button type="submit" class="btn btn-sm btn-default">Search</button>
            </div>
          </form>
        </div>
      </div>
    </div>
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
            <input type="text" class="form-control" name="vendorNameStr" required> 
          </div>
          <div class="form-group col-md-4">
            <label>Vendor Location</label>
            <input type="text" class="form-control" name="vendorAddress" required>
          </div>
          <div class="form-group col-md-4">
            <label>Contact Name</label>
            <input type="text" class="form-control" name="vendorContactName" required>
          </div>
        </div>
        <div class="form-row">    
          <div class="form-group col-md-4">
            <label>Contact Number</label>
            <input type="text" class="form-control" name="vendorNumber" required>
          </div>
          <div class="form-group col-md-4">
            <label>Contact Email</label>
            <input type="text" class="form-control" name="vendorEmail" required>
          </div>
          <div class="form-group col-md-4">
            <br>
            <button type="button" class="btn btn-default" onClick="addVendor();">Add</button>
          </div>
        </div>              
      </div>
    </div>  
  </div>  
</div>
<div class="modal fade bd-example-modal-lg" id="addUserModel" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
 <div class="modal-dialog modal-lg" role="document">
  <div class="modal-content">
   <div class="modal-header">
    <h4 class="modal-title" >Add New User</h4>
  </div>
  <div class="modal-body">
    <div class="form-row">
      <div class="form-group col-md-3">
        <label>User Name</label>
        <input type="text" class="form-control" name="userName" required> 
      </div>
      <div class="form-group col-md-3">
        <label>Password</label>
        <input type="text" class="form-control" name="userPassword" required> 
      </div>
      <div class="form-group col-md-3">
        <label>First Name</label>
        <input type="text" class="form-control" name="firstName" required>
      </div>
      <div class="form-group col-md-3">
        <label>Last Name</label>
        <input type="text" class="form-control" name="lastName" required>
      </div>
    </div>
    <div class="form-row">    
      <div class="form-group col-md-3">
        <label>User Contact</label>
        <input type="text" class="form-control" name="contactNumber" required>
      </div>          
      <div class="form-group col-md-3">
        <label>User Email</label>
        <input type="text" class="form-control" name="emailAddress" required>
      </div>
      <div class="form-group col-md-3">
        <label >User Email</label>
        <select class="form-control" name="userRole">
          <option value="Admin">Admin</option>
          <option value="Accounts">Accounts</option>
          <option value="Engineer">Engineer</option>
        </select>        
      </div>
      <div class="form-group col-md-3">
        <br>
        <button type="button" class="btn btn-default" onClick="addUser();" style="width:60%;" >Add User</button>
      </div>
    </div>              
  </div>
</div>  
</div>  
</div>
<section class="light-gray-bg pv-30 clearfix">
  <div class="container">
    <div class="row">
      <dir class="col-md-4">
        <div class="white-bg shadow p-20 text-center object-non-visible animated object-visible fadeInUpSmall" data-animation-effect="fadeInUpSmall" data-effect-delay="100" data-toggle="modal" data-target="#addVeenderModel">
          <h3 class="mt-4" >Add New Vender</h3>
          <div class="separator"></div>                
        </div>
      </dir>
      <dir class="col-md-4">
        <div class="white-bg shadow p-20 text-center object-non-visible animated object-visible fadeInUpSmall" data-animation-effect="fadeInUpSmall" data-effect-delay="100" data-toggle="modal" data-target="#addUserModel">
          <h3 class="mt-4" >Add New User</h3>
          <div class="separator"></div>                
        </div>
      </dir>
      <dir class="col-md-4">
        <div class="white-bg shadow p-20 text-center object-non-visible animated object-visible fadeInUpSmall" data-animation-effect="fadeInUpSmall" data-effect-delay="100"  data-toggle="modal" data-target="#currentProjectModal">
          <h3 class="mt-4" >Current Projects</h3>
          <div class="separator"></div>
        </div>
      </dir>
    </div>
  </div>
</section>
<div class="modal fade" id="currentProjectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">Current Projects</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
      </div>      
        <div class="modal-body">
          ${projectList}
          <br/>
        </div>      
    </div>
  </div>
</div>

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
<script src="./plugins/jquery.min.js"></script>
<script src="./bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="./plugins/rs-plugin-5/js/jquery.themepunch.tools.min.js"></script>
<script src="./plugins/rs-plugin-5/js/jquery.themepunch.revolution.min.js"></script>
<script src="./plugins/isotope/imagesloaded.pkgd.min.js"></script>
<script src="./plugins/isotope/isotope.pkgd.min.js"></script>
<script src="./plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="./plugins/waypoints/jquery.waypoints.min.js"></script>
<script src="./plugins/waypoints/sticky.min.js"></script>
<script src="./plugins/countTo/jquery.countTo.js"></script>
<script src="./plugins/slick/slick.min.js"></script>
<script src="./js/template.js"></script>
<script src="./js/custom.js"></script>
<script src="plugins/jquery.blockUI.js"></script>
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
  function addVendor()
  {
    if(
      $('[name="vendorNameStr"]').val() === ''
      || $('[name="vendorAddress"]').val() === ''
      || $('[name="vendorContactName"]').val() === ''
      || $('[name="vendorNumber"]').val() === ''
      || $('[name="vendorEmail"]').val() === '') 
    {
      alert('Please fill out all the fields and try again..!!');
      return;
    }

    showLoading();
    $.ajax({
     type : 'POST',
     data :  {'vendorName' : $('[name="vendorNameStr"]').val(), 'vendorAddress': $('[name="vendorAddress"]').val(), 'contactName': $('[name="vendorContactName"]').val(), 'contactNumber': $('[name="vendorNumber"]').val(), 'contactEmail': $('[name="vendorEmail"]').val()},
     url : 'saveVendor',
     success : function(data) 
     {
      var venderName = $('[name="vendorNameStr"]').val();
      $("[name='vendorName']").append("<option value=" + venderName + ">" + venderName + "</option>");

      document.getElementById("textOverlaySearch").style.display = "none";

      alert('Vender has been added successfully');              
    }
  });
    hideLoading();
  }
</script>

<script>
  function addUser()
  {
    if(
      $('[name="userPassword"]').val()===''
      || $('[name="userName"]').val()===''
      || $('[name="firstName"]').val()===''
      || $('[name="lastName"]').val()===''
      || $('[name="contactNumber"]').val()===''
      || $('[name="emailAddress"]').val()===''
      || $('[name="userRole"]').val()==='')
    {
      alert('Please fill out all the fields and try again..!!');
      return;
    }

    showLoading();
    $.ajax({
     type : 'POST',
     data :  {'userPassword' : $('[name="userPassword"]').val(), 'userName' : $('[name="userName"]').val(), 'firstName': $('[name="firstName"]').val(), 'lastName': $('[name="lastName"]').val(), 'contactNumber': $('[name="contactNumber"]').val(), 'emailAddress': $('[name="emailAddress"]').val(), 'userRole' : $('[name="userRole"]').val()},
     url : 'registerUser',
     success : function(data) 
     {
      alert('User has been added successfully.');
    }
  });
    hideLoading();
  }
</script>

</body>
</html>