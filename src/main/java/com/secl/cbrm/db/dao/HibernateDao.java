package com.secl.cbrm.db.dao;


import java.util.Date;
import java.util.List;

import com.secl.cbrm.entity.AbstractEntity;

public interface HibernateDao {

    public void saveObject(AbstractEntity entity) throws Exception;

    public List<? extends AbstractEntity> getObjectListByHQL(String hql) throws Exception;

    @SuppressWarnings("rawtypes")
	public AbstractEntity getObjectByOneProperty(Class clazz, String propertyName, String propertyValue) throws Exception;

    @SuppressWarnings("rawtypes")
	public List<? extends AbstractEntity> getObjectList(Class entityClass) throws Exception;

    public void saveList(List<? extends AbstractEntity> entityList) throws Exception;
    
    public void deleteList(List< ? extends AbstractEntity > entityList) throws Exception;
    
    @SuppressWarnings("rawtypes")
	public AbstractEntity getObjectByOneDateValue(Class clazz,String datePropertyName, Date datePropertyValue) throws Exception; 
	
    @SuppressWarnings("rawtypes")
	public  List selectSQLQuery(String sql) throws Exception ;
}