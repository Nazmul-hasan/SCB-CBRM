package com.secl.cbrm.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.bean.UserBean;
import com.secl.cbrm.converter.BeanToEntityConverter;
import com.secl.cbrm.entity.AbstractEntity;
import com.secl.cbrm.entity.User;
import com.secl.cbrm.manager.UserManager;
import com.secl.cbrm.utils.Constant;
import com.secl.cbrm.utils.PasswordCipher;
import com.secl.cbrm.utils.Table;


public class UserManagerImpl extends ManagerImpl implements UserManager, Constant {
	
	private Logger _logger = Logger.getLogger(this.getClass());
	
	private List<AbstractEntity> entityList = new ArrayList<AbstractEntity>();


	
	@Override
	public ResponseBean getAllUsers(UserBean userBean) {
		ResponseBean resBean = new ResponseBean();
		try
		{
			@SuppressWarnings("unchecked")
			List<UserBean> userList = springJdbcDao.getObjectList(queryManager.getAllUsers(), null, UserBean.class);
			if(userList == null || userList.isEmpty())
			{
				return resBean;
			}
			resBean.setData(userList);
			resBean.setSuccess(true);
			
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while get user List  : ", e);
		}
		return resBean;
	}
	
	
	public ResponseBean getFiltereduserManager(UserBean model) {
		ResponseBean resBean = new ResponseBean();
		try
		{
			
			String sql="" ;
			
			if (model.getFilterName().equalsIgnoreCase("role")) 
			{	
				sql="select distinct roleid as valueName  from login";
				
			}
			else if(model.getFilterName().equalsIgnoreCase("status"))
			{
				sql = "SELECT  distinct status as valueName  FROM login";
			}
			
			@SuppressWarnings("unchecked")
			List<UserBean> objList = springJdbcDao.getObjectList( sql , null, UserBean.class);
			if(objList == null || objList.isEmpty()){
				return resBean;
			}
			resBean.setData(objList);
			resBean.setSuccess(true);
			
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while get data on filterkey list : ", e);
		}
		return resBean;
	}


	@Override
	public ResponseBean getAllEmployeeAsuser(UserBean model) {
		ResponseBean resBean = new ResponseBean();
		try
		{
			@SuppressWarnings("unchecked")
			List<UserBean> userList = springJdbcDao.getObjectList(queryManager.getAllEmployeeAsuser(), null, UserBean.class);
			if(userList == null || userList.isEmpty())
			{
				return resBean;
			}
			resBean.setData(userList);
			resBean.setSuccess(true);
			
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while get user List  : ", e);
		}
		return resBean;
	}


	@Override
	public ResponseBean saveUser(HttpServletRequest request,ResponseBean resBean, UserBean model)
			 
	{
		ResponseBean responseBean = new ResponseBean();
		try
		{
			
			if(!checkDuplicateUserID(model.getLoginid()))
			{
				if(model.getLoginid() == null)
				{
					//model.setOid(idGenerator.generateId());
					model.setLoginid(model.getLoginBean().getLoginId());
				}
				model.setCreatedBy(model.getLoginBean().getLoginId());
				model.setCreatedOn(new Date());
				model.setPassword(PasswordCipher.encrypt(model.getPassword()));
				
				User user = BeanToEntityConverter.convertUserBeanToEntity(model);
				
				hibernateDao.saveObject(user);
				responseBean.setMessage("Successfully Saved");
				responseBean.setSuccess(true);
			}
			else
			{
				responseBean.setMessage("User ID ("+model.getLoginid()+") already exist ....");
				responseBean.setSuccess(false);
			}
			
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while save User data : ", e);
			responseBean.setSuccess(false);
			responseBean.setMessage("Unable to save user ....");
		}
		return responseBean;
	}
	
	@Override
	public ResponseBean changeUserStatus (UserBean model) 
		{
		
		ResponseBean responseBean = new ResponseBean();
		try
		{			
			springJdbcDao.updateObject(queryManager.changeUserStatus(model.getStatus()), new Object[] {model.getLoginid() });
			responseBean.setData(model);
			responseBean.setSuccess(true);
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while save user data : ", e);
			responseBean.setSuccess(false);
		}
		return responseBean;
	}
	
	@SuppressWarnings("unchecked")
	private boolean checkDuplicateUserID(String id)
	{
		try
		{
			String sql ="SELECT * FROM "+Table.LOGIN+" WHERE loginid = ?";
		    
			List <UserBean> list = new ArrayList<UserBean>();		    
			
			list = springJdbcDao.getObjectList(sql, new Object[]{id}, UserBean.class);
			
			if(list.size()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			_logger.error("Duplicate Loginid found : ", e);
		}
		return false;
	}


	@Override
	public ResponseBean getUserByloginid(UserBean model) {
		ResponseBean resBean= new ResponseBean();
		try {
			UserBean userBean = (UserBean) springJdbcDao.getObject(queryManager.getUserByloginid(), new Object[] {model.getLoginid() }, UserBean.class);
	
			if(userBean == null){
				return resBean;
			}
			resBean.setData(userBean);
			resBean.setSuccess(true);
			
		} 
		catch (Exception e) 
		{
			_logger.error("An exception occurred while get user by login ID   : ", e);
		}
		return resBean;
	}


	@Override
	public ResponseBean updateUser(UserBean model) {
		ResponseBean responseBean = new ResponseBean();
		try
		{			
			springJdbcDao.updateObject(queryManager.updateUser(model.getStatus(),model.getEmail(),model.getRoleJSON(),model.getRoleid(),model.getLoginid()), new Object[] {});
			responseBean.setData(model);
			responseBean.setMessage("Successfully Updated");
			responseBean.setSuccess(true);
		}
		catch(Exception e)
		{
			_logger.error("An exception occurred while save user data : ", e);
			responseBean.setSuccess(false);
		}
		return responseBean;
	}

	
}
