package com.secl.cbrm.manager.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.secl.cbrm.bean.BranchBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.converter.BeanToEntityConverter;
import com.secl.cbrm.entity.Branch;
import com.secl.cbrm.manager.BranchManager;
import com.secl.cbrm.utils.Constant;
import com.secl.cbrm.utils.ParamUtil;


public class BranchManagerImpl extends ManagerImpl implements BranchManager, Constant {
	
	private Logger _logger = Logger.getLogger(this.getClass());

	@Override
	public ResponseBean SaveBranch(HttpServletRequest request,ResponseBean resBean, BranchBean model)
	{
		 try {
			/* Object[] param = ParamUtil.getParamsWithoutObject(idGenerator.generateId(),model.getName(),model.getAddress());
			 springJdbcDao.saveObject(queryManager.saveBranch(),param);*/
			 if(model.getOid() == null)
				{
					model.setOid(idGenerator.generateId());
				}		
				
				Branch branch = BeanToEntityConverter.convertBranchBeanToEntity(model);
				
				hibernateDao.saveObject(branch);
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
	public ResponseBean UpdateBranch(ResponseBean resBean, BranchBean model) {
		 try {
			 Object[] param = ParamUtil.getParamsWithoutObject(model.getName(),model.getAddress(),model.getOid());
			 springJdbcDao.saveObject(queryManager.updateBranch(),param);
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
	public ResponseBean getAllBranch(ResponseBean resBean, BranchBean model) {
		 try {
			 List<BranchBean> allBranch= springJdbcDao.getObjectList(queryManager.getAllBranch(),null,BranchBean.class);
			 if (allBranch.size()>0){
				  resBean.setSuccess(true);
				  resBean.setData(allBranch);
				 _logger.info("successfully load all barnches");
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
	public ResponseBean deleteBranch(ResponseBean resBean, BranchBean model) {
		try {
			springJdbcDao.deleteObject(queryManager.deleteBranch(),new Object[]{model.getOid()});
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
	public ResponseBean getBranchByOid(ResponseBean resBean, BranchBean model) {
		try {
			 BranchBean branch= (BranchBean)springJdbcDao.getObject(queryManager.getBranchByOid(),new Object[]{model.getOid()},BranchBean.class);
			 if (branch.getName()!= null){
				  resBean.setSuccess(true);
				  resBean.setData(branch);
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

	@Override
	public ResponseBean generatePDFReprotForBranch(ServletContext context,ResponseBean responseBean, BranchBean model) 
	{
			
		// TODO Auto-generated method stub
		return null;
	}	
	
	
	}