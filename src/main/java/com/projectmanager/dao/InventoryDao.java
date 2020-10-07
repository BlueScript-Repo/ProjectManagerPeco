package com.projectmanager.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.Inventory;
import com.projectmanager.entity.InventoryMuster;
import com.projectmanager.entity.InventorySpec;

@Repository
public class InventoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public int saveInventory(Inventory inventory) throws Exception {
		Session session = sessionFactory.getCurrentSession();

		try {
			 System.out.println("Before calling save");
			 session.save(inventory);
			 System.out.println("After calling save");
			 session.flush();
		} catch (Exception hibernateException) 
		{
			hibernateException.printStackTrace();
			throw hibernateException;
		}
		return inventory.getInventoryRowId();
	}

	
	@Transactional
	public int updateWhenSaveFailed(Inventory inventory) {
		Session session = sessionFactory.getCurrentSession();
					
			try
			{
				System.out.println("inventoryRowId is : "+inventory.getInventoryRowId());
				session.update(inventory);
			}
			catch(Exception updateHibernateException)
			{
				System.out.println("Update failed.");
				updateHibernateException.printStackTrace();
			}
		return inventory.getInventoryRowId();
	}

	
	@Transactional
	public ArrayList<Inventory> getAvailableInventory() {
		ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Inventory invD where invD.inventorySpec.assignedProject = null or invD.inventorySpec.assignedProject = '' and invD.quantity > 0";

		Query query = session.createQuery(hql);
		List results = query.getResultList();

		Iterator itr = results.iterator();

		while (itr.hasNext()) {

			inventoryList.add((Inventory) itr.next());
		}
		return inventoryList;
	}

	@Transactional
	public int getAvailableQuantity(Inventory inventory) {
		int availableQuantity = 0;
		InventorySpec inventorySpec = inventory.getInventorySpec();

		Session session = null;
		String selectHql = "SELECT invD.quantity FROM Inventory invD where " + "invD.inventorySpec.inventoryName = '"
				+ inventorySpec.getInventoryName() + "' and  " + "invD.inventorySpec.material = '"
				+ inventorySpec.getMaterial() + "' and  " + "invD.inventorySpec.type = '" + inventorySpec.getType()
				+ "' and  " + "invD.inventorySpec.manifMethod = '" + inventorySpec.getManifMethod() + "' and  "
				+ "invD.inventorySpec.gradeOrClass = '" + inventorySpec.getGradeOrClass() + "' and  "
				+ "invD.inventorySpec.size = '" + inventorySpec.getSize() + "' and  " + "invD.inventorySpec.ends = '"
				+ inventorySpec.getEnds() + "' and  (" + "invD.inventorySpec.assignedProject = null or invD.inventorySpec.assignedProject = '')";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(selectHql);

			Object result = query.uniqueResult();

			availableQuantity = (int) (result != null ? result : 0);

			System.out.println("Available Quentity is : " + availableQuantity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return availableQuantity;
	}

	@Transactional
	public int getQuantityByStatus(Inventory inventory, String status, boolean noInvoiceNum ) {
		int availableQuantity = 0;
		InventorySpec inventorySpec = inventory.getInventorySpec();

		Session session = null;
		String selectHql = "SELECT invD.quantity FROM Inventory invD where " + "invD.inventorySpec.inventoryName = '"
				+ inventorySpec.getInventoryName() + "' and  " + "invD.inventorySpec.material = '"
				+ inventorySpec.getMaterial() + "' and  " + "invD.inventorySpec.type = '" + inventorySpec.getType()
				+ "' and  " + "invD.inventorySpec.manifMethod = '" + inventorySpec.getManifMethod() + "' and  "
				+ "invD.inventorySpec.gradeOrClass = '" + inventorySpec.getGradeOrClass() + "' and  "
				+ "invD.inventorySpec.size = '" + inventorySpec.getSize() + "' and  " + "invD.inventorySpec.ends = '"
				+ inventorySpec.getEnds() + "' and  " + "invD.inventorySpec.assignedProject = '"
				+ inventorySpec.getAssignedProject() + "' and invD.inventorySpec.status='"+status+"'";
		
		if(noInvoiceNum)
		{
			selectHql = selectHql + " and invD.invoiceNo is null";
		}
		else
		{
			selectHql = selectHql + " and invD.invoiceNo is NOT null";
		}
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(selectHql);

			ArrayList<Integer> result = (ArrayList<Integer>) query.getResultList();

			for(Integer qty : result)
			{
				availableQuantity += (int) (qty != null ? qty : 0);	
			}
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return availableQuantity;
	}

	public int isEntityPresent(Inventory inventory, String statusTo, boolean noInvoice) {
		int associatedRowId = 0;
		InventorySpec inventorySpec = inventory.getInventorySpec();

		Session session = null;
		String selectHql = "SELECT invD.inventoryRowId FROM Inventory invD where "
				+ "invD.inventorySpec.inventoryName = '" + inventorySpec.getInventoryName() + "' and  "
				+ "invD.inventorySpec.material = '" + inventorySpec.getMaterial() + "' and  "
				+ "invD.inventorySpec.type = '" + inventorySpec.getType() + "' and  "
				+ "invD.inventorySpec.manifMethod = '" + inventorySpec.getManifMethod() + "' and  "
				+ "invD.inventorySpec.gradeOrClass = '" + inventorySpec.getGradeOrClass() + "' and  "
				+ "invD.inventorySpec.size = '" + inventorySpec.getSize() + "' and  " 
				+ "invD.inventorySpec.assignedProject = '" + inventorySpec.getAssignedProject() + "' and  " 
				+ "invD.inventorySpec.ends = '"	+ inventorySpec.getEnds() +"'";

		if(noInvoice)
		{
			selectHql = selectHql + " and invD.invoiceNo is null";
		}
		else
		{
			selectHql = selectHql + " and invD.invoiceNo is not null";
		}

		
		if(!statusTo.equals("%%"))
		{
			selectHql = selectHql + " and invD.inventorySpec.status = '" + statusTo + "'";
		}
		
		
		try {
			session = sessionFactory.openSession();

			System.out.println("InventoryRowId selection SQL is : "+selectHql);
			Query query = session.createQuery(selectHql);

			associatedRowId = query.uniqueResult() != null ? (int) query.uniqueResult() : 0;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return associatedRowId;

	}

	public int isEntityPresent(Inventory inventory) {
		return isEntityPresent(inventory, "%%", true);
	}

	@Transactional
	public double getPurchaseRate(Inventory inventory, boolean noInvoiceNum) {
		double purchaseRate = 0;
		InventorySpec inventorySpec = inventory.getInventorySpec();

		Session session = null;
		String selectHql = "SELECT invD.purchaseRate FROM Inventory invD where "
				+ "invD.inventorySpec.inventoryName = '" + inventorySpec.getInventoryName() + "' and  "
				+ "invD.inventorySpec.material = '" + inventorySpec.getMaterial() + "' and  "
				+ "invD.inventorySpec.type = '" + inventorySpec.getType() + "' and  "
				+ "invD.inventorySpec.manifMethod = '" + inventorySpec.getManifMethod() + "' and  "
				+ "invD.inventorySpec.gradeOrClass = '" + inventorySpec.getGradeOrClass() + "' and  "
				+ "invD.inventorySpec.size = '" + inventorySpec.getSize() + "' and  " 
				+ "invD.inventorySpec.ends = '" + inventorySpec.getEnds() + "'  and  " 
				+ "invD.inventorySpec.assignedProject = '" + inventorySpec.getAssignedProject() + "' and "
				+ "invD.inventorySpec.status='"+ inventory.getInventorySpec().getStatus() +"'";
		
		if(noInvoiceNum)
		{
			selectHql = selectHql + " and invD.invoiceNo is null";
		}
		else
		{
			selectHql = selectHql + " and invD.invoiceNo is NOT null";
		}
		
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(selectHql);

			purchaseRate = Double.parseDouble((String.valueOf(((ArrayList<Integer>) query.getResultList()).get(0))));

			System.out.println("PurchaseRate is : " + purchaseRate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return purchaseRate;
	}

	@Transactional
	public ArrayList<Inventory> getAssignedInventory(String projectName) {

		ArrayList<Inventory> assignedInventory = new ArrayList<Inventory>();

		Session session = null;
		String selectHql = "FROM Inventory invD where " + "invD.inventorySpec.assignedProject = '" + projectName + "' and "
				+ "invD.inventorySpec.status = 'assigned' and invD.invoiceNo is null";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(selectHql);

			assignedInventory = (ArrayList<Inventory>) query.getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return assignedInventory;
	}

	@Transactional
	public ArrayList<Inventory> getConsumedInventory(String projectName) {

		ArrayList<Inventory> assignedInventory = new ArrayList<Inventory>();

		Session session = null;
		String selectHql = "FROM Inventory invD where " + "invD.inventorySpec.assignedProject = '" + projectName + "' and "
				+ " invD.invoiceNo is NOT null";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(selectHql);

			assignedInventory = (ArrayList<Inventory>) query.getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return assignedInventory;
	}
	
	@Transactional
	public int getLatestInventoryEntryNo() {
		Session session = sessionFactory.getCurrentSession();

		String selectHql = "Select max(invD.inventoryRowId) from Inventory invD";

		Query query = session.createQuery(selectHql);
		int inventoryEntryNo = query.uniqueResult() == null ? 0 : (int) query.uniqueResult();
		return inventoryEntryNo;
	}
	
	@Transactional
	public ArrayList<Inventory> getNoInvoiceInventory(String projectName) throws Exception {
		Session session = sessionFactory.getCurrentSession();

		ArrayList<Inventory> results = new ArrayList<>();
		try {
			String queryStr = " from Inventory WHERE invoiceNo is null and assignedProject=:projectId";

			Query query = session.createQuery(queryStr);
			query.setParameter("projectId", projectName);
			
			results = (ArrayList<Inventory>) query.getResultList();

		} catch (Exception hibernateException) {
			throw hibernateException;
		}
		return results;
	}

	@Transactional
	public ArrayList<InventoryMuster> getReceivedInventory() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<InventoryMuster> assignedInventory = new ArrayList<InventoryMuster>();
		
		try {
			String queryStr = " from InventoryMuster";

			Query query = session.createQuery(queryStr);
			//query.setParameter("projectId", projectName);
			
			assignedInventory = (ArrayList<InventoryMuster>) query.getResultList();

		} catch (Exception hibernateException) {
			throw hibernateException;
		}
		return assignedInventory;
	}
	
	@Transactional
	public int saveReveivedInventory(InventoryMuster inventoryMuster) throws Exception {
		Session session = sessionFactory.getCurrentSession();

		try {
			 System.out.println("Before calling save");
			 session.save(inventoryMuster);
			 System.out.println("After calling save");
			// session.flush();
		} catch (Exception hibernateException) 
		{
			hibernateException.printStackTrace();
			throw hibernateException;
		}
		return inventoryMuster.getId();
	}
}
