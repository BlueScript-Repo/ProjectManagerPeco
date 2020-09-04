<!DOCTYPE html>
<html dir="ltr" lang="zxx">

<head>
  <meta charset="utf-8">
  <title>PECO Project</title>
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
  <link href="css/custTooltip.css" rel="stylesheet">

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
<body class="" cz-shortcut-listen="true">

  <!-- scrollToTop -->
  <!-- ================ -->
  <div class="scrollToTop circle fadeToTop"><i class="fa fa-angle-up"></i></div>

  <!-- page wrapper start -->
  <!-- ================ -->
  <div class="page-wrapper">
    <!-- header-container start -->
    <div class="header-container">
      <div class="sticky-wrapper" style="height: 111px;"><div class="sticky-wrapper" style="height: 110px;"><header class="header fixed fixed-desktop clearfix object-visible">
        <div class="container">
          <div class="col-md-auto hidden-md-down">
            <div class="header-first clearfix">
             <div class="row">
               <div class="col-md-8">
                 <div class="navbar navbar-default navbar-static-top container" style="margin-left: 0px; margin-right: 0px;">
                  <div class="navbar-header" style="width: 200px;">
                   <img src="./images/img/PECOLogo1.jpg" alt="" style="width: 250px;height: 55px;margin-top: 20px;margin-left: -150px;">
                 </div>
               </div>
             </div> 
             <div class="col-md-2">
               <form class="form-horizontal" action="home" method="POST" style="margin-left: 100px;margin-top: 30px;">
                <button type="submit" class="btn btn-default btn-animated">Home<i class="fa fa-user"></i></button>
              </form>
            </div>
            <div class="col-md-2"> 
              <form class="form-horizontal" action="logout" method="POST" style="margin-left: 100px;margin-top: 30px;">
                <button type="submit" class="btn btn-default btn-animated">Log Out <i class="fa fa-user"></i></button>
              </form>
            </div>
            <div class="site-slogan">
            </div>
          </div>
        </div>
        <div class="col-auto hidden-md-down">
        </div>
      </div>
    </div>
  </header>
</div>

<!-- header end -->
</div>
<!-- main-container start -->
<!-- ================ -->
<section class="">
  <!-- section -->
  <!-- ================ -->
  <section class="light-gray-bg pv-30 padding-bottom-clear clearfix">
    <div class="container" style="max-width:98%;">
      <div class="row">
        <div class="col-md-7" >
          <div class="pv-30 ph-20 feature-box bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
            <h3>${projectName}</h3>
            <div class="separator clearfix"></div>
            <p>${projectDesc}</p>
          </div>
        </div> 
        <aside class="col-md-5 col-xl-5 ml-xl-auto">
          <div class="sidebar">
            <div class="block clearfix">
              <h3 class="title">Project Details</h3>
              <div class="separator-2"></div>
              <ul class="list margin-clear">
                <li>
                  <strong>PO Date: </strong> <span class="text-right">${poDate}</span>  <strong style="padding-left: 19%;">PO Number:</strong> <span>${poNumber}</span>
                </li>
                <li>
                  <strong>Contact Person: </strong> <span class="text-right">${contactName}</span>  <strong style="padding-left: 15%;">Contact Number: </strong> <span class="text-right">${contactPhone}</span>
                </li>
                <li>
                  <strong>Address: </strong> <span class="text-right">${address}</span> <strong style="padding-left: 10%;">Contact Email: </strong> <span class="text-right">${contactEmail}</span>
                </li>                    
                <li>
                  <strong>GST #: </strong> <span class="text-right">${gstNumber}</span>
                </li>
              </ul>
            </div>
          </div>
        </aside>			  
      </div>
      <br>
    </div>
    <!-- Update project Section START -->
    <div class="row" style="margin-left: 1%;margin-top: -1.8%;">
      <div class="col-md-3">
        <div class="pv-10 ph-10 feature-box bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall __web-inspector-hide-shortcut__" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
          <div class="row">
            <h3 class="select-menu" data-toggle="modal" data-target="#createProjectModal" style="margin-left: 6%;margin-top: 3%;"> + Project Section</h3>
            <div class="container collapse" style="max-width:98%;" id="projectDetails">
             <div class="col-md-12 ">

              <div class="modal fade bd-example-modal-lg" id="createProjectModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
               <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content" style="width:110%;margin-left:-4%;">
                 <div class="modal-header">
                  <h4 class="modal-title" >Project Details</h4>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
                </div>
                <div class="modal-body">
                 <form action="updateProject" class="projDetails" method="POST">
                  <div class="row" style="margin-top: 2%;">
                    <div class="col-md-3 ">
                      <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                        <div class="form-group has-feedback">
                          <label style="margin-left: -80%;">PO Date</label>
                          <input type="text" name="poDate" class="form-control" value="" required>                  
                        </div>
                      </div>
                    </div>
                    <div class="col-md-3 ">
                      <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                        <label style="margin-left: -75%;">PO Number</label>
                        <input type="text" name="poNumber" class="form-control" value="" required>
                      </div>
                    </div>
                    <div class="col-md-3 ">
                      <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                       <label style="margin-left: -55%;">Contact Person Name</label>
                       <input type="text" name="contactName" class="form-control" required>
                     </div>
                   </div>
                   <div class="col-md-3 ">
                    <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                      <label style="margin-left: -70%;">Contact Email</label>
                      <input type="text" name="contactEmail" class="form-control" required> 
                    </div>
                  </div>
                </div>
                <br>
                <div class="row" style="margin-top: -3%;margin-bottom: 2%">
                  <div class="col-md-3 ">
                    <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                     <label style="margin-left: -70%;">Contact Phone</label>
                     <input type="text" name="contactPhone" class="form-control" required>
                   </div>
                 </div>
                 <div class="col-md-3 ">
                  <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                   <label style="margin-left: -70%;">GST Number</label>
                   <input type="text" name="gstNumber" class="form-control" value="" required>
                 </div>
               </div>
               <div class="col-md-3 ">
                <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                 <label style="margin-left: -80%;">Address</label>
                 <input type="text" name="address" class="form-control" required>
               </div>
             </div>

             <div class="col-md-3 " style="margin-left: -2%;">
               <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                <label></label>
                <br>
                <button type="submit" class="btn btn-default">Update Project</button>
              </div>          
            </div>
          </div>
          <input type="hidden" name="projectId" value="${projectId}">
        </form></div>
      </div>  
    </div>
  </div>
</div>
</div>
</div>
</div>
</div>
</div>

<!-- Update project Section END -->
<div class="row" style="margin-left: 1%;margin-top: -1.8%;">
  <div class="col-md-4">
    <div class="pv-10 ph-10 feature-box bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall __web-inspector-hide-shortcut__" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
      <div class="row" style="margin-top: -2%;margin-left: 2%;">
        <h3 class="mt-4" data-toggle="modal" data-target="#createProjectModal1" style="margin-left: 2%;"> + BOQ Section</h3>

        <div class="container collapse" style="max-width:98%;" id="boqDetails">

         <div class="modal fade bd-example-modal-lg" id="createProjectModal1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
           <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content" style="width:110%;margin-left:-4%;">
             <div class="modal-header">
              <h4 class="modal-title" >BOQ Section</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
              <div class="row">
                <div class="col-md-3" align="center">
                  <h4>Quotation Revisions</h4>
                  <select class="form-control revisionSection" onchange="download($('.revisionSection').val(),'tableContentDetails');">
                    <option></option>
                  </select>
                </div> 
                <div class="col-md-3" align="center">
                  <br/>
                  <button type="button" class="btn btn-default" onclick="toggleCreateBOQSec();">Create BOQ</button>
                </div>
                <div class="col-md-3" align="center">
                  <br/>
                  <button type="button" class="btn btn-default" onclick="toggleDesignOfferSec();">Create Design Offer</button>
                </div>
                <div class="col-md-3" align="center">
                  <br/>
                  <form name="fileUploadForm" action="import" method="post" enctype="multipart/form-data" style="margin: 0px">
                   <button class="btn btn-default" name="uploadFile">Upload</button>
                   <label for="choose">Choose File</label>
                   <input id="choose" type="file" name="file" onClick="toggleImportSec();" style="display:none;" class="btn btn-default">
                 </form>  
               </div>
             </div>
             <div class="row" style="margin-left: 2%";>
              <input class="form-control" type="hidden" name="boqNameList" value="${boqNameList}" style="margin-left: 3%;margin-bottom: 6%;">
              <input class="form-control" type="hidden" name="quotationNamesList" value="${quotationNamesList}" style="margin-left: 3%;margin-bottom: 6%;">
              <input class="form-control" type="hidden" name="taxInvoiceNamesList" value="${taxInvoiceNamesList}" style="margin-left: 3%;margin-bottom: 6%;">
              <input class="form-control" type="hidden" name="poNamesList" value="${poNamesList}" style="margin-left: 3%;margin-bottom: 6%;">
            </div>

            <div class="row" style="margin-bottom: 2%;">
              <div class="col-md-12">
                <div class="separator object-non-visible mt-10 animated object-visible fadeIn" data-animation-effect="fadeIn" data-effect-delay="100"></div>
              </div>
            </div>
            <form name="generateBOQ" action="generateNew" class="createBOQ" method="POST" style="display: none;">
              <div class="row" style="margin-left: 8%;">
                <div class="col-md-3 col-sm-3" >
                 <div class="animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                  <label>Doc Name</label>
                  <input type="text" name="dName" class="form-control" value="" required>
                </div>
              </div>
              <div class="col-md-3 col-sm-3">
               <div class="animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                <label>Utility</label>
                <input type="text" name="utility" class="form-control" value="" required>
              </div>
            </div>
            <div class="col-md-3 col-sm-3">
             <div class="animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
              <label>Pressure</label>
              <input type="text" name="pressure" class="form-control" value="" required>
            </div>
          </div>
          <div class="col-md-3 col-sm-3" style="margin-left: 0%;">
           <div class="animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
            <label>Temperature</label>
            <input type="text" name="temperature" class="form-control" value="" required>
          </div>
        </div>
      </div>
      <div class="row" style="margin-left: 8%;margin-top: 1%;">
        <div class="col-md-3 col-sm-3">
         <div class="animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
          <label>Doc Number</label>
          <input type="text" class="form-control" name="dNo" value="" required>
        </div>
      </div>
      <div class="col-md-3 col-sm-3">
       <div class="animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
        <label>Client</label>
        <input type="text" name="client" class="form-control" value="${clientName}" required>
      </div>
    </div>
    <div class="col-md-3 col-sm-3">
     <div class="animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
      <label>Site</label>
      <input type="text" name="site" class="form-control" value="" required>
    </div>
  </div>
  <div class="col-md-3 col-sm-3">
    <label class="createBOQ" style="margin-top: 1%; display: none;">BOQ Name : </label>
    <input class="createBOQ form-control" style="display: none;" type="text" id="boqName" name="boqName" value="" project="" required>
    <input type="hidden" name="projectId" value="${projectId}"/>
  </div>  
</div>
<ul class="nav nav-tabs style-1" role="tablist" id="sheetListtableContentDetails" style="margin-top:3%;">
</ul>
<div class="tab-content" id="tableContentDetails">  
</div>
<div class="row" style="margin-top: 2%;">
  <div class="col-md-1" align="center">
  </div>
  <div class="col-md-2" align="center">
    <input type="button" class="btn btn-default" name="deleteBoqButton" onclick="deleteRevision('boq');" value="Delete This BOQ">
  </div>
  <div class="col-md-2" align="center">
    <input type="button" class="btn btn-default" name="downloadBoqButton" onclick="downloadInquiry('boq');" value="Download This BOQ">
  </div>
  <div class="col-md-2" align="center">
    <button type="submit" name="generateBOQButton" class="btn btn-default generateBOQButton">Generate Quotation</button>
  </div>
  <span class="border border-info">
    <div class="col-md-2" align="center">
      <input type="text" class="form-control" style="margin-top: 5px;width: 150px;" name="newSheetName">
    </div>
    <div class="col-md-2" align="center">
      <h4 class="btn btn-default" data-toggle="collapse" onClick="addNewSheet()">Add New Sheet</h4>
    </div>
  </span>
  <div class="col-md-2" align="center">
    <select class="form-control" onchange="hideOthers(this.value)" style="width: 100%;">
      <option></option>
      <option value="item1">Add Pipes & Fittings</option>
      <option value="valve1">Add Valves</option>
      <option value="accessory1">Add Accessories  & Equipments </option>
      <option value="fabrication">Add Fabrication works </option>
    </select>
  </div>
</div>
<div class="row" style="margin-top: 2%;">
  <div class="col-md-12">
    <div class="separator object-non-visible mt-10 animated object-visible fadeIn" data-animation-effect="fadeIn" data-effect-delay="100"></div>
  </div>
</div>
</form>

