package com.secl.cbrm.querymanager;

/**
 * @author nazmul.hasan
 *
 */
public interface QueryManager {

	public String getLoggedinUserinfo();

	public String getUserinfoByEmailID();

	public String getAllLoginForEmployee();

	public String getAllLogin();

	public String getAllUsers();

	public String getAllEmployeeAsuser();
	
	public String getLoginInfoByLoginId();
	
	public String insertUserAttempts();
	
	public String updateUserAttempts();
	
	public String getAttempedUserByLoginId();
	
	public String getAttempts();
	
	public String updateAccount();
	
	public String updatetFailAttempts();

	public String changeUserStatus(String status);

	public String getUserByloginid();

	public String updateUser(String status, String email, String roleJSON,
			String roleid, String loginid);

	public String saveBranch();

	public String updateBranch();

	public String getAllBranch();

	public String deleteBranch();

	public String getBranchByOid();
	
	// code by marjan

	public String saveTest();

	public String updateTest();

	public String getAllTest();

	public String deleteTest();

	public String getTestByOid();

	// code by salman

	public String saveSectorCode();

	public String getAllSectorCode();

	public String getSectorCodeByOid();

	public String saveScbBranch();

	public String updateScbBranch();

	public String getAllScbBranch();

	public String deleteScbBranch();

	public String getScbBranchByOid();

	public String bddb2BatchUpload();

}
