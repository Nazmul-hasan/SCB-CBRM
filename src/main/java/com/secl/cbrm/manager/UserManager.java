package com.secl.cbrm.manager;


import javax.servlet.http.HttpServletRequest;

import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.bean.UserBean;


public interface UserManager {
	
	public ResponseBean saveUser(HttpServletRequest request,
			ResponseBean resBean, UserBean model);
	
	public ResponseBean getAllUsers(UserBean userBean);
	
	public ResponseBean getFiltereduserManager(UserBean model);

	public ResponseBean getAllEmployeeAsuser(UserBean model);
	
	public ResponseBean changeUserStatus( UserBean model);

	public ResponseBean getUserByloginid(UserBean model);

	public ResponseBean updateUser(UserBean model);

	
}
