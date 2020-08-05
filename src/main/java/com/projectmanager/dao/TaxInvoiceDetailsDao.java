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

import com.projectmanager.entity.ProjectDetails;
import com.projectmanager.entity.TaxInvoiceDetails;

@Repository
public class TaxInvoiceDetailsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean saveTaxIvoice(TaxInvoiceDetails taxInvoiceDetails) {
		boolean taxInvoiceaved = false;

		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(taxInvoiceDetails);
			taxInvoiceaved = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return taxInvoiceaved;
	}

	@Transactional
	public ArrayList<TaxInvoiceDetails> getTaxIvoiceData(String tag, String value) {
		ArrayList<TaxInvoiceDetails> taxInvoiceDetailsList = new ArrayList<TaxInvoiceDetails>();
		try {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from TaxInvoiceDetails td where td." + tag + "='" + value + "'";

			Query query = session.createQuery(sql);

			List results = query.getResultList();

			Iterator itr = results.iterator();

			while (itr.hasNext()) {
				taxInvoiceDetailsList.add((TaxInvoiceDetails) itr.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return taxInvoiceDetailsList;
	}


	@Transactional
	public boolean deleteTaxIvoiceData(String projectId)
	{
		boolean deleted = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			String sql = "delete from TaxInvoiceDetails td where td.projectId='" + projectId + "'";

			Query query = session.createQuery(sql);

			query.executeUpdate();
		} catch (Exception ex) {
			deleted = false;
			ex.printStackTrace();
		}
		return deleted;
	}

	@Transactional
	public String getLastTaxIvoiceNo() {
		String lastTaxInvoiceno = "";
		try {
			Session session = sessionFactory.getCurrentSession();
			String sql = "SELECT taxInvoiceNo FROM TaxInvoiceDetails ORDER BY STR_TO_DATE(taxInvoiceDate, '%Y-%m-%d %H:%i:%S')  DESC";

			Query query = session.createQuery(sql);

			List<Object> results = query.getResultList();

			if(results.size()>0)
			{
				lastTaxInvoiceno = (String) results.get(0);	
			}
				

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lastTaxInvoiceno;
	}
}
