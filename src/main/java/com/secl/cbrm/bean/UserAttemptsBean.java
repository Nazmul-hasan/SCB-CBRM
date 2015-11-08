package com.secl.cbrm.bean;

import java.sql.Date;


@SuppressWarnings("serial")
public class UserAttemptsBean extends AbstractBean {
	
	private int attempts;
	private Date createdOn;
	private String createdBy;
	private Date editedOn;
	private String editeddBy;
	
	
	
	
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getEditedOn() {
		return editedOn;
	}

	public void setEditedOn(Date editedOn) {
		this.editedOn = editedOn;
	}

	public String getEditeddBy() {
		return editeddBy;
	}

	public void setEditeddBy(String editeddBy) {
		this.editeddBy = editeddBy;
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
