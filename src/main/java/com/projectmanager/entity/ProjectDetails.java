package com.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class ProjectDetails 
{
	@Id
	@Column(name = "projectId")
	private int projectId;

	@Column(name = "po_date")
	private String poDate;

	@Column(name = "po_number")
	private String poNumber;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "contact_phone")
	private String contactPhone;

	@Column(name = "contact_email")
	private String contactEmail;

	@Column(name = "gst_number")
	private String gstNumber;

	@Column(name = "address")
	private String address;

	public ProjectDetails() {

	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
	    return "ProjectDetails [projectId=" + projectId + ": poDate=" + poDate + ": poNumber=" + poNumber
		    + ": contactName=" + contactName + ": contactPhone=" + contactPhone + ": contactEmail="
		    + contactEmail + ": gstNumber=" + gstNumber + ": address=" + address + "]";
	}

	
}