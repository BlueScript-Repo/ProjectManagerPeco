h<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    
    <title>PECO Project</title>
    <meta name="description" content="The Project a Bootstrap-based, Responsive HTML5 Template">
    <meta name="author" content="author">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=PT+Serif" rel="stylesheet">
    <link href="css/custTooltip.css" rel="stylesheet">
    <link href="fonts/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="plugins/magnific-popup/magnific-popup.css" rel="stylesheet">
    <link href="css/animations.css" rel="stylesheet">
    <link href="plugins/slick/slick.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/typography-default.css" rel="stylesheet">
    <link href="css/skins/light_blue.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <script src="plugins/jquery.min.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/notification.css" rel="stylesheet">
    <link rel="stylesheet" href="css/materialdesignicons.min.css">
</head>
<body>
    <div class="page-wrapper" style="background-color: #eaeaea;">
        <#include "./header.ftl">
    <section class="main-container pt-0">
    <section class="light-gray-bg padding-bottom-clear clearfix" style="background-color:#eaeaea;">
    <div class="container pt-5" style="min-height: 380px;">
        <div class="content-wrapper">
          <div class="email-wrapper wrapper">
            <div class="row align-items-stretch">
       <div class="container bootstrap snippets bootdey">
                   <div class="row">
                       <div class="col-sm-3 col-md-2">
                           <div class="btn-group">
                               <span class="text-muted"><b>Notification</b></span>
                           </div>
                       </div>

                   </div>
                   <hr>
                   <div class="row">
                       <div class="col-sm-5 col-md-5">
                         <ul class="nav nav-tabs nav-justified">
                               <li class="nav-item">
                                   <a class="nav-link active"  href="#outbox" data-toggle="tab"><i class="fa fa-envelope" aria-hidden="true"></i>&nbsp; OutBox</a>
                               </li>

                               <li class="nav-item">
                                   <a class="nav-link"  href="#sent" data-toggle="tab"><i class="fa fa-paper-plane" aria-hidden="true"></i>&nbsp; Sent</a>
                               </li>
                         </ul>
                           <!-- Tab panes -->
                           <div class="tab-content">
                               <div class="tab-pane in active" id="outbox">
                                   <div class="list-group" style = "overflow-y: scroll; overflow-x: hidden; max-height: 600px;">
                                       ${notificationListInboxVal}
                                   </div>
                               </div>
                               <div class="tab-pane in fade" id="sent">
                                   <div class="list-group" style = "overflow-y: scroll; overflow-x: hidden; max-height: 600px;">
                                      ${notificationListSentVal}
                                   </div>
                               </div>

                           </div>

                       </div>
                       <div class="col-sm-7 col-md-7">
                                   <div class="card shadow-none mt-3 border border-light">

                                      <div id="viewOnLoad" style="visibility: visible;" class="card-body">
                                            <span  class="media-meta float-left">Please click on email for view.</span>
                                      </div>
                                      <div id="viewOnClick"  style="visibility: hidden;" class="card-body">
                                        <div class="media mb-3">
                                           <div class="media-body">
                                               <span id="datespan" class="media-meta float-right"></span>
                                               <h4 id="ReciverHeading" class="text-primary m-0"></h4>
                                               <small id="ReciverId" class="text-muted"></small>
                                             </div>
                                         </div> <!-- media -->

                                        <span>
                                        <textarea id="mailBody" name="body" class="form-control mailBody" rows="12"></textarea>
                                        </span>
                                         <hr>
                                         <h4> <i class="fa fa-paperclip mr-2"></i> Attachments</h4>
                                         <div class="row">
                                             <div class="col-sm-4 col-md-4">
                                                 <span id = "attachment">
                                                 <ul id="attachDoc" style="display:inline;">
                                                 </ul>
                                                 </span>
                                             </div>
                                         </div>
                                         <div class="text-right">
                                             <button type="button"  id="sendEmail" onclick= sendNotify(); class="btn btn-primary waves-effect waves-light mt-3"><i class="fa fa-send mr-1"></i> Send</button>
                                         </div>
                                     </div>
                                   </div> <!-- card -->
                       </div>
                   </div>
               </div>
    </div>
</div>
</div>
</div>
</section>
</section>
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




<script src="bootstrap/js/bootstrap.min.js"></script>

<script src="plugins/jquery.blockUI.js"></script>


<script>


 var emailObject = [recevier,subject,body,attachment,date,itemId];

  function sendNotify() {
                         var receiver = emailObject[0];
                         var subject = emailObject[1];
                         var body = emailObject[2];
                         var attach1 = emailObject[3];
                         var attach2 = "";
                         if(emailObject[3] !== undefined)
                         {
                           attach2 = emailObject[3];
                         }
                         var sentDate = emailObject[4];
                         var dbItemId = emailObject[5];

                         console.log('subject is : ' + subject);
                         console.log('attach1 is : '+attach1);
                         console.log('attach2 is : '+attach2);
                         console.log('body is : '+body);
                         console.log('receiver is : '+receiver);

                          showLoading();
                          $.ajax({
                               type : 'POST',
                               data :  {  'receiver' : receiver,
                                          'subject' : subject,
                                          'body' : body,
                                          'attachmentNames' : attach1 + "," +attach2,
                                          'id' : dbItemId,
                                          'dateValue': sentDate},
                               url : 'sendNotification',
                               success : function(data)
                                {
                                  alert("Notifcation sent success..!");
                                },
                                error : function(data)
                                {
                                  alert("Error sending Notifcation..!");
                                }
                          });
                          hideLoading();
                       }

    function ShowMailContent(mailBody)
    {

     var divMailBody = document.getElementById("viewOnClick");
     var divMailBodyOnLoad = document.getElementById("viewOnLoad");

     if(divMailBody.style.visibility === "hidden"){

        divMailBody.style.visibility = "visible";
        divMailBodyOnLoad.style.visibility = "hidden";
     }


     document.getElementById("attachDoc").innerHTML = "";
     document.getElementById("mailBody").innerHTML ="";
    document.getElementById("ReciverId").innerHTML ="";
    document.getElementById("datespan").innerHTML ="";
    var notifList = mailBody.split('|');

    if(notifList[5] === "SENT" )
    {
        document.getElementById("mailBody").disabled = true;
        document.getElementById("sendEmail").disabled = true;
        document.getElementById("sendEmail").style.visibility="hidden";
    }
    else
    {
        document.getElementById("mailBody").disabled = false;
        document.getElementById("sendEmail").disabled = false;
        document.getElementById("sendEmail").style.visibility="visible";
        emailObject =[notifList[1], notifList[4], notifList[0],notifList[3],notifList[2],notifList[5]];
     }
    document.getElementById("attachDoc").innerHTML = "";
    document.getElementById("mailBody").innerHTML =notifList[0];
    document.getElementById("ReciverId").innerHTML =notifList[1];
    document.getElementById("datespan").innerHTML =notifList[2];
    document.getElementById("ReciverHeading").innerHTML =notifList[4];

    var attachmentFile = notifList[3].split(';');
    if(attachmentFile.length > 0)
    {
    var i;
        for(i = 0; i < attachmentFile.length; i++)
        {
            var ul = document.getElementById("attachDoc");
            var li = document.createElement("li");
            var link = document.createElement("a");
            link.setAttribute('href', 'downloadAttachment?fileName='+attachmentFile[i]);
            li.appendChild(link);
            var text = document.createTextNode(attachmentFile[i]);
            link.appendChild(text);
            ul.insertBefore(li, ul.childNodes[i]);
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

</body>
</html>