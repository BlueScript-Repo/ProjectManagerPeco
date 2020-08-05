package com.projectmanager.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.AccessoryDetails;
import com.projectmanager.entity.Inventory;
import com.projectmanager.entity.InventorySpec;

@Repository
public class AccessoryDetailsDao {/*

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean saveAccessory(AccessoryDetails accessoryDetails) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(accessoryDetails);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean updateWhenSaveFailed(AccessoryDetails accessoryDetails) {
		Session session = sessionFactory.getCurrentSession();
		boolean updateSucess = true;
		try {
			session.update(accessoryDetails);
		} catch (Exception updateHibernateException) {
			updateSucess = false;
			System.out.println("Update faled too.");
			updateHibernateException.printStackTrace();
		}
		return updateSucess;
	}

	@Transactional
	public ArrayList<AccessoryDetails> getAccessoryDetailsByStatus() {
		return getAccessoryDetailsByStatus("", "available");
	}

	@Transactional
	public ArrayList<AccessoryDetails> getAccessoryDetailsByStatus(String project, String status) {
		ArrayList<AccessoryDetails> accessoryList = new ArrayList<AccessoryDetails>();
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM AccessoryDetails accessD where accessD.assignedProject=:assignedProject ";

		if(status.equalsIgnoreCase("consumed"))
		{
			hql = hql + " and accessD.invoiceNo is NOT null";
		}
		else if(status.equalsIgnoreCase("assigned"))
		{
			hql = hql + " and accessD.invoiceNo is null";
		}
		
		Query query = session.createQuery(hql);
		query.setParameter("assignedProject", project);

		List results = query.getResultList();

		Iterator itr = results.iterator();

		while (itr.hasNext()) {

			accessoryList.add((AccessoryDetails) itr.next());
		}
		return accessoryList;
	}

	@Transactional
	public String getAccessoryDetailsByStatus(AccessoryDetails accessory, String status) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select accessD.quantity FROM AccessoryDetails accessD  " + " where accessD.desc1=:desc1 "
				+ " and accessD.desc2=:desc2 " + " and accessD.desc3=:desc3 " + " and accessD.desc4=:desc4 "
				+ " and accessD.desc5=:desc5 " + " and accessD.accessoryName=:accessoryName "
				+ " and accessD.assignedProject=:assignedProject " + " and accessD.status=:status";

		Query query = session.createQuery(hql);
		query.setParameter("desc1", accessory.getDesc1());
		query.setParameter("desc2", accessory.getDesc2());
		query.setParameter("desc3", accessory.getDesc3());
		query.setParameter("desc4", accessory.getDesc4());
		query.setParameter("desc5", accessory.getDesc5());
		query.setParameter("accessoryName", accessory.getAccessoryName());
		query.setParameter("assignedProject", accessory.getAssignedProject());
		query.setParameter("status", status);

		String availableQuantity = "0";
		try {

			Object result = query.uniqueResult();

			availableQuantity = (String) (result != null ? String.valueOf(result) : "0");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return availableQuantity;
	}

	@Transactional
	public boolean isEntityPresent(AccessoryDetails accessory, String statusTo) {
		List<AccessoryDetails> accessories = new ArrayList<AccessoryDetails>();

		Session session = null;
		String selectHql = "FROM AccessoryDetails accessD  " + " where accessD.desc1=:desc1 "
				+ " and accessD.desc2=:desc2 " + " and accessD.desc3=:desc3 " + " and accessD.desc4=:desc4 "
				+ " and accessD.desc5=:desc5 " + " and accessD.accessoryName=:accessoryName "
				+ " and accessD.assignedProject=:assignedProject ";

		if (!statusTo.equals("%%")) {
			selectHql = selectHql + " and accessD.status=:status";
		}

		session = sessionFactory.openSession();

		Query query = session.createQuery(selectHql);

		query.setParameter("desc1", accessory.getDesc1());
		query.setParameter("desc2", accessory.getDesc2());
		query.setParameter("desc3", accessory.getDesc3());
		query.setParameter("desc4", accessory.getDesc4());
		query.setParameter("desc5", accessory.getDesc5());
		query.setParameter("accessoryName", accessory.getAccessoryName());
		query.setParameter("assignedProject", accessory.getAssignedProject());

		if (!statusTo.equals("%%")) {
			query.setParameter("status", statusTo);
		}

		try {
			accessories = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return accessories.size() > 0 ? true : false;
	}

	public boolean isEntityPresent(AccessoryDetails accessory) {
		return isEntityPresent(accessory, "%%");
	}

	@Transactional
	public int getQuantityByStatus(AccessoryDetails accessory, String status) {
		String requestedQuantity = "0";

		Session session = null;
		String selectHql = "SELECT accessD.quantity FROM AccessoryDetails accessD  " + " where accessD.desc1=:desc1 "
				+ " and accessD.desc2=:desc2 " + " and accessD.desc3=:desc3 " + " and accessD.desc4=:desc4 "
				+ " and accessD.desc5=:desc5 " + " and accessD.accessoryName=:accessoryName "
				+ " and accessD.assignedProject=:assignedProject and accessD.status=:status";
		try {
			session = sessionFactory.openSession();

			Query query = session.createQuery(selectHql);

			query.setParameter("desc1", accessory.getDesc1());
			query.setParameter("desc2", accessory.getDesc2());
			query.setParameter("desc3", accessory.getDesc3());
			query.setParameter("desc4", accessory.getDesc4());
			query.setParameter("desc5", accessory.getDesc5());
			query.setParameter("accessoryName", accessory.getAccessoryName());
			query.setParameter("assignedProject", accessory.getAssignedProject());
			query.setParameter("status", status);

			Object result = query.uniqueResult();

			requestedQuantity = (String) (result != null ? result : 0);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Integer.valueOf(requestedQuantity);
	}
*/}