<div class="designOffer" style="max-width: 90%;display: none;">
       <h1 class="page-title">Design Order</h1>
       <div class="separator-2"></div>
       <form method="POST" action="generateDesign">
        <div class="row">
          <div class="col-md-3">
            <div class="form-group has-feedback">
              <label>Doc No</label>
              <input type="text" class="form-control" name="docNumber">
            </div>
          </div>
          <div class="col-md-3">
            <div class="form-group has-feedback">
              <label>Contact Name</label>
              <input type="text" class="form-control" name="contactName">
            </div>
          </div>
          <div class="col-md-3">
            <div class="form-group has-feedback">
              <label>Company</label>
              <input type="text" class="form-control" name="clientCompany">
            </div>
          </div>
          <div class="col-md-3">
            <div class="form-group has-feedback">
              <label>Address</label>
              <input type="text" class="form-control" name="address">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-2">
            <div class="form-group has-feedback">
              <label>City</label>
              <input type="text" class="form-control" name="city">
            </div>
          </div>
          <div class="col-md-2">
            <div class="form-group has-feedback">
              <label>Pincode</label>
              <input type="text" class="form-control" name="pinCode">
            </div>
          </div>
          <div class="col-md-4">
            <div class="form-group has-feedback">
              <label>Subject</label>
              <input type="text" class="form-control" name="subject">
            </div>
          </div>
          <div class="col-md-4">
            <div class="form-group has-feedback">
              <label>Uitlity</label>
              <input type="text" class="form-control" name="utility">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6" >
            <h2 class="page-title">Scope</h1>
              <div class="separator-2"></div>
              <div id="scopeList">
                <div class="clearfix" id="scope1">
                  <input type="button" class="float-left mt-4 btn btn-info" value="x" onclick="$('#scope1').remove();">
                  <textarea class="form-control float-right" name="scope" rows="3" style="width: 90%;"> * Study of Existing piping Scheme of CHW & CA:- A detailed study shall conduct on existing Piping network, from generators to consumers, including Pump stations, Receivers/Storage, Distribution network analysis, Piping supports, & Insulation.</textarea>
                </div>
                <br/>
                <div class="clearfix" id="scope2">
                  <input type="button" class="float-left mt-4 btn btn-info" value="x" onclick="$('#scope2').remove();">
                  <textarea class="form-control float-right" name="scope" rows="3" style="width: 90%;">* Identifying any concerns within present system:-  The Operational and Maintenance related issues shall be addressed during the study of existing network, identifying pressure and temperature issues, evaluation of supply versus return flows of Utilities.</textarea> 
                </div>
                <br>
                <div class="clearfix" id="scope3">
                  <input type="button" class="float-left mt-4 btn btn-info" value="x" onclick="$('#scope3').remove();">
                  <textarea class="form-control float-right" name="scope" rows="3" style="width: 90%;">* Input data of actual load of all utility consumers (evaluation): - As a part of process of fresh designing of the Utility networks, the complete loads of consumers shall be estimated/evaluated basis on the OEM data, buffer required during the load fluctuations, peak loads identification, and required pressure and temperatures for the better quality of the product.</textarea> 
                </div>
                <br>
                <div class="clearfix" id="scope4">
                  <input type="button" class="float-left mt-4 btn btn-info" value="x" onclick="$('#scope4').remove();">
                  <textarea class="form-control float-right" name="scope" rows="3" style="width: 90%;">* Design of new P&ID considering future expansion factor:- Basis on the input data collection, the new Utility Piping networks shall be designed from the source to consumers. Each machine, header, sub-headers, pumps suction & discharges line sizes shall be calculated, pressure drops of the individual network shall be estimated, necessary instrumentation scheme will be incorporated, Monitoring parameters list shall be identified.</textarea> 
                </div>
                <br>
                <div class="clearfix" id="scope5">
                  <input type="button" class="float-left mt-4 btn btn-info" value="x" onclick="$('#scope5').remove();">
                  <textarea class="form-control float-right"  name="scope" rows="3" style="width: 90%;"> * Preparation of Piping Layout and Isometrics:-  Implementing the Good Engineering Practices, the new Piping networks shall be designed as Operation and Maintenance friendly systems. The Piping systems, Storages Tanks, Isolation Valves, Flow Meters, Control Valves to locate in safe locations for quick access. The complete piping networks shall be shown in the plan-view by superimposing the piping and key-equipment in the plant plot-plan.</textarea> 
                </div>
                <br>
                <div class="clearfix" id="scope6">
                  <input type="button" class="float-left mt-4 btn btn-info" value="x" onclick="$('#scope6').remove();">
                  <textarea class="form-control float-right"  name="scope" rows="3" style="width: 90%;">Isometric drawings shall be generated considering the piping layout as input, the isometrics shall give 3dimentional routing clarity, actual measurement of spool pieces, prefabrication numbering terminology based on each tapping/piping/spool, support location, fabrication and installation details for welding and flange joints.</textarea> 
                </div>
                <br>
                <div class="clearfix" id="scope7">
                  <input type="button" class="float-left mt-4 btn btn-info" value="x" onclick="$('#scope7').remove();">
                  <textarea class="form-control float-right"  name="scope" rows="3" style="width: 90%;">* Generation of Material Specification along with quantities:- Pipes, Fittings, Accessories and other specific products detailed specification shall be generated as per ASME B 31.3 codes and its respective standards as applicable. The specification is a global level platform.</textarea> 
                </div>
                <br>
                <div class="clearfix" id="scope8">
                  <input type="button" class="float-left mt-4 btn btn-info" value="x" onclick="$('#scope8').remove();">
                  <textarea class="form-control float-right"  name="scope" rows="3" style="width: 90%;">* Design Concept note:- The complete Piping networks design basis shall be submitted, including the inputs, peak loads, selection criteria, key instrumentation logic, safe operation practice, etc. The Design Concept Report will be a detailed narrative report of the P&IDs of its respective Utility.</textarea>
                </div>
              </div>
              <input type="button" class="btn btn-default" value="Add" onclick="addScope();">
            </div>            
            <div class="col-md-6" >
              <div id="delvList">
                <h2 class="page-title">Deliverables</h2>
                <div class="separator-2"></div>
                <div class="clearfix" id="delv1">
                  <input type="button" class="float-left mt-3 btn btn-info" value="x" onclick="$('#delv1').remove();">
                  <textarea class="form-control float-right" id="delv1" name="deliverables" rows="2" style="width: 90%;">* Piping & Instrumentation Diagram &#13;&#10;(Line size, Pressure drops, Selection of equipments & pumps, network/Hook-ups)</textarea> 
                </div>
                <br>                
                <div class="clearfix" id="delv2">
                  <input type="button" class="float-left mt-3 btn btn-info" value="x" onclick="$('#delv2').remove();">
                  <textarea class="form-control float-right" id="delv2" name="deliverables" rows="3" style="width: 90%;">* Piping Layouts&#13;&#10;(Detailed Plan view of total piping network, Section views for elevation changes and piping pitch arrangements, & Cut-outs, Foundations)</textarea>

                </div>
                <br>
                <div class="clearfix" id="delv3">
                  <input type="button" class="float-left mt-3 btn btn-info" value="x" onclick="$('#delv3').remove();">
                  <textarea class="form-control float-right" id="delv3" name="deliverables" rows="2" style="width: 90%;">* Isometric Drawings&#13;&#10;(3Dimensional view of Pipe routing, detailed hook-ups, line crossings Etc)</textarea>
                </div>
                <br>
                <div class="clearfix" id="delv4">
                  <input type="button" class="float-left mt-3 btn btn-info" value="x" onclick="$('#delv4').remove();">
                  <textarea class="form-control float-right" id="delv4" name="deliverables" rows="2" style="width: 90%;">* BOQ/BOM&#13;&#10;(Final Bill Of Quantities for all pipes, fittings & accessories for all piping networks)</textarea>
                </div>                
                <br>
              </div>
              <input type="button" class="btn btn-default" value="Add" onclick="addDeliverables();">
              <div class="separator-2"></div>
              <div id="deliveryList">
                <br>
                <h2 class="page-title">Delivery</h2>
                <div class="separator-2"></div>
                <br>
                <div class="clearfix" id="delivery1">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#delivery1').remove();">
                  <input type="text" class="form-control float-right" id="delivery1" name="delivery" style="width: 90%;" value="Existing Schematic drawings shall be submitted at site.">
                </div>
                <br>
                <div class="clearfix" id="delivery2">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#delivery2').remove();">
                  <input type="text" class="form-control float-right" id="delivery2" name="delivery" style="width: 90%;" value="Proposed P&ID scheme shall be defined at Site.">
                </div>
                <br>
                <div class="clearfix" id="delivery3">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#delivery3').remove();">
                  <input type="text" class="form-control float-right" id="delivery3" name="delivery" style="width: 90%;" value="Piping Layout & Isometrics 4Weeks after Site visit.">
                </div>
                <br>
                <div class="clearfix" id="delivery4">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#delivery4').remove();">
                  <input type="text" class="form-control float-right" id="delivery4" name="delivery" style="width: 90%;" value="Detailed Specification along with Quantities 2weeks from the date of Isometrics Submission.">
                </div>
                <br>                
              </div>
              <input type="button" class="btn btn-default" value="Add" onclick="addDelivery();">
              <div class="separator-2"></div>
            </div>
          </div>
          <div class="separator-2"></div>
          <br>
          <div class="row">
            <div class="col-md-6">
              <div class="row">
                <div class="col-md-12">
                  <h2 class="page-title">Payment Terms</h2>
                  <div class="separator-2"></div>
                  <br>
                  <div id="payTermList">
                    <div class="clearfix" id="payTerm1">
                      <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#payTerm1').remove();">
                      <input type="text" class="form-control float-right" style="width:90%;" name="payTerm" value="50% Advance along with PO.">
                      <br>
                    </div>
                    <div class="clearfix" id="payTerm2">
                      <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#payTerm2').remove();">
                      <input type="text" class="form-control float-right" style="width:90%;" id="payTerm2" name="payTerm" value="50% Against Readiness of Piping Layout & Isometrics (Before Submission).">
                      <br>
                    </div>
                  </div>
                  <input type="button" class="btn btn-default" value="Add" onclick="addPayTerm();">
                </div>
              </div>
              <div class="separator-2"></div>
              <br>
              <div class="row">
                <div class="col-md-12">
                  <h2 class="page-title">Line Items</h2>
                  <div class="separator-2"></div>
                  <label>Description</label>
                  <input type="text" class="form-control" id="lineItemMainDesc" name="lineItemMainDesc" value="Charges for Basic and Detail Engineering Services for ">
                  <br>
                  <div id="lineItemList">
                    <div class="row">
                      <div class="col-md-4"><label>Item</label></div>
                      <div class="col-md-4"><label>Quantity</label></div>
                      <div class="col-md-4"><label>Rate</label></div>
                    </div>  
                    <div class="clearfix" id="lineItem1">
                      <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#lineItem1').remove();">
                      <div class="row">
                        <div class="col-md-4"><input type="text" class="form-control" id="lineItemDesc" name="lineItemDesc" value="Site Visit"></div>
                        <div class="col-md-4"><input type="text" class="form-control" id="lineItemQty" name="lineItemQty" value=""></div>
                        <div class="col-md-4"><input type="text" class="form-control" id="lineItemRate" name="lineItemRate" value=""></div>
                      </div>
                      <br>
                    </div>
                    <div class="clearfix" id="lineItem2">
                      <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#lineItem2').remove();">
                      <div class="row" >
                        <div class="col-md-4"><input type="text" class="form-control" id="lineItemDesc" name="lineItemDesc" value="Detailed Engineering Services"></div>
                        <div class="col-md-4"><input type="text" class="form-control" id="lineItemQty" name="lineItemQty" value=""></div>
                        <div class="col-md-4"><input type="text" class="form-control" id="lineItemRate" name="lineItemRate" value=""></div>
                      </div>
                      <br>
                    </div>
                  </div>
                  <input type="button" class="btn btn-default" value="Add" onclick="addLineItem();">
                  <div class="separator-2"></div> 
                </div>
              </div>  
            </div>
            <div class="col-md-6">
              <h2 class="page-title">Terms & Conditions</h2>
              <div class="separator-2"></div>
              <br>
              <div id="termsAndConditionList">                
                <div class="clearfix" id="termsAndCondition1">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#termsAndCondition1').remove();">
                  <input type="text" class="form-control float-right" style="width: 90%;" id="termsAndCondition1" name="termsAndCondition" value="Site visit plan to confirm, 2 weeks in advance.">
                  <br>
                </div>
                <div class="clearfix" id="termsAndCondition2">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#termsAndCondition2').remove();">
                  <input type="text" class="form-control float-right" style="width: 90%;" id="termsAndCondition2" name="termsAndCondition" value="Day-wise charge & Travel cost will be applicable on departure from Pune(HO).">
                  <br>
                </div>
                <div class="clearfix" id="termsAndCondition3">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#termsAndCondition3').remove();">
                  <input type="text" class="form-control float-right" style="width: 90%;" id="termsAndCondition3" name="termsAndCondition" value="Travel Expenses from Pune to Site location, Accommodation, Food, and Local conveyance in your scope.">
                  <br>
                </div>
                <div class="clearfix" id="termsAndCondition4">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#termsAndCondition4').remove();">
                  <input type="text" class="form-control float-right" style="width: 90%;" id="termsAndCondition4" name="termsAndCondition" value="Visa and other formalities if any shall be done by PetStream.">
                  <br>
                </div>
                <div class="clearfix" id="termsAndCondition5">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#termsAndCondition5').remove();">
                  <input type="text" class="form-control float-right" style="width: 90%;" id="termsAndCondition5" name="termsAndCondition" value="Layout and Isometrics submission shall depend upon piping quantity.">
                  <br>
                </div>
                <div class="clearfix" id="termsAndCondition6">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#termsAndCondition6').remove();">
                  <input type="text" class="form-control float-right" style="width: 90%;" id="termsAndCondition6" name="termsAndCondition" value="PO and Advance shall release along with the site visit confirmation (2Week before departure).">
                  <br>
                </div>
                <div class="clearfix" id="termsAndCondition7">
                  <input type="button" class="float-left mt-1 btn btn-info" value="x" onclick="$('#termsAndCondition7').remove();">
                  <input type="text" class="form-control float-right" style="width: 90%;" id="termsAndCondition7" name="termsAndCondition" value="3D Modelling costing will submitted in separate offer, by tentative estimation on Piping Network size.">
                  <br>
                </div>
              </div>
              <input type="button" class="btn btn-default" value="Add" onclick="addTermsAndCondition();">
            </div>
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>
      </div>

