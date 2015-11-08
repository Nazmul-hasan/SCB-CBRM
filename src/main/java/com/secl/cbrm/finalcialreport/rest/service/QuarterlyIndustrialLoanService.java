package com.secl.cbrm.finalcialreport.rest.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.financialreport.bean.QuarterlyIndustrialLoanBean;
import com.secl.cbrm.financialreportmanager.QuarterlyIndustrialLoanManager;
import com.secl.cbrm.manager.SessionManager;

/**
 * @author nazmul.hasan
 *
 */

@Path("/quarterlyIndustrialLoan")
public class QuarterlyIndustrialLoanService {

	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private QuarterlyIndustrialLoanManager quarterlyIndustrialLoanManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	
	public ResponseBean postObj(QuarterlyIndustrialLoanBean model) {
		ResponseBean resBean = new ResponseBean();
		
		
		 return resBean;
	}

	
	public void setQuarterlyIndustrialLoanManager(
			QuarterlyIndustrialLoanManager quarterlyIndustrialLoanManager) {
		this.quarterlyIndustrialLoanManager = quarterlyIndustrialLoanManager;
	}


	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}
}
