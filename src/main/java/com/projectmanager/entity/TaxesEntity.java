package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxes")
public class TaxesEntity {
	@Id
	int id;
	
	private int cGst;
	private int sGst;
	private int iGst;
	
	
	public TaxesEntity() {
	
	}
	
	
	public TaxesEntity(int cGst, int sGst, int iGst) {
		super();
		this.cGst = cGst;
		this.sGst = sGst;
		this.iGst = iGst;
	}
	
	
	public int getcGst() {
		return cGst;
	}
	public void setcGst(int cGst) {
		this.cGst = cGst;
	}
	public int getsGst() {
		return sGst;
	}
	public void setsGst(int sGst) {
		this.sGst = sGst;
	}
	public int getiGst() {
		return iGst;
	}
	public void setiGst(int iGst) {
		this.iGst = iGst;
	}
	
	

}
