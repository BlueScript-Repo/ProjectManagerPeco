package com.projectmanager.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.VendorDetails;

@Repository
public class VendorDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean saveVendorDetails(VendorDetails vendorDetails) {
	boolean saved = false;

	Session session = sessionFactory.getCurrentSession();

	try {
	    session.save(vendorDetails);
	    saved = true;
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return saved;
    }

    @Transactional
    public ArrayList<String> getVendorList() {
	ArrayList<String> vendorList = new ArrayList<String>();

	Session session = sessionFactory.getCurrentSession();

	try {
	    String queryStr = "SELECT vd.vendorName from VendorDetails vd";

	    Query query = session.createQuery(queryStr);

	    vendorList = (ArrayList<String>) query.getResultList();

	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return vendorList;
    }

    @Transactional
    public VendorDetails getVendorDetails(String vendorName) {
	VendorDetails vendorDetails = new VendorDetails();

	Session session = sessionFactory.getCurrentSession();

	try {
	    String queryStr = "from VendorDetails vd where vd.vendorName='";
	    
	    vendorName = vendorName.replaceAll("\\s", ""); 

	    Query query = session.createQuery(queryStr +vendorName+"'");

	    vendorDetails = (VendorDetails) query.getSingleResult();

	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return vendorDetails;
    }


}
