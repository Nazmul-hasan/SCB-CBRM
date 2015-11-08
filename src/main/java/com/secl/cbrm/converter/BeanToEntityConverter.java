package com.secl.cbrm.converter;

import com.secl.cbrm.bean.BranchBean;
import com.secl.cbrm.bean.ScbBranchBean;
import com.secl.cbrm.bean.SectorCodeBean;
import com.secl.cbrm.bean.UserBean;
import com.secl.cbrm.entity.Branch;
import com.secl.cbrm.entity.ScbBranch;
import com.secl.cbrm.entity.SectorCode;
import com.secl.cbrm.entity.User;
import com.secl.cbrm.bean.TestBean;
import com.secl.cbrm.entity.Test;




public class BeanToEntityConverter {
	
	public static User convertUserBeanToEntity(UserBean model) {
		User entity = new User();
		
		entity.setLoginid(model.getLoginid());
		entity.setRoleid(model.getRoleid());
		entity.setEmployeeid(model.getEmployeeid());
		entity.setPassword(model.getPassword());
		entity.setStatus(model.getStatus());
		entity.setName(model.getName());
		entity.setPhoneno(model.getPhoneno());
		entity.setEmail(model.getEmail());
		entity.setRolejson(model.getRoleJSON());
		
		entity.setCreatedBy(model.getCreatedBy());
		entity.setCreatedOn(model.getCreatedOn());
		entity.setEditedBy(model.getEditedBy());
		entity.setEditedOn(model.getEditedOn());
		
		return entity;
	}
	
	
	public static Branch convertBranchBeanToEntity(BranchBean model) {
		Branch entity = new Branch();
		
		entity.setOid(model.getOid());
		entity.setName(model.getName());
		entity.setAddress(model.getAddress());
		
		return entity;
	}
	
	public static Test convertTestBeanToEntity(TestBean model) {
		Test entity = new Test();
		
		entity.setOid(model.getOid());
		entity.setName(model.getName());
		entity.setDescription(model.getDescription());
		
		return entity;
	}
	
	public static SectorCode convertSectorCodeBeanToEntity(SectorCodeBean model) {
		SectorCode entity = new SectorCode();
		
		entity.setOid(model.getOid());
		entity.setValue(model.getValue());
		entity.setDescription(model.getDescription());
		
		return entity;
	}
	
	public static ScbBranch convertScbBranchBeanToEntity(ScbBranchBean model) {
		ScbBranch entity = new ScbBranch();
		
		entity.setOid(model.getOid());
		entity.setBrCode(model.getBrCode());
		entity.setBrName(model.getBrName());
		entity.setBrAddress(model.getBrAddress());
		entity.setBrCodeForClRpt(model.getBrCodeForClRpt());
		entity.setDivision(model.getDivision());
		entity.setBbBrCode(model.getBbBrCode());
		entity.setBbBrCodeForClRpt(model.getBbBrCodeForClRpt());
		entity.setCreatedOn(model.getCreatedOn());
		entity.setCreatedBy(model.getCreatedBy());
		entity.setEditedOn(model.getEditedOn());
		entity.setEditedBy(model.getEditedBy());
		
		return entity;
	}

}
