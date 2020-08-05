package com.projectmanager.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.LoginInfo;

@Repository
public class LoginInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public String gePasswordToValidate(LoginInfo loginInfo) {

		Session session = sessionFactory.getCurrentSession();

		String selectHql = " FROM LoginInfo logI where logI.userName='";

		Query query = session.createQuery(selectHql + loginInfo.getUserName() + "'");
		List results = query.getResultList();

		Iterator itr = results.iterator();

		while(itr.hasNext())
		{
			loginInfo = (LoginInfo) itr.next();
		}

		return loginInfo.getPassword();
	}

	@Transactional
	public boolean addLoginInfo(LoginInfo loginInfo) {

		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(loginInfo);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Transactional
	public LoginInfo getLoginInfo(String userName) {

		LoginInfo loginInfo = null;
		try {
			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from LoginInfo where userName=:userName");
			query.setParameter("userName", userName);

			loginInfo = (LoginInfo)query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return loginInfo;
	}
}
