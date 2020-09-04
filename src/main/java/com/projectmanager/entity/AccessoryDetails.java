package com.projectmanager.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import org.jetbrains.annotations.Nullable;

@Entity
public class AccessoryDetails implements Serializable {

	@Id
	private int accessoryRowId;

	private String accessoryName;
	private String desc1;
	private String desc2;
	private String desc3;
	private String desc4;
	private String desc5;

	@ColumnDefault("''")
	private String assignedProject;

	private String location;

	private String status;

	private String quantity;

	@Nullable
	private String invoiceNo;

	private String receivedDate;

	public AccessoryDetails() {

	}

	public AccessoryDetails(String accessoryName, String desc1, String desc2, String desc3, String desc4, String desc5,
			String assignedProject, String location, String status, String quantity, String invoiceNo,
			String receivedDate) {
		super();
		this.accessoryName = accessoryName;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.desc4 = desc4;
		this.desc5 = desc5;
		this.assignedProject = assignedProject;
		this.location = location;
		this.status = status;
		this.quantity = quantity;
		this.invoiceNo = invoiceNo;
		this.receivedDate = receivedDate;
	}

	public int getAccessoryRowId() {
		return accessoryRowId;
	}

	public void setAccessoryRowId(int accessoryRowId) {
		this.accessoryRowId = accessoryRowId;
	}

	public String getAccessoryName() {
		return accessoryName;
	}

	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public String getDesc3() {
		return desc3;
	}

	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}

	public String getDesc4() {
		return desc4;
	}

	public void setDesc4(String desc4) {
		this.desc4 = desc4;
	}

	public String getDesc5() {
		return desc5;
	}

	public void setDesc5(String desc5) {
		this.desc5 = desc5;
	}

	public String getAssignedProject() {
		return assignedProject;
	}

	public void setAssignedProject(String assignedProject) {
		this.assignedProject = assignedProject;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

}
