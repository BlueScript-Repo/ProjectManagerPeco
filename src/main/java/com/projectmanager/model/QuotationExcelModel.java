package com.projectmanager.model;

public class QuotationExcelModel {

	public QuotationExcelModel(int srNumber, String invetoryName, String description, String quantity,
			int availableQuantity) 
	{
		this.srNumber = srNumber;
		this.invetoryName = invetoryName;
		this.description = description;
		this.quantity = quantity;
		this.availableQuantity = availableQuantity;
	}

	public int getSrNumber() {
		return srNumber;
	}

	public void setSrNumber(int srNumber) {
		this.srNumber = srNumber;
	}

	public String getInvetoryName() {
		return invetoryName;
	}

	public void setInvetoryName(String invetoryName) {
		this.invetoryName = invetoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public int srNumber = 0;
	public String invetoryName = "Invetory Name";
	public String description = "Description";
	public String quantity = "Quantity";
	public int availableQuantity = 0;
}
