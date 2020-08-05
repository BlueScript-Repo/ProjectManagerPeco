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
"inventoryName",
"material",
"type",
"classOrGrade",
"catogory"
})
public class InventoryMappingModel {

@JsonProperty("item_id")
private String itemId;
@JsonProperty("inventoryName")
private String inventoryName;
@JsonProperty("material")
private String material;
@JsonProperty("type")
private String type;
@JsonProperty("classOrGrade")
private String classOrGrade;
@JsonProperty("catogory")
private String catogory;
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

@JsonProperty("inventoryName")
public String getInventoryName() {
return inventoryName;
}

@JsonProperty("inventoryName")
public void setInventoryName(String inventoryName) {
this.inventoryName = inventoryName;
}

@JsonProperty("material")
public String getMaterial() {
return material;
}

@JsonProperty("material")
public void setMaterial(String material) {
this.material = material;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("classOrGrade")
public String getClassOrGrade() {
return classOrGrade;
}

@JsonProperty("classOrGrade")
public void setClassOrGrade(String classOrGrade) {
this.classOrGrade = classOrGrade;
}

@JsonProperty("catogory")
public String getCatogory() {
return catogory;
}

@JsonProperty("catogory")
public void setCatogory(String catogory) {
this.catogory = catogory;
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
