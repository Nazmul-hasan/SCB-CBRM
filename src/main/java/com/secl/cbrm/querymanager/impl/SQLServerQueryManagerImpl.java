package com.secl.cbrm.querymanager.impl;

import com.secl.cbrm.querymanager.QueryManager;
import com.secl.cbrm.utils.Table;

public class SQLServerQueryManagerImpl implements QueryManager 
{

	@Override
	public String getLoggedinUserinfo() {
		String sql = "select l.rolejson as roleJSON,l.loginid, l.password, l.status,l.accountNonLocked,r.roleID, r.roledescription as roleDescription, r.menujson as menuJSON,"
				+ " e.employeeid as employeeID,e.name as employeeName,e.imagepath as photoPath"
				+ " from "
				+ Table.LOGIN
				+ " l, "
				+ Table.ROLE
				+ " r, "
				+ Table.EMPLOYEE
				+ " e "
				+ " where l.roleid = r.roleid"
				+ " and l.employeeid = e.employeeid" + " and loginid = ?";

		return sql;
	}

	@Override
	public String getUserinfoByEmailID() {

		String sql = "select l.password, l.email as emailID, l.loginid as username, l.employeeID, e.name as EmployeeName"
				+ ", e.employeeID from "
				+ Table.LOGIN
				+ " l, "
				+ Table.EMPLOYEE
				+ " e where l.email = ? and"
				+ " l.employeeID = e.employeeID ";
		return sql;
	}

	@Override
	public String getAllLoginForEmployee() {
		String sql = "select login.*, employee.gradeid as gradeid from "
				+ Table.LOGIN + " , " + Table.EMPLOYEE
				+ " where login.employeeid = employee.employeeid";

		return sql;
	}

	@Override
	public String getAllLogin() {

		String sql = "select *  from " + Table.LOGIN + "";

		return sql;
	}

	@Override
	public String getAllUsers() {

		String sql = "select * from " + Table.LOGIN + "";
		return sql;
	}

	@Override
	public String getAllEmployeeAsuser() {
		String sql = "select * from " + Table.EMPLOYEE;
		return sql;
	}

	@Override
	public String changeUserStatus(String status) {
		String sql = "UPDATE " + Table.LOGIN + "  SET status ='" + status
				+ "' WHERE loginid= ?";
		return sql;
	}

	@Override
	public String getUserByloginid() {
		String sql = "select * from login where loginid = ?";
		return sql;
	}

	@Override
	public String updateUser(String status, String email, String roleJSON,
			String roleid, String loginid) {
		String sql = "UPDATE " + Table.LOGIN + "  SET status = '" + status
				+ "' , email = '" + email + "' , rolejson = '" + roleJSON
				+ "', roleid = '" + roleid + "' WHERE loginid= '" + loginid
				+ "' ";
		return sql;
	}
	
	@Override
	public String saveBranch() {
		String sql=" INSERT INTO "+Table.Branch+" (oid,name,address) values(?,?,?) ";
		return sql;
	}

	@Override
	public String updateBranch() {
		String sql=" update "+Table.Branch+" set name=?, address=? where oid=? ";
		return sql;
	}

	@Override
	public String getAllBranch() {
		String sql="select * from "+Table.Branch+" ";
		return sql;
	}

	@Override
	public String deleteBranch() {
		String sql="delete from "+Table.Branch+" where oid=?";
		return sql;
	}

	@Override
	public String getBranchByOid() {
		String sql="select * from "+Table.Branch+" where oid=?";
		return sql;
	}
	
	
	// code by salman
	
	@Override
	public String saveTest() {
		String sql=" INSERT INTO Test (oid,name,description) values(?,?,?) ";
		return sql;
	}

	@Override
	public String updateTest() {
		String sql=" UPDATE Test set name=?, description=? where oid=? ";
		return sql;
	}

	@Override
	public String getAllTest() {
		String sql="SELECT * FROM Test";
		return sql;
	}

	@Override
	public String deleteTest() {
		String sql="DELETE FROM Test WHERE oid=?";
		return sql;
	}

