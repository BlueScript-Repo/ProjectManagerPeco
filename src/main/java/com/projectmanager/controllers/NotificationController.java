package com.projectmanager.controllers;

import com.projectmanager.dao.NotificationDao;
import com.projectmanager.dao.UserDetailsDao;
import com.projectmanager.entity.Notifications;
import com.projectmanager.entity.UserDetails;
import com.projectmanager.util.EmailUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@EnableWebMvc
@Controller
public class NotificationController
{

    @Autowired
    NotificationDao notificationDao;

    @Autowired
    EmailUtils emailUtils;

    @Autowired
    UserDetailsDao userDetailsDao;

    @RequestMapping(value = "showNotifications", method = RequestMethod.GET)
    public ModelAndView showNotificationsList(HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView("notifications");

        String userName = (String) session.getAttribute("userName");

        ArrayList<Notifications> notificationListInbox = notificationDao.getNotification("userName",userName, "status", "INBOX");

        ArrayList<Notifications> notificationListSent = notificationDao.getNotification("userName",userName, "status", "SENT");

        StringBuilder builderInbox = new StringBuilder();

        for(Notifications notification : notificationListInbox)
        {
            builderInbox.append(notification.toString());
            builderInbox.append("[[[");
        }

        StringBuilder builderSent = new StringBuilder();

        for(Notifications notification : notificationListSent)
        {
            builderSent.append(notification.toString());
            builderSent.append("[[[");
        }

        modelAndView.addObject("notificationListInboxVal", builderInbox.toString());
        modelAndView.addObject("notificationListSentVal", builderSent.toString());

        return modelAndView;
    }


    @RequestMapping(value = "downloadAttachment", method = RequestMethod.GET)
    public void downloadAttachment(HttpSession session, HttpServletResponse response, String fileName)
    {
        if(null==fileName)
        {
            return;
        }
        try {
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);

            String userName = (String) session.getAttribute("userName");
            String fileLocation = System.getProperty("java.io.tmpdir") + "/" + userName+"/";
            OutputStream out = response.getOutputStream();

            FileInputStream fIn = new FileInputStream(new File(fileLocation+fileName));

            byte[] bytes = IOUtils.toByteArray(fIn);

            int length = bytes.length;

            out.write(bytes, 0, length);
            out.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @RequestMapping(value = "sendNotification", method = RequestMethod.POST)
    public @ResponseBody boolean sendNotification(HttpSession session, Notifications notification, int id, String dateValue)
    {
        boolean success = true;
        try
        {
            String userName = (String) session.getAttribute("userName");
            String sender = userDetailsDao.getEmailAddress(userName);

            emailUtils.sendMessageWithAttachment(sender, notification.getReceiver(), notification.getSubject(), notification.getBody(), notification.getAttachmentNames(), userName);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(dateValue.substring(0, dateValue.length() - 2));

            notification.setDate(date);
            notification.setId(id);
            notification.setUserName(userName);
            notification.setStatus("SENT");

            notificationDao.saveOrUpdate(notification);
        }
        catch (Exception ex)
        {
            success = false;
            ex.printStackTrace();
        }

        return success;
    }
}