<div class="container collapse" id="item1" style="max-width:98%;" id="addInventory">
  <div class="row createBOQ" style="display: none;">
    <div class="col-md-12 form-inline">
     <table class="table table-colored border border-info" style="max-width: 98%;">
      <thead>
        <tr>
          <th>Item</th>
          <th>Material</th>
          <th>Type</th>
          <th>Manifacturing Method</th>
          <th>Class/Schedule</th>
          <th>Ends</th>
          <th>Size</th>
        </tr>
      </thead>
      <tbody id="tableContent">
       <tr>
        <td>
         <div class="form-group">
           <select class="form-control" name="inventoryName" id="inventoryName" onchange="myFunction(this.value,'inventoryName','material');">
             <option></option>
             ${items}
           </select>
         </div>
       </td>
       <td>
         <div class="form-group">
           <select class="form-control" name="material" id="material" onchange="myFunction(this.value,'material','type');">
             <option></option>
           </select>
         </div>
       </td>
       <td>
         <div class="form-group">
           <select class="form-control" name="type" id="type" onchange="myFunction($('#material').val(),'material','classOrGrade');">
             <option></option>
           </select>
         </div>
       </td>
       <td>
         <div class="form-group">
           <select class="form-control" name="manifacturingMethod" id="manifacturingMethod">
             <option></option>
             <option>Seamless</option>
             <option>ERW</option>
             <option>Centrifuge</option>
           </select>
         </div>
       </td>
       <td>
         <div class="form-group">
           <select class="form-control" name="classOrGrade" id="classOrGrade">
             <option></option>
           </select>
         </div>
       </td>
       <td>
         <div class="form-group">
           <select class="form-control" name="ends" id="ends">
             <option></option>
             <option>Buttweld</option>
             <option>Socket Weld/Threaded</option>
             <option>Threaded</option>
             <option>Plain End</option>
           </select>
         </div>
       </td>
       <td>
         <div class="form-group">
           <select class="form-control" name="size" id="size">
            <option value='15NB-1/2"'>15NB-1/2" </option>
            <option value='20NB-3/4"'>20NB-3/4" </option>
            <option value='25NB-1"'>25NB-1"   </option>
            <option value='32NB-1:1/4"'>32NB-1:1/4" </option> 
            <option value='40NB-1:1/2"'>40NB-1:1/2" </option> 
            <option value='50NB-2"'>50NB-2"   </option>
            <option value='65NB-2:1/2"'>65NB-2:1/2" </option> 
            <option value='80NB-3"'>80NB-3"   </option>
            <option value='100NB-4"'>100NB-4" </option>
            <option value='125NB-5"'>125NB-5" </option>
            <option value='150NB-6"'>150NB-6" </option>
            <option value='200NB-8"'>200NB-8" </option>
            <option value='250NB-10"'>250NB-10" </option>
            <option value='300NB-12"'>300NB-12" </option>
            <option value='350NB-14"'>350NB-14" </option>
            <option value='400NB-16"'>400NB-16" </option>
            <option value='450NB-18"'>450NB-18" </option>
            <option value='500NB-20"'>500NB-20" </option>
            <option value='550NB-22"'>550NB-22" </option>
            <option value='600NB-24"'>600NB-24" </option>
          </select>
        </div>
      </td>
    </tr>                 
  </tbody>
</table>
</div>
</div>
<div class="row createBOQ" style="display: none;">
  <div class="col-md-2">
   <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
     <label></label>
     <br>
     <button type="button" class="btn btn-default" onclick="appendInventory();">Add Inventory</button>   
   </div> 
 </div>
</div>
</div>
<div class="container collapse" id="accessory1" style="max-width:98%;" id="addAccessory">
  <div class="row createBOQ" style="display: none;">
    <div class="col-md-12">
      <table class="table table-colored createBOQ rounded-circle border border-info" style="display:none;">
        <thead>
          <tr>
            <th>Accessory</th>
            <th>Desc1</th>
            <th>Desc2</th>
            <th>Desc3</th>
            <th>Desc4</th>
            <th>Desc5</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><input class="form-control" type="text" name="accessoryName" id="accessoryName" /></td>
            <td><input class="form-control" type="text" name="desc1" id="desc1" /></td>
            <td><input class="form-control" type="text" name="desc2" id="desc2" /></td>
            <td><input class="form-control" type="text" name="desc3" id="desc3" /></td>
            <td><input class="form-control" type="text" name="desc4" id="desc4" /></td>
            <td><input class="form-control" type="text" name="desc5" id="desc5" /></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  <div class="row createBOQ" style="display: none;">
    <div class="col-md-2">
     <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
       <label></label>
       <br>
       <button type="button" class="btn btn-default" onclick="appendAccessory();">Add Accessory</button>   
     </div> 
   </div>
 </div>
</div>
<div class="container collapse" id="valve1" style="max-width:90%;" id="addValve">
  <div class="row createBOQ" style="display: none;">
    <div class="col-md-12 form-inline">
      <table class="table table-colored createBOQ rounded-circle border border-info" style="display:none;">
        <thead>
          <tr>
            <th>Model</th>
            <th>Material</th>
            <th>End</th>
            <th>Type</th>
            <th>Pressure Ratings</th>
            <th>Max Inlet Pressure</th>
            <th>Operations</th>
            <th>SeatAndSeals</th>
            <th>Valve Size</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
             <div class="form-group">
               <select class="form-control" name="model" id="model" onchange="getValveDetails('material');">
                <option></option>
                <option value="CAST_IRON_GATE:API-600"  >CAST IRON GATE-API-600 </option>
                <option value="CAST_IRON_GATE:API6D"  >CAST IRON GATE-API6D </option>
                <option value="CAST_IRON_GATE:MSS-SP-81"  >CAST IRON GATE-MSS SP-81</option>
                <option value="CAST_IRON_GLOBE:API-600"  >CAST IRON GLOBE-API-600</option>
                <option value="CAST_IRON_GLOBE:API6D"  >CAST IRON GLOBE-API6D</option>
                <option value="CAST_IRON_GLOBE:MSS-SP-81"  >CAST IRON GLOBE-MSS SP-81</option>
                <option value="SLUICE_&_REFLUX:API-600"  >SLUICE & REFLUX-API-600</option>
                <option value="SLUICE_&_REFLUX:API6D"  >SLUICE & REFLUX-API6D</option>
                <option value="SLUICE_&_REFLUX:MSS-SP-81"  >SLUICE & REFLUX-MSS SP-81</option>
                <option value="STAINERS:ARC 014 "  >STAINERS-ARC 014  </option>
                <option value="GATE:API 602"  >GATE-API 602  </option>
                <option value="GATE:BS-5352"  >GATE-BS-5352  </option>
                <option value="GATE:ARC-024"  >GATE-ARC-024  </option>
                <option value="GLOBE:API 602"  >GLOBE-API 602  </option>
                <option value="GLOBE:BS-5352"  >GLOBE-BS-5352  </option>
                <option value="GLOBE:ARC-024"  >GLOBE-ARC-024  </option>
                <option value="CHECK:API 602"  >CHECK-API 602  </option>
                <option value="CHECK:BS-5352"  >CHECK-BS-5352  </option>
                <option value="CHECK:ARC-024"  >CHECK-ARC-024  </option>
                <option value="DIAPHRAGM:BS-5156"  >DIAPHRAGM-BS-5156  </option>
                <option value="SAFETY:API 526"  >SAFETY-API 526  </option>
                <option value="STEAM_TRAPS:IS 12268"  >STEAM TRAPS-IS 12268 </option>
                <option value="GATE:API 600"  > GATE-API 600  </option>
                <option value="GATE:API-6D"  > GATE-API 6D   </option>
                <option value="GATE:MSS SP-81"  > GATE-MSS SP-81</option>
                <option value="KNIFE_EDGE_GATE:API 600"  >KNIFE EDGE GATE-API 600  </option>
                <option value="KNIFE_EDGE_GATE:API-6D"  >KNIFE EDGE GATE-API 6D   </option>
                <option value="KNIFE_EDGE_GATE:MSS SP-81"  >KNIFE EDGE GATE-MSS SP-81</option>
                <option value="GLOBE:BS-1873"  >GLOBE-BS-1873  </option>
                <option value="GLOBE:ND-16"  >GLOBE-ND-16    </option>
                <option value="GLOBE:ND-40"  >GLOBE-ND-40    </option>
                <option value="NON_RETURN:BS-1868"  >NON RETURN-BS-1868  </option>
                <option value="NON_RETURN:API~6D"  >NON RETURN-API 6D   </option>
                <option value="FLOATING&TRUNION:BS-5351"  >FLOATING&TRUNION-BS-5351 </option>
                <option value="FLOATING&TRUNION:API_6D"  >FLOATING&TRUNION-API 6D </option>
                <option value="FLOATING&TRUNION:BS5159"  >FLOATING&TRUNION-BS5159 </option>
                <option value="FLOATING&TRUNION:ISO 17292" >FLOATING&TRUNION-ISO 17292</option>
                <option value="BUTTERFLY:BS-5155"  >BUTTERFLY-BS-5155</option>
                <option value="BUTTERFLY:API 609"  >BUTTERFLY-API 609  </option>
                <option value="BUTTERFLY:AWWA C504"  >BUTTERFLY-AWWA C504</option>
                <option value="BUTTERFLY:IS 13095"  >BUTTERFLY-IS 13095 </option>
                <option value="WAFER:API.6D"  >WAFER-API 6D  </option>
                <option value="WAFER:API 594"  >WAFER-API 594  </option>
                <option value="DUALPLATE_CHECK:API.6D"  >DUALPLATE CHECK-API 6D</option>
                <option value="DUALPLATE_CHECK:API 594" >DUALPLATE CHECK-API 594</option>
              </select>
            </div>
          </td>
          <td>
           <div class="form-group">
             <select class="form-control" name="material" id="materialVal" onchange="getValveDetails('end');">
               <option></option>
             </select>
           </div>
         </td>
         <td>
           <div class="form-group">
             <select class="form-control" name="end" id="endVal" onchange="getValveDetails('type');">
               <option></option>
             </select>
           </div>
         </td>
         <td>
           <div class="form-group">
             <select class="form-control" name="type" id="typeVal" onchange="getValveDetails('pressureRatings');">
               <option></option>
             </select>
           </div>
         </td>
         <td>
           <div class="form-group">
             <select class="form-control" name="pressureRatings" id="pressureRatingsVal" onchange="getValveDetails('maxInletPressure');" >
               <option value='-'>-</option>
             </select>
           </div>
         </td>
         <td>
           <div class="form-group">
             <select class="form-control" name="maxInletPressure" id="maxInletPressureVal" onchange="getValveDetails('operations');">
               <option value='-'>-</option>
             </select>
           </div>
         </td>
         <td>
           <div class="form-group">
             <select class="form-control" name="operations" id="operationsVal" onchange="getValveDetails('seatAndSeals');">
               <option value='-'>-</option>
             </select>
           </div>
         </td>
         <td>
           <div class="form-group">
             <select class="form-control" name="seatAndSeals" id="seatAndSealsVal">
               <option value='-'>-</option>
             </select>
           </div>
         </td>
         <td>
           <div class="form-group">
            <select class="form-control" name="valveSize" id="valveSize">
              <option value='15NB-1/2"'>15NB-1/2" </option>
              <option value='20NB-3/4"'>20NB-3/4" </option>
              <option value='25NB-1"'>25NB-1"   </option>
              <option value='32NB-1:1/4"'>32NB-1:1/4" </option> 
              <option value='40NB-1:1/2"'>40NB-1:1/2" </option> 
              <option value='50NB-2"'>50NB-2"   </option>
              <option value='65NB-2:1/2"'>65NB-2:1/2" </option> 
              <option value='80NB-3"'>80NB-3"   </option>
              <option value='100NB-4"'>100NB-4" </option>
              <option value='125NB-5"'>125NB-5" </option>
              <option value='150NB-6"'>150NB-6" </option>
              <option value='200NB-8"'>200NB-8" </option>
              <option value='250NB-10"'>250NB-10" </option>
              <option value='300NB-12"'>300NB-12" </option>
              <option value='350NB-14"'>350NB-14" </option>
              <option value='400NB-16"'>400NB-16" </option>
              <option value='450NB-18"'>450NB-18" </option>
              <option value='500NB-20"'>500NB-20" </option>
              <option value='550NB-22"'>550NB-22" </option>
              <option value='600NB-24"'>600NB-24" </option>
            </select>
          </div>
        </td>
      </tr> 
    </tbody>
  </table>