	@Override
	public String getTestByOid() {
		String sql="SELECT * FROM Test WHERE oid=?";
		return sql;
	}
	
	// code by marjan
	
	@Override
	public String saveSectorCode() {
		String sql=" INSERT INTO SectorCode (oid,value,description) values(?,?,?) ";
		return sql;
	}
	
	@Override
	public String getAllSectorCode() {
		String sql="select * from sectorCode";
		return sql;
	}
	
	@Override
	public String getSectorCodeByOid() {
		String sql="select * from sectorCode where oid=?";
		return sql;
	}
	
	@Override
	public String saveScbBranch() {
		String sql=" INSERT INTO ScbBranch (oid,brCode,brName,brAddress,brCodeForClRpt,division,bbBrCode,bbBrCodeForClRpt,createdOn,createdBy,editedOn,editedBy) values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		return sql;
	}

	@Override
	public String updateScbBranch() {
		String sql=" update ScbBranch set brCode=?, brName=? brAddress=? brCodeForClRpt=? division=? bbBrCode=? bbBrCodeForClRpt=? createdOn=? createdBy=? editedOn=? editedBy=?  where oid=? ";
		return sql;
	}

	@Override
	public String getAllScbBranch() {
		String sql="select * from ScbBranch";
		return sql;
	}

	@Override
	public String deleteScbBranch() {
		String sql="delete from ScbBranch where oid=?";
		return sql;
	}

	@Override
	public String getScbBranchByOid() {
		String sql="select * from ScbBranch where oid=?";
		return sql;
	}


	@Override
	public String bddb2BatchUpload() {
		
		String sql = "Insert into "
				+ Table.BDDB2
				+ " (BR,MASTER_ID,NAME,FULLNO,CCY,LBAL,LBALFLAG,OPEN_DATE,ACLAS,CRIND,CRATE,DRIND,DRATE,LF,CACFLG,REF,REJ,SF,NXTDATE,ODLIMIT, "
				+ " LIMFLAG,EXP_DATE,FDMAT,STAFF,DORMANT,DRDTLAST,CRDTLAST,MGMCODE,SEG,PRD,BDTEQUIV,BDTFLAG,CRINTBASIS,TERM,DTFDROLL,STATCODE, "
				+ " SUPFLAG,INTACTYPE,CRINTDUE,BLANK0,CRINTACNO,DRINTDUE,BLANK1,DRINTACNO,CRTURNHALFYR,DRTURNHALFYR,CRT,TAX,AVERAGEBAL,AVERAGEFLG,AVBPRECAL,AVBPREFLG," 
				+ " XRATE,WDAY,FDNPI,TIN,TFACC,MINITRANS,DRLATXNDT,CRLATXNDT,INTPP,NOTXNHYR,NODRTPRIOD,INTP,TRNACCNO,DRINTBASIS,RBAL,BALFLAG,AVGQTRBAL," 
				+ " AVGMONBAL,InSuspFlag,FTPRate,createdOn,createdBy) "
				+ " Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return sql;
		
	}

	@Override
	public String getLoginInfoByLoginId() {
		String sql="select * from login where loginId=?";
		return sql;
	}

	@Override
	public String insertUserAttempts() {
		String sql="insert into userAttempts(oid,loginId,attempts,createdOn,createdBy) values(?,?,?,?,?)";
		return sql;
	}

	@Override
	public String updateUserAttempts() {
		String sql="update  userAttempts set attempts=? where loginId=?";
		return sql;
	}

	@Override
	public String getAttempedUserByLoginId() {
		String sql="select * from userAttempts where loginId=?";
		return sql;
	}

	@Override
	public String getAttempts() {
		String sql="SELECT attempts FROM userAttempts WHERE loginId = ?";
		return sql;
	}

	@Override
	public String updateAccount() {
		String sql="Update login set accountNonLocked=0 where loginId = ?";	
		return sql;
	}

	@Override
	public String updatetFailAttempts() {
		String sql="update  userAttempts set attempts=? where loginId=?";
		return sql;
	}

}



