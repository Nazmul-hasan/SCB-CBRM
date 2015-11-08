package com.secl.cbrm.manager;

import javax.servlet.http.HttpServletRequest;

import com.secl.cbrm.bean.ScbBranchBean;
import com.secl.cbrm.bean.ResponseBean;


public interface ScbBranchManager {
	
	public ResponseBean saveScbBranch(HttpServletRequest request,ResponseBean resBean, ScbBranchBean model);
	
	public ResponseBean updateScbBranch(ResponseBean resBean, ScbBranchBean model);
	
	public ResponseBean getAllScbBranch(ResponseBean resBean, ScbBranchBean model);
	
	public ResponseBean deleteScbBranch(ResponseBean resBean, ScbBranchBean model);
	
	public ResponseBean getScbBranchByOid(ResponseBean resBean, ScbBranchBean model);
	
}
