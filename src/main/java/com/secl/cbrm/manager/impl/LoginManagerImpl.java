package com.secl.cbrm.manager.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.secl.cbrm.bean.LoginBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.bean.UserAttemptsBean;
import com.secl.cbrm.manager.LoginManager;
import com.secl.cbrm.utils.Constant;
import com.secl.cbrm.utils.DateUtil;
import com.secl.cbrm.utils.PasswordCipher;
import com.secl.cbrm.utils.Table;


public class LoginManagerImpl extends ManagerImpl implements LoginManager, Constant {
	
private Logger _logger = Logger.getLogger(this.getClass());	
	
	public ResponseBean login(HttpServletRequest request, ResponseBean responseBean, LoginBean model) {
		
		try {
			
			if(IsValidUser(model)){

				LoginBean loginBean = (LoginBean) springJdbcDao.getObject(queryManager.getLoggedinUserinfo(), new Object[]{model.getLoginId()}, LoginBean.class);
				
				if(loginBean == null)
				{
					responseBean.setMessage("Invalid login ID");
					responseBean.setSuccess(false);
					return responseBean;
				}
				
				if(loginBean.getStatus().equalsIgnoreCase("I"))
				{
					responseBean.setSuccess(false);
					responseBean.setData("invalid");
					_logger.info(loginBean.getEmployeeName()+" (Inactive user) was tried to log in CBRM on : "+DateUtil.getDateStrWithPattern("yyyy-MMM-dd HH:mm:ss", new Date())+" ");
					return responseBean;
				}
				
				if(loginBean.isAccountNonLocked()==false)
				{
					responseBean.setSuccess(false);
					responseBean.setMessage("your Account is Locked");
					_logger.info(loginBean.getEmployeeName()+" (Locked user) was tried to log in CBRM on : "+DateUtil.getDateStrWithPattern("yyyy-MMM-dd HH:mm:ss", new Date())+" ");
					return responseBean;
				}
				
				if(!loginBean.getPassword().equalsIgnoreCase(PasswordCipher.encrypt(model.getPassword())))
				{
					responseBean.setMessage("Invalid Password");
					responseBean.setSuccess(false);
					return responseBean;
				}
				
				_logger.info("Successfully logged in CBRM by : "+loginBean.getEmployeeName()+" on : "+DateUtil.getDateStrWithPattern("yyyy-MMM-dd HH:mm:ss", new Date())+" ");
				loginBean.setSessionId(idGenerator.getSessionId());
				loginBean.setIpAddress(request.getRemoteHost());
				loginBean.setPrimaryRole(loginBean.getRoleID());
				loginBean.setSecondaryRole(loginBean.getRoleID());
				responseBean.setSuccess(true);
				responseBean.setData(loginBean);
				sessionManager.setUserInSession(loginBean);
				saveAccessLog(loginBean, "login");	
			}
			else{
				_logger.error("You Are not A valid user");
			}
			
			
		} catch (Exception e) {
			_logger.error("An exception occurred while login : ", e);
		}
		
		return responseBean;
	}
	
	
	private Boolean IsValidUser(LoginBean model){
		Boolean IsUser=false;
		try {
			LoginBean userLogin = (LoginBean) springJdbcDao.getObject(queryManager.getLoginInfoByLoginId(),new Object[]{model.getLoginId()}, LoginBean.class);
			
			if (userLogin !=null){
				if(!userLogin.getPassword().equalsIgnoreCase(PasswordCipher.encrypt(model.getPassword()))){
					if(!isPreviousAttempts(model)){
						springJdbcDao.saveObject(queryManager.insertUserAttempts(), new Object[]{idGenerator.generateId(),model.getLoginId(),1,new Timestamp(new Date().getTime()),model.getLoginId()});
					}
					else{
						int count=countAttempts(model);						
						springJdbcDao.updateObject(queryManager.updateUserAttempts(), new Object[]{count+1,model.getLoginId()});
					}
					
				}
				else{
					resetFailAttempts(model);
					IsUser=true;
				}
				
			}
			else{
				IsUser=false;
			}
		} catch (Exception e) {
			_logger.error("An exception occurred while Attemp to login : ", e);
		}
		return IsUser;
	}
	
	private boolean isPreviousAttempts(LoginBean model) {

		boolean result = false;		
		try {
			UserAttemptsBean attempts=(UserAttemptsBean) springJdbcDao.getObject(queryManager.getAttempedUserByLoginId(),new Object[]{model.getLoginId()}, UserAttemptsBean.class);
			if(attempts !=null){
				
				result = true;
			}
			
		} catch (Exception e) {
			_logger.error("An exception occurred while get last Attempts user : ", e);
		}

		return result;

}

