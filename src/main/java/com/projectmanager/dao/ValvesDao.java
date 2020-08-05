package com.projectmanager.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.Mappings;
import com.projectmanager.entity.Valves;

@Repository
public class ValvesDao {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public ArrayList<Valves> getValveDetails()
	{
		Session session = sessionFactory.getCurrentSession();
		
		String sqlStr = "From Valves";
		
		Query query = session.createQuery(sqlStr);
		
		ArrayList<Valves> valveDetailsList = (ArrayList<Valves>) query.getResultList();
		
		return valveDetailsList;
	}
	
	@Transactional
	public boolean updateValves(Valves valves) {
	
		boolean result = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(valves);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}
	return result;	
	}


}
