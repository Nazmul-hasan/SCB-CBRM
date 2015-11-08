package com.secl.cbrm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Login")
public class User extends AbstractEntity {
	
 	
	private String loginid;
	private String roleid;
	private String employeeid;
	private String name;
	private String password;
	private String status;
	private String phoneno;
	private String email;
	private String rolejson;
		
	private Date createdOn;	
	private String createdBy;	
	private Date editedOn;	
	private String editedBy;
	
	public User() {
		
		
	}


	public User(String loginid, String roleid,
			String employeeid, String name,
			String password, String status, String phoneno,
			String email, String rolejson,
			Date createdOn, String createdBy, Date editedOn, String editedBy) {
		super();
		
		this.loginid = loginid;
		this.roleid = roleid;
		this.employeeid = employeeid;
		this.name = name;
		this.password = password;
		this.status = status;
		this.phoneno = phoneno;
		this.email = email;
		this.rolejson = rolejson;		
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.editedOn = editedOn;
		this.editedBy = editedBy;
	}

	@Id
	@Column(name = "loginid", nullable = false, length = 64)
	
	public String getLoginid() {
		return loginid;
	}


	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}


	@Column(name = "roleid", nullable = false, length = 64)
	
	public String getRoleid() {
		return roleid;
	}


	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	@Column(name = "employeeid", nullable = true, length = 64)
	public String getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	@Column(name = "name", nullable = true, length = 64)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 64)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "status", nullable = false, length = 64)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "phoneno", nullable = true, length = 64)
	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Column(name = "email", nullable = true, length = 64)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "rolejson", nullable = true, length = 64)
	public String getRolejson() {
		return rolejson;
	}


	public void setRolejson(String rolejson) {
		this.rolejson = rolejson;
	}

	@Column(name = "createdOn", nullable = false, length = 64)
	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "createdBy", nullable = false, length = 64)
	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "editedOn", nullable = true, length = 64)
	public Date getEditedOn() {
		return editedOn;
	}


	public void setEditedOn(Date editedOn) {
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
