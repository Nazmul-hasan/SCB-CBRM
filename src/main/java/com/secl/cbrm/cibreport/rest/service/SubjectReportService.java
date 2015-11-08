package com.secl.cbrm.cibreport.rest.service;

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
import com.secl.cbrm.cibreportmanager.SubjectReportManager;
import com.secl.cbrm.manager.SessionManager;

/**
 * @author nazmul.hasan
 *
 */
@Path("/subjectReport")
public class SubjectReportService {


	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private SubjectReportManager subjectReportManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postObj(SubjectReportBean model) {
		ResponseBean resBean = new ResponseBean();
		 return resBean;
	}

	public void setSubjectReportManager(SubjectReportManager subjectReportManager) {
		this.subjectReportManager = subjectReportManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}
	
	
	
}
