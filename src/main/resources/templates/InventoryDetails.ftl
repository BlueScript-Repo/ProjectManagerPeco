<!DOCTYPE html>
<html dir="ltr" lang="zxx">

<head>
  <meta charset="utf-8">
  <title>Inventory Details</title>
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
<body >
  <div class="scrollToTop circle"><i class="fa fa-angle-up"></i></div>
  <div class="page-wrapper">

    <#include "./header.ftl">
  </div>
  <section class="main-container">
    <div class="row ml-5">
     <div class="col-md-12">
      <ul class="nav nav-tabs style-1" role="tablist">
        <li class="nav-item">
          <a class="nav-link active" href="#htab1" role="tab" data-toggle="tab"><i class="fa fa-user pr-2"></i>Mapping</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#htab2" role="tab" data-toggle="tab"><i class="fa fa-user pr-2"></i>Valves</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#htab3" role="tab" data-toggle="tab"><i class="fa fa-user pr-2"></i>Taxes</a>
        </li>
      </ul>
      <div class="tab-content">
        <div class="tab-pane fade show active" id="htab1" role="tabpanel">                  
          <div class="row">
            <div class="col-md-12">
              <table id="tblMappingDetails" class="table table-striped table-colored table-responsive">
               <thead>
                <tr>
                	<th>#</th>
                	<th></th>
                	<th>Inventory Name</th>
                	<th>Material</th>
                	<th>Type</th>
                	<th>Class Or Grade</th>
                	<th>Category</th>
                </tr>
              </thead>
              <form id="updateMappingDetails" action="updateMappingDetails" method="POST">
                <tbody>
                 ${mappingDetails}

               </tbody> 
             </table> 
             <input id="addMappingBtn" type="button" class="btn btn-primary mt-5" value="+" onclick="addRow('tblMappingDetails');change()">
             <input id="updateMappingBtn" type="submit" class="btn btn-primary mt-5" value="Update">
           </form>

         </div>
       </div>
     </div>
     <div class="tab-pane fade" id="htab2" role="tabpanel">                  
      <div class="row">
        <div class="col-md-12">
          <table class="table table-striped table-colored table-responsive" id="tblValvesDetails">
           <thead>
            <tr>
             <th>#</th>
             <th></th>
             <th>Model</th>
             <th>Material</th>
             <th>End</th>
             <th>Type</th>
             <th>Pressure Ratings</th>
             <th>Max Inlet Pressure</th>
             <th>Operations</th>
             <th>Seat And Seals</th>
             <th>Valve Size</th>
           </tr>
         </thead>
         <form id="updateValvesDetails" action="updateValvesDetails" method="POST">
           <tbody>
             ${valvesDetails}
           </tbody> 
         </table> 
         <input id="addValvesBtn" type="button" class="btn btn-primary mt-5" value="+" onclick="addRowInValve('tblValvesDetails');changeUpdateValvebtn()">
         <input id="updateValvesBtn" type="submit" class="btn btn-primary mt-5" value="Update">
       </form>
     </div>
   </div>
 </div>

 <div class="tab-pane fade " id="htab3" role="tabpanel">                  
  <div class="row">
    <div class="col-md-12">

     <form id="updateTaxesDetails" action="updateTaxesDetails" method="POST">
      ${taxesDetails}
       <input id="updateTaxesBtn" type="submit" class="btn btn-primary mt-5" value="Update">
     </form>

   </div>
 </div>
</div>
</div>	  		
</div>
</div>
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

<script src="plugins/lazy/jquery.lazy.min.js"></script>
<script src="plugins/lazy/jquery.lazy.plugins.min.js"></script>

