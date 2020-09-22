package com.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class DesignOffer
{
    @Id
    String docNumber;

    String contactName;
    String clientCompany ;
    String address ;
    String city ;
    String pinCode ;
    String subject ;
    String utility ;
    String lineItemMainDesc;

    @Column(columnDefinition = "Text")
    String scope;
    @Column(columnDefinition = "Text")
    String deliverables;
    @Column(columnDefinition = "Text")
    String delivery ;
    @Column(columnDefinition = "Text")
    String payTerm ;
    @Column(columnDefinition = "Text")
    String lineItemDesc;
    @Column(columnDefinition = "Text")
    String lineItemQty ;
    @Column(columnDefinition = "Text")
    String lineItemRate ;
    @Column(columnDefinition = "Text")
    String termsAndCondition;
    @Column(columnDefinition = "Text")
    String validity;

    Date creationDate;

    String projectId;

    public DesignOffer()
    {

    }

    public DesignOffer(String docNumber, String contactName, String clientCompany, String address, String city, String pinCode, String subject, String utility, String lineItemMainDesc, String scope, String deliverables, String delivery, String payTerm, String lineItemDesc, String lineItemQty, String lineItemRate, String termsAndCondition, String validity, Date creationDate, String projectId)
    {
        this.docNumber = docNumber;
        this.contactName = contactName;
        this.clientCompany = clientCompany;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.subject = subject;
        this.utility = utility;
        this.lineItemMainDesc = lineItemMainDesc;
        this.scope = scope;
        this.deliverables = deliverables;
        this.delivery = delivery;
        this.payTerm = payTerm;
        this.lineItemDesc = lineItemDesc;
        this.lineItemQty = lineItemQty;
        this.lineItemRate = lineItemRate;
        this.termsAndCondition = termsAndCondition;
        this.validity = validity;
        this.creationDate = creationDate;
        this.projectId = projectId;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    public String getLineItemMainDesc() {
        return lineItemMainDesc;
    }

    public void setLineItemMainDesc(String lineItemMainDesc) {
        this.lineItemMainDesc = lineItemMainDesc;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPayTerm() {
        return payTerm;
    }

    public void setPayTerm(String payTerm) {
        this.payTerm = payTerm;
    }

    public String getLineItemDesc() {
        return lineItemDesc;
    }

    public void setLineItemDesc(String lineItemDesc) {
        this.lineItemDesc = lineItemDesc;
    }

    public String getLineItemQty() {
        return lineItemQty;
    }

    public void setLineItemQty(String lineItemQty) {
        this.lineItemQty = lineItemQty;
    }

    public String getLineItemRate() {
        return lineItemRate;
    }

    public void setLineItemRate(String lineItemRate) {
        this.lineItemRate = lineItemRate;
    }

    public String getTermsAndCondition() {
        return termsAndCondition;
    }

    public void setTermsAndCondition(String termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}
