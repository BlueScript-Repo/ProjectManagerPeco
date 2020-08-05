package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VendorDetails 
{
    @Id
    private String vendorName;
    private String vendorAddress;
    private String contactName;
    private String contactEmail;
    private String contactNumber;
    
    @Override
    public String toString() {
	return "VendorDetails [vendorName=" + vendorName + ": vendorAddress=" + vendorAddress + ": contactName="
		+ contactName + ": contactEmail=" + contactEmail + ": contactNumber=" + contactNumber + "]";
    }

    public VendorDetails()
    {
	
    }
    
    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    public String getVendorAddress() {
        return vendorAddress;
    }
    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }    
}
