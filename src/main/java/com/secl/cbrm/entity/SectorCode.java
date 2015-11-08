package com.secl.cbrm.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "SectorCode")
public class SectorCode extends AbstractEntity {

	private String oid;
	private String value;
	private String description;

	@Id
	@Column(name = "oid", nullable = false, length =64)
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	// TO DO
	@Column(name = "value", nullable = true, length = 64)
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	// TO DO
	@Column(name = "description", nullable = true, length = 64)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
