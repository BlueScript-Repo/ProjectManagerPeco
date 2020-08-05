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

import com.projectmanager.entity.PaymentDetails;

@Repository
public class PaymentDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean savePaymentDetails(PaymentDetails paymentDetails) {

		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(paymentDetails);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean deletePaymentDetails(String projectId) {

		boolean deleted = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			String deleteHql = "delete FROM PaymentDetails payD where payD.projectId=:projectId";

			Query deleteQuery = session.createQuery(deleteHql);

			deleteQuery.executeUpdate();
		}
		catch(Exception ex)
		{
			deleted = false;
			ex.printStackTrace();
		}
		return deleted;
	}

	@Transactional
	public ArrayList<PaymentDetails> getPayentDetails(String taxInvoiceNumber, String projectId) {

		ArrayList<PaymentDetails> paymentDetailsList = new ArrayList<PaymentDetails>();

		Session session = sessionFactory.getCurrentSession();
		String selectHql = " FROM PaymentDetails payD where payD.projectId=:projectId";

		if (null != taxInvoiceNumber) {
			selectHql = selectHql + " and taxInvoiceNumber=:taxInvoiceNumber";
		}
		Query query = session.createQuery(selectHql);

		query.setParameter("projectId", projectId);

		if (null != taxInvoiceNumber) {
			query.setParameter("taxInvoiceNumber", taxInvoiceNumber);
		}

		List results = query.getResultList();
		Iterator itr = results.iterator();

		while (itr.hasNext()) {
			paymentDetailsList.add((PaymentDetails) itr.next());
		}

		return paymentDetailsList;
	}

	@Transactional
	public ArrayList<PaymentDetails> getPayentDetails(String projectId) {
		return getPayentDetails(null, projectId);
	}
	
	@Transactional
	public ArrayList<PaymentDetails> getPendingPayentDetails() {

		ArrayList<PaymentDetails> paymentDetailsList = new ArrayList<PaymentDetails>();

		Session session = sessionFactory.getCurrentSession();
		String selectHql = " FROM PaymentDetails payD where payD.pendingAmount > 0";
		
		Query query = session.createQuery(selectHql);

		List results = query.getResultList();
		Iterator itr = results.iterator();

		while (itr.hasNext()) {
			paymentDetailsList.add((PaymentDetails) itr.next());
		}

		return paymentDetailsList;
	}
}
