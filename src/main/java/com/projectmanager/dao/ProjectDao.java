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

import com.projectmanager.entity.Project;

@Repository
public class ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public int addProject(Project proj) {

		int projectId;

		Session session = sessionFactory.getCurrentSession();

		projectId = (int) session.save(proj);

		return projectId;
	}

	@Transactional
	public boolean deleteProject(String projectId) {

		boolean projectDeleted = true;
		try {
			Session session = sessionFactory.getCurrentSession();

			session.delete(new Project(Integer.parseInt(projectId), "", "", ""));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			projectDeleted = false;
		}
		return projectDeleted;
	}

	@Transactional
	public Project getProject(int projectId) {
		Project project = new Project();
		
		try {
			Session session = sessionFactory.getCurrentSession();

			String hql = "FROM Project P WHERE P.projectId = ";

			Query query = session.createQuery(hql + projectId);
			List results = query.getResultList();

			Iterator itr = results.iterator();

			while (itr.hasNext()) {
				project = (Project) itr.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return project;
	}

	@Transactional
	public ArrayList<Project> getProject(String tag, String value) {
		ArrayList<Project> projectList = new ArrayList<Project>();

		Session session = sessionFactory.getCurrentSession();

		String hql = "FROM Project P WHERE P." + tag + " LIKE '%";

		Query query = session.createQuery(hql + value + "%'");
		List results = query.getResultList();

		Iterator itr = results.iterator();

		while (itr.hasNext()) {
			projectList.add((Project) itr.next());
		}

		return projectList;
	}

	@Transactional
	public int getProjectId(String projectName) {
		int projectId = 0;

		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT P.projectId FROM Project P WHERE P.projectName = '";

		Query query = session.createQuery(hql + projectName + "'");
		List results = query.getResultList();

		Iterator itr = results.iterator();

		while (itr.hasNext()) {
			projectId = ((int) itr.next());
		}

		return projectId;
	}
}
