package com.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOQDetails")
public class BOQDetails {

	String projectId;
	String boqName;
	String quotationName;
	String inventoryName;
	String material;
	String type;
	String manifacturingMethod;
	String classOrGrade;
	String ends;
	String size;
	String quantity;
	String baseSupplyRate;
	String supplyRate;
	String baseErectionRate;
	String erectionRate;
	String supplyAmount;
	String erectionAmount;
	String sheetName;

	public BOQDetails()
	{
		
	}

	public BOQDetails(String projectId, String boqName, String inventoryName, String material, String type,
			String manifacturingMethod, String classOrGrade, String ends, String size, String quantity,
			String supplyRate, String erectionRate, String supplyAmount, String erectionAmount,
			String baseErectionRate, String baseSupplyRate, String sheetName) {
		super();
		this.projectId = projectId;
		this.boqName = boqName;
		this.inventoryName = inventoryName;
		this.material = material;
		this.type = type;
		this.manifacturingMethod = manifacturingMethod;
		this.classOrGrade = classOrGrade;
		this.ends = ends;
		this.size = size;
		this.quantity = quantity;
		this.supplyRate = supplyRate;
		this.erectionRate = erectionRate;
		this.supplyAmount = supplyAmount;
		this.erectionAmount = erectionAmount;
		this.baseErectionRate = baseErectionRate;
		this.baseSupplyRate = baseSupplyRate;
		this.sheetName = sheetName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

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

	public String getBoqName() {
		return boqName;
	}

	public void setBoqName(String boqName) {
		this.boqName = boqName;
	}

	public String getOfferName() {
		return quotationName;
	}

	public void setOfferName(String offerName) {
		this.quotationName = offerName;
	}
	
	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
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

	public String getManifacturingMethod() {
		return manifacturingMethod;
	}

	public void setManifacturingMethod(String manifacturingMethod) {
		this.manifacturingMethod = manifacturingMethod;
	}

	public String getClassOrGrade() {
		return classOrGrade;
	}

	public void setClassOrGrade(String classOrGrade) {
		this.classOrGrade = classOrGrade;
	}

	public String getEnds() {
		return ends;
	}

	public void setEnds(String ends) {
		this.ends = ends;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSupplyRate() {
		return supplyRate;
	}

	public void setSupplyRate(String supplyRate) {
		this.supplyRate = supplyRate;
	}

	public String getErectionRate() {
		return erectionRate;
	}

	public void setErectionRate(String erectionRate) {
		this.erectionRate = erectionRate;
	}

	public String getSupplyAmount() {
		return supplyAmount;
	}

	public void setSupplyAmount(String supplyAmount) {
		this.supplyAmount = supplyAmount;
	}

	public String getErectionAmount() {
		return erectionAmount;
	}

	public void setErectionAmount(String erectionAmount) {
		this.erectionAmount = erectionAmount;
	}

	public String getQuotationName() {
	    return quotationName;
	}

	public void setQuotationName(String quotationName) {
	    this.quotationName = quotationName;
	}

	public String getBaseSupplyRate() {
	    return baseSupplyRate;
	}

	public void setBaseSupplyRate(String baseSupplyRate) {
	    this.baseSupplyRate = baseSupplyRate;
	}

	public String getBaseErectionRate() {
	    return baseErectionRate;
	}

	public void setBaseErectionRate(String baseErectionRate) {
	    this.baseErectionRate = baseErectionRate;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	
	
	
}
