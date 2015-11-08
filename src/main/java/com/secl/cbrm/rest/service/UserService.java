package com.secl.cbrm.rest.service;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.bean.UserBean;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.manager.UserManager;
import com.secl.cbrm.utils.Constant;

@Path("/json/user")
public class UserService implements Constant {
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private UserManager userManager;
	@SuppressWarnings("unused")
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	
	public ResponseBean postUser(UserBean model) {
		
		ResponseBean resBean = new ResponseBean();
		if(!sessionManager.isValid(model.getLoginBean())){
			return resBean;
		}		
		
		else if(model.getOperation().equalsIgnoreCase(SAVE))
		{
			resBean =  userManager.saveUser(request, resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(UPDATE))
		{
			resBean =  userManager.updateUser(model);
		}
		
		else if(model.getOperation().equalsIgnoreCase(GET_ALL))
		{
			resBean =  userManager.getAllUsers(model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_FILTERED_ITEM))
		{
			resBean = userManager.getFiltereduserManager(model);
		}
		
		else if(model.getOperation().equalsIgnoreCase(CHANGE_STATUS))
		{
			resBean =  userManager.changeUserStatus( model);
		}
		
		else  if(model.getOperation().equalsIgnoreCase(GET_BY_ID))
		{
			resBean = userManager.getUserByloginid(model);
		}
	   
		return resBean;
	}

	
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	
}


