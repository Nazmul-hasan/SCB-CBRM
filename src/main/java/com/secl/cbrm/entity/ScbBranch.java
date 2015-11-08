package com.secl.cbrm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ScbBranch")
public class ScbBranch extends AbstractEntity {
	
	private String oid;
	private String brCode;
	private String brName;
	private String brAddress;
	private String brCodeForClRpt;
	private String division;
	private String bbBrCode;
	private String bbBrCodeForClRpt;
	private String createdOn;
	private String createdBy;
	private String editedOn;
	private String editedBy;
	
	@Id
	@Column(name = "oid", nullable = false, length =64)
	public String getOid() {
		return oid;
	}
	
	public void setOid(String oid) {
		this.oid = oid;
	}
	
	@Column(name = "brCode", nullable = true, length = 64)
	public String getBrCode() {
		return brCode;
	}
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}
	
	@Column(name = "brName", nullable = true, length = 64)
	public String getBrName() {
		return brName;
	}
	
	public void setBrName(String brName) {
		this.brName = brName;
	}
	
	@Column(name = "brAddress", nullable = true, length = 64)
	public String getBrAddress() {
		return brAddress;
	}

	public void setBrAddress(String brAddress) {
		this.brAddress = brAddress;
	}

	@Column(name = "brCodeForClRpt", nullable = true, length = 64)
	public String getBrCodeForClRpt() {
		return brCodeForClRpt;
	}

	public void setBrCodeForClRpt(String brCodeForClRpt) {
		this.brCodeForClRpt = brCodeForClRpt;
	}

	@Column(name = "division", nullable = true, length = 64)
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Column(name = "bbBrCode", nullable = true, length = 64)
	public String getBbBrCode() {
		return bbBrCode;
	}

	public void setBbBrCode(String bbBrCode) {
		this.bbBrCode = bbBrCode;
	}

	@Column(name = "bbBrCodeForClRpt", nullable = true, length = 64)
	public String getBbBrCodeForClRpt() {
		return bbBrCodeForClRpt;
	}

	public void setBbBrCodeForClRpt(String bbBrCodeForClRpt) {
		this.bbBrCodeForClRpt = bbBrCodeForClRpt;
	}

	@Column(name = "createdOn", nullable = true, length = 64)
	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "createdBy", nullable = true, length = 64)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "editedOn", nullable = true, length = 64)
	public String getEditedOn() {
		return editedOn;
	}

	public void setEditedOn(String editedOn) {
		this.editedOn = editedOn;
	}

	@Column(name = "editedBy", nullable = true, length = 64)
	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

}
