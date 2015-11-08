package com.secl.cbrm.rest.service;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.LoginBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.manager.LoginManager;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.utils.Constant;

@Path("/security")
public class LoginService implements Constant {
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private LoginManager loginManager;
	@SuppressWarnings("unused")
	private SessionManager sessionManager;
	
	@POST
	@Path("/useraccess")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postLogin(LoginBean model) {
		
		ResponseBean resBean = new ResponseBean();
		
		if(model.getOperation().equalsIgnoreCase(USER_LOGIN))
		{
			resBean =  loginManager.login(request, resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(USER_LOGOUT))
		{
			resBean =  loginManager.logout(request, resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(USER_PASSWORD_CHANGE))
		{
			resBean =  loginManager.changePassword(request, resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_BY_EMAIL_ID))
		{
			resBean=loginManager.getUserInfoByEmailID(model);
		}	    
		else if(model.getOperation().equalsIgnoreCase(GET_ALL))
		{
			resBean =  loginManager.getAllLogin(model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_ALL_LOGIN_WITH_GRADE))
		{
			resBean =  loginManager.getAllLoginForEmployee(model);
		}
		else if(model.getOperation().equalsIgnoreCase(USER_SWITCH_ROLE))
		{
			resBean =  loginManager.switchRole(request, resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_OLD_PWD))
		{
			resBean =  loginManager.getOldPassword(request, resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_PWD_ENCRYPTED))
		{
			resBean =  loginManager.encryptPassword(request, resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_DECRYPTED_PWD))
		{
			resBean =  loginManager.getDecryptedPassword(request, resBean, model);
		}
	
	   return resBean;
   }
	
	 public void setLoginManager(LoginManager loginManager) {
			this.loginManager = loginManager;
		}


		public void setSessionManager(SessionManager sessionManager) {
			this.sessionManager = sessionManager;
		}
	
}


