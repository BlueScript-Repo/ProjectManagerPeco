package com.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.jetbrains.annotations.Nullable;

@Entity
public class ReceivedInventory {

	@EmbeddedId
	private InventorySpec inventorySpec;

	@Column(name = "purchaseRate")
	private String purchaseRate;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "location")
	private String location;

	@Nullable
	private String invoiceNo;

	private String receivedDate;
	
	public ReceivedInventory()
	{
		
	}
	
	public ReceivedInventory(InventorySpec inventorySpec, String purchaseRate, int quantity,
			String location, String invoiceNo, String receivedDate) {
		super();
		this.inventorySpec = inventorySpec;
		this.purchaseRate = purchaseRate;
		this.quantity = quantity;
		this.location = location;
		this.invoiceNo = invoiceNo;
		this.receivedDate = receivedDate;
	}

	public InventorySpec getInventorySpec() {
		return inventorySpec;
	}

	public void setInventorySpec(InventorySpec inventorySpec) {
		this.inventorySpec = inventorySpec;
	}

	public String getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(String purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
