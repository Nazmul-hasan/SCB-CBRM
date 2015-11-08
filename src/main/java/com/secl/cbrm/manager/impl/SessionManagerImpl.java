package com.secl.cbrm.manager.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.secl.cbrm.bean.LoginBean;
import com.secl.cbrm.manager.SessionManager;

public class SessionManagerImpl implements SessionManager {
	
	private Map<String, Map<String, LoginBean>> session = new ConcurrentHashMap<String, Map<String, LoginBean>>();
	
	@Override
	public void setUserInSession(LoginBean model){
		Map<String, LoginBean> userInfo = null;
		if(!session.containsKey(model.getLoginId())){
			userInfo = new ConcurrentHashMap<String, LoginBean>();
		}
		else {
			userInfo = session.get(model.getLoginId());
		}
		userInfo.put(model.getSessionId(), model);
		session.put(model.getLoginId(), userInfo);
	}
	
	@Override
	public LoginBean getUserInSession(LoginBean model){
		return session.get(model.getLoginId()).get(model.getSessionId());
	}

	@Override
	public void clearSession(LoginBean model) {
		if(session.containsKey(model.getLoginId())){
			session.get(model.getLoginId()).remove(model.getSessionId());
		}		
	}
	
	@Override
	public boolean isValid(LoginBean model) {
		if(!session.containsKey(model.getLoginId())){
			return false;
		}
		else if(!session.get(model.getLoginId()).containsKey(model.getSessionId())){
			return false;
		}
		return true;
	}
	

}
