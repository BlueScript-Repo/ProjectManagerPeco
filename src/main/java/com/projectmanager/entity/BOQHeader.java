package com.projectmanager.entity;

import javax.persistence.*;

import com.projectmanager.interfaces.BOQData;

@Entity
public class BOQHeader implements BOQData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String projectId;
	private String boqName;
	private String client;
	private String site;
	private String project;
	private String dName;
	private String utility;
	private String pressure;
	private String temp;
	private String dNo;
	private String sheetDetails;

	@Column(columnDefinition = "TEXT")
	private String paymentTerms;

	public BOQHeader() {

	}

	public BOQHeader(String projectId, String client, String site, String project, String dName, String utility, String pressure,
			String temp, String dNo, String boqName, String sheetDetails, String paymentTerms) {
		super();
		this.projectId = projectId;
		this.boqName = boqName;
		this.client = client;
		this.site = site;
		this.project = project;
		this.dName = dName;
		this.utility = utility;
		this.pressure = pressure;
		this.temp = temp;
		this.dNo = dNo;
		this.sheetDetails = sheetDetails;
		this.paymentTerms = paymentTerms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getUtility() {
		return utility;
	}

	public void setUtility(String utility) {
		this.utility = utility;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getdNo() {
		return dNo;
	}

	public void setdNo(String dNo) {
		this.dNo = dNo;
	}

	public String getBoqName() {
		return boqName;
	}

	public void setBoqName(String boqName) {
		this.boqName = boqName;
	}

	public String getSheetDetails() {
		return sheetDetails;
	}

	public void setSheetDetails(String sheetDetails) {
		this.sheetDetails = sheetDetails;
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	@Override
	public String toString() {
		return "BOQHeader [id=" + id + ", projectId=" + projectId + ", boqName=" + boqName + ", client=" + client
				+ ", site=" + site + ", project=" + project + ", dName=" + dName + ", utility=" + utility
				+ ", pressure=" + pressure + ", temp=" + temp + ", dNo=" + dNo + ", sheetDetails=" + sheetDetails + "]";
	}
	
}
