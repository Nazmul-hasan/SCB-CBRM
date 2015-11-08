package com.secl.cbrm.sbs3report.rest.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.sbs3report.bean.SBS3_Advance_Summary_ReportBean;
import com.secl.cbrm.sbs3reportmanager.SBS3_Advance_Summary_ReportManager;

/**
 * @author nazmul.hasan
 *
 */

@Path("/sbs3AdvanceSummary")
public class SbS3_ReportService {

	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private  SBS3_Advance_Summary_ReportManager sbs3_Advance_Summary_ReportManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	
	public ResponseBean postObj(SBS3_Advance_Summary_ReportBean model) {
		ResponseBean resBean = new ResponseBean();
		
		
		 return resBean;
	}

	public void setSbs3_Advance_Summary_ReportManager(
			SBS3_Advance_Summary_ReportManager sbs3_Advance_Summary_ReportManager) {
		this.sbs3_Advance_Summary_ReportManager = sbs3_Advance_Summary_ReportManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}
}
