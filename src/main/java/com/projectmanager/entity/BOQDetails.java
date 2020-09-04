package com.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BOQDetails {

	String projectId;
	String boqName;
	String quotationName;
	String inventoryName;
	String material;
	String type;
	String manufacturingMethod;
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
	String materialSpecs;
	String standardType;

	public BOQDetails()
	{
		
	}

	public BOQDetails(String projectId, String boqName, String inventoryName, String material, String type,
			String manufacturingMethod, String classOrGrade, String ends, String size, String quantity,
			String supplyRate, String erectionRate, String supplyAmount, String erectionAmount,
			String baseErectionRate, String baseSupplyRate, String sheetName, String materialSpecs, String standardType) {
		super();
		this.projectId = projectId;
		this.boqName = boqName;
		this.inventoryName = inventoryName;
		this.material = material;
		this.type = type;
		this.manufacturingMethod = manufacturingMethod;
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
		this.materialSpecs = materialSpecs;
		this.standardType = standardType;
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

	public String getManufacturingMethod() {
		return manufacturingMethod;
	}

	public void setManufacturingMethod(String manufacturingMethod) {
		this.manufacturingMethod = manufacturingMethod;
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

	public String getMaterialSpecs() {
		return materialSpecs;
	}

	public void setMaterialSpecs(String materialSpecs) {
		this.materialSpecs = materialSpecs;
	}

	public String getStandardType() {
		return standardType;
	}

	public void setStandardType(String standardType) {
		this.standardType = standardType;
	}
}
