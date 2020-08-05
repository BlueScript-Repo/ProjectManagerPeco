package com.projectmanager.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.PODetails;
import com.projectmanager.entity.TaxInvoiceDetails;

@Repository
public class PODetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean savePO(PODetails poDetails) {

	Session session = sessionFactory.getCurrentSession();
	try {
	    session.save(poDetails);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return false;
	}
	return true;
    }

    @Transactional
    public ArrayList<String> getAssociatedPONames(String projectId) {

	ArrayList<String> boqDetailsNameList = new ArrayList<String>();

	Session session = sessionFactory.getCurrentSession();
	
	System.out.println("projectId in DAO is : "+projectId);
	
	String selectHql = "Select distinct poD.poNumber FROM PODetails poD where poD.projectId='";

	Query query = session.createQuery(selectHql + projectId + "'");
	List results = query.getResultList();

	Iterator itr = results.iterator();

	while (itr.hasNext()) {
	    boqDetailsNameList.add((String) itr.next());
	}

	return boqDetailsNameList;
    }

	@Transactional
	public boolean deletePO(String projectId) {
		boolean deleted = true;
		try
		{
			Session session = sessionFactory.getCurrentSession();

			String lrNoSQL = "delete from PODetails poD where poD.projectId='" + projectId + "'";

			Query qry = session.createQuery(lrNoSQL);

			qry.executeUpdate();

		} catch (Exception ex) {
			deleted = false;

			ex.printStackTrace();
		}

		return deleted;
	}

    @Transactional
    public List<String> getPoNumber(String projectId) {
	List<String> lrList = new ArrayList<String>();

	try 
	{
	    Session session = sessionFactory.getCurrentSession();

	    String lrNoSQL = "Select poD.poNumber from PODetails poD where poD.projectId='" + projectId + "'";

	    Query qry = session.createQuery(lrNoSQL);

	    lrList = qry.getResultList();

	} catch (Exception ex) {
	    ex.printStackTrace();
	}

	return lrList;
    }

    @Transactional
    public ArrayList<PODetails> getPOData(String tag, String value) {
	ArrayList<PODetails> poDetailsList = new ArrayList<PODetails>();
	try {
	    Session session = sessionFactory.getCurrentSession();
	    String sql = "from PODetails td where td." + tag + "='" + value+"'";

	    Query query = session.createQuery(sql);

	    List results = query.getResultList();

	    Iterator itr = results.iterator();

	    while (itr.hasNext()) {
		poDetailsList.add((PODetails) itr.next());
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return poDetailsList;
    }
}
