package com.secl.cbrm.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginBean implements Serializable {

	private String loginId;
	private String roleID;
	private String roleType;
	private String password;
	private String sessionId;
	private String operation;
	private String gradeID;
	private String name;
	private String status;
	private String roleDescription;
	private String menuJSON;
	private String employeeID;
	private String employeeName;
	private String photoPath;

	private String newPassword;
	private String confirmPassword;

	private String username;
	private String emailID;

	private String ipAddress;

	private String[] roleJSON;
	
	private String roles;

	private String primaryRole;
	private String secondaryRole;

	private String oldPassword;
	private String switchPassword;
	
	private String[] mailJSON;
	
	private String itemName;
	private String releaseDate;
	private String IntervalDay;
	private String changeFromPreviousVersion;
	private String version;
	private String decrypted;
	
	private boolean accountNonLocked; 
	private boolean accountNonExpired ;
	private boolean passwordNonExpired; 
	private String passwordHistory; 
	
	public String getGradeID() {
		return gradeID;
	}

	public void setGradeID(String gradeID) {
		this.gradeID = gradeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getMailJSON() {
		return mailJSON;
	}

	public void setMailJSON(String[] mailJSON) {
		this.mailJSON = mailJSON;
	}

	public String getSwitchPassword() {
		return switchPassword;
	}

	public void setSwitchPassword(String switchPassword) {
		this.switchPassword = switchPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPrimaryRole() {
		return primaryRole;
	}

	public void setPrimaryRole(String primaryRole) {
		this.primaryRole = primaryRole;
	}

	public String[] getRoleJSON() {
		return roleJSON;
	}

	public void setRoleJSON(String[] roleJSON) {
		this.roleJSON = roleJSON;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getMenuJSON() {
		return menuJSON;
	}

	public void setMenuJSON(String menuJSON) {
		this.menuJSON = menuJSON;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSecondaryRole() {
		return secondaryRole;
	}

	public void setSecondaryRole(String secondaryRole) {
		this.secondaryRole = secondaryRole;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getIntervalDay() {
		return IntervalDay;
	}

	public void setIntervalDay(String intervalDay) {
		IntervalDay = intervalDay;
	}

	public String getChangeFromPreviousVersion() {
		return changeFromPreviousVersion;
	}

	public void setChangeFromPreviousVersion(String changeFromPreviousVersion) {
		this.changeFromPreviousVersion = changeFromPreviousVersion;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getDecrypted() {
		return decrypted;
	}

	public void setDecrypted(String decrypted) {
		this.decrypted = decrypted;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isPasswordNonExpired() {
		return passwordNonExpired;
	}

	public void setPasswordNonExpired(boolean passwordNonExpired) {
		this.passwordNonExpired = passwordNonExpired;
	}

	public String getPasswordHistory() {
		return passwordHistory;
	}

	public void setPasswordHistory(String passwordHistory) {
		this.passwordHistory = passwordHistory;
	}
	

}