	private int countAttempts(LoginBean model) {
		int count  = 0;
		int MaxCount=3;
		UserAttemptsBean countAttempts;
		try {
			countAttempts = (UserAttemptsBean) springJdbcDao.getObject(queryManager.getAttempts(),new Object[]{model.getLoginId()}, UserAttemptsBean.class);
		    count =countAttempts.getAttempts();
		    if(count+1>MaxCount){		    		
		    	springJdbcDao.updateObject(queryManager.updateAccount(), new Object[]{model.getLoginId()});
		    	_logger.info("User Account is Locked for : "+model.getLoginId());
		    	
		    }
		} catch (Exception e) {
			_logger.error("An exception occurred while get count User Attempts : ", e);
		}
		
		return count;
	}
	
	private void resetFailAttempts(LoginBean model) {
		try {
			springJdbcDao.updateObject(queryManager.updatetFailAttempts(), new Object[]{0,model.getLoginId()});
		} catch (Exception e) {
			_logger.error("An exception occurred while get update Fail userAttempts : ", e);
		}

	}
	
	@Override
	public ResponseBean logout(HttpServletRequest request, ResponseBean resBean, LoginBean model) {
		

		saveAccessLog(model,"logout");
		sessionManager.clearSession(model);
		resBean.setSuccess(true);
		_logger.info("Successfully logged out CBRM by : "+model.getEmployeeName()+" on : "+DateUtil.getDateStrWithPattern("yyyy-MMM-dd HH:mm:ss", new Date())+" ");
		
		return resBean;
	}
    
	//For Switch role to comparing the password after encryption
	@Override
	public ResponseBean encryptPassword(HttpServletRequest request,ResponseBean resBean,LoginBean model)	   
	{	 
		try
		{
			resBean.setVal(PasswordCipher.encrypt(model.getNewPassword()));
			resBean.setSuccess(true);
			
		}
		catch(Exception e)
		{
			 
		}
		return resBean;
	}
	

	@Override
	public ResponseBean getOldPassword(HttpServletRequest request,ResponseBean resBean, LoginBean model)	   
	{
		if(!PasswordCipher.encrypt(model.getOldPassword()).equals(model.getPassword()))
		{
			resBean.setMessage("Invailid Old Password");
			resBean.setSuccess(false);
			return resBean;
		}else{
			ResponseBean resBeans =	changePassword(request, resBean, model);
			return resBeans;
		}
	}
	
	@Override
	public ResponseBean changePassword(HttpServletRequest request,ResponseBean resBean, LoginBean model)
	 {
		try
		{
			if (checkOldPassword(model)) 
			{
			String sql = "update "+Table.LOGIN+" set password = '"+PasswordCipher.encrypt(model.getNewPassword())+"',editedon='"+new Date()+"',editedby='"+model.getLoginId()+"' where loginid = '"+model.getLoginId()+"'";
			springJdbcDao.updateObject(sql, null);
			model.setPassword(PasswordCipher.encrypt(model.getNewPassword()));
			resBean.setData(model);
			sessionManager.setUserInSession(model);
			resBean.setSuccess(true);
			resBean.setMessage("Successfully changed password");
			_logger.info("Successfully change password for : "+model.getLoginId()+" on : "+DateUtil.getDateStrWithPattern("yyyy-MMM-dd HH:mm:ss", new Date())+" ");
			
			}
			else {
				_logger.error("An exception occured while  update password : ");
				resBean.setMessage("Unable to change password");
				resBean.setSuccess(false);
			}
		}
		catch(Exception e)
		{
			 resBean.setMessage("Unable to change password");
			 resBean.setSuccess(false);
			_logger.error("An exception occured while change password for :"+model.getLoginId(), e);
		}
		return resBean;
	 }
	
	 private boolean checkOldPassword(LoginBean model) 
	  {
		 boolean isOldPwd = false;
		 try{
		
		String sql = "SELECT password, loginid FROM login WHERE password = '" +PasswordCipher.encrypt(model.getOldPassword())+ "'  AND loginid = '"+model.getLoginId()+"'";
	    LoginBean loginBean = (LoginBean) springJdbcDao.getObject(sql, null, LoginBean.class);
		 
		 if(!loginBean.getPassword().equalsIgnoreCase(PasswordCipher.encrypt(model.getOldPassword())))
			{
		 	 isOldPwd = false;
			}
		 else
			{
			  isOldPwd = true;
			}
		 }
		 catch(Exception e)
		 {
			 _logger.error("An exception occured while query executed.. : ");
		 }
			return isOldPwd;
		}

