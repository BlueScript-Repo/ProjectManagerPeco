package com.projectmanager.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryDefinitionDao {

	@Autowired
	SessionFactory sessionFactory;

	public List getAssociatedOptions(String superSet, String superSetVal, String subSet) {
		List<String> associatedValues = new ArrayList<String>();
		Session session = null;
		String selectHql = "SELECT distinct invD.inventorySpec." + subSet + " FROM InventoryDefinition invD where invD.inventorySpec." + superSet + " = '"
				+ superSetVal +"'";
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(selectHql);

			associatedValues = query.getResultList();
		} finally {
			session.close();
		}
		return associatedValues;
	}

}
