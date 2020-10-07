package com.projectmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




import com.projectmanager.entity.DataDisplay;
import com.projectmanager.entity.InventoryMuster;


@Repository
public class InventoryMustereDao {

	
	@Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean saveMustered(InventoryMuster inventoryMustered) {
	boolean saved = false;
	try {
	    Session session = sessionFactory.getCurrentSession();

	    session.persist(inventoryMustered);
	    System.out.println("Done");

	    saved = true;
	} catch (Exception ex) {
		
		saved = false;
		ex.printStackTrace();
	}

	return saved;
    }
    
    @Transactional
	public List<InventoryMuster> getInventoryList() {
		Session session = sessionFactory.getCurrentSession();

		String queryStr = "from InventoryMustered ";

		Query query = session.createQuery(queryStr);

		List<InventoryMuster> inventoryList = query.getResultList();

		

		return inventoryList;
	}

}
