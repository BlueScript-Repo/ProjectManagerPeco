package com.projectmanager.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class InventoryDefinition 
{
	@EmbeddedId
	private InventorySpec inventorySpec;

	public InventoryDefinition() {
	}
}