<script type="text/javascript">

  var lbNewMapp = false;
  $('#updateMappingBtn').on('click', function(e){

   var dataArrayToSend = [];


   $('#tblMappingDetails input:checkbox:checked').each(function() {

    if(lbNewMapp)
    {
      row = $(this).closest("tr");

      var InventoryLength = $(row).find("input[name=inventoryName]").val().length;
      var MaterialLength =$(row).find("input[name=material]").val().length;
      if(InventoryLength == 0 && MaterialLength == 0 || InventoryLength == 0 || MaterialLength == 0 )
      {
       alert("Please enter Inventory name and Material");
       return;

     }
   }

   row = $(this).closest("tr");
   dataArrayToSend.push({ 
    item_id : $(row).find("input[name=ItemId]").val(),
    inventoryName  : $(row).find("input[name=inventoryName]").val(),
    material     : $(row).find("input[name=material]").val(),
    type     : $(row).find("input[name=type]").val(),
    classOrGrade     : $(row).find("input[name=classOrGrade]").val(),
    catogory     : $(row).find("input[name=catogory]").val()       
  });


 });
    //alert( JSON.stringify(values));
    e.preventDefault(); 

    if(dataArrayToSend.length > 0)
    {
     var ajaxReq = $.ajax({
       url : 'updateMappingDetails',
       type : 'POST',
       data : JSON.stringify(dataArrayToSend),
       dataType: "json",
       contentType: "application/json; charset=utf-8",
   // data : $('#updateMappingDetails').clone(true,true).serialize(),
   success: function(data) 
   {
    alert("Updated Successfully..!!");
    console.log(" Received data from BE");
    console.log(data); 
    window.location.reload();             
  }
});
   }

 });



  function change(){

    var btn = document.getElementById("updateMappingBtn");
    if(btn.value === "Update")
      btn.value = "Add";
    lbNewMapp = true;
  }


  function addRow(tableID) {


   var table = document.getElementById(tableID);

   var rowCount = table.rows.length;
   var row = table.insertRow(rowCount);

   var cell1 = row.insertCell(0);
   var element1 = document.createElement("input");
   element1.value = rowCount + 1;
   element1.type = "text";
   element1.class = "form-control";
   element1.name = "ItemId";
   element1.style = "width:50px";
   element1.style.height = "40px";
   cell1.appendChild(element1);

   var cell2 = row.insertCell(1);
   var element2 = document.createElement("input");
   element2.type = "checkbox";
   element2.class="chkView";
   element2.checked="true";
   cell2.appendChild(element2);


   var cell3 = row.insertCell(2);
   var element3 = document.createElement("input");
   element3.style.width = "103px";
   element3.style.height = "40px";
   element3.type = "text";
   element3.class = "form-control";
   element3.name = "inventoryName";
   cell3.appendChild(element3);

   var cell4 = row.insertCell(3);
   var element4 = document.createElement("input");
   element4.style.width = "103px";
   element4.style.height = "40px";
   element4.type = "text";
   element4.class = "form-control";
   element4.name = "material";
   cell4.appendChild(element4);

   var cell5 = row.insertCell(4);
   var element5 = document.createElement("input");
   element5.style.width = "103px";
   element5.style.height = "40px";
   element5.type = "text";
   element5.name = "type";
   element5.class = "form-control";
   cell5.appendChild(element5);

   var cell6 = row.insertCell(5);
   var element6 = document.createElement("input");
   element6.style.width = "103px";
   element6.style.height = "40px";
   element6.type = "text";
   element6.class = "form-control";
   element6.name = "classOrGrade";
   element6.value = "";
   cell6.appendChild(element6);

   var cell7 = row.insertCell(6);
   var element7 = document.createElement("input");
   element7.style.width = "103px";
   element7.style.height = "40px";
   element7.type = "text";
   element7.class = "form-control";
   element7.name = "catogory";
   element7.value = "";
   cell7.appendChild(element7);

 } 

</script>

