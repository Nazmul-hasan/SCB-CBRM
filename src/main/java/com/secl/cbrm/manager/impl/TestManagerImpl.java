package com.secl.cbrm.manager.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

//import com.secl.cbrm.bean.BranchBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.converter.BeanToEntityConverter;
//import com.secl.cbrm.entity.Branch;
//import com.secl.cbrm.manager.BranchManager;
import com.secl.cbrm.utils.Constant;
import com.secl.cbrm.utils.ParamUtil;
import com.secl.cbrm.bean.TestBean;
import com.secl.cbrm.entity.Test;
import com.secl.cbrm.manager.TestManager;


public class TestManagerImpl extends ManagerImpl implements TestManager, Constant {
	
	private Logger _logger = Logger.getLogger(this.getClass());

	@Override
	public ResponseBean SaveTest(HttpServletRequest request,ResponseBean resBean, TestBean model)
	{
		 try {
			/* Object[] param = ParamUtil.getParamsWithoutObject(idGenerator.generateId(),model.getName(),model.getAddress());
			 springJdbcDao.saveObject(queryManager.SaveBranch(),param);*/
			 if(model.getOid() == null)
				{
					model.setOid(idGenerator.generateId());
				}		
				
				Test test = BeanToEntityConverter.convertTestBeanToEntity(model);
				
				hibernateDao.saveObject(test);
				resBean.setSuccess(true);
				 _logger.info("Test Saved successfully");
				 resBean.setMessage("Test Saved successfully");
			 
		  }  catch (Exception e) {
			  _logger.error("An exception occurred while save new Test : ", e);
			  resBean.setSuccess(false);
			  resBean.setMessage("Failed to save test");
		}
			 
	      return resBean;
	}

	@Override
	public ResponseBean UpdateTest(ResponseBean resBean, TestBean model) {
		 try {
			 Object[] param = ParamUtil.getParamsWithoutObject(model.getName(),model.getDescription(),model.getOid());
			 springJdbcDao.saveObject(queryManager.updateTest(),param);
			 resBean.setSuccess(true);
			 _logger.info("Test Updated successfully for oid: " +model.getOid());
			 resBean.setMessage("Test Updated successfully");
			 
		  }  catch (Exception e) {
			  _logger.error("An exception occurred while Updated Test for : "+model.getOid()+" ", e);
			  resBean.setSuccess(false);
			  resBean.setMessage("Failed to save Test");
		}
			 
	      return resBean;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ResponseBean getAllTest(ResponseBean resBean, TestBean model) {
		 try {
			 List<TestBean> allTest= springJdbcDao.getObjectList(queryManager.getAllTest(),null,TestBean.class);
			 if (allTest.size()>0){
				  resBean.setSuccess(true);
				  resBean.setData(allTest);
				 _logger.info("successfully load all tastes");
			 }
			 else {
				 resBean.setSuccess(true);
				 _logger.info("No records avilable for id : " +model.getOid());
				 resBean.setMessage("No records avilable for testes");
			  } 
			 
		  }  catch (Exception e) {
			  _logger.error("An exception occurred while get All testes : ", e);
			  resBean.setSuccess(false);
			  resBean.setMessage("Failed to load testes");
		}
		return resBean;
	}

	@Override
	public ResponseBean deleteTest(ResponseBean resBean, TestBean model) {
		try {
			springJdbcDao.deleteObject(queryManager.deleteTest(),new Object[]{model.getOid()});
			 resBean.setSuccess(true);
			_logger.info("successfully delete test for ID : " +model.getOid());
			 resBean.setMessage("successfully delete test for ID :" +model.getOid());
		} catch (Exception e) {
			_logger.error("An exception occurred while attempt to delete Branchs for ID :"+model.getOid()+ " ", e);
			 resBean.setSuccess(false);
			 resBean.setMessage("Failed to delete test");
		}
		return resBean;
	}

	@Override
	public ResponseBean getTestByOid(ResponseBean resBean, TestBean model) {
		try {
			 TestBean test= (TestBean)springJdbcDao.getObject(queryManager.getTestByOid(),new Object[]{model.getOid()},TestBean.class);
			 if (test.getName()!= null){
				  resBean.setSuccess(true);
				  resBean.setData(test);
				 _logger.info("successfully get test for ID : " +model.getOid());
			 }
			 else {
				 resBean.setSuccess(true);
				 _logger.info("No records avilable for test ID: " +model.getOid());
				 resBean.setMessage("No records avilable for test ID" +model.getOid());
			  } 
			 
		  }  catch (Exception e) {
			  _logger.error("An exception occurred while get test for id : "+model.getOid()+" ", e);
			  resBean.setSuccess(false);
			  resBean.setMessage("Failed to get test for ID :" +model.getOid());
		}
		return resBean;
	}	
	
	
	}