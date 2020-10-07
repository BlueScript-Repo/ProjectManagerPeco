package com.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projectmanager.interfaces.BOQData;

@Entity
public class InventoryMuster{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	

	private String challanNo;
	private String inventoryName;
	private String material;
	private String type;
	private String manifMethod;
	private String gradeOrClass;
	private String size;
	private String ends;
	private String receiveDate;
	private String assignedProject;
	private String location;
	private int quantity;
	private String consignee;
	private String invoiceNo;
	private String materialSpecs;
	
	
	
	public InventoryMuster(String challanNo, String inventoryName,
			String material, String type, String manifMethod,
			String gradeOrClass, String size, String ends, String receiveDate,
			String assignedProject, String location, int quantity,
			String consignee, String invoiceNo, String materialSpecs) {
		super();
		this.challanNo = challanNo;
		this.inventoryName = inventoryName;
		this.material = material;
		this.type = type;
		this.manifMethod = manifMethod;
		this.gradeOrClass = gradeOrClass;
		this.size = size;
		this.ends = ends;
		this.receiveDate = receiveDate;
		this.assignedProject = assignedProject;
		this.location = location;
		this.quantity = quantity;
		this.consignee = consignee;
		this.invoiceNo = invoiceNo;
		this.materialSpecs = materialSpecs;
	}
	
	
	public String getMaterialSpecs() {
		return materialSpecs;
	}


	public void setMaterialSpecs(String materialSpecs) {
		this.materialSpecs = materialSpecs;
	}


	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getManifMethod() {
		return manifMethod;
	}
	public void setManifMethod(String manifMethod) {
		this.manifMethod = manifMethod;
	}
	public String getGradeOrClass() {
		return gradeOrClass;
	}
	public void setGradeOrClass(String gradeOrClass) {
		this.gradeOrClass = gradeOrClass;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getEnds() {
		return ends;
	}
	public void setEnds(String ends) {
		this.ends = ends;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getAssignedProject() {
		return assignedProject;
	}
	public void setAssignedProject(String assignedProject) {
		this.assignedProject = assignedProject;
	}
	
	public InventoryMuster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getChallanNo() {
		return challanNo;
	}
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	
	
			
}
