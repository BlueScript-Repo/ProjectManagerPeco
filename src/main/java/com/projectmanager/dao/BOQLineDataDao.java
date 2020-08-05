package com.projectmanager.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanager.entity.BOQLineData;

@Repository
public class BOQLineDataDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public BOQLineData getLineData(String material, String inventoryName) {
		ArrayList<BOQLineData> boqLineDataList = new ArrayList<BOQLineData>();

		String[] inventoryNameSplited = inventoryName.split(":");
		try {
			Session session = sessionFactory.getCurrentSession();
			Query sqlQuery = null;

			if (inventoryName.equals("Pipe")) {
				sqlQuery = session.createQuery(
						"from BOQLineData as lineData where lineData.material=:material and lineData.inventoryName=:inventoryName");
				sqlQuery.setParameter("material", material);
				System.out.println("Getting data for : " + material);
			} else {
				sqlQuery = session
						.createQuery("from BOQLineData as lineData where lineData.inventoryName=:inventoryName");
			}

			if (inventoryNameSplited.length > 1) {
				inventoryName = inventoryNameSplited[1];
			}
			sqlQuery.setParameter("inventoryName", inventoryName);

			List results = sqlQuery.getResultList();
			Iterator itr = results.iterator();

			while (itr.hasNext()) {
				boqLineDataList.add((BOQLineData) itr.next());
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		BOQLineData boqLineData = null;
		if (boqLineDataList.size() > 0)
			boqLineData = boqLineDataList.get(0);

		if (boqLineData != null && inventoryNameSplited.length > 1) {
			boqLineData.setInventoryName(inventoryNameSplited[0] + ":" + boqLineData.getInventoryName());
		}

		return boqLineData;
	}
}
