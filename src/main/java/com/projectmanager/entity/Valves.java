package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valves {

	@Id
	
	private int id;
	
	private String model;
	private String material;
	private String end;
	private String type;
	private String pressureRatings;
	private String sizeRange;
	private String maxInletPressure;
	private String operation;
	private String seatAndSeals;
	
	public Valves()
	{
		
	}
	
	public Valves(int id, String model, String material, String end, String type, String pressureRatings,
			String sizeRange, String maxInletPressure, String operation, String seatAndSeals) {
		super();
		this.id = id;
		this.model = model;
		this.material = material;
		this.end = end;
		this.type = type;
		this.pressureRatings = pressureRatings;
		this.sizeRange = sizeRange;
		this.maxInletPressure = maxInletPressure;
		this.operation = operation;
		this.seatAndSeals = seatAndSeals;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPressureRatings() {
		return pressureRatings;
	}
	public void setPressureRatings(String pressureRatings) {
		this.pressureRatings = pressureRatings;
	}
	public String getSizeRange() {
		return sizeRange;
	}
	public void setSizeRange(String sizeRange) {
		this.sizeRange = sizeRange;
	}
	public String getMaxInletPressure() {
		return maxInletPressure;
	}
	public void setMaxInletPressure(String maxInletPressure) {
		this.maxInletPressure = maxInletPressure;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getSeatAndSeals() {
		return seatAndSeals;
	}
	public void setSeatAndSeals(String seatAndSeals) {
		this.seatAndSeals = seatAndSeals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((maxInletPressure == null) ? 0 : maxInletPressure.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((pressureRatings == null) ? 0 : pressureRatings.hashCode());
		result = prime * result + ((seatAndSeals == null) ? 0 : seatAndSeals.hashCode());
		result = prime * result + ((sizeRange == null) ? 0 : sizeRange.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valves other = (Valves) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (maxInletPressure == null) {
			if (other.maxInletPressure != null)
				return false;
		} else if (!maxInletPressure.equals(other.maxInletPressure))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (pressureRatings == null) {
			if (other.pressureRatings != null)
				return false;
		} else if (!pressureRatings.equals(other.pressureRatings))
			return false;
		if (seatAndSeals == null) {
			if (other.seatAndSeals != null)
				return false;
		} else if (!seatAndSeals.equals(other.seatAndSeals))
			return false;
		if (sizeRange == null) {
			if (other.sizeRange != null)
				return false;
		} else if (!sizeRange.equals(other.sizeRange))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}	
}