</div>
</div>
<div class="row createBOQ" style="display: none;">
 <div class="col-md-2">
   <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
     <label></label>
     <br>
     <button type="button" class="btn btn-default" onclick="appendValve();">Add Valve</button>   
   </div> 
 </div>
</div>
</div>
<div class="form-row createBOQ" style="display: none;">
 <div class="col-md-4 ">
   <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
   </div>
 </div>
 <div class="col-md-4 ">
   <div class="ph-20 feature-box text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
   </div>         
 </div>
 <div class="col-md-4 ">

 </div>
</div>

<br>
<div class="col-md-3 ">
</div>
</div>
<div class="row" id="LoadingImage" style="display: none">
  <div class="col-md-4">
  </div>
  <div class="col-md-4">
    <div>
    </div>
  </div>
  <div class="col-md-4">
  </div>
</div>
<div class="row" style="margin-top: 10px">
</div>
</form></div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<!--Create BOQ Start-->
<div class="row" style="margin-left: 1%;margin-top: -1.8%;">
  <div class="col-md-5">
    <div class="pv-10 ph-10 feature-box bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall __web-inspector-hide-shortcut__" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
      <div class="row" style="margin-top: -2%;margin-left: 1%;">
        <h3 class="mt-4" data-toggle="modal" data-target="#createProjectModal2" style="margin-left: 3%;"> + Inquiry Section</h3>
        <div class="container collapse" style="max-width:98%;" id="inquiryDetails">
         <div class="modal fade bd-example-modal-lg" id="createProjectModal2" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
           <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content" style="width:110%;margin-left:-4%;">
             <div class="modal-header">
              <h4 class="modal-title" >Inquiries</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
              <ul class="nav nav-tabs style-1" role="tablist" id="sheetListtableContentInqSec">
              </ul>
              <div class="tab-content" id="tableContentInqSec">  
              </div>
              <div class="row" style="margin-top: 2%;margin-bottom: 2%;">
               <div class="col-md-3" style="margin-left: 5%;">
                 <h4>Quotation Revisions</h4>
                 <select class="form-control revisionSection" onchange="download($(this).val(), 'tableContentInqSec');">
                  <option></option>
                </select>
                <br>
                <h4>Inquiry List</h4>
                <select class="form-control offerRevisionSection" onchange="download($(this).val(),'tableContentInqSec');" >
                  <option></option>
                </select>                
              </div>
              <div class="col-md-3" style="margin-left: -5%;">
                <input type="hidden" name="venderList" value="${venderList}">
                <h4>Vender List</h4>
                <select class="form-control venderList" name="selectedVenderName">
                  <option></option>
                </select>
              </div> 
              <div class="col-md-3" style="margin-left: -5%;">
                <h4>Inquiry Name</h4>
                <input type="text" class="form-control" name="inquiryName">
                <br>
                <button type="button" onclick="deleteRevision('inquiry');" class="btn btn-default" style="width:67%;margin-top:10%;">Delete Inquiry</button> 
              </div>
              <div class="col-md-3" style="margin-left: -5%;">
                <input type="hidden" name="boqNameList" value="${boqNameList}">
                <input type="hidden" name="quotationNamesList" value="${quotationNamesList}">
                <br>
                <button type="button" onclick="createInquiry();" class="btn btn-default" >Generate & Send Inquiry</button>
                <br>
                <br>
                <button type="button" onclick="downloadInquiry('inquiry');" class="btn btn-default" style="width:67%;margin-top:7.5%;">Download Inquiry</button>
              </div>
            </div>
          </div>    
        </div>
      </div>
    </div>    
  </div>
</div>
</div>
</div>
</div>
</div>
<div class="row"style="margin-left: 1%;margin-top: -1.8%;">
  <div class="col-md-6">
    <div class="pv-10 ph-10 feature-box bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall __web-inspector-hide-shortcut__" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
      <div class="row" style="margin-top: -2%;margin-left: 1%;">
        <h3 class="mt-4" data-toggle="modal" data-target="#createProjectModal3" style="margin-left: 3%;"> + Purchase Order Section</h3>
        <div class="container collapse" style="max-width:98%;" id="purchaseDetails">
         <div class="modal fade bd-example-modal-lg" id="createProjectModal3" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
           <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content" style="width:110%;margin-left:-4%;">
             <div class="modal-header">
              <h4 class="modal-title" >Purchase Details</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
              <ul class="nav nav-tabs style-1" role="tablist" id="sheetListtableContentPOSec">
              </ul>
              <div class="tab-content" id="tableContentPOSec">  
              </div>
              <div class="row" style="margin-top: 2%;margin-bottom: 2%;">
                <div class="col-md-3" style="margin-left:5%";>
                  <h4>Inquiry List</h4>
                  <select class="form-control offerRevisionSection" onchange="download($(this).val(),'tableContentPOSec');">
                    <option></option>
                  </select>
                </div>
                <div class="col-md-3 ">
                  <h4>PO List:</h4> 
                  <select class="form-control" onchange="downloadPO($('#poList').val());" id="poList">
                    <option></option>
                  </select>

                </div>  
                <div class="col-md-3" style="margin-top: 1.5%;">      
                  <button type="button" onclick="generatePO();" class="btn btn-default">Generate PO</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
</div>
<div class="row"style="margin-left: 1%;margin-top: -1.8%;">
  <div class="col-md-7">
    <div class="pv-10 ph-10 feature-box bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall __web-inspector-hide-shortcut__" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
      <div class="row" style="margin-top: -2%;margin-left: 1%;">
        <h3 class="mt-4" data-toggle="modal" data-target="#createProjectModal4" style="margin-left: 3%;"> + Invoice and Payment Section</h3>
        <div class="container collapse" style="max-width:98%;" id="InvoiceDetails">
          <div class="modal fade bd-example-modal-lg" id="createProjectModal4" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
           <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content" style="width:110%;margin-left:-4%;">
             <div class="modal-header">
              <h4 class="modal-title" >Invoice Details</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
              <div class="row" style="margin-top: 2%;margin-bottom: 2%;">
                <div class="col-md-3 "style="margin-left:5%";>
                 <h4>TaxInvoice List</h4>
                 <select class="form-control" onchange="downloadInvoice($('#taxInvoiceList').val());" id="taxInvoiceList">
                  <option></option>
                </select>
              </div>
              <div class="col-md-3" style="margin-top: 1.5%;">      
                <button type="button" class="btn btn-default" data-toggle="collapse" data-target="#payDetails" onclick="closeOther('payDetails');">Received Payment Details</button>
              </div>
              <div class="col-md-3" style="margin-left:-3%;margin-top: 1.5%;">      
               <button type="button" class="btn btn-default" data-toggle="collapse" data-target="#createProjectModal5" onclick="closeOther('createProjectModal5');" >Add Payment Details</button>
             </div>
             <div class="col-md-3" style="margin-left:-6%;margin-top: 1.5%;">      
               <button type="button" class="btn btn-default" data-toggle="collapse" data-target="#generateInvoice" id="generateInvoiceFrNInv" onclick="closeOther('generateInvoice');" >Generate Invoice for received Inventory</button>
             </div>
           </div>
           <div class="separator clearfix"></div>
           <div class="collapse border border-info" id="createProjectModal5">
            <div class="row" style="margin-top: 1.5%;">
             <div class="col-md-3" style="margin-left: 5%;">
               <label class="" style="margin-top: 1%;">Invoice</label>
               <select class="form-control" name="taxInvoiceNumber" id="taxInvoiceNumber" > 
                <option></option>
              </select>
            </div>
            <div class="col-md-3" style="margin-left: -4%;">
             <label class="" style="margin-top: 1%;">Total Amount</label>
             <input class="form-control" style="" type="text" id="" name="totalAmount" value="" project="">
           </div>
           <div class="col-md-3" style="margin-left: -4%;">
             <label class="" style="margin-top: 1%;">Received Amount</label>
             <input class="form-control" style="" type="text" id="" name="receivedAmount" value="" project="">
           </div>
           <div class="col-md-3" style="margin-left: -5%;">
            <label class="" style="margin-top: 1%;">Payment Mode</label>
            <input class="form-control" style="" type="text" id="" name="paymentMode" value="" project="">
          </div>
        </div>
        <div class="row" style="">
         <div class="col-md-3" style="margin-left: 5%;">
           <input type="button" class="btn btn-default" onClick="addPayDetails();" value="Add">
         </div>
       </div>
     </div>
     <div class="separator clearfix"></div>
     <div class="collapse border border-info" id="payDetails">				
      <div class="col-md-12" style="margin-top: 1.5%;">      
        <table id="payDetailsSection" class="table table-striped table-colored">
         <thead>
           <tr>
             <th>Payment ID</th>
             <th>TaxInvoice Number</th>
             <th>Total Amount</th>
             <th>Amount Received</th>
             <th>Amount Prnding</th>
             <th>Payment Method</th>
             <th>Date Received</th>
           </tr>
         </thead>     
         <tbody id="paymentDetailsBody" >
          ${paymentDetails}
        </tbody>
      </table>
    </div>		
  </div>
  <div class="separator clearfix"></div>
  <div class="collapse border border-info" id="generateInvoice" >
    <section class="main-container">
      <div class="container">
        <form action="generateInvoice" id="updateInventory" method="POST">
          <dir class="row" style="padding-left:6%;margin-left: -9%;">          
            <table class="table table-colored">
              <thead>
               <tr>
                <th>#</th>
                <th>Item</th>
                <th>Material</th>
                <th>Type</th>
                <th>Manifacturing Method</th>
                <th>Class/Schedule</th>
                <th>Ends</th>
                <th>Size</th>
                <th>Purchase Rate</th>
                <th>Received Quantity</th>                
                <th>Location</th>
                <th>Received Date</th>
              </tr>
            </thead>
            <tbody id="generateInvoiceTable">
            </tbody>
          </table>
        </dir>
        <div class="collapse border border-info" id="invoice" style="padding-left:3%;"> 
          <label><h3></h3></label>  
          <div class="form-row">  
            <div class="form-group col-md-3">
              <label>Contact Name</label>
              <input type="text" class="form-control" name="contactName" value="${contactName}">
            </div>
            <div class="form-group col-md-3">
              <label>Mobile No</label>
              <input type="text" class="form-control" name="mobileNo" value="${mobileNo}">
            </div>
            <div class="form-group col-md-3">
              <label>Addressed To</label>
              <input type="text" class="form-control" name="addressedto1" value="${addressedTo}">
            </div>
            <div class="form-group col-md-3">
              <label>Order Date</label>
              <input type="text" class="form-control" name="orderDate">
            </div>
          </div>
          <div class="form-row">              
           <div class="form-group col-md-3">
            <label>Email</label>
            <input type="text" class="form-control" name="emailAddress" value="${emailAddress}">
          </div>
          <div class="form-group col-md-3">
            <label>Invoice Type</label>
            <select class="form-control" name="invoiceType" id="invoiceType">
              <option></option>
              <option value="Supply">Supply</option>
              <option value="Labour">Labour</option>
              <option value="Supply&amp;Labour">Supply&amp;Labour</option>
            </select>
          </div>
          <div class="form-group col-md-3">
            <label>Hsn/Sac</label>
            <input type="text" class="form-control" name="hsnOrSac">
          </div>
          <div class="form-group col-md-3">
            <br/>
            
          </div>
          <input type="hidden" name="orderNo" value="">
        </div>
        
      </div>
      <div class="row" style="margin-left: 0%;">
        <div class="col-md-3 ">
         <div class="ph-20 feature-box text-center">
           <br>
           <button type="button" onclick="hideOthers('invoice')" data-toggle="collapse" data-target="#invoice" class="btn btn-default">Invoice Details</button>
         </div> 
       </div>
       <div class="col-md-3">
         <div class="ph-20 feature-box text-center">
           <br>
           <button type="button" id="updateButton" onclick="generateInvoice();" class="btn btn-default">Generate Invoice</button>
         </div> 
       </div>
     </div>
   </form>
 </div>
</section>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>

