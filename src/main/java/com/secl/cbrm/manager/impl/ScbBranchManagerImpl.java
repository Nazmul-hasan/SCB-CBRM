package com.secl.cbrm.manager.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.secl.cbrm.bean.ScbBranchBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.converter.BeanToEntityConverter;
import com.secl.cbrm.entity.ScbBranch;
import com.secl.cbrm.manager.ScbBranchManager;
import com.secl.cbrm.utils.Constant;
import com.secl.cbrm.utils.ParamUtil;


public class ScbBranchManagerImpl extends ManagerImpl implements ScbBranchManager, Constant {
	
	private Logger _logger = Logger.getLogger(this.getClass());

	@Override
	public ResponseBean saveScbBranch(HttpServletRequest request,ResponseBean resBean, ScbBranchBean model)
	{
		 try {
			/* Object[] param = ParamUtil.getParamsWithoutObject(idGenerator.generateId(),model.getName(),model.getAddress());
			 springJdbcDao.saveObject(queryManager.saveBranch(),param);*/
			 if(model.getOid() == null)
				{
					model.setOid(idGenerator.generateId());
				}		
				
				ScbBranch scbBranch = BeanToEntityConverter.convertScbBranchBeanToEntity(model);
				
				hibernateDao.saveObject(scbBranch);
				resBean.setSuccess(true);
				 _logger.info("Branch Saved successfully");
				 resBean.setMessage("Branch Saved successfully");
			 
		  }  catch (Exception e) {
			  _logger.error("An exception occurred while save new Branch : ", e);
			  resBean.setSuccess(false);
			  resBean.setMessage("Failed to save branch");
		}
			 
	      return resBean;
	}

	@Override
	public ResponseBean updateScbBranch(ResponseBean resBean, ScbBranchBean model) {
		 try {
			 Object[] param = ParamUtil.getParamsWithoutObject(model.getBrCode(),model.getBrName(),model.getBrAddress(),model.getBrCodeForClRpt(),
					   model.getDivision(),model.getBbBrCode(),model.getBbBrCodeForClRpt(),model.getCreatedOn(),
					   model.getCreatedBy(),model.getEditedOn(),model.getEditedBy(),model.getOid());
			 springJdbcDao.saveObject(queryManager.updateScbBranch(),param);
			 resBean.setSuccess(true);
			 _logger.info("Branch Updated successfully for oid: " +model.getOid());
			 resBean.setMessage("Branch Updated successfully");
			 
		  }  catch (Exception e) {
			  _logger.error("An exception occurred while Updated Branch for : "+model.getOid()+" ", e);
			  resBean.setSuccess(false);
			  resBean.setMessage("Failed to save branch");
		}
			 
	      return resBean;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ResponseBean getAllScbBranch(ResponseBean resBean, ScbBranchBean model) {
		 try {
			 List<ScbBranchBean> allScbBranch= springJdbcDao.getObjectList(queryManager.getAllScbBranch(),null,ScbBranchBean.class);
			 if (allScbBranch.size()>0){
				  resBean.setSuccess(true);
				  resBean.setData(allScbBranch);
				 _logger.info("successfully load all barnches: " +model.getOid());
			 }
			 else {
				 resBean.setSuccess(true);
				 _logger.info("No records avilable for id : " +model.getOid());
				 resBean.setMessage("No records avilable for barnch");
			  } 
			 
		  }  catch (Exception e) {
			  _logger.error("An exception occurred while get All Branchs : ", e);
			  resBean.setSuccess(false);
			  resBean.setMessage("Failed to load branch");
		}
		return resBean;
	}

	@Override
	public ResponseBean deleteScbBranch(ResponseBean resBean, ScbBranchBean model) {
		try {
			springJdbcDao.deleteObject(queryManager.deleteScbBranch(),new Object[]{model.getOid()});
			 resBean.setSuccess(true);
			_logger.info("successfully delete branch for ID : " +model.getOid());
			 resBean.setMessage("successfully delete branch for ID :" +model.getOid());
		} catch (Exception e) {
			_logger.error("An exception occurred while attempt to delete Branchs for ID :"+model.getOid()+ " ", e);
			 resBean.setSuccess(false);
			 resBean.setMessage("Failed to delete branch");
		}
		return resBean;
	}

	@Override
	public ResponseBean getScbBranchByOid(ResponseBean resBean, ScbBranchBean model) {
		try {
			 ScbBranchBean scbBranch= (ScbBranchBean)springJdbcDao.getObject(queryManager.getScbBranchByOid(),new Object[]{model.getOid()},ScbBranchBean.class);
			 if (scbBranch.getBrCode()!= null){
				  resBean.setSuccess(true);
				  resBean.setData(scbBranch);
				 _logger.info("successfully get barnch for ID : " +model.getOid());
			 }
			 else {
				 resBean.setSuccess(true);
				 _logger.info("No records avilable for barnch ID: " +model.getOid());
				 resBean.setMessage("No records avilable for barnch ID" +model.getOid());
			  } 
			 
		  }  catch (Exception e) {
			  _logger.error("An exception occurred while get Branc for id : "+model.getOid()+" ", e);
			  resBean.setSuccess(false);
			  resBean.setMessage("Failed to get branch for ID :" +model.getOid());
		}
		return resBean;
	}	
	
	
	}