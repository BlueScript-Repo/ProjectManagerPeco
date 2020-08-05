package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaxInvoiceDetails {

	@Id
	public String taxInvoiceNo;
	public String addressedto1;
	public String addressedto2;
	public String addressedto3;
	public String addressedto4;
	public String invoiceNo;
	public String date;
	public String orderNo;
	public String orderDate;
	public String contactName;
	public String mobileNo;
	public String hsnOrSac;
	public String rate;
	public String amtInwrd1;
	public String amtInwrd2;
	public String cGst;
	public String total;
	public String gstNo;
	public String emailAddress;
	public String projectName;
	public int projectId;
	public String invoiceType;
	public String miscChargesDesc;
	public String miscCharges;
	public String taxInvoiceDate;

	public TaxInvoiceDetails() {

	}

	public TaxInvoiceDetails(String taxInvoiceNo, String addressedto1, String addressedto2, String addressedto3,
			String addressedto4, String invoiceNo, String date, String orderNo, String orderDate, String contactName,
			String mobileNo, String hsnOrSac, String rate, String amtInwrd1, String amtInwrd2, String cGst,
			String total, String gstNo, String emailAddress, String projectName, int projectId, String invoiceType,
			String taxInvoiceDate, String miscChargesDesc, String miscCharges) {
		super();
		this.taxInvoiceNo = taxInvoiceNo;
		this.addressedto1 = addressedto1;
		this.addressedto2 = addressedto2;
		this.addressedto3 = addressedto3;
		this.addressedto4 = addressedto4;
		this.invoiceNo = invoiceNo;
		this.date = date;
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.contactName = contactName;
		this.mobileNo = mobileNo;
		this.hsnOrSac = hsnOrSac;
		this.rate = rate;
		this.amtInwrd1 = amtInwrd1;
		this.amtInwrd2 = amtInwrd2;
		this.cGst = cGst;
		this.total = total;
		this.gstNo = gstNo;
		this.emailAddress = emailAddress;
		this.projectName = projectName;
		this.projectId = projectId;
		this.invoiceType = invoiceType;
		this.taxInvoiceDate = taxInvoiceDate;
		this.miscChargesDesc = miscChargesDesc;
		this.miscCharges = miscCharges;
	}

	public String getTaxInvoiceNo() {
		return taxInvoiceNo;
	}

	public void setTaxInvoiceNo(String taxInvoiceNo) {
		this.taxInvoiceNo = taxInvoiceNo;
	}

	public String getAddressedto1() {
		return addressedto1;
	}

	public void setAddressedto1(String addressedto1) {
		this.addressedto1 = addressedto1;
	}

	public String getAddressedto2() {
		return addressedto2;
	}

	public void setAddressedto2(String addressedto2) {
		this.addressedto2 = addressedto2;
	}

	public String getAddressedto3() {
		return addressedto3;
	}

	public void setAddressedto3(String addressedto3) {
		this.addressedto3 = addressedto3;
	}

	public String getAddressedto4() {
		return addressedto4;
	}

	public void setAddressedto4(String addressedto4) {
		this.addressedto4 = addressedto4;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getHsnOrSac() {
		return hsnOrSac;
	}

	public void setHsnOrSac(String hsnOrSac) {
		this.hsnOrSac = hsnOrSac;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getAmtInwrd1() {
		return amtInwrd1;
	}

	public void setAmtInwrd1(String amtInwrd1) {
		this.amtInwrd1 = amtInwrd1;
	}

	public String getAmtInwrd2() {
		return amtInwrd2;
	}

	public void setAmtInwrd2(String amtInwrd2) {
		this.amtInwrd2 = amtInwrd2;
	}

	public String getcGst() {
		return cGst;
	}

	public void setcGst(String cGst) {
		this.cGst = cGst;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getMiscChargesDesc() {
		return miscChargesDesc;
	}

	public void setMiscChargesDesc(String miscChargesDesc) {
		this.miscChargesDesc = miscChargesDesc;
	}

	public String getMiscCharges() {
		return miscCharges;
	}

	public void setMiscCharges(String miscCharges) {
		this.miscCharges = miscCharges;
	}

	public String getTaxInvoiceDate() {
		return taxInvoiceDate;
	}

	public void setTaxInvoiceDate(String taxInvoiceDate) {
		this.taxInvoiceDate = taxInvoiceDate;
	}

}
