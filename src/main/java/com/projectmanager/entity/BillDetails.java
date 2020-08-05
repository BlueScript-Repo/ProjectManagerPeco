package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class BillDetails {

    @Id
    private String billNumber;
    private String billDate;
    private String poNumber;
    private String gstNumber;

    public BillDetails() {

    }

    public BillDetails(String billNumber, String billDate, String poNumber, String gstNumber) {
	super();
	this.billNumber = billNumber;
	this.billDate = billDate;
	this.poNumber = poNumber;
	this.gstNumber = gstNumber;
    }

    public String getBillNumber() {
	return billNumber;
    }

    public void setBillNumber(String billNumber) {
	this.billNumber = billNumber;
    }

    public String getBillDate() {
	return billDate;
    }

    public void setBillDate(String billDate) {
	this.billDate = billDate;
    }

    public String getPoNumber() {
	return poNumber;
    }

    public void setPoNumber(String poNumber) {
	this.poNumber = poNumber;
    }

    public String getGstNumber() {
	return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
	this.gstNumber = gstNumber;
    }

}
