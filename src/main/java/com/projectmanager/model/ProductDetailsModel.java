package com.projectmanager.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "item_id",
        "product",
        "materialOfConstruct",
        "constructType",
        "classOrGrade",
        "materialSpec",
        "standardType"
})

public class ProductDetailsModel
{

    @JsonProperty("item_id")
    private String itemId;
    @JsonProperty("product")
    private String product;
    @JsonProperty("materialOfConstruct")
    private String materialOfConstruct;
    @JsonProperty("constructType")
    private String constructType;
    @JsonProperty("classOrGrade")
    private String classOrGrade;
    @JsonProperty("materialSpec")
    private String materialSpec;
    @JsonProperty("standardType")
    private String standardType;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("item_id")
    public String getItemId() {
        return itemId;
    }

    @JsonProperty("item_id")
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
    }
    @JsonProperty("materialOfConstruct")
    public void setMaterialOfConstruct(String materialOfConstruct) {
        this.materialOfConstruct = materialOfConstruct;
    }
    @JsonProperty("constructType")
    public void setConstructType(String constructType) {
        this.constructType = constructType;
    }
    @JsonProperty("classOrGrade")
    public void setClassOrSch(String classOrSch) {
        this.classOrGrade = classOrSch;
    }
    @JsonProperty("materialSpec")
    public void setMaterialSpec(String materialSpec) {
        this.materialSpec = materialSpec;
    }
    @JsonProperty("standardType")
    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }

    public String getProduct() {
        return product;
    }

    public String getMaterialOfConstruct() {
        return materialOfConstruct;
    }

    public String getConstructType() {
        return constructType;
    }

    public String getClassOrSch() {
        return classOrGrade;
    }

    public String getMaterialSpec() {
        return materialSpec;
    }

    public String getStandardType() {
        return standardType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
