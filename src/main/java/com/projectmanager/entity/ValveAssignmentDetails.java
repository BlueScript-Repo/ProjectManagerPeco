package com.projectmanager.entity;

import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

public class ValveAssignmentDetails {

	@Id
	private String model;
	@Id
	private String material;
	@Id
	private String end;
	@Id
	private String type;
	@Id
	private String pressureRatings;
	@Id
	private String sizeRange;
	@Id
	private String maxInletPressure;
	@Id
	private String operation;
	@Id
	private String seatAndSeals;
	@Id
	@ColumnDefault("''")
	private String assignedProject;
	@Id
	private String status;
	
	private String location;
	private String quantity;
	
	public ValveAssignmentDetails()
	{
		
	}
	
	public ValveAssignmentDetails(String model, String material, String end, String type, String pressureRatings,
			String sizeRange, String maxInletPressure, String operation, String seatAndSeals, String assignedProject,
			String status, String location, String quantity) {
		super();
		this.model = model;
		this.material = material;
		this.end = end;
		this.type = type;
		this.pressureRatings = pressureRatings;
		this.sizeRange = sizeRange;
		this.maxInletPressure = maxInletPressure;
		this.operation = operation;
		this.seatAndSeals = seatAndSeals;
		this.assignedProject = assignedProject;
		this.status = status;
		this.location = location;
		this.quantity = quantity;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPressureRatings() {
		return pressureRatings;
	}
	public void setPressureRatings(String pressureRatings) {
		this.pressureRatings = pressureRatings;
	}
	public String getSizeRange() {
		return sizeRange;
	}
	public void setSizeRange(String sizeRange) {
		this.sizeRange = sizeRange;
	}
	public String getMaxInletPressure() {
		return maxInletPressure;
	}
	public void setMaxInletPressure(String maxInletPressure) {
		this.maxInletPressure = maxInletPressure;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getSeatAndSeals() {
		return seatAndSeals;
	}
	public void setSeatAndSeals(String seatAndSeals) {
		this.seatAndSeals = seatAndSeals;
	}
	public String getAssignedProject() {
		return assignedProject;
	}
	public void setAssignedProject(String assignedProject) {
		this.assignedProject = assignedProject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
