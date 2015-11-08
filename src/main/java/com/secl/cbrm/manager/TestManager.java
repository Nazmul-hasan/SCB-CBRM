package com.secl.cbrm.manager;

import javax.servlet.http.HttpServletRequest;

import com.secl.cbrm.bean.TestBean;
import com.secl.cbrm.bean.ResponseBean;


public interface TestManager {
	
	public ResponseBean SaveTest(HttpServletRequest request,ResponseBean resBean, TestBean model);
	
	public ResponseBean UpdateTest(ResponseBean resBean, TestBean model);
	
	public ResponseBean getAllTest(ResponseBean resBean, TestBean model);
	
	public ResponseBean deleteTest(ResponseBean resBean, TestBean model);
	
	public ResponseBean getTestByOid(ResponseBean resBean, TestBean model);
	
}
