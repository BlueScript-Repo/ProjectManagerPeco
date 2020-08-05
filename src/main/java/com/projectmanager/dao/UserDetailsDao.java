package com.projectmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.UserDetails;

@Repository
public class UserDetailsDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public String getEmailAddress(String userName) {
		String emailAddress = null;
		String queryString = "select emailAddress from UserDetails where userName=:userName";

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		query.setParameter("userName", userName == null ? "" : userName);

		emailAddress = (String) query.getSingleResult();

		return emailAddress;
	}

	@Transactional
	public UserDetails getuSerDetails(String userName) {
		UserDetails userDetails = null;
		String queryString = "from UserDetails where userName=:userName";

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		query.setParameter("userName", userName == null ? "" : userName);

		userDetails = (UserDetails) query.getSingleResult();

		return userDetails;
	}

	@Transactional
	public boolean saveUser(UserDetails userDetails) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(userDetails);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return false;
	}
	
	@Transactional
	public UserDetails isUserPresent(String userName){
		UserDetails ispresent = null;
		Session session = sessionFactory.getCurrentSession();
		try{
		String Select = "from UserDetails where userName=:userName";
		Query query = session.createQuery(Select);
		query.setParameter("userName", userName);
		ispresent = (UserDetails)query.getSingleResult();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ispresent;
	}
}
