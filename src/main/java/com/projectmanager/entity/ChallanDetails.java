package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class ChallanDetails {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cId;
    
    private String projectId;
    private int inventoryRowId;
    private String poNo;
    private String poDate;
    private String receivedFrom;
    private String consignee;
    private String transportMode;
    private String lrNumber;
    private String vheicleNumber;
    private String gstNo;

    public ChallanDetails() {

    }

    public ChallanDetails(String poNo, String poDate, String receivedFrom, String consignee, String transportMode,
	    String lrNumberDate, String vheicleNumber, String gstNo, String projectId) {
	super();
	this.poNo = poNo;
	this.poDate = poDate;
	this.receivedFrom = receivedFrom;
	this.consignee = consignee;
	this.transportMode = transportMode;
	this.lrNumber = lrNumberDate;
	this.vheicleNumber = vheicleNumber;
	this.gstNo = gstNo;
	this.projectId = projectId;
    }

    
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }    
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getInventoryRowId() {
        return inventoryRowId;
    }

    public void setInventoryRowId(int inventoryRowId) {
        this.inventoryRowId = inventoryRowId;
    }

    public String getPoNo() {
	return poNo;
    }

    public void setPoNo(String poNo) {
	this.poNo = poNo;
    }

    public String getPoDate() {
	return poDate;
    }

    public void setPoDate(String poDate) {
	this.poDate = poDate;
    }

    public String getReceivedFrom() {
	return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
	this.receivedFrom = receivedFrom;
    }

    public String getConsignee() {
	return consignee;
    }

    public void setConsignee(String consignee) {
	this.consignee = consignee;
    }

    public String getTransportMode() {
	return transportMode;
    }

    public void setTransportMode(String transportMode) {
	this.transportMode = transportMode;
    }

    public String getLrNumberDate() {
	return lrNumber;
    }

    public void setLrNumberDate(String lrNumberDate) {
	this.lrNumber = lrNumberDate;
    }

    public String getVheicleNumber() {
	return vheicleNumber;
    }

    public void setVheicleNumber(String vheicleNumber) {
	this.vheicleNumber = vheicleNumber;
    }

    public String getGstNo() {
	return gstNo;
    }

    public void setGstNo(String gstNo) {
	this.gstNo = gstNo;
    }

}
