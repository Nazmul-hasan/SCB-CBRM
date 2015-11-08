package com.secl.cbrm.rest.service;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.ScbBranchBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.manager.ScbBranchManager;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.utils.Constant;

@Path("/scbBranch")
public class ScbBranchService implements Constant {
	
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private ScbBranchManager scbBranchManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postClient(ScbBranchBean model) {
		ResponseBean resBean = new ResponseBean();
		/*if(!sessionManager.isValid(model.getLoginBean())){
			return resBean;
		}*/
		 if(model.getOperation().equalsIgnoreCase(SAVE)){
			 resBean = scbBranchManager.saveScbBranch(request,resBean, model);
		 }
		else if(model.getOperation().equalsIgnoreCase(UPDATE)){
			resBean = scbBranchManager.updateScbBranch(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_ALL)){
			resBean = scbBranchManager.getAllScbBranch(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_BY_OID)){
			resBean = scbBranchManager.getScbBranchByOid(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(DELETE)){
			resBean = scbBranchManager.deleteScbBranch(resBean, model);
		}
	   return resBean;
   }
	

	public void setScbBranchManager(ScbBranchManager scbBranchManager) {
        this.scbBranchManager = scbBranchManager;
   }

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	
}




