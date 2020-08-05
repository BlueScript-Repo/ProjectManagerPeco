package com.projectmanager.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.Mappings;

@Repository
public class MappingsDao {

	@Autowired
	SessionFactory sessionFactory;

	public List getAssociatedOptions(String superSet, String superSetVal, String subSet, String inventory) {
		List<String> associatedValues = new ArrayList<String>();
		Session session = null;
		String selectHql = "";

		if (inventory == null) {
			selectHql = "SELECT distinct mpng." + subSet + " FROM Mappings mpng";
		} else if (superSetVal.equalsIgnoreCase("null")) {
			selectHql = "SELECT distinct mpng." + subSet + " FROM Mappings mpng where mpng." + superSet + " is "
					+ superSetVal;
		} else {
			selectHql = "SELECT distinct mpng." + subSet + " FROM Mappings mpng where mpng.inventoryName='" + inventory
					+ "' and mpng." + superSet + " = '" + superSetVal + "'";
		}

		if (inventory != null && !(inventory.trim().equals("Pipe"))) {
			selectHql = "SELECT distinct mpng." + subSet + " FROM Mappings mpng where mpng.inventoryName='" + inventory
					+ "'";
		}

		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(selectHql);

			associatedValues = query.getResultList();
		} finally {
			session.close();
		}
		return associatedValues;
	}

	@Transactional
	public ArrayList<Mappings> getAllMappinsData() {
		ArrayList<Mappings> mappingsList = new ArrayList<Mappings>();
		try {
			Session session = sessionFactory.getCurrentSession();
			String selectHql = "From Mappings";
			
			Query query = session.createQuery(selectHql);

			mappingsList = (ArrayList<Mappings>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("false mapping dao");
		}
		return mappingsList;
	}
	

	@Transactional
	public ArrayList<Mappings> getAllMapping(String inventoryName) {
		ArrayList<Mappings> mappingsList = new ArrayList<Mappings>();
		try {
			Session session = sessionFactory.getCurrentSession();
			String selectHql = "From Mappings where inventoryName=:inventoryName";
			
			Query query = session.createQuery(selectHql);
			query.setParameter("inventoryName", inventoryName);
			mappingsList = (ArrayList<Mappings>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("false mapping dao");
		}
		return mappingsList;
	}
	
	@Transactional
	public ArrayList<Mappings> getMappingById(int Id) {
		ArrayList<Mappings> mappingsList = new ArrayList<Mappings>();
		try {
			Session session = sessionFactory.getCurrentSession();
			String selectHql = "From Mappings where Id=:Id";
			
			Query query = session.createQuery(selectHql);
			query.setParameter("Id", Id);
			mappingsList = (ArrayList<Mappings>) query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("false mapping dao");
		}
		return mappingsList;
	}


	@Transactional
	public void updateMapping(Mappings mapp) {
			Session session = sessionFactory.getCurrentSession();
			
			//if(classOrGradePresent)
			session.save(mapp);
			/*else 
				session.update(mapp);*/
		
	}
	@Transactional
	public ArrayList<String> getAllInventory(){
		Session session = sessionFactory.getCurrentSession();
		String selectHql = "select distinct inventoryName from Mappings";

		Query query = session.createQuery(selectHql);
		
		List inventoryList = query.getResultList();
		return (ArrayList<String>) inventoryList ;
	}
	
	@Transactional
	public ArrayList<Mappings> getMappingDetails(String inventoryName, String material){
		Session session = sessionFactory.getCurrentSession();
		String selectHql = "FROM Mappings WHERE inventoryName=:inventoryName AND material=:material";
	
		
		Query query = session.createQuery(selectHql);
		query.setParameter("inventoryName", inventoryName);
		query.setParameter("material", material);
		
		List inventoryList = query.getResultList();
		return (ArrayList<Mappings>) inventoryList ;
	}
	
	

	@Transactional
	public ArrayList<String> getMaterial(String inventoryName) {
		Session session = sessionFactory.getCurrentSession();
		String selectHql = "select distinct material from Mappings where inventoryName=:inventoryName";
		
		Query query = session.createQuery(selectHql);
		query.setParameter("inventoryName", inventoryName);
		List materialList = query.getResultList();
		return (ArrayList<String>) materialList; 
	}
	
	@Transactional
	public ArrayList<String> getType(String inventoryName, String material) {
		Session session = sessionFactory.getCurrentSession();
		
		String selectHql = "select distinct type from Mappings where inventoryName=:inventoryName and material=:material";
		
		Query query = session.createQuery(selectHql);
		query.setParameter("inventoryName", inventoryName);
		query.setParameter("material", material);
		List typeList = query.getResultList();
		return (ArrayList<String>) typeList; 
	}
	@Transactional
	public ArrayList<String> getClassOrGrade(String inventoryName, String material) {
		Session session = sessionFactory.getCurrentSession();
		String selectHql = "select distinct classOrGrade from Mappings where inventoryName=:inventoryName and material=:material";
		
		Query query = session.createQuery(selectHql);
		query.setParameter("inventoryName", inventoryName);
		query.setParameter("material", material);
		List classOrGradeList = query.getResultList();
		return (ArrayList<String>) classOrGradeList; 
	}
	
	@Transactional
	public ArrayList<String> getCategory(String inventoryName, String material) {
		Session session = sessionFactory.getCurrentSession();
		String selectHql = "select distinct catogory from Mappings where inventoryName=:inventoryName and material=:material";
		
		Query query = session.createQuery(selectHql);
		query.setParameter("inventoryName", inventoryName);
		query.setParameter("material", material);
		List categoryList = query.getResultList();
		return (ArrayList<String>) categoryList; 
	}

	@Transactional
	public boolean presentClassOrGrade(String inventoryName, String material, String classOrGrade) {
		boolean classOrGradePresent = false;
		try{
		Session session = sessionFactory.getCurrentSession();
		System.out.println("ceck class or grade is present");
		String selectHql= "FROM Mappings WHERE inventoryName=:inventoryName AND material=:material AND classOrGrade IN(:classOrGrade)";
		Query query = session.createQuery(selectHql);
		query.setParameter("inventoryName", inventoryName);
		query.setParameter("material", material);
		query.setParameter("classOrGrade", classOrGrade);
		List mappingList = query.getResultList();
		if(mappingList.size()>0){
			classOrGradePresent =true;
		}}catch(Exception e){
			System.out.println("exception occur in presentClassOrGade");
		}
		System.out.println("ceck class or grade is present done");
		return classOrGradePresent;
	}
	
	@Transactional
	public int getMaxId ()
	{
		Session session = sessionFactory.getCurrentSession();
		String selectHql = "SELECT MAX(id) AS id FROM Mappings";
		Query query = session.createQuery(selectHql);
		
		Object obj = query.getSingleResult();
		if(obj==null) return 0;
	    return (Integer)obj;
	}
	
	
	
}
