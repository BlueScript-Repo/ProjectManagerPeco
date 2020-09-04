package com.projectmanager.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductDefinition {

    @EmbeddedId
    private ProductId productId;

    private String classOrGrade;
    private String materialSpecs;
    private String standardType;

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public String getClassOrGrade() {
        return classOrGrade;
    }

    public void setClassOrGrade(String classOrGrade) {
        this.classOrGrade = classOrGrade;
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

    public ProductDefinition()
    {

    }

}
