package com.projectmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projectmanager.interfaces.BOQData;
import org.jetbrains.annotations.Nullable;

@Entity
@Embeddable
@Table(name = "inventory")
public class Inventory implements Serializable, BOQData {

	@Id
	private int inventoryRowId;

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

	public Inventory(InventorySpec inventorySpec, String purchaseRate, int quantity, String location, String invoiceNo,
			String receivedDate) {
		super();
		this.inventorySpec = inventorySpec;
		this.purchaseRate = purchaseRate;
		this.quantity = quantity;
		this.location = location;
		this.invoiceNo = invoiceNo;
		this.receivedDate = receivedDate;
	}

	public Inventory() {

	}

	public int getInventoryRowId() {
		return inventoryRowId;
	}

	public void setInventoryRowId(int inventoryRowId) {
		this.inventoryRowId = inventoryRowId;
	}

	public InventorySpec getInventorySpec() {
		return inventorySpec;
	}

	public void setInventorySpec(InventorySpec inventorySpec) {
		this.inventorySpec = inventorySpec;
	}

	public String getPurchaseRate() {
		return this.purchaseRate;
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

	public Inventory copyObject(Inventory invt) {
		Inventory toBeReturned = new Inventory();

		InventorySpec invSpecToBeReturned = invt.getInventorySpec();
		toBeReturned.setInventorySpec(invSpecToBeReturned);
		toBeReturned.setLocation(invt.getLocation());
		toBeReturned.setPurchaseRate(invt.getPurchaseRate());
		toBeReturned.setQuantity(invt.getQuantity());

		return toBeReturned;
	}

	@Override
	public String toString() {
		return "Inventory [inventorySpec=" + inventorySpec + ", inventoryRowId=" + inventoryRowId + ", purchaseRate="
				+ purchaseRate + ", quantity=" + quantity + ", location=" + location + ", invoiceNo=" + invoiceNo
				+ ", receivedDate=" + receivedDate + "]";
	}
}
