package com.secl.cbrm.clbreport.rest.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.cibreport.bean.SubjectReportBean;
import com.secl.cbrm.clreport.bean.Cl_1_ReportBean;
import com.secl.cbrm.clreportmanager.Cl_1_ReportManager;
import com.secl.cbrm.manager.SessionManager;

/**
 * @author nazmul.hasan
 *
 */
@Path("/cl1_Report")
public class Cl_1_ReportService {


	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private Cl_1_ReportManager cl_1_ReportManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObj(Cl_1_ReportBean model) {
		ResponseBean resBean = new ResponseBean();
		
		
		 return resBean;
	}


	public void setCl_1_ReportManager(Cl_1_ReportManager cl_1_ReportManager) {
		this.cl_1_ReportManager = cl_1_ReportManager;
	}


	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}
	
	
}