<div class="row"style="margin-left: 1%;margin-top: -1.8%;">
  <div class="col-md-8">
    <div class="pv-10 ph-10 feature-box bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall __web-inspector-hide-shortcut__" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
      <div class="row" style="margin-top: -2%; margin-left: 1%;">
        <h3 class="mt-4" data-toggle="modal" data-target="#createProjectModal6" style="margin-left: 3%;"> + Item Section</h3>
        <div class="container collapse" style="max-width:98%;" id="InventoryDetails">
         <div class="modal fade bd-example-modal-lg" id="createProjectModal6" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
           <div class="modal-dialog modal-lg" role="document">
             <div class="modal-content" style="width:110%;margin-left:-4%;">
               <div class="modal-header">
                <h4 class="modal-title" >Inventory Details</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
              </div>
              <div class="modal-body">
                <div class="row" style="margin-top: 2%;margin-bottom: 2%;">
                 <div class="col-md-3 "style="margin-left:5%";>
                  <br>
                  <button type="button" class="btn btn-default" onClick="hideOthers1('aitem')" style="margin-left:8%;" data-toggle="collapse" data-target="#assignedInventory">Show Assigned Item</button>
                </div>
                <div class="col-md-3">
                  <br>
                  <button type="button" class="btn btn-default" onClick="hideOthers1('citem')" style="margin-left:6%;" data-toggle="collapse" data-target="#consumedInventory">Show Consumed Item</button>
                </div>
              </div>
            </div>

            <div class="container collapse" id="aitem" style="max-width:98%;" id="assignedInventory">
              <div class="col-md-12 ">
                <div class="table-responsive">                
                  <table class="table table-colored assignedInventorySec border border-info" >
                    <thead>
                      <tr>
                       <th></th>
                       <th>Item</th>
                       <th>Material</th>
                       <th>Type</th>
                       <th>Manifacturing Method</th>
                       <th>Class/Schedule</th>
                       <th>Ends</th>
                       <th>Size</th>
                       <th>Quantity</th>
                       <th>Purchase Rate</th>
                       <th>Project</th>
                       <th>Location</th>
                       <th>Action</th>
                     </tr>
                   </thead>
                   <tbody id="tableContentDetails">
                    ${assignedInventory}
                  </tbody>
                </table>                
              </div> 
            </div>
          </div>
          <div class="container collapse" id="citem" style="max-width:98%;" id="consumedInventory">
            <div class="col-md-12 ">
              <div class="table-responsive">               
                <table class="table table-colored border border-info">
                  <thead>
                    <tr>
                     <th></th>
                     <th>Item</th>
                     <th>Material</th>
                     <th>Type</th>
                     <th>Manifacturing Method</th>
                     <th>Class/Schedule</th>
                     <th>Ends</th>
                     <th>Size</th>
                     <th>Quantity</th>
                     <th>Purchase Rate</th>
                     <th>Project</th>
                     <th>Location</th>
                     <th>Action</th>
                   </tr>
                 </thead>
                 <tbody>
                  ${consumedInventory}
                </tbody>
              </table>            
            </div> 
          </div>
        </div>
      </div>
    </div> 
  </div>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="form-row">
</div>	
<br>
</section>
</section>
<!-- main-container end -->
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
</footer>

<form action="generateOrderForm" id="generateOffer" method="POST">	
</form>

<div class="modal-backdrop1" style="display:none;">
  <img src="images/img/loading.gif" style="padding-left: 45%;padding-bottom: 45%;">
</div>

<script src="plugins/jquery.min.js"></script>
<script src="plugins/jquery.blockUI.js"></script>
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
<script src="js/jquery.validate.js"></script>

<script>
  function hideOthers(idToBeOpen)
  {

    var idVals = ["item1","accessory1","valve1"];

    for(var i=0; i< idVals.length; i++)
    {
      if(idToBeOpen !== idVals[i])
      {
        $('#'+idVals[i]).collapse("hide");

      }
      else
      {
        if($('#'+idToBeOpen).hasClass('collapse'))
        {
          $('#'+idToBeOpen).collapse("show");  
        }
        else
        {
         $('#'+idToBeOpen).collapse("hide"); 
       }

     }

   }
 }
</script>
<script>
  function hideOthers1(idToBeOpen)
  {

    var idVals = ["aitem","citem"];

    for(var i=0; i< idVals.length; i++)
    {
      if(idToBeOpen !== idVals[i])
      {
        $('#'+idVals[i]).collapse("hide");

      }
      else
      {
        if($('#'+idToBeOpen).hasClass('collapse'))
        {
          $('#'+idToBeOpen).collapse("show");  
        }
        else
        {
         $('#'+idToBeOpen).collapse("hide"); 
       }

     }

   }
 }
</script>
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
    /*this.setTimeout($.unblockUI,1000);*/
    $.unblockUI();

  }

</script>

<script>
  function captureFileLocation() {
    $('#LoadingImage').show();
    var fileLocation;
    var entrerLocationRequest = prompt("Please Enter the file location", "BOQ File Location");
    if (entrerLocationRequest == null || entrerLocationRequest == "") {
      fileLocation = "User cancelled the prompt.";
    } else {
      fileLocation = entrerLocationRequest;
    }
    console.log("File Location : "+fileLocation);

    if(fileLocation != "User cancelled the prompt.")
    {
      showLoading();
      $.ajax({
       type : 'POST',
       data : {'location' : fileLocation},
       url : 'import',
       success : function(data) {

        $('#tableContentDetails').html(data);
        adjustWidth();
        hideLoading();
      }
    });

      var imp = document.getElementById("importBoq");
        //imp.style.display = "none";
        
        var generate = document.getElementById("generate");
        generate.style.display = "block";
        
        var generateInq = document.getElementById("generateQuot");
        generateInq.style.display = "block";
      }
    }
    function adjustWidth() 
    {
     console.log('Inside adjustWidth');
   }

 </script>
 <script>
  function myFunction(value, tagName, nextTagName) {

    $('#LoadingImage').show();
    var tag = '#'+nextTagName;
    var inventory = $('#inventoryName')[0].value;
    
    showLoading();

    $.ajax({
     type : 'POST',
     data :  {'value' : value,'currentTag' : tagName,'nextTagName' : nextTagName, 'inventory' : inventory},
     url : 'getDropdown',
     success : function(data) {

      console.log(data);
      console.log($(tag));

      var blank = "<option> </option>";
      $(tag).html(blank);
      $(tag).append(data);
      hideLoading();
    }
  });
  }
</script>
<script>
  function updateSupplyRate(thisObj)
  {

    var rate = [];
    var quantity = [];

    var obj = $(thisObj);

    console.log($(thisObj).find('parentElement').find('parentElement').find('parentElement'))
    console.log("Base count is :  "+$(thisObj).find('#inventoryDetails').find("input[name='baseSupplyRate']").length);

    var thisBaseSupplyRates = $($(obj).closest("table")[0]).find("input[name='baseSupplyRate']");
    /*$("input[name='baseSupplyRate']").each(function() {*/
      $(thisBaseSupplyRates).each(function() {
        var sRate = parseFloat($(this).val()) + parseFloat($("[name='supplyPrsnt']").val()*$(this).val()/100);

        if(sRate % 5 != 0)
        {
          sRate + 5 - sRate % 5
        }
        rate.push(sRate);
      });

      var thisSupplyRates = $($(obj).closest("table")[0]).find("input[name='supplyRate']");
      var int = 0;
      $(thisSupplyRates).each(function() {
        $(this).val(rate[int]);
        int++;
      });

      var thisQuantity = $($(obj).closest("table")[0]).find("input[name='quantity']");
      $(thisQuantity).each(function() {
       quantity.push($(this).val());
     });


      var thisSupplyAmount = $($(obj).closest("table")[0]).find("input[name='supplyAmount']");

      var i = 0;
      $(thisSupplyAmount).each(function() {
       console.log(rate[i]);
       console.log(quantity[i]);
       $(this).val(rate[i]*quantity[i]);
       i++;
     });

    }
  </script>        
  <script>
    function updateErectionRate(thisObj)
    {

      var rate = [];
      var quantity = [];

      var obj = $(thisObj);

      var thisBaseErectionRate = $($(obj).closest("table")[0]).find("input[name='baseErectionRate']");

      $(thisBaseErectionRate).each(function() {
        var eRate = parseFloat($(this).val()) + parseFloat($("[name='erectionPrsnt']").val()*$(this).val()/100);

        if(eRate % 5 != 0)
        {
          eRate + 5 - eRate % 5
        }

        rate.push(eRate);
      });

      var thisErectionRate = $($(obj).closest("table")[0]).find("input[name='erectionRate']");
      var int = 0;
      $(thisErectionRate).each(function() {
        $(this).val(rate[int]);
        int++;
      });

      var thisQuantity = $($(obj).closest("table")[0]).find("input[name='quantity']");
      $(thisQuantity).each(function() {
       quantity.push($(this).val());
     });

      var thisErectionAmount = $($(obj).closest("table")[0]).find("input[name='erectionAmount']");

      var i = 0;
      $(thisErectionAmount).each(function() {
       console.log(rate[i]);
       console.log(quantity[i]);
       $(this).val(rate[i]*quantity[i]);
       i++;
     });
    }
  </script>

  <script>
    $(document).ready(function(){
   // we define and invoke a function
   (function(){

     var inputArray = $("input[name='boqNameList']")[0].value.split(",");
     
     var names = [];
     $.each(inputArray, function(i, el){
      if($.inArray(el, names) === -1) 
      {
       names.push(el);
     }
   });

     var dummy = "<option value=\"BOQRevisions\"><h5>BOQRevisions</h5></option>";
     
     $.each(names,function(i){

      var dummy1 = dummy.replace("BOQRevisions",names[i]);

      var tags = dummy1.replace("BOQRevisions",names[i]);

      $('.revisionSection').append(tags);

    });
     
   })();
 });

    $(document).ready(function(){
   // we define and invoke a function
   (function(){

     var inputArray = $("input[name='quotationNamesList']")[0].value.split(",");
     
     var names = [];
     $.each(inputArray, function(i, el){
      if($.inArray(el, names) === -1) 
      {
        names.push(el);
      }
    });

     var dummy = "<option value=\"QuotationRevisions\"><h5>QuotationRevisions</h5></option>";
     
     $.each(names,function(i){

      var dummy1 = dummy.replace("QuotationRevisions",names[i]);

      var tags = dummy1.replace("QuotationRevisions",names[i]);

      $('.offerRevisionSection').append(tags);

    });
     
   })();
 });

    $(document).ready(function(){
   // we define and invoke a function
   (function(){

     var inputArray = $("input[name='taxInvoiceNamesList']")[0].value.split(",");
     
     var names = [];
     $.each(inputArray, function(i, el){
      if($.inArray(el, names) === -1) 
      {
        names.push(el);
      }
    });

     var dummy = "<option value=\"taxInvoiceName\"><h5>taxInvoiceName</h5></option>";
     
     $.each(names,function(i){

      var dummy1 = dummy.replace("taxInvoiceName",names[i]);

      var tags = dummy1.replace("taxInvoiceName",names[i]);

      $('#taxInvoiceList').append(tags);
      $('#taxInvoiceNumber').append(tags);

    });
     
   })();
 });

    $(document).ready(function(){
   // we define and invoke a function
   (function(){

     var inputArray = $("input[name='poNamesList']")[0].value.split(",");
     
     var names = [];
     $.each(inputArray, function(i, el){
      if($.inArray(el, names) === -1) 
      {
        names.push(el);
      }
    });

     var dummy = "<option value=\"poName\"><h5>poName</h5></option>";
     
     $.each(names,function(i){

      var dummy1 = dummy.replace("poName",names[i]);

      var tags = dummy1.replace("poName",names[i]);

      $('#poList').append(tags);

    });
     
   })();
 });
</script>

<script>
  function download(name, sectionName) 
  {
  	
    showLoading();
    
    if(sectionName === 'tableContentInqSec')
    {
      $('.tableContentInqSec').css('display','block');
    }
    else if(sectionName === 'tableContentPOSec')
    {
      $('.tableContentPOSec').css('display','block');
    }
    else
    {
      $('.createBOQ').show();
      $('.generateBOQButton').css('display','block');
      $('.inventoryTableHeader').css('display','block');  
    }    
    
    $('[name="boqName"]')[0].value = name;
    
    var projectId = $('[name="projectId"]')[0].value;  

    var formData = $(this).serializeArray();

    formData.push({name: 'projectId', value: projectId});
    formData.push({name: 'boqName', value: name});


    $.ajax({
     type : 'GET',
     data :  formData,
     url : 'downloadBoq',
     success : function(data)
     { 

       var details = data.split('::');

       var headerDetails = details[0];

       var headerHTML = $.parseHTML(headerDetails);

       for(var k=0;k<headerHTML.length-2;k++)
       {
        var ele = headerHTML[k];
        var val = headerHTML[k].value;

        $('[name="'+ele.name+'"]').attr('value',val);
      }

      var sheetDetailsHTML = headerHTML[headerHTML.length-1];
      $('[name="generateBOQ"]').append(sheetDetailsHTML);

      $('#sheetList'+sectionName).html('');

      var isFirst = true;
      for(var i=1;i<details.length-1;i++)
      {
        var sheetName = details[i];
        var className = '';

        if(isFirst)
        {
          className = 'active show';
        } 

        $('#sheetList'+sectionName).append('<li class="nav-item"><a class="nav-link '+sheetName+' '+className+'" href="#'+sheetName+'" role="tab" data-toggle="tab" aria-selected="true">'+sheetName+'<i class="fa fa-times pr-2" onClick="removeSheet('+sheetName+');" style="margin-left:5px;"></i></a></li>');

        isFirst = false;
      }

      var tagData = details[details.length-1]; 
      $('#'+sectionName+'').html(tagData);
      $('#LoadingImage').hide();

    }

  });

    hideLoading();
  }
  function adjustWidthDn() 
  {
   console.log('Inside adjustWidth');
 }
