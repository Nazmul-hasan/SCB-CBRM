package com.secl.cbrm.manager;

import javax.servlet.http.HttpServletRequest;

import com.secl.cbrm.bean.LoginBean;
import com.secl.cbrm.bean.ResponseBean;


public interface LoginManager {
	
	
	public ResponseBean login(HttpServletRequest request, ResponseBean resBean, LoginBean model);
	
	public ResponseBean logout(HttpServletRequest request, ResponseBean resBean, LoginBean model);

	public ResponseBean changePassword(HttpServletRequest request,ResponseBean resBean, LoginBean model);
	
	
	public ResponseBean getUserInfoByEmailID(LoginBean model);
	
	public ResponseBean getAllLogin(LoginBean model);
	
	public ResponseBean switchRole(HttpServletRequest request, ResponseBean resBean, LoginBean model);

	public ResponseBean getOldPassword(HttpServletRequest request,
			ResponseBean resBean, LoginBean model);
	
	public ResponseBean encryptPassword(HttpServletRequest request,
			ResponseBean resBean, LoginBean model);

	public ResponseBean getAllLoginForEmployee(LoginBean model);

	public ResponseBean getDecryptedPassword(HttpServletRequest request,ResponseBean resBean, LoginBean model);
	
}
