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

import com.projectmanager.entity.BOQDetails;

@Repository
public class BOQDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean saveBOQ(BOQDetails boqDetails) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(boqDetails);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Transactional
	public ArrayList<BOQDetails> getBOQFromName(String boqName, String projectId) {

		ArrayList<BOQDetails> boqDetailsList = new ArrayList<BOQDetails>();

		Session session = sessionFactory.getCurrentSession();
		String selectHql = " FROM BOQDetails boqD where boqD.boqName=:boqName and projectId=:projectId";

		Query query = session.createQuery(selectHql );
		query.setParameter("boqName", boqName);
		query.setParameter("projectId", projectId);
		List results = query.getResultList();

		Iterator itr = results.iterator();

		while (itr.hasNext()) {
			boqDetailsList.add((BOQDetails) itr.next());
		}

		return boqDetailsList;
	}

	@Transactional
	public void deleteBoqData(String docNameToDownload, String projectId) {
		Session session = sessionFactory.getCurrentSession();
		String selectHql = "delete FROM BOQDetails boqD where boqD.boqName=:boqName and projectId=:projectId";

		Query query = session.createQuery(selectHql);
		query.setParameter("boqName", docNameToDownload);
		query.setParameter("projectId", projectId);

		query.executeUpdate();
	}

	@Transactional
	public ArrayList<String> getAssociatedBOQNames(String projectId) {

		ArrayList<String> boqDetailsNameList = new ArrayList<String>();

		Session session = sessionFactory.getCurrentSession();
		String selectHql = "Select distinct boqD.boqName FROM BOQDetails boqD where boqD.projectId='";

		Query query = session.createQuery(selectHql + projectId + "'");
		List results = query.getResultList();

		Iterator itr = results.iterator();

		while (itr.hasNext()) {
			boqDetailsNameList.add((String) itr.next());
		}

		return boqDetailsNameList;
	}

	@Transactional
	public ArrayList<String> getMatchingBOQNames(String boqName, String projectId) {

		ArrayList<String> boqNames = new ArrayList<String>();

		Session session = sessionFactory.getCurrentSession();
		String selectHql = "SELECT boqD.boqName FROM BOQDetails boqD where boqD.boqName like '%";

		Query query = session.createQuery(selectHql + boqName + "%' and boqD.projectId='" + projectId + "'");
		List results = query.getResultList();

		Iterator itr = results.iterator();

		while (itr.hasNext()) {
			boqNames.add((String) itr.next());
		}

		return boqNames;
	}

	@Transactional
	public ArrayList<String> getRecentProject() {
		ArrayList<String> projectId = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		String queryString = "SELECT distinct(projectId) FROM BOQDetails";
		Query query = session.createQuery(queryString);

		try {
			projectId = (ArrayList<String>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return projectId;
	}

	@Transactional
	public String getLatestAssociatedBOQProject(String projectId) {
		String boqName = "";
		Session session = sessionFactory.getCurrentSession();
		String queryString = "SELECT boqName FROM BOQDetails WHERE projectId='" + projectId
				+ "' AND id IN (SELECT MAX(id) FROM BOQDetails WHERE projectId='" + projectId
				+ "' AND boqName NOT LIKE 'Inquiry_%' )";
		Query query = session.createQuery(queryString);

		boqName = (String) query.getSingleResult();

		return boqName;
	}

}
