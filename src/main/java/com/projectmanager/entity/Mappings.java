package com.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Mappings {

	@Id
	private int Id;
	
	@Column
	private String inventoryName;
	
	@Column
	private String material;
	
	@Column
	private String type;
	
	@Column
	private String classOrGrade;
	
	@Column
	private String catogory;
	
	
	
	public Mappings() {
		
	}
	public Mappings(int id, String inventoryName, String material, String type,
			String classOrGrade, String catogory) {
		super();
		Id = id;
		this.inventoryName = inventoryName;
		this.material = material;
		this.type = type;
		this.classOrGrade = classOrGrade;
		this.catogory = catogory;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public String getClassOrGrade() {
		return classOrGrade;
	}
	public void setClassOrGrade(String classOrGrade) {
		this.classOrGrade = classOrGrade;
	}
	public String getCatogory() {
		return catogory;
	}
	public void setCatogory(String catogory) {
		this.catogory = catogory;
	}	
}
