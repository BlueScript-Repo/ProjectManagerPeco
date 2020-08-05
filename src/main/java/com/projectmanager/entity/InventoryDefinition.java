package com.projectmanager.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inventorydefinition")
public class InventoryDefinition 
{
	@EmbeddedId
	private InventorySpec inventorySpec;

	public InventoryDefinition() {
	}
}
