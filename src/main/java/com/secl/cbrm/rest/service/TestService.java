package com.secl.cbrm.rest.service;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.TestBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.manager.TestManager;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.utils.Constant;

@Path("/test")
public class TestService implements Constant {
	
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private TestManager testManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postClient(TestBean model) {
		ResponseBean resBean = new ResponseBean();
		if(!sessionManager.isValid(model.getLoginBean())){
			return resBean;
		}
		 if(model.getOperation().equalsIgnoreCase(SAVE)){
			 resBean = testManager.SaveTest(request,resBean, model);
		 }
		else if(model.getOperation().equalsIgnoreCase(UPDATE)){
			resBean = testManager.UpdateTest(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_ALL)){
			resBean = testManager.getAllTest(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_BY_OID)){
			resBean = testManager.getTestByOid(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(DELETE)){
			resBean = testManager.deleteTest(resBean, model);
		}
	   return resBean;
   }
	

	public void setTestManager(TestManager testManager) {
        this.testManager = testManager;
   }

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	
}




