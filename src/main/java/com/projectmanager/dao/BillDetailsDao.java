package com.projectmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.BillDetails;

@Repository
public class BillDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean saveBill(BillDetails billDetails) {

	Session session = sessionFactory.getCurrentSession();
	try {
	    session.save(billDetails);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return false;
	}
	return true;
    }

}
