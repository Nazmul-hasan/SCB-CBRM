package com.secl.cbrm.bean;


@SuppressWarnings("serial")
public class BranchBean extends AbstractBean {
	
	private String name;
	private String address;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
