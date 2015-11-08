package com.secl.cbrm.rest.service;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.BranchBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.manager.BranchManager;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.utils.Constant;

@Path("/branch")
public class BranchService implements Constant {
	
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private BranchManager branchManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postClient(BranchBean model) {
		ResponseBean resBean = new ResponseBean();
		if(!sessionManager.isValid(model.getLoginBean())){
			return resBean;
		}
		 if(model.getOperation().equalsIgnoreCase(SAVE)){
			 resBean = branchManager.SaveBranch(request,resBean, model);
		 }
		else if(model.getOperation().equalsIgnoreCase(UPDATE)){
			resBean = branchManager.UpdateBranch(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_ALL)){
			resBean = branchManager.getAllBranch(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(GET_BY_OID)){
			resBean = branchManager.getBranchByOid(resBean, model);
		}
		else if(model.getOperation().equalsIgnoreCase(DELETE)){
			resBean = branchManager.deleteBranch(resBean, model);
		}
	   return resBean;
   }
	

	public void setBranchManager(BranchManager branchManager) {
        this.branchManager = branchManager;
   }

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	
}




