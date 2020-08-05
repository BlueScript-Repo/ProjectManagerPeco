package com.projectmanager.dao;

import com.projectmanager.entity.Notifications;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean saveNotification(Notifications notifications)
    {
        boolean success = true;
        try
        {
            Session session = sessionFactory.getCurrentSession();

            session.save(notifications);

        }
        catch(Exception ex){
            success = false;
        }

        return success;
    }

    @Transactional
    public ArrayList<Notifications> getNotification(String tag1, String tagValue1)
    {
        return getNotification(tag1,tagValue1, null, null);
    }

    @Transactional
    public ArrayList<Notifications> getNotification(String tag1, String tagValue1, String tag2, String tagValue2)
    {
        ArrayList<Notifications> notificationList = new ArrayList<>();
        try
        {
            Session session = sessionFactory.getCurrentSession();

            String selectSQL = "from Notifications where "+tag1+"='"+tagValue1+"'";

            if(tag2!=null && tagValue2!=null)
            {
                selectSQL = selectSQL + " and "+tag2+"='"+tagValue2+"'";
            }

            Query query = session.createQuery(selectSQL);

            notificationList = (ArrayList<Notifications>) query.getResultList();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return notificationList;
    }

    @Transactional
    public boolean saveOrUpdate(Notifications notification)
    {
        boolean success = true;

        try
        {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(notification);
        }
        catch (Exception ex)
        {
            success = false;
            ex.printStackTrace();
        }

        return success;
    }

    @Transactional
    public ArrayList<Notifications> updateNotification(String criteria, String criteriaVal, String tag, String tagValue)
    {
        ArrayList<Notifications> notificationList = new ArrayList<>();
        try
        {
            Session session = sessionFactory.getCurrentSession();

            String selectSQL = "update Notifications set "+ tag +"='"+ tagValue + "' where "+criteria+"='"+criteriaVal+"'";


            Query query = session.createQuery(selectSQL);

            notificationList = (ArrayList<Notifications>) query.getResultList();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return notificationList;
    }

}