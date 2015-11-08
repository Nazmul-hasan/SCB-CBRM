package com.secl.cbrm.daynamicqueryreport.rest.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.daynamicqueryreport.bean.DetailBorrowerListBean;
import com.secl.cbrm.dynamicqueryreportsmanager.DetailBorrowerListManager;
import com.secl.cbrm.manager.SessionManager;

/**
 * @author nazmul.hasan
 *
 */
@Path("/borrowerlist")
public class DetailBorrowerListService {

	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private DetailBorrowerListManager detailBorrowerListManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObj(DetailBorrowerListBean model) {
		ResponseBean resBean = new ResponseBean();
		
		
		 return resBean;
	}



	public void setDetailBorrowerListManager(
			DetailBorrowerListManager detailBorrowerListManager) {
		this.detailBorrowerListManager = detailBorrowerListManager;
	}



	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}
	
}
