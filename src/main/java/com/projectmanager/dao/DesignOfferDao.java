package com.projectmanager.dao;

import com.projectmanager.entity.DesignOffer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
public class DesignOfferDao
{
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public ArrayList<String> getLatestAssociatedDocNo(String docNumber)
    {
        ArrayList<String> docNumberList = new ArrayList<>();
        try
        {
            Session session = sessionFactory.getCurrentSession();

            String queryString = "Select docNumber from DesignOffer where docNumber like '%" + docNumber + "%'";

            Query query = session.createQuery(queryString);

            docNumberList = (ArrayList<String>) query.getResultList();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
     return docNumberList;
    }

    @Transactional
    public ArrayList<String> getLatestAssociatedDocNoForProject(String projectId)
    {
        ArrayList<String> docNumberList = new ArrayList<>();
        try
        {
            Session session = sessionFactory.getCurrentSession();

            String queryString = "Select docNumber from DesignOffer where projectId ='"+projectId+"'";

            Query query = session.createQuery(queryString);

            docNumberList = (ArrayList<String>) query.getResultList();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return docNumberList;
    }

    @Transactional
    public DesignOffer getDesignOffer(String docNumber)
    {
       DesignOffer designOffer = null;
        try
        {
            Session session = sessionFactory.getCurrentSession();

            String queryString = "From DesignOffer where docNumber=:docNumber";

            Query query = session.createQuery(queryString);

            query.setParameter("docNumber",docNumber);
            designOffer = (DesignOffer) query.getSingleResult();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return designOffer;
    }

    @Transactional
    public boolean saveOrUpdateDesignOffer(DesignOffer designOffer)
    {
        boolean saved = true;

        try
        {
            Session session = sessionFactory.getCurrentSession();

            session.saveOrUpdate(designOffer);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            saved = false;
        }

        return saved;
    }
}