package com.projectmanager.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.TaxesEntity;


@Repository
public class TaxesDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public ArrayList<TaxesEntity> getTaxesDetails()
	{
		Session session = sessionFactory.getCurrentSession();
		
		String sqlStr = "From TaxesEntity";
		
		Query query = session.createQuery(sqlStr);
		
	ArrayList<TaxesEntity> result  =(ArrayList<TaxesEntity>) query.getResultList();
		
		return result;
	}

	@Transactional
	public boolean updateTaxes(int cGst, int sGst, int iGst) {
		boolean result = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			String sqlStr = "update TaxesEntity set cGSt=:cGst, sGSt=:sGst, iGst=:iGst";
			Query query = session.createQuery(sqlStr);
			query.setParameter("cGst", cGst);
			query.setParameter("sGst", sGst);
			query.setParameter("iGst", iGst);

			query.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}
	return result;	
		
	}
	

}
