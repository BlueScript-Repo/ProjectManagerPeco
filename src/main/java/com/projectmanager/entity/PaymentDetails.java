package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int paymentId;
    
    /*private String taxInvoiceNumber;*/
    private String totalAmount;
    private String receivedAmount;
    private String pendingAmount;
    private String paymentMode;
    private String dateReceived;
    private String projectId;

    public PaymentDetails() {

    }
 
	public PaymentDetails(String totalAmount, String receivedAmount, String pendingAmount,
			String paymentMode, String dateReceived, String projectId) {
		super();
		//this.taxInvoiceNumber = taxInvoiceNumber;
		this.totalAmount = totalAmount;
		this.receivedAmount = receivedAmount;
		this.pendingAmount = pendingAmount;
		this.paymentMode = paymentMode;
		this.dateReceived = dateReceived;
		this.projectId = projectId;
	}


	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/*public String getTaxInvoiceNumber() {
		return taxInvoiceNumber;
	}

	public void setTaxInvoiceNumber(String taxInvoiceNumber) {
		this.taxInvoiceNumber = taxInvoiceNumber;
	}*/

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(String receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public String getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(String pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
