<!DOCTYPE html>
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
        <div class="mail-sidebar d-none d-lg-block col-md-2 pt-3 bg-white border">
        <div class="menu-bar">
                  <ul class="menu-items">                    
                    <li class="font-weight-bold inboxItems" onclick="showItems('inboxItems');">Inbox</li>
                    <li class="font-weight-bold sentItems" onclick="showItems('sentItems');">Sent</li>
                </ul>
        </div>
        </div>
        <div class="mail-list-container col-md-3 border-right bg-white border pt-3">
        </div>
        <div class="mail-view d-none d-md-block col-md-9 col-lg-7 bg-white border pt-3">
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


<input type="hidden" id="notificationListInbox" name="notificationListInbox" value="${notificationListInboxVal}">
<input type="hidden" id="notificationListSent" name="notificationListSent" value="${notificationListSentVal}">

<script src="bootstrap/js/bootstrap.min.js"></script>

<script src="plugins/jquery.blockUI.js"></script>

<script>
$(document).ready(function(){
    populateItems('notificationListInbox');
    $('#item1').show();
    $('.mail-list-container')[0].style.height = $('.mail-view')[0].clientHeight+"px";
});

function populateItems(notificationListCode)
{
    $(".mail-list-container").html('');
    $(".mail-view").html('');

    class Notification 
    {
      constructor(userName, receiver, subject, body, attachmentNames, status, date) 
      {
        this.userName = userName;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
        this.attachmentNames = attachmentNames;
        this.status = status;
        this.date = date;
      }
    }

    var notifList = $('#'+notificationListCode)[0].value.split('[[[');

    var mailEntry =  '<div class="mail-list border" onclick="show(\'ITEM_NO\')">              <div class="content">                   <p class="message_text">SUBJECT</p>                 </div>             </div>';

    var mailBody = '<div class="message-body" id="ITEM_NO" style="display:none;">              <div class="sender-details bg-light">                <div class="details">                  <p class="msg-subject">                    <textarea name="subject" class="form-control mailSubject" rows="1" style="width:143%;"> SUBJECT </textarea>                </p> <p class="sender-email"> <span class="float-left">TO :  RECEIVER <input type="hidden" class="receiverAddr" name="receiverAddr" value="RECEIVER">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="mdi mdi-account-multiple-plus"></i></span> <span class="float-right"> DATEnTIME</span></p>           </div>        </div>        <div class="message-content"> <textarea name="body" class="form-control mailBody" rows="12">MAILBODY</textarea>                        <p><br><br>Regards,<br>SENDER</p>        </div>        <div class="attachments-sections">            <ul style="display:inline;">              <li>                  <a href="downloadAttachment?fileName=ATTACHMENT1" class="attach1">ATTACHMENT1 </a>              </li>              <li>                  <a href="downloadAttachment?fileName=ATTACHMENT2" class="attach2">ATTACHMENT2 </a>              </li>          </ul>      <input type="hidden" name="dbItemId" class="dbItemId" value="dbItemIdVal" > <input type="hidden" name="date" class="sentDate" value="DATEnTIME"><input type="button" class="btn btn-primary" onclick="sendNotify(\'ITEM_NO\')" value="Send"></div>  </div>';

    var indexNo = 0;
    $.each(notifList, function(index1, value) {
  
        if(value==="")
        {
            return;
        }

        indexNo = indexNo + 1;

        var itemId = "";

        var notifVal = value.split(",");

        var bodyHTML = mailBody;
        var mailEntryDummy = mailEntry

        $.each(notifVal, function(index, value) {

        console.log(index, value);

        if(index===0)
        {
            bodyHTML = bodyHTML.replace(/dbItemIdVal/g,value);
        }
        else if(index===2)
        {
            bodyHTML = bodyHTML.replace(/RECEIVER/g,value);
        }
        else if(index===3)
        {
            mailEntryDummy = mailEntryDummy.replace("SUBJECT",value);


            if(notificationListCode==="notificationListSent")
            {
                itemId = "sentItem"+indexNo;
            }
            else
            {
                itemId = "item"+indexNo;
            }

            mailEntryDummy = mailEntryDummy.replace("ITEM_NO", itemId);

            $(".mail-list-container").append(mailEntryDummy);

            bodyHTML = bodyHTML.replace("SUBJECT",value);
        }
        else if(index===4)
        {
            bodyHTML = bodyHTML.replace("MAILBODY",value);
        }
        else if(index===5)
        {
            var attachments = value.split(";")

            bodyHTML = bodyHTML.replace(/ATTACHMENT1/g, attachments[0]);

            if(attachments.length>1)
            {
                bodyHTML = bodyHTML.replace(/ATTACHMENT2/g, attachments[1]);
            }
            else
            {
                bodyHTML = bodyHTML.replace(/ATTACHMENT2/g,"");
            }
        }
        else if(index===7)
        {
            bodyHTML = bodyHTML.replace(/DATEnTIME/g, value);
        }

      });

        bodyHTML = bodyHTML.replace(/ITEM_NO/g, itemId);
        $(".mail-view").append(bodyHTML);

    });
}
</script>

<script type="text/javascript">
    function show(idVal)
    {
        var mailBodies = $(".mail-view").find(".message-body");
        
        for(var i=0;i<mailBodies.length;i++)
        {
            $(mailBodies[i]).hide();
        }
        
        $("#"+idVal).show();
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
<script type="text/javascript">
    function sendNotify(itemNo)
    {
        var body = $('#'+itemNo).find('.mailBody')[0].value;
        var subject = $('#'+itemNo).find('.mailSubject')[0].value;

        var dbItemId = $('#'+itemNo).find('.dbItemId')[0].value;
        var sentDate = $('#'+itemNo).find('.sentDate')[0].value;
        var attach1 = $('#'+itemNo).find('.attach1')[0].text;

        var attach2 = "";
        
        if($('#'+itemNo).find('.attach2')[0] !== undefined)
        {
          attach2 = $('#'+itemNo).find('.attach2')[0].text;    
        }        

        var receiver = $('#'+itemNo).find('.receiverAddr')[0].value;

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
</script>
<script type="text/javascript">
    function showItems(areaId)
    {
        if(areaId==='inboxItems')
        {
             populateItems('notificationListInbox');
    
        }
        else
        {
            populateItems('notificationListSent');

            $('#sentItem1').show();
        }
    }
</script>   
</body>
</html>