package com.projectmanager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.ChallanDetails;

@Repository
public class ChallanDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean saveChallan(ChallanDetails challanDetails) {
	boolean saved = false;
	try {
	    Session session = sessionFactory.getCurrentSession();

	    session.saveOrUpdate(challanDetails);

	    saved = true;
	} catch (Exception ex) {

	}

	return saved;
    }

	@Transactional
	public boolean deleteChallan(String projectId) {
		boolean deleted = true;
		try
		{
			Session session = sessionFactory.getCurrentSession();

			String deleteSQL = "delete from ChallanDetails cd where cd.projectId='"+projectId+"'";

			Query qry = session.createQuery(deleteSQL);

			qry.executeUpdate();

		} catch (Exception ex)
		{
			ex.printStackTrace();
			deleted = false;
		}

		return deleted;
	}
    
    @Transactional
    public List<String> getLrNo(String projectId) {
	List<String> lrList = new ArrayList<String>();
	
	try
	{
	    Session session = sessionFactory.getCurrentSession();

	    String lrNoSQL = "select cd.lrNumber from ChallanDetails cd where cd.projectId='"+projectId+"'";
	    
	    Query qry = session.createQuery(lrNoSQL);
	    
	    lrList = qry.getResultList();

	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}

	return lrList;
    }
}
