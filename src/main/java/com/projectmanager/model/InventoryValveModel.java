package com.projectmanager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"item_id",
"model",
"material",
"end",
"type",
"pressureRatings",
"sizeRange",
"maxInletPressure",
"operation",
"seatAndSeals"
})
public class InventoryValveModel {
	
	@JsonProperty("item_id")
	private String itemId;
	@JsonProperty("model")
	private String model;
	@JsonProperty("material")
	private String material;
	@JsonProperty("end")
	private String end;
	@JsonProperty("type")
	private String type;
	@JsonProperty("pressureRatings")
	private String pressureRatings;
	@JsonProperty("sizeRange")
	private String sizeRange;
	@JsonProperty("maxInletPressure")
	private String maxInletPressure;
	@JsonProperty("operation")
	private String operation;
	@JsonProperty("seatAndSeals")
	private String seatAndSeals;
	
	@JsonProperty("item_id")
	public String getItemId() {
		return itemId;
	}
	
	@JsonProperty("item_id")
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	@JsonProperty("model")
	public String getModel() {
		return model;
	}
	
	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}
	
	@JsonProperty("material")
	public String getMaterial() {
		return material;
	}
	
	@JsonProperty("material")
	public void setMaterial(String material) {
		this.material = material;
	}
	
	@JsonProperty("end")
	public String getEnd() {
		return end;
	}
	
	@JsonProperty("end")
	public void setEnd(String end) {
		this.end = end;
	}
	
	@JsonProperty("type")
	public String getType() {
		return type;
	}
	
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
	
	@JsonProperty("pressureRatings")
	public String getPressureRatings() {
		return pressureRatings;
	}
	
	@JsonProperty("pressureRatings")
	public void setPressureRatings(String pressureRatings) {
		this.pressureRatings = pressureRatings;
	}
	
	@JsonProperty("sizeRange")
	public String getSizeRange() {
		return sizeRange;
	}
	
	@JsonProperty("sizeRange")
	public void setSizeRange(String sizeRange) {
		this.sizeRange = sizeRange;
	}
	
	@JsonProperty("maxInletPressure")
	public String getMaxInletPressure() {
		return maxInletPressure;
	}
	
	@JsonProperty("maxInletPressure")
	public void setMaxInletPressure(String maxInletPressure) {
		this.maxInletPressure = maxInletPressure;
	}
	
	@JsonProperty("operation")
	public String getOperation() {
		return operation;
	}
	
	@JsonProperty("operation")
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	@JsonProperty("seatAndSeals")
	public String getSeatAndSeals() {
		return seatAndSeals;
	}
	
	@JsonProperty("seatAndSeals")
	public void setSeatAndSeals(String seatAndSeals) {
		this.seatAndSeals = seatAndSeals;
	}

	
	


}
