package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String userName;
    String receiver;
    String subject;
    String body;
    String attachmentNames;
    String status;
    Date date;

    public Notifications()
    {

    }
    public Notifications(String userName,
                         String receiver,
                         String subject,
                         String body,
                         String attachmentNames,
                         String status,
                         Date date)
    {
        this.userName = userName;
        this.receiver = receiver;
        this.subject = subject;
        this.body = body;
        this.attachmentNames = attachmentNames;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachmentNames() {
        return attachmentNames;
    }

    public void setAttachmentNames(String attachmentNames) {
        this.attachmentNames = attachmentNames;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return
                ""  +id +
                "," + userName +
                "," + receiver +
                "," + subject +
                "," + body +
                "," + attachmentNames +
                "," + status +
                "," + date;
    }

    /*@Override
    public String toString()
    {
        return  id + ',' +
                userName + ',' +
                receiver + ',' +
                subject + ',' +
                body + ',' +
                attachmentNames + ',' +
                status + ',' +
                date;
    }*/
}
