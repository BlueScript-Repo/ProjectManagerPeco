package com.projectmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class Project implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projectId")
	private int projectId;
		
	@Column(name="project_name", unique=true)
	private String projectName;
	
	@Column(name="project_desc")
	private String projectDesc;
	
	private String companyName;
	
	private String projectNumber;
	
	

	public Project()
	{
		
	}

	public Project(int projectId, String projectName, String projectDesc, String companyName, String projectNumber) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.companyName = companyName;
		this.projectNumber = projectNumber;
	}

	
	
	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getCompanyName() {
	    return companyName;
	}

	public void setCompanyName(String companyName) {
	    this.companyName = companyName;
	}	
}
