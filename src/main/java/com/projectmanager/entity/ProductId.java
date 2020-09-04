package com.projectmanager.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductId implements Serializable {

    private String product;
    private String materialOfConstruction;
    private String manufactureMethod;

    public ProductId()
    {

    }

    public ProductId(String product, String materialOfConstruction, String manufactureMethod) {
        this.product = product;
        this.materialOfConstruction = materialOfConstruction;
        this.manufactureMethod = manufactureMethod;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMaterialOfConstruction() {
        return materialOfConstruction;
    }

    public void setMaterialOfConstruction(String materialOfConstruction) {
        this.materialOfConstruction = materialOfConstruction;
    }

    public String getManufactureMethod() {
        return manufactureMethod;
    }

    public void setManufactureMethod(String manufactureMethod) {
        this.manufactureMethod = manufactureMethod;
    }

}
