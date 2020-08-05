package com.projectmanager.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.BOQHeader;

@Repository
public class BOQHeaderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean saveBOQHeader(BOQHeader boqHeader) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(boqHeader);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public BOQHeader getBOQHeaderFromName(String boqName, String projectId)
	{
		BOQHeader header = null;
		Session session = sessionFactory.getCurrentSession();
		try
		{
			String sql = "from BOQHeader BH where BH.boqName=:boqName and BH.projectId=:projectId";
			Query query = session.createQuery(sql);
			
			query.setParameter("boqName", boqName);
			query.setParameter("projectId",projectId);
			
			header = (BOQHeader) query.getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return header;
	}
	
	@Transactional
	public void	deleteHeaderData(String docNameToDownload, String projectId)
	{
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "delete from BOQHeader BH where BH.boqName=:boqName and BH.projectId=:projectId";
		
		Query query = session.createQuery(sql);
		
		query.setParameter("boqName", docNameToDownload);
		query.setParameter("projectId",projectId);
		
		query.executeUpdate();
	}


	@Transactional
	public void	deleteHeaderData( String projectId)
	{
		Session session = sessionFactory.getCurrentSession();

		String sql = "delete from BOQHeader BH where BH.projectId=:projectId";

		Query query = session.createQuery(sql);

		query.setParameter("projectId",projectId);

		query.executeUpdate();
	}
}
