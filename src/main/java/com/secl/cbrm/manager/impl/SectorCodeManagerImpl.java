package com.secl.cbrm.manager.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.secl.cbrm.bean.SectorCodeBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.converter.BeanToEntityConverter;
import com.secl.cbrm.entity.SectorCode;
import com.secl.cbrm.manager.SectorCodeManager;
import com.secl.cbrm.utils.Constant;

public class SectorCodeManagerImpl extends ManagerImpl implements SectorCodeManager, Constant {

	private Logger _logger = Logger.getLogger(this.getClass());

	@Override
	public ResponseBean SaveSectorCode(HttpServletRequest request,ResponseBean resBean, SectorCodeBean model)
	{
		try {
			/* Object[] param = ParamUtil.getParamsWithoutObject(idGenerator.generateId(),model.getName(),model.getAddress());
			 springJdbcDao.saveObject(queryManager.saveBranch(),param);*/
			if(model.getOid() == null)
			{
				model.setOid(idGenerator.generateId());
			}		

			SectorCode sectorCode = BeanToEntityConverter.convertSectorCodeBeanToEntity(model);

			hibernateDao.saveObject(sectorCode);
			resBean.setSuccess(true);
			_logger.info("SectorCode Saved successfully");
			resBean.setMessage("SectorCode Saved successfully");

		}  catch (Exception e) {
			_logger.error("An exception occurred while save new SectorCode : ", e);
			resBean.setSuccess(false);
			resBean.setMessage("Failed to save SectorCode");
		}

		return resBean;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ResponseBean getAllSectorCode(ResponseBean resBean, SectorCodeBean model) {
		try {
			List<SectorCodeBean> allSectorCode= springJdbcDao.getObjectList(queryManager.getAllSectorCode(),null,SectorCodeBean.class);
			if (allSectorCode.size()>0){
				resBean.setSuccess(true);
				resBean.setData(allSectorCode);
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
	public ResponseBean getSectorCodeByOid(ResponseBean resBean, SectorCodeBean model) {
		try {
			SectorCodeBean sectorCode= (SectorCodeBean)springJdbcDao.getObject(queryManager.getSectorCodeByOid(),new Object[]{model.getOid()},SectorCodeBean.class);
			if (sectorCode.getValue()!= null){
				resBean.setSuccess(true);
				resBean.setData(sectorCode);
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
