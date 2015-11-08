package com.secl.cbrm.bean;


@SuppressWarnings("serial")
public class ScbBranchBean extends AbstractBean {
	
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
	

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getBrAddress() {
		return brAddress;
	}

	public void setBrAddress(String brAddress) {
		this.brAddress = brAddress;
	}

	public String getBrCodeForClRpt() {
		return brCodeForClRpt;
	}

	public void setBrCodeForClRpt(String brCodeForClRpt) {
		this.brCodeForClRpt = brCodeForClRpt;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getBbBrCode() {
		return bbBrCode;
	}

	public void setBbBrCode(String bbBrCode) {
		this.bbBrCode = bbBrCode;
	}

	public String getBbBrCodeForClRpt() {
		return bbBrCodeForClRpt;
	}

	public void setBbBrCodeForClRpt(String bbBrCodeForClRpt) {
		this.bbBrCodeForClRpt = bbBrCodeForClRpt;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getEditedOn() {
		return editedOn;
	}

	public void setEditedOn(String editedOn) {
		this.editedOn = editedOn;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	@Override
	public String getOperation() {
		return operation;
	}

	@Override
	public void setOperation(String operation) {
		this.operation=operation;
		
	}

	@Override
	public String getOid() {
		return oid;
	}

	@Override
	public void setOid(String oid) {
		this.oid=oid;
		
	}

	@Override
	public LoginBean getLoginBean() {
		return loginBean;
	}

	@Override
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean=loginBean;
		
	}

	
	
}
