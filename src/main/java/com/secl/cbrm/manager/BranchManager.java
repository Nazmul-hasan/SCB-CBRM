package com.secl.cbrm.manager;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.secl.cbrm.bean.BranchBean;
import com.secl.cbrm.bean.ResponseBean;


public interface BranchManager {
	
	public ResponseBean SaveBranch(HttpServletRequest request,ResponseBean resBean, BranchBean model);
	
	public ResponseBean generatePDFReprotForBranch(ServletContext context,ResponseBean responseBean, BranchBean model);
	
	public ResponseBean UpdateBranch(ResponseBean resBean, BranchBean model);
	
	public ResponseBean getAllBranch(ResponseBean resBean, BranchBean model);
	
	public ResponseBean deleteBranch(ResponseBean resBean, BranchBean model);
	
	public ResponseBean getBranchByOid(ResponseBean resBean, BranchBean model);
	
}
