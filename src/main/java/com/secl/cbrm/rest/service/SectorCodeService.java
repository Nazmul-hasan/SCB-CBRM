package com.secl.cbrm.rest.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.secl.cbrm.bean.SectorCodeBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.manager.SectorCodeManager;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.utils.Constant;

@Path("/sectorCode")
public class SectorCodeService implements Constant {


	@Context ServletContext servletContext;
	@Context HttpServletRequest request;
	private SectorCodeManager sectorCodeManager;
	private SessionManager sessionManager;

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBean postClient(SectorCodeBean model) {
		ResponseBean resBean = new ResponseBean();
		if(!sessionManager.isValid(model.getLoginBean())){
			return resBean;
		}
		if(model.getOperation().equalsIgnoreCase(SAVE)){
			resBean = sectorCodeManager.SaveSectorCode(request,resBean, model);
		}

		else if(model.getOperation().equalsIgnoreCase(GET_ALL)){
			resBean = sectorCodeManager.getAllSectorCode(resBean, model);
		}

		else if(model.getOperation().equalsIgnoreCase(GET_BY_OID)){
			resBean = sectorCodeManager.getSectorCodeByOid(resBean, model);
		}

		return resBean;
	}


	public void setSectorCodeManager(SectorCodeManager sectorCodeManager) {
		this.sectorCodeManager = sectorCodeManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

}