<script type="text/javascript">

  var lbNewValve = false;

  $('#updateValvesBtn').on('click', function(e){

    var dataArrayToSendContoller = [];


    $('#tblValvesDetails input:checkbox:checked').each(function() {
    //for each checked checkbox

    if(lbNewValve)
    {
      row = $(this).closest("tr");

      var ModelLength = $(row).find("input[name=model]").val().length;
      if(ModelLength == 0)
      {
       alert("Please enter model");
       return;

     }
   }


   row = $(this).closest("tr");
   dataArrayToSendContoller.push({ 
    item_id 		: $(row).find("input[name=ItemId]").val(),
    model  			: $(row).find("input[name=model]").val(),
    material     	: $(row).find("input[name=material]").val(),
    end     		: $(row).find("input[name=end]").val(),
    type    	    : $(row).find("input[name=type]").val(),
    pressureRatings : $(row).find("input[name=pressureRatings]").val(),
    maxInletPressure: $(row).find("input[name=maxInletPressure]").val(),  
    operation     	: $(row).find("input[name=operation]").val(),
    seatAndSeals    : $(row).find("input[name=seatAndSeals]").val(),
    sizeRange     	: $(row).find("input[name=sizeRange]").val()				
  });


 });


    e.preventDefault(); 
    if(dataArrayToSendContoller.length > 0)
    {
     var ajaxReq = $.ajax({
       url : 'updateValvesDetails',
       type : 'POST',
       data : JSON.stringify(dataArrayToSendContoller),
       dataType: "json",
       contentType: "application/json; charset=utf-8",
   // data : $('#updateValvesDetails').clone(true,true).serialize(),
   success: function(data) 
   {
    alert("Updated Successfully..!!");
    console.log(" Received data from BE");
    console.log(data);  
    window.location.reload();                
  }
});
   }		

 });


  function changeUpdateValvebtn(){

    var btn = document.getElementById("updateValvesBtn");
    if(btn.value === "Update")
      btn.value = "Add";
    lbNewValve = true;
  }

  function addRowInValve(tableID) {


   var table = document.getElementById(tableID);

   var rowCount = table.rows.length;
   var row = table.insertRow(rowCount);

   var cell1 = row.insertCell(0);
   var element1 = document.createElement("input");
   element1.value = rowCount + 1;
   element1.type = "text";
   element1.class = "form-control";
   element1.name = "ItemId";
   element1.style = "width:50px";
   element1.style.height = "40px";
   cell1.appendChild(element1);

   var cell2 = row.insertCell(1);
   var element2 = document.createElement("input");
   element2.type = "checkbox";
   element2.class="chkView";
   element2.checked="true";
   cell2.appendChild(element2);


   var cell3 = row.insertCell(2);
   var element3 = document.createElement("input");
   element3.style.width = "59px";
   element3.style.height = "40px";
   element3.type = "text";
   element3.class = "form-control";
   element3.name = "model";
   cell3.appendChild(element3);

   var cell4 = row.insertCell(3);
   var element4 = document.createElement("input");
   element4.style.width = "59px";
   element4.style.height = "40px";
   element4.type = "text";
   element4.class = "form-control";
   element4.name = "material";
   cell4.appendChild(element4);

   var cell5 = row.insertCell(4);
   var element5 = document.createElement("input");
   element5.style.width = "59px";
   element5.style.height = "40px";
   element5.type = "text";
   element5.name = "end";
   element5.class = "form-control";
   cell5.appendChild(element5);

   var cell6 = row.insertCell(5);
   var element6 = document.createElement("input");
   element6.style.width = "59px";
   element6.style.height = "40px";
   element6.type = "text";
   element6.class = "form-control";
   element6.name = "type";
   element6.value = "";
   cell6.appendChild(element6);

   var cell7 = row.insertCell(6);
   var element7 = document.createElement("input");
   element7.style.width = "59px";
   element7.style.height = "40px";
   element7.type = "text";
   element7.class = "form-control";
   element7.name = "pressureRatings";
   element7.value = "";
   cell7.appendChild(element7);

   var cell8 = row.insertCell(7);
   var element8 = document.createElement("input");
   element8.style.width = "59px";
   element8.style.height = "40px";
   element8.type = "text";
   element8.class = "form-control";
   element8.name = "maxInletPressure";
   element8.value = "";
   cell8.appendChild(element8);

   var cell9 = row.insertCell(8);
   var element9 = document.createElement("input");
   element9.style.width = "59px";
   element9.style.height = "40px";
   element9.type = "text";
   element9.class = "form-control";
   element9.name = "operation";
   element9.value = "";
   cell9.appendChild(element9);

   var cell10 = row.insertCell(9);
   var element10 = document.createElement("input");
   element10.style.width = "59px";
   element10.style.height = "40px";
   element10.type = "text";
   element10.class = "form-control";
   element10.name = "seatAndSeals";
   element10.value = "";
   cell10.appendChild(element10);

   var cell11 = row.insertCell(10);
   var element11 = document.createElement("input");
   element11.style.width = "59px";
   element11.style.height = "40px";
   element11.type = "text";
   element11.class = "form-control";
   element11.name = "sizeRange";
   element11.value = "";
   cell11.appendChild(element11);


 } 

</script>

<script type="text/javascript">

  $('#tblMappingDetails').on('change', '.chkView[type=checkbox]', function(event) {

    let viewCheck = $(this);
    let isViewChecked = !!viewCheck.prop('checked');
    let isViewDisbled = !!viewCheck.prop('disabled');
    let rowChecks = viewCheck
    .closest('tr')
    .find(' input[name=type], input[name=classOrGrade], input[name=catogory]');
    viewCheck.filter(':checked').prop('checked', !isViewDisbled);
    rowChecks.prop('disabled', isViewDisbled || (!isViewChecked && !isViewDisbled));
    rowChecks.filter(function(index, checkbox) {
      return isViewDisbled || (!isViewChecked && $(checkbox).is(':checked'));
    })
    .prop('checked', false);
    rowChecks.filter(function(index, checkbox) {
      return isViewDisbled && $(checkbox).is(':checked');
    }).prop('checked', false);

  }).find('.chkView[type=checkbox]').filter(function(index, element) {
    return !!$(element).siblings('input[type=checkbox]');
  }).trigger('change'); 

</script>

<script>
  $('#updateTaxesBtn').on('click', function(e){

   e.preventDefault(); 

   var ajaxReq = $.ajax({
     url : 'updateTaxesDetails',
     type : 'POST',
     data : $('#updateTaxesDetails').serialize(),

     success: function(data) 
     {
      alert("Updated Successfully..!!");
      console.log(" Received data from BE");
      console.log(data);  
      location.reload(); 

    }
  });

 });
</script>
<script type="text/javascript">
 $(function() {
  $('.lazy').lazy();
});
</script>

</body>
</html>