</script>


<script>
  function createInquiry() 
  {

    showLoading();

    var inventoryName       = [];
    var material            = [];
    var type                = [];
    var manifacturingMethod = [];
    var classOrGrade        = [];
    var ends                = [];
    var size                = [];
    var quantity            = [];
    var baseSupplyRate      = [];
    var supplyRate          = [];
    var baseErectionRate    = [];
    var erectionRate        = [];
    var supplyAmount        = [];
    var erectionAmount      = [];
    var sheetDetails        = "";

    var tabs = $('.tab-pane');
    for(var r=0;r<tabs.length;r++)
    {

      var CheckeleCount = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input:checkbox').length;

      var selectedElements = [];
      var i;
      var checkedEle = 0;
      for(i=0; i < CheckeleCount; i++)
      {
        if($($('#tableContentInqSec').find('.tab-pane')[r]).find('input:checkbox')[i].checked)
        {
         selectedElements[i] = i;
         checkedEle++;
       }
     }

     if(checkedEle>0)
     {
      sheetDetails = sheetDetails + $($('#tableContentInqSec').find('.tab-pane')[r]).attr('id')+','+checkedEle+',';
     }
     
     var eleCount = $('#tableContentInqSec input').length;
     var j;
     var k = 0;
     var n = 1;
     for(k=0;k<selectedElements.length;k++)
     {

       if(selectedElements[k] != undefined)
       {
        var start = 3 + 15*parseFloat(selectedElements[k]);
        console.log('Start is : '+start);

        quantity[quantity.length+k]           = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        baseSupplyRate[baseSupplyRate.length+k]     = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        supplyRate[supplyRate.length+k]         = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        baseErectionRate[baseErectionRate.length+k]   = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        erectionRate[erectionRate.length+k]       = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        supplyAmount[supplyAmount.length+k]       = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        erectionAmount[erectionAmount.length+k]     = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        inventoryName[inventoryName.length+k] 	    = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;							      
        material[material.length+k]      	    = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;     
        type[type.length+k]               = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;

        var tempVal = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;

        if(tempVal==="")
        {
          manifacturingMethod[manifacturingMethod.length+k] = " ";
        }
        else
        {
          manifacturingMethod[manifacturingMethod.length+k] = tempVal;
        }
        

        classOrGrade[classOrGrade.length+k]       = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        ends[ends.length+k]               = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
        size[size.length+k]               = $($('#tableContentInqSec').find('.tab-pane')[r]).find('input')[start++].value;
      }	
    }
  }
  var lastArray = 3 + 20*parseFloat(selectedElements[parseFloat(selectedElements.length) - 1]);


  var formData = $(this).serializeArray();

  formData.push({name: 'projectId', value: $('[name="projectId"]').val()});
  formData.push({name: 'boqName', value: $('[name="inquiryName"]').val()});


  var inventoryName_string = cleanArray(inventoryName);
  formData.push({name: 'inventoryName', value: inventoryName_string});
  var material_string = cleanArray(material);
  formData.push({name: 'material', value: material_string});
  var type_string = cleanArray(type);
  formData.push({name: 'type', value: type_string});
  var manifacturingMethod_string = cleanArray(manifacturingMethod);
  formData.push({name: 'manifMetod', value: manifacturingMethod_string});
  var classOrGrade_string = cleanArray(classOrGrade);
  formData.push({name: 'classOrGrade', value: classOrGrade_string});
  var ends_string = cleanArray(ends);
  formData.push({name: 'ends', value: ends_string});
  var size_string = cleanArray(size);
  formData.push({name: 'size', value: size_string});
  var quantity_string = cleanArray(quantity);
  formData.push({name: 'quantity', value: quantity_string});

  var baseSupplyRate_string = cleanArray(baseSupplyRate);
  formData.push({name: 'baseSupplyRate', value: baseSupplyRate_string});
  var supplyRate_string = cleanArray(supplyRate);
  formData.push({name: 'supplyRate', value: supplyRate_string});
  var baseErectionRate_string = cleanArray(baseErectionRate);
  formData.push({name: 'baseErectionRate', value: baseErectionRate_string});
  var erectionRate_string = cleanArray(erectionRate);
  formData.push({name: 'erectionRate', value: erectionRate_string});

  var supplyAmount_string = cleanArray(supplyAmount);
  formData.push({name: 'supplyAmount', value: supplyAmount_string});
  var erectionAmount_string = cleanArray(erectionAmount);
  formData.push({name: 'erectionAmount', value: erectionAmount_string});

  formData.push({name: 'venderName', value: $('[name="selectedVenderName"]').val()});
  formData.push({name: 'isOffer', value: 'true'});
  formData.push({name: 'sheetDetails', value: sheetDetails});

  var inquiryNameList = $('.offerRevisionSection')[0].options; 

  var revisionNo = 0;
  for(var k = 0; k < inquiryNameList.length; k++)
  {
    if(inquiryNameList[k].value.startsWith('Inquiry_'+$('[name="inquiryName"]').val()))
    {
      revisionNo ++;
      var optionVal = inquiryNameList[k].value;
      console.log(optionVal);        
    }

  }

  console.log('revisionNo is : '+revisionNo);    

  var inquiryName = '<option value="Inquiry_'+ $('[name="inquiryName"]').val() +'_R'+revisionNo+'">Inquiry_'+$('[name="inquiryName"]').val()+'_R'+revisionNo+'</option>';
  $.ajax({
   url: "generate",
   data: formData,
   type: 'post',
   success: function(data) {

    console.log("Appending "+inquiryName);
    $('.offerRevisionSection').append(inquiryName);
    hideLoading();

    alert('Inquiry has been sent successfully.');
  }
});
  
}

function cleanArray(actual)
{
  var newArray = new Array();
  for(var i = 0; i<actual.length; i++)
  {
    if (actual[i])
    {
      newArray.push(actual[i]);
    }
  }
  return newArray;
}
</script>

<script>

  function generatePO()
  {	
    showLoading();
    var length = $('#tableContentPOSec  input').length;

    var line;
    var i;
    for(i=1;i<length;i++)
    {
     if($('#tableContentPOSec  input')[i].name == "inventoryName")
     {
      var temp = $('#tableContentPOSec  input')[i];
      line = $(temp).clone();
    } 
    else if($('#tableContentPOSec  input')[i].name == "material")
    {
      var temp = $('#tableContentPOSec  input')[i];
      line = $(temp).clone();
    }
    else if($('#tableContentPOSec  input')[i].name == "type")
    {
      var temp = $('#tableContentPOSec  input')[i];
      line = $(temp).clone();
    }
    else if($('#tableContentPOSec  input')[i].name == "manifMetod")
    {
      var temp = $('#tableContentPOSec input')[i];
      line = $(temp).clone();
    }
    else if($('#tableContentPOSec input')[i].name == "classOrGrade")
    {
      var temp = $('#tableContentPOSec input')[i];
      line = $(temp).clone();
    }
    else if ($('#tableContentPOSec input')[i].name == "ends")
    {
      var temp = $('#tableContentPOSec input')[i];
      line = $(temp).clone();
    }
    else if ($('#tableContentPOSec input')[i].name == "size")
    {
      var temp = $('#tableContentPOSec input')[i];
      line = $(temp).clone();
    }
    else if ($('#tableContentPOSec input')[i].name == "quantity")
    {
      var temp = $('#tableContentPOSec input')[i];
      line = $(temp).clone();
    }
    else if ($('#tableContentPOSec input')[i].name == "supplyRate")
    {
      if($('#tableContentPOSec input')[i].value === "")
      {
        alert('Please provide the supply Rates and retry.!!');
        hideLoading();
        return;
      }
      var temp = $('#tableContentPOSec input')[i];
      line = $(temp).clone();
    }

    $('#generateOffer').append($(line));		
  }

  var temp = $('[name="projectId"]')[0];
  line = $(temp).clone();
  $('#generateOffer').append($(line));

  $('#generateOffer').submit();
  showLoading();
}
</script>
<script>
  function toggleCreateBOQSec()
  {
   $('.createBOQ').toggle();
 }    
</script>
<script>
  function toggleImportSec()
  {
    console.log('calling toggleImportSec');
    $('.importBOQ1').toggle();
    $('.importBOQ2').toggle();
  }    
</script>

<script>
  function appendInventory() 
  {

    $('.generateBOQButton').css('display','block');
    $('.inventoryTableHeader').css('display','block');

    var inventoryName = $('#inventoryName').children("option:selected").val();
    var material = $('#material').children("option:selected").val();
    var type = $('#type').children("option:selected").val();
    var manifacturingMethod = $('#manifacturingMethod').children("option:selected").val();
    var classOrGrade = $('#classOrGrade').children("option:selected").val();
    var ends = $('#ends').children("option:selected").val();
    var size = $('#size').val();

    console.log(type);

    var	template = "<tr>"
    + "	   <td> </td>"
    + "    <td> <input type='hidden' name='inventoryName' value='"+inventoryName+"'></input>"+inventoryName+"</td>"
    + "    <td> <input type='hidden' name='material' value='"+material+"'></input>"+material+"</td>"
    + "    <td> <input type='hidden' name='type' value='"+type+"'></input>"+type+"</td>"
    + "    <td> <input type='hidden' name='manifMetod' value='"+manifacturingMethod+"'></input>"+manifacturingMethod+"</td>"
    + "    <td> <input type='hidden' name='classOrGrade' value='"+classOrGrade+"'></input>"+classOrGrade+"</td>"
    + "    <td> <input type='hidden' name='ends' value='"+ends+"'></input>"+ends+"</td>"
    + "    <td> <input type='hidden' name='size' value='"+size+"'></input>"+size+"</td>"
    + "	   <td><input class='form-control' style='width:60px;' type='text' name='quantity' value=''></input></td>"
    + "	   <td><input class='form-control' style='width:60px;' type='text' onchange='updateSupplyRate($(this));' name='baseSupplyRate' value=''></input></td>"
    + "	   <td><input class='form-control' style='width:60px;' type='text' onchange='updateSupplyRate($(this));' name='supplyRate' value=''></input></td>"
    + "	   <td><input class='form-control' style='width:60px;' type='text' onchange='updateErectionRate($(this));' name='baseErectionRate' value=''></input></td>"
    + "	   <td><input class='form-control' style='width:60px;' type='text' onchange='updateErectionRate($(this));' name='erectionRate' value=''></input></td>"
    + "	   <td><input class='form-control' style='width:60px;' type='text' name='supplyAmount' value=''></input></td>"
    + "	   <td><input class='form-control' style='width:60px;' type='text' name='erectionAmount' value=''></input></td>";

    console.log(template);
    $('.inventoryDetails').css("display","block");          	

    var sheet = $('.nav-link.active.show').attr('href').substring(1);

    if($('#'+sheet).find('tbody#tableContentDetails.inventry').length>0)
    {
     $('#'+sheet).find('tbody#tableContentDetails.inventry').last().after(template);
   }
   else if($('#'+sheet).find('tbody#tableContentDetails.accessoryTr').length>0)
   {
     $('#'+sheet).find('tbody#tableContentDetails.accessoryTr').first().before(template);
   }
   else
   {
     $('#'+sheet).find('tbody#tableContentDetails').append(template);
   }         	
 }

</script>

<script>
  function appendAccessory() 
  {

    $('.generateBOQButton').css('display','block');
    $('.inventoryTableHeader').css('display','block');

    var accessoryName = $('#accessoryName').val();
    var desc1         = $('#desc1').val();
    var desc2         = $('#desc2').val();
    var desc3         = $('#desc3').val();
    var desc4         = $('#desc4').val();
    var desc5         = $('#desc5').val();

    console.log(type);

    var template = "<tr class='accessoryTr'>" 
    + "     <td></td>"
    + "    <td> <input type='hidden' name='inventoryName' value='"+accessoryName+"'></input>"+accessoryName+"</td>"
    + "    <td> <input type='hidden' name='material' value='"+desc1+"'></input>"+desc1+"</td>"
    + "    <td> <input type='hidden' name='type' value='"+desc2+"'></input>"+desc2+"</td>"
    + "    <td> <input type='hidden' name='ends' value='"+desc3+"'></input>"+desc3+"</td>"
    + "    <td> <input type='hidden' name='classOrGrade' value='"+desc4+"'></input>"+desc4+"</td>"
    + "    <td> <input type='hidden' name='manifMetod' value='"+desc5+"'></input>"+desc5+"</td>"
    + "    <td> <input type='hidden' name='size' value='-'></input>-</td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='quantity' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='baseSupplyRate' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='supplyRate' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='baseErectionRate' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='erectionRate' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='supplyAmount' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='erectionAmount' value=''></input></td>";

    console.log(template);
    $('.inventoryDetails').css("display","block");

    var sheet = $('.nav-link.active.show').attr('href').substring(1);

    if($('#'+sheet).find('tbody#tableContentDetails.inventry').length>0)
    {
     $('#'+sheet).find('tbody#tableContentDetails.inventry').last().after(template);
   }
   else if($('#'+sheet).find('tbody#tableContentDetails.accessoryTr').length>0)
   {
     $('#'+sheet).find('tbody#tableContentDetails.accessoryTr').first().before(template);
   }
   else
   {
     $('#'+sheet).find('tbody#tableContentDetails').append(template);
   }  
 }
</script>

<script>
  function appendValve() 
  {

    $('.generateBOQButton').css('display','block');
    $('.inventoryTableHeader').css('display','block');

    var model         = $('#model').val();
    var material        = $('#materialVal').val();
    var end           = $('#endVal').val();
    var type          = $('#typeVal').val();
    var pressureRatings   = $('#pressureRatingsVal').val();
    var maxInletPressure    = $('#maxInletPressureVal').val();
    var operations        = $('#operationsVal').val();     
    var seatAndSeals    = $('#seatAndSealsVal').val();     
    var valveSize       = $('#valveSize').val();    

    var template = "<tr class='accessoryTr'>" 
    + "     <td></td>"
    + "    <td> <input type='hidden' name='inventoryName' value='"+model+"'></input>"+model+"</td>"
    + "    <td> <input type='hidden' name='material' value='"+material+"'></input>"+material+"</td>"    
    + "    <td> <input type='hidden' name='type' value='"+type+"-"+operations+"-"+seatAndSeals+"'></input>"+type+"-"+operations+"-"+seatAndSeals+"</td>"
    + "    <td>-</td>"
    + "    <td> <input type='hidden' name='classOrGrade' value='"+pressureRatings+"-"+maxInletPressure+"'></input>"+pressureRatings+"-"+maxInletPressure+"</td>"
    + "    <td> <input type='hidden' name='ends' value='"+end+"'></input>"+end+"</td>"
    + "    <td> <input type='hidden' name='manifMetod' value=''> <input type='hidden' name='size' value='"+valveSize+"'></input>"+valveSize+"</td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='quantity' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='baseSupplyRate' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='supplyRate' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='baseErectionRate' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='erectionRate' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='supplyAmount' value=''></input></td>"
    + "    <td> <input class='form-control' style='width:60px;' type='text' name='erectionAmount' value=''></input></td>";

    console.log(template);
    $('.inventoryDetails').css("display","block");


    var sheet = $('.nav-link.active.show').attr('href').substring(1);

    if($('#'+sheet).find('tbody#tableContentDetails.inventry').length>0)
    {
     $('#'+sheet).find('tbody#tableContentDetails.inventry').last().after(template);
   }
   else if($('#'+sheet).find('tbody#tableContentDetails.accessoryTr').length>0)
   {
     $('#'+sheet).find('tbody#tableContentDetails.accessoryTr').first().before(template);
   }
   else
   {
     $('#'+sheet).find('tbody#tableContentDetails').append(template);
   }  
 }
</script>

<script>

  function downloadInvoice( invoiceName )
  {
   window.location.assign("showInvoice?invoiceName="+invoiceName);
 }

 function downloadPO( poName )
 {
   window.location.assign("showPO?poName="+poName);
 }
</script>
<script>
  $(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
  });
</script>
<script>
  function toggleProjSec()
  {
   $('.projDetails').toggle();
 }

 function togglePayDetailsSec()
 {
   $('#payDetailsSection').toggle();
 }
</script>
<script>
  function updateVal(){
   var promptVal = prompt("Enter %","0%");
   console.log(promptVal);
 }
</script>
<script type="text/javascript">
  $(function() {
    $('button[name=uploadFile]').click(function(e) {
      e.preventDefault();
      showLoading();
    //Disable submit button
    $(this).prop('disabled',true);
    $('.inventoryTableHeader').css('display','block');
    var form = document.forms[name="fileUploadForm"];
    
    var formData = new FormData(form);

    console.log(formData);	
    // Ajax call for file uploaling
    var ajaxReq = $.ajax({
      url : 'import',
      type : 'POST',
      data : formData,
      cache : false,
      contentType : false,
      processData : false,
      
      success: function(data) 
      {
       $('#tableContentDetails').html(data);
       
       toggleCreateBOQSec();
       adjustWidth();

       var imp = document.getElementById("importBoq");
	        //imp.style.display = "none";
	        
	        var generate = document.getElementById("generate");
	        generate.style.display = "block";
	        
	        var generateInq = document.getElementById("generateQuot");
	        generateInq.style.display = "block";
	        
	        $('[name="client"]')[0].value  	= $('#iDclient')[0].value; 	
         $('[name="site"]')[0].value 	= $('#iDsite')[0].value; 		
         $('[name="project"]')[0].value 	= $('#iDproject')[0].value; 	
         $('[name="dName"]')[0].value 	= $('#iDdName')[0].value; 		
         $('[name="utility"]')[0].value 	= $('#iDutility')[0].value; 	
         $('[name="pressure"]')[0].value	= $('#iDpressure')[0].value; 	
         $('[name="temperature"]')[0].value 	= $('#iDtemp')[0].value; 		
         $('[name="dNo"]')[0].value 		= $('#iDdNo')[0].value;

         $('#LoadingImage').hide();
       }
     });

    // Called on success of file upload
    ajaxReq.done(function(msg) {
      $('input[type=file]').val('');
      $('button[type=submit]').prop('disabled',false);
    });
    
    // Called on failure of file upload
    ajaxReq.fail(function(jqXHR) {
      $('button[type=submit]').prop('disabled',false);
    });
    
    $(this).prop('disabled',false);
  });
  });
  hideLoading();
</script>
<script>
  $('.statusTo').on('click',function() {

   showLoading();


   var quantity 		= $(this.form.elements)[0].value;
   var inventoryStr    = $(this.form.elements)[2].value;
   var materialStr		= $(this.form.elements)[3].value;
   var typeStr			= $(this.form.elements)[4].value;
   var manifMethodStr	= $(this.form.elements)[5].value;
   var gradeOrClassStr = $(this.form.elements)[6].value;
   var endsStr			= $(this.form.elements)[7].value;
   var sizeStr			= $(this.form.elements)[8].value + '"';
   var purchaseRateStr = $(this.form.elements)[9].value;
   var projectStr		= $(this.form.elements)[10].value;
   var locationStr		= $(this.form.elements)[11].value;
   var projectId		= $(this.form.elements)[13].value;
   var projectName		= $(this.form.elements)[14].value;
   var projectDesc		= $(this.form.elements)[15].value;
   var statusTo		= $(this).val();

   if(statusTo !== '')
   {
    $.ajax({
     url: "release",
     data: { 'inventoryStr' : 	inventoryStr,
     'materialStr' : 	materialStr,		
     'typeStr' : 		typeStr,			
     'manifMethodStr' : 	manifMethodStr,	
     'gradeOrClassStr' : gradeOrClassStr, 
     'endsStr' : 		endsStr,			
     'sizeStr' : 		sizeStr,			
     'purchaseRateStr' : purchaseRateStr, 
     'projectStr' : 		projectStr,		
     'locationStr' : 	locationStr,
     'quantity'	 : 		quantity,		
     'projectId' : 		projectId,		
     'projectName' : 	projectName,		
     'projectDesc' : 	projectDesc,
     'statusTo' : 		statusTo},
     type: 'post',
     success: function(data) {
      console.log(data);
      $('#LoadingImage').hide();

    }
  });
  }	

  hideLoading();
});
</script>
<script>
  $('.accessoryStatusTo').on('change',function() {

    showLoading();


    var quantity			= $(this.form.elements)[0].value;
    var accessoryStatusTo	= $(this.form.elements)[1].value;
    var desc1 				= $(this.form.elements)[2].value;
    var desc2    			= $(this.form.elements)[3].value;
    var desc3				= $(this.form.elements)[4].value;
    var desc4				= $(this.form.elements)[5].value;
    var desc5				= $(this.form.elements)[6].value;
    var accessoryName 		= $(this.form.elements)[7].value;	
    var project 			= $(this.form.elements)[8].value;	
    var locationStr			= $(this.form.elements)[9].value;	
    var projectId			= $(this.form.elements)[10].value;
    var projectName			= $(this.form.elements)[11].value;
    var projectDesc			= $(this.form.elements)[12].value;

    if(accessoryStatusTo !== '')
    {
      $.ajax({
       url: "releaseAccessory",
       data: { 'quantity' 			: quantity,
       'accessoryStatusTo' : accessoryStatusTo,
       'desc1' 			: desc1,
       'desc2' 			: desc2,
       'desc3' 			: desc3,
       'desc4' 			: desc4,
       'desc5' 			: desc5,
       'accessoryName' 	: accessoryName,
       'project' 			: project,
       'locationStr' 		: locationStr,
       'projectId' 		: projectId,
       'projectName' 		: projectName,
       'projectDesc' 		: projectDesc},
       type: 'post',
       success: function(data) {
        console.log(data);
        $('#LoadingImage').hide();

      }
    });
    }	
    hideLoading();
  });
</script>
<script type="text/javascript">
  function addPayDetails()
  {
    showLoading();
    var taxInvoiceNumber = $('[name="taxInvoiceNumber"]').children("option:selected").val();
    var receivedAmount = $('[name="receivedAmount"]')[0].value;
    var paymentMode = $('[name="paymentMode"]')[0].value;
    var projectId = $('[name="projectId"]')[0].value;

    if(taxInvoiceNumber==="" || receivedAmount==="" || paymentMode==="")
    {
      alert('Please add all the details and try Again..!!');
      return;
    }

    var paymentDetailsLine = '';

    $.ajax({
     url: "updatePaymentDetails",
     data: {'taxInvoiceNumber' : taxInvoiceNumber, 
     'receivedAmount' : receivedAmount, 
     'paymentMode' : paymentMode, 
     'projectId' : projectId},
     type: 'post',
     success: function(totalAmount) {

      if(totalAmount!=='Failure')
      {
        var fullDate = new Date();
        var twoDigitMonth = fullDate.getMonth()+"";if(twoDigitMonth.length==1)  twoDigitMonth="0" +twoDigitMonth;
        var twoDigitDate = fullDate.getDate()+"";if(twoDigitDate.length==1) twoDigitDate="0" +twoDigitDate;
        var currentDate = twoDigitDate + "/" + twoDigitMonth + "/" + fullDate.getFullYear();

        var amountPrnding = parseFloat(totalAmount) - parseFloat(receivedAmount); 
        $('#paymentDetailsBody').append('<tr><th>-</th><th>'+taxInvoiceNumber+'</th><th>'+totalAmount+'</th><th>'+receivedAmount+'</th><th>'+amountPrnding+'</th><th>'+paymentMode+'</th><th>'+currentDate+'</th></tr>');
      }

    }
  });
    hideLoading();
  }
</script>
<script>
  function getValveDetails(nextTagName) {

   showLoading();
   var tag = '#'+nextTagName;
   var model = $('#model')[0].value;

   console.log("nextTagName is : "+ nextTagName);

   $.ajax({
     type : 'POST',
     data :  {'nextTagName' : nextTagName, 'model' : model},
     url : 'getValveDetails',
     success : function(data) {
      var blank = "<option> </option> <option value='-'>-</option>";
      $(tag+'Val').html(blank);
      $(tag+'Val').append(data);
      $('#LoadingImage').hide();
    }
  });
   hideLoading();
 }
</script>
<script type="text/javascript">
  $(function() {
    $('button[name=generateBOQButton]').click(function(e) {
      e.preventDefault();

      if($('[name="sheetDetails"]').length===0)
      {
        alert('Please add atleast 1 sheet with Inventory Details and try again..!!');
        return;
      }

      var ele1 = $('[name="quantity"]');
      var length = $('#tableContentDetails').find(ele1).length;
      var stopNow = false;

      var sheetCount = $('[name="sheetDetails"]');
      
      try
      {
        for(var i=0;i<sheetCount.length;i++)
        {
          var eleLength = 0;


          eleLength = $('#'+sheetCount[i].value).find('tbody#tableContentDetails').find('input[name="inventoryName"]').length;

          if(eleLength===0)
          {
            alert('Please remove the blank sheet and try again..!!');
            return;
          }

          $('#'+sheetCount[i].value).find('tbody#tableContentDetails').find('input[name="sheetDetails"]').attr('value',sheetCount[i].value.split(',')[0]+','+eleLength);
        }
      }
      catch(e)
      {
        console.log(e);
      }

      for(var i=0; i < length; i++)
      {
        if($('#tableContentDetails').find(ele1)[i].value === "")
        {
          alert('Please enter Quantity for each element in BOQ');
          stopNow = true; 
          break;
        }
      }
      try{
        if(!stopNow)
        {
          $('[name="generateBOQ"]').validate();
          $('[name="generateBOQ"]').submit();
        }
      }
      catch(err)
      {
        console.log('Error occured while generating BOQ : '+err);
      }

      var boqList = $('.revisionSection')[0].options; 

      var revisionNo = 1;
      for(var k = 0; k < boqList.length; k++)
      {
        if(boqList[k].value.startsWith($('[name="boqName"]').val()))
        {
          revisionNo ++;
          var optionVal = boqList[k].value;
          console.log(optionVal);        
        }

      }

      console.log('revisionNo is : '+revisionNo);

      var boqNameToAppend = '<option value="'+ $('[name="boqName"]').val() +'_R'+revisionNo+'">'+$('[name="boqName"]').val()+'_R'+revisionNo+'</option>';

      console.log("boqNameToAppend is : "+boqNameToAppend);

      $('.revisionSection').append(boqNameToAppend);

    });
  });
</script>
<script>
  function downloadInquiry(docType)
  {
    var fileToDownloadName = '';
    if(docType==='inquiry')
    {
      if($('.offerRevisionSection option:selected').val()==='')
      {
        alert('Please select the Inquiry to download');
        return;
      }
      fileToDownloadName = $('.offerRevisionSection option:selected').val();
    }
    else if(docType==='boq')
    {
      if($('#boqName')[0].value==='')
      {
        alert('Please select the BOQ to download');
        return;
      }
      fileToDownloadName = $('#boqName')[0].value;
    }

    var newForm = jQuery('<form>', {
      'action': 'download',
      'method': 'POST'
    }).append(jQuery('<input>', {
      'name': 'projectId',
      'value': $('[name="projectId"]')[0].value,
      'type': 'hidden'
    })).append(jQuery('<input>', {
      'name': 'docNameToDownload',
      'value': fileToDownloadName,
      'type': 'hidden'
    }));
    $(document.body).append(newForm);
    newForm.submit();
  }
</script>

<script type="text/javascript">
  function deleteRevision(docType)
  {
    var fileToDownloadName = '';
    if(docType==='inquiry')
    {
      if($('.offerRevisionSection option:selected').val()==='')
      {
        alert('Please select the Inquiry to delete');
        return;
      }

      fileToDownloadName = $('.offerRevisionSection option:selected').val();
    }
    else if(docType==='boq')
    {
      if($('#boqName')[0].value==='')
      {
        alert('Please select the BOQ to delete');
        return;
      }

      fileToDownloadName = $('#boqName')[0].value;
    }

    var newForm = jQuery('<form>', {
      'action': 'delete',
      'method': 'POST'
    }).append(jQuery('<input>', {
      'name': 'projectId',
      'value': $('[name="projectId"]')[0].value,
      'type': 'hidden'
    })).append(jQuery('<input>', {
      'name': 'docNameToDownload',
      'value': fileToDownloadName,
      'type': 'hidden'
    }));
    $(document.body).append(newForm);
    newForm.submit();
  }
</script>


<script type="text/javascript">

  function generateInvoice() 
  {

    showLoading();

    var CheckeleCount = $('#generateInvoiceTable input.checkbox').length;

    var selectedElements = [];
    var i;

    for(i=0; i < CheckeleCount; i++)
    {
      if($('#generateInvoiceTable input.checkbox')[i].checked)
      {
       selectedElements[i] = i;
     }
   }

   if(selectedElements.length === 0)
   {
    alert('Please select an element to generate the Invoice');
    return; 
  }

  var eleCount = $('#generateInvoiceTable input').length;

  var inventoryName        = [];
  var material             = [];
  var type                 = [];
  var manifacturingMethod  = [];
  var classOrGrade         = [];
  var ends                 = [];
  var size                 = [];
  var purchaseRate       = [];
  var receivedQuantity     = [];
  var location         = [];
  var receivedDate         = [];

  var contactName          = $('[name="contactName"]')[0].value;
  var mobileNo           = $('[name="mobileNo"]')[0].value;
  var addressedto1         = $('[name="addressedto1"]')[0].value;
  var orderDate          = $('[name="orderDate"]')[0].value;
  var emailAddress       = $('[name="emailAddress"]')[0].value;
  var invoiceType        = $('[name="invoiceType"]')[0].value;
  var hsnOrSac         = $('[name="hsnOrSac"]')[0].value;

  var j;
  var k = 0;
  var n = 1;
  for(k=0;k<selectedElements.length;k++)
  {

   if(selectedElements[k] != undefined)
   {
    var start = 1 + 14*parseFloat(selectedElements[k]);

    inventoryName[k]      = $('#generateInvoiceTable input')[start++].value;
    material[k]       = $('#generateInvoiceTable input')[start++].value;
    type[k]         = $('#generateInvoiceTable input')[start++].value;
    manifacturingMethod[k]  = $('#generateInvoiceTable input')[start++].value;
    classOrGrade[k]     = $('#generateInvoiceTable input')[start++].value;
    ends[k]         = $('#generateInvoiceTable input')[start++].value;
    size[k]         = $('#generateInvoiceTable input')[start++].value;
    purchaseRate[k]     = $('#generateInvoiceTable input')[start++].value;                    
    receivedQuantity[k]   = $('#generateInvoiceTable input')[start++].value;
    start++;     
    location[k]       = $('#generateInvoiceTable input')[start++].value;
    receivedDate[k]     = $('#generateInvoiceTable input')[start++].value;

  } 
}

var lastArray = 3 + 20*parseFloat(selectedElements[parseFloat(selectedElements.length) - 1]);


var formData = $(this).serializeArray();

formData.push({name: 'projectId', value: $('[name="projectId"]').val()});

var inventoryName_string = cleanArray(inventoryName);
formData.push({name: 'inventoryName', value: inventoryName_string});
var material_string = cleanArray(material);
formData.push({name: 'material', value: material_string});
var type_string = cleanArray(type);
formData.push({name: 'type', value: type_string});
var manifacturingMethod_string = cleanArray(manifacturingMethod);
formData.push({name: 'manifMetod', value: manifacturingMethod_string});
var classOrGrade_string = cleanArray(classOrGrade);
formData.push({name: 'classOrGrade', value: classOrGrade_string});
var ends_string = cleanArray(ends);
formData.push({name: 'ends', value: ends_string});
var size_string = cleanArray(size);
formData.push({name: 'size', value: size_string});
var purchaseRate_string = cleanArray(purchaseRate);
formData.push({name: 'purchaseRate', value: purchaseRate_string});
var receivedQuantity_string = cleanArray(receivedQuantity);
formData.push({name: 'receivedQuantity', value: receivedQuantity_string});
var location_string = cleanArray(location);
formData.push({name: 'location', value: location_string});
var receivedDate_string = cleanArray(receivedDate);
formData.push({name: 'receivedDate', value: receivedDate_string});

formData.push({name: 'contactName', value: contactName});
formData.push({name: 'mobileNo', value: mobileNo});
formData.push({name: 'addressedto1', value: addressedto1});
formData.push({name: 'orderDate', value: orderDate});
formData.push({name: 'emailAddress', value: emailAddress});
formData.push({name: 'invoiceType', value: invoiceType});
formData.push({name: 'hsnOrSac', value: hsnOrSac});

$.ajax({
 url: "generateInvoice",
 data: formData,
 type: 'post',
 success: function(data)
 {

  var CheckeleCount1 = $('#generateInvoiceTable input.checkbox').length;

  var selectedElements1 = [];
  var j;

  for(j=0; j < CheckeleCount1; j++)
  {
    if($('#generateInvoiceTable input.checkbox')[j].checked)
    {
     selectedElements1[j] = j;
   }
 }

 var deleted = 0;
 for(var d=0;d<selectedElements1.length;d++)
 {
   if(selectedElements1[d] != undefined)
   {
    $('#generateInvoiceTable tr')[d-deleted].remove();
    deleted++;
  }
}

}
});
hideLoading();
}

function cleanArray(actual)
{
  var newArray = new Array();
  for(var i = 0; i<actual.length; i++)
  {
    if (actual[i])
    {
      newArray.push(actual[i]);
    }
  }
  return newArray;
}
</script>
<script type="text/javascript">
  $('#generateInvoiceFrNInv').on('click', function(){

    showLoading();

    $.ajax({
     type : 'POST',
     data :  {'projectId' : $('[name="projectId"]')[0].value},
     url : 'getNoInvoiceInventory',
     success : function(data) 
     {
      $('#generateInvoiceTable').html('');
      $('#generateInvoiceTable').append(data);
    }
  });

    hideLoading();

  });
</script>
<script>
  function addNewSheet()
  {
    if($('[name="newSheetName"]').val()==="")
    {
      alert('Please add a Sheet name..!!');
      return;
    }
    var sheetName = $('[name="newSheetName"]').val();
    var tab = '<li class="nav-item"><a class="nav-link '+sheetName+'" href="#'+sheetName+'" role="tab" data-toggle="tab" aria-selected="true">'+sheetName+'<i class="fa fa-times pr-2" onClick="removeSheet('+sheetName+');" style="margin-left:5px;"></i></a></li>';

    $('#sheetListtableContentDetails').append(tab);

    var tabPane = '<div class="tab-pane fade" id="'+sheetName+'" role="tabpanel"><div class="row" style="margin-top:2%;">     <div class="col-md-12 ">       <div class="table-responsive">                        <table class="table table-colored inventoryDetails inventoryTableHeader" style="display: none;">         <thead>           <tr>            <th>#</th>            <th>Invnt</th>            <th>Material</th>            <th>Type</th>            <th>Method</th>            <th>Grd/Cls</th>            <th>Ends</th>            <th>Size</th>            <th>Qty</th>            <th>Base Supply Rate</th>            <th>Supply Rate</th>            <th>Base Erection Rate</th>            <th>Erection Rate</th>            <th>Supply Amount</th>            <th>Erection Amount</th>          </tr>          <tr>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th></th>            <th><input type="text" style="width:45px;" name="supplyPrsnt" onChange="updateSupplyRate($(this));"/></th>            <th></th>            <th><input type="text" style="width:45px;" name="erectionPrsnt" onChange="updateErectionRate($(this));"/></th>            <th></th>            <th></th>            <th></th>          </tr>        </thead>        <tbody id="tableContentDetails">        </tbody>      </table>    </div>  </div></div></div>';

    $($('.tab-content')[0]).append(tabPane); 

    $('#'+sheetName).find('tbody#tableContentDetails').append('<input type="hidden" name="sheetDetails" id="sd'+sheetName+'" value="'+sheetName+'">');  

  }
</script>
<script type="text/javascript">
  function removeSheet(sheetName)
  {
   console.log(sheetName);
   var name = sheetName.attributes.id.value;
   $('.'+name).remove();
   /*$('#'+name).remove();*/
 }
</script>
<script type="text/javascript">
  $(document).ready(function(){

    var vList = $('[name="venderList"]').val().split(',');
    for(var i = 0; i < vList.length ; i++)
    {
     var venderName = vList[i];

     if(venderName != "")
      $("[name='selectedVenderName']").append("<option value=" + venderName + ">" + venderName + "</option>");
  }

});
</script>
<script type="text/javascript">  
  $(function() {

    //BOQ Secsion  
    $('#createProjectModal1').on('hidden.bs.modal', function () {
      $($($('[name="generateBOQ"]')[0]).find('[name="sheetDetails"]')[0]).remove();
      $($('#sheetListtableContentDetails')[0]).html('');
      $('#tableContentDetails').html('');
    });

    //Inquiry Section
    $('#createProjectModal2').on('hidden.bs.modal', function () {
      $($($('[name="generateBOQ"]')[0]).find('[name="sheetDetails"]')[0]).remove();
      $($('#sheetListtableContentInqSec')[0]).html('');
      $('#tableContentInqSec').html('');
    });

    //PO section
    $('#createProjectModal3').on('hidden.bs.modal', function () {
      $($($('[name="generateBOQ"]')[0]).find('[name="sheetDetails"]')[0]).remove();
      $($('#sheetListtableContentPOSec')[0]).html('');
      $('#tableContentPOSec').html('');
    });
  });
</script>
<script type="text/javascript">
  function closeOther(modalToShow)
  {
    if(modalToShow!=="payDetails")
      $('#payDetails').attr('class','border border-info collapse');
    
    if(modalToShow!=="createProjectModal5")
      $('#createProjectModal5').attr('class','border border-info collapse');
    
    if(modalToShow!=="generateInvoice")
      $('#generateInvoice').attr('class','border border-info collapse');
  }
</script>
</body>
</html>