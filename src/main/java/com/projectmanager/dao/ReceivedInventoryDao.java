package com.projectmanager.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.Inventory;
import com.projectmanager.entity.ReceivedInventory;

@Repository
public class ReceivedInventoryDao {

	@Autowired
	private SessionFactory sessionFactory;

/*	@Transactional
	public boolean saveOrUpdateInventory(ReceivedInventory inventory) throws Exception {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.saveOrUpdate(inventory);

		} catch (Exception hibernateException) {
			hibernateException.printStackTrace();
			return false;
		}
		return true;
	}*/

	/*@Transactional
	public ArrayList<ReceivedInventory> getAllInventory() throws Exception {
		Session session = sessionFactory.getCurrentSession();

		ArrayList<ReceivedInventory> results = new ArrayList<>();
		try {
			String queryStr = " from ReceivedInventory";

			Query query = session.createQuery(queryStr);
			results = (ArrayList<ReceivedInventory>) query.getResultList();

		} catch (Exception hibernateException) {
			throw hibernateException;
		}
		return results;
	}
*/
/*	@Transactional
	public ArrayList<ReceivedInventory> getNoInvoiceInventory(int projectId) throws Exception {
		Session session = sessionFactory.getCurrentSession();

		ArrayList<ReceivedInventory> results = new ArrayList<>();
		try {
			String queryStr = " from ReceivedInventory WHERE invoiceNo is null and assignedProject=:projectId";

			Query query = session.createQuery(queryStr);
			query.setParameter("projectId", projectId);
			
			results = (ArrayList<ReceivedInventory>) query.getResultList();

		} catch (Exception hibernateException) {
			throw hibernateException;
		}
		return results;
	}*/
}