	@SuppressWarnings("unused")
	public ResponseBean getUserInfoByEmailID(LoginBean model) {
		ResponseBean resBean= new ResponseBean();
		try {
			
			LoginBean loginBean = (LoginBean) springJdbcDao.getObject(queryManager.getUserinfoByEmailID(), new Object[]{model.getEmailID()}, LoginBean.class);
			
			loginBean.setPassword(PasswordCipher.decrypt(loginBean.getPassword()));
			
			if(loginBean == null)
			{
				resBean.setMessage("Email ID is not found");
				resBean.setSuccess(false);				
				return resBean;
			}
			else
			{
			
			_logger.info("Successfully get user info by email id : "+loginBean.getEmailID()+" on : "+new Date());
			loginBean.setSessionId(idGenerator.getSessionId());
			resBean.setSuccess(true);
			resBean.setData(loginBean);
			
			}
		}
		catch (Exception e) 
		{
			_logger.error("An exception occurred while login : ", e);
		}
		
		return resBean;
	}

	
	private void saveAccessLog(LoginBean loginBean, String accessType)
	{
		String sql = "";
		try {
			if(accessType.equalsIgnoreCase("login")) {
				sql = "insert into "+Table.LOGIN_LOG+"(oid, userId, roleID, ipAddress, loginTime, loginStatus) values(?,?,?,?,?,?)";
				springJdbcDao.saveObject(sql, new Object[]{loginBean.getSessionId(), loginBean.getLoginId(), loginBean.getRoleID(), loginBean.getIpAddress(), new Date(), USER_LOGGEDIN});
			} else {
				sql = "update "+Table.LOGIN_LOG+" set loginStatus = ?, logoutTime = ? where oid = ?";
				springJdbcDao.saveObject(sql, new Object[]{USER_LOGGEDOUT, new Date(), loginBean.getSessionId()});
			}
		} catch(Exception e) {
			_logger.error("An exception occurred while save access log for : "+loginBean.getLoginId(),e);
		}
	}
	
	@Override
	public ResponseBean getAllLogin(LoginBean loginBean) {
		
		ResponseBean resBean = new ResponseBean();
		try
		{
			@SuppressWarnings("unchecked")
			List<LoginBean> userList = springJdbcDao.getObjectList(queryManager.getAllLogin(), null, LoginBean.class);
			if(userList == null || userList.isEmpty())
			{
				return resBean;
			}
			resBean.setData(userList);
			resBean.setSuccess(true);
			
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while get logins List  : ", e);
		}
		return resBean;
	}

	@Override
	public ResponseBean switchRole(HttpServletRequest request,
			ResponseBean responseBean, LoginBean model) {
		try{
			
			LoginBean loginBean = (LoginBean) springJdbcDao.getObject(queryManager.getLoggedinUserinfo(), new Object[]{model.getLoginId()}, LoginBean.class);
			
			if(loginBean == null)
			{
				responseBean.setMessage("Invalid login ID");
				responseBean.setSuccess(false);
				return responseBean;
			}
			
			if(!loginBean.getPassword().equalsIgnoreCase(PasswordCipher.encrypt(model.getPassword())))
			{
				responseBean.setMessage("Invalid Password");
				responseBean.setSuccess(false);
				return responseBean;
			}
			loginBean.setMenuJSON(getMenuJSONByRole(model.getSecondaryRole()));
			loginBean.setPrimaryRole(loginBean.getRoleID());
			loginBean.setSecondaryRole(model.getSecondaryRole());
			loginBean.setSessionId(model.getSessionId());
			responseBean.setSuccess(true);
			responseBean.setData(loginBean);
			_logger.info("Successfully switched Role from : "+loginBean.getRoleID()+" to : "+loginBean.getSecondaryRole()+" in CBRM by : "+loginBean.getEmployeeName()+" on : "+DateUtil.getDateStrWithPattern("yyyy-MMM-dd HH:mm:ss", new Date())+" ");
			
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while switch role for : "+model.getLoginId(), e);
		}
		
		return responseBean;
	}
	
	private String getMenuJSONByRole(String secondaryRole){
		
		String menuJSON = null;
		
		try{
			String sql = "select menuJSON from Role where roleid = ?";
			
			LoginBean loginBean = (LoginBean) springJdbcDao.getObject(sql, new Object[]{secondaryRole}, LoginBean.class);
			if(loginBean != null)
			{
				menuJSON = loginBean.getMenuJSON();
			}
			
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while get menuJSON by secondary role : ", e);
		}
		
		return menuJSON;
	}

	@Override
	public ResponseBean getAllLoginForEmployee(LoginBean model) {
		ResponseBean resBean = new ResponseBean();
		try
		{
			@SuppressWarnings("unchecked")
			List<LoginBean> userList = springJdbcDao.getObjectList(queryManager.getAllLoginForEmployee(), null, LoginBean.class);
			if(userList == null || userList.isEmpty())
			{
				return resBean;
			}
			resBean.setData(userList);
			resBean.setSuccess(true);
			
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while get logins List  : ", e);
		}
		return resBean;
	}


	@Override
	public ResponseBean getDecryptedPassword(HttpServletRequest request,ResponseBean resBean,LoginBean model)	   
	{	 
		try
		{	 model.setDecrypted((PasswordCipher.decrypt(model.getPassword())));
		
			resBean.setSuccess(true);
			
			resBean.setData(model);
			
		}
		catch (Exception e) 
		{
			_logger.error("An exception occurred while Decryping Password : ", e);
		}
		return resBean;
	}



	}