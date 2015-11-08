package com.secl.cbrm.rest.service;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.BDDB2TextFilesDataUploadBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.manager.BDDB2TextFilesDataUploadManager;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.utils.Constant;

@Path("json/bddb2FileUpload")
public class BDDB2TextFilesDataUploadService implements Constant {
	
	
	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private BDDB2TextFilesDataUploadManager bddb2TextFilesDataUploadManager;
	private SessionManager sessionManager;
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ResponseBean PostBddb2Data(BDDB2TextFilesDataUploadBean model) {
		ResponseBean resBean = new ResponseBean();
		if(!sessionManager.isValid(model.getLoginBean())){
			return resBean;
		}
		 if(model.getOperation().equalsIgnoreCase(SAVE)){
			 resBean = bddb2TextFilesDataUploadManager.UploadBDDB2dataIntoDB(resBean, model);
		 }
		
	   return resBean;
   }
	


	public void setBddb2TextFilesDataUploadManager(
			BDDB2TextFilesDataUploadManager bddb2TextFilesDataUploadManager) {
		this.bddb2TextFilesDataUploadManager = bddb2TextFilesDataUploadManager;
	}



	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	
}




