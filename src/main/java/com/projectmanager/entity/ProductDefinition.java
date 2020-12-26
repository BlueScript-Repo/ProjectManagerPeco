package com.projectmanager.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductDefinition {

    @EmbeddedId
    private ProductId productId;

    private String classOrSch;
    private String materialSpecs;
    private String standardType;

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public String getClassOrSch() {
        return classOrSch;
    }

    public void setClassOrSch(String classOrSch) {
        this.classOrSch = classOrSch;
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
