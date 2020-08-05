package com.projectmanager.util;

import com.projectmanager.dao.NotificationDao;
import com.projectmanager.entity.Notifications;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import java.util.Date;

@ManagedBean
public class NotificationUtil {

    @Autowired
    NotificationDao notificationDao;

    public boolean pushNotification(String userName, String receiver,
                                    String subject,
                                    String body,
                                    String attachmentNames,
                                    String status,
                                    Date date)
    {

        Notifications notification = new Notifications( userName,
                 receiver,
                 subject,
                 body,
                 attachmentNames,
                 status,
                date);

        notificationDao.saveNotification(notification);

        return true;
    }

}
