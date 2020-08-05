package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOQLineData")
public class BOQLineData {

	@Id
	private String id;
	
	private String material;
	private String inventoryName;
	private String stdLine;
	private String specLine;
	private String grdLine;
	private String endsLine;
	private String makesLine;
	private String category;
	
	public BOQLineData()
	{}	
	
	public BOQLineData(String material, String stdLine, String specLine, String grdLine, String endsLine, String makesLine, String inventoryName, String category) {
		super();
		this.material = material;
		this.stdLine = stdLine;
		this.specLine = specLine;
		this.grdLine = grdLine;
		this.endsLine = endsLine;
		this.makesLine = makesLine;
		this.inventoryName = inventoryName;
		this.category = category;
	}
	
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}	
	public String getStdLine() {
		return stdLine;
	}
	public void setStdLine(String stdLine) {
		this.stdLine = stdLine;
	}
	public String getSpecLine() {
		return specLine;
	}
	public void setSpecLine(String specLine) {
		this.specLine = specLine;
	}
	public String getGrdLine() {
		return grdLine;
	}
	public void setGrdLine(String grdLine) {
		this.grdLine = grdLine;
	}
	public String getEndsLine() {
		return endsLine;
	}
	public void setEndsLine(String endsLine) {
		this.endsLine = endsLine;
	}
	public String getMakesLine() {
		return makesLine;
	}
	public void setMakesLine(String makesLine) {
		this.makesLine = makesLine;
	}
	
    public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isSameEntry(BOQLineData obj1, BOQLineData obj2) {
	boolean isEqual = false;

	if (obj1.getStdLine().equalsIgnoreCase(obj2.getStdLine())
		&& obj1.getEndsLine().equalsIgnoreCase(obj2.getEndsLine())
		&& obj1.getGrdLine().equalsIgnoreCase(obj2.getGrdLine())
		&& obj1.getMakesLine().equalsIgnoreCase(obj2.getMakesLine())
		&& obj1.getMaterial().equalsIgnoreCase(obj2.getMaterial())
		&& obj1.getSpecLine().equalsIgnoreCase(obj2.getSpecLine())
		&& obj1.getInventoryName().equalsIgnoreCase(obj2.getInventoryName())
		&& obj1.getCategory().equalsIgnoreCase(obj2.getCategory())) {
	    isEqual = true;
	}

	return isEqual;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BOQLineData other = (BOQLineData) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (endsLine == null) {
			if (other.endsLine != null)
				return false;
		} else if (!endsLine.equals(other.endsLine))
			return false;
		if (grdLine == null) {
			if (other.grdLine != null)
				return false;
		} else if (!grdLine.equals(other.grdLine))
			return false;
		if (inventoryName == null) {
			if (other.inventoryName != null)
				return false;
		} else if (!inventoryName.equals(other.inventoryName))
			return false;
		if (makesLine == null) {
			if (other.makesLine != null)
				return false;
		} else if (!makesLine.equals(other.makesLine))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (specLine == null) {
			if (other.specLine != null)
				return false;
		} else if (!specLine.equals(other.specLine))
			return false;
		if (stdLine == null) {
			if (other.stdLine != null)
				return false;
		} else if (!stdLine.equals(other.stdLine))
			return false;
		return true;
	}
       
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((endsLine == null) ? 0 : endsLine.hashCode());
		result = prime * result + ((grdLine == null) ? 0 : grdLine.hashCode());
		result = prime * result + ((inventoryName == null) ? 0 : inventoryName.hashCode());
		result = prime * result + ((makesLine == null) ? 0 : makesLine.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((specLine == null) ? 0 : specLine.hashCode());
		result = prime * result + ((stdLine == null) ? 0 : stdLine.hashCode());
		return result;
	}
}
