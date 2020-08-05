package com.projectmanager.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





import com.projectmanager.entity.ResetCode;

@Repository
public class ResetCodeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	public boolean saveResetCode(ResetCode resetCode){
		boolean saveCode = true;
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(resetCode);
		}catch (Exception ex){
			saveCode = false;
			ex.printStackTrace();
		}
		
		return saveCode;
	}
	
	@Transactional
	public String getCode(String userName){
		Session session = sessionFactory.getCurrentSession();
		System.out.println(userName);
		
		String selectSql = "select randomCode from ResetCode where userName=:userName";
		Query query = session.createQuery(selectSql);
		
		query.setParameter("userName", userName);
		
		String resetCode =  (String) query.getSingleResult();
		return resetCode;
	}
	
	@Transactional
	public boolean setNewPassword(String userName, String password){
		Session session = sessionFactory.getCurrentSession();
		
		String selectSql = "UPDATE LoginInfo SET password=:password WHERE userName=:userName";
		Query query = session.createQuery(selectSql);
	
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		
		query.executeUpdate();
		return true;
	}

}