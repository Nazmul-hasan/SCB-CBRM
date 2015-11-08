package com.secl.cbrm.db.dao.impl;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secl.cbrm.db.dao.HibernateDao;
import com.secl.cbrm.entity.AbstractEntity;

 
public class HibernateDaoImpl extends HibernateDaoSupport implements HibernateDao
{
	
    public void saveObject(AbstractEntity entity) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(entity);
            getHibernateTemplate().flush();
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<? extends AbstractEntity> getObjectListByHQL(String hql) throws Exception {
        List<? extends AbstractEntity> entities = null;
        try {
            entities = getHibernateTemplate().find(hql);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return entities;
    }

    @SuppressWarnings("rawtypes")
    public AbstractEntity getObjectByOneProperty(Class clazz, String propertyName, String propertyValue) throws Exception {
        AbstractEntity entity = null;
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(clazz).add(Restrictions.eq(propertyName, propertyValue)) ;
            List objects = getHibernateTemplate().findByCriteria(criteria);
            if(objects != null && !objects.isEmpty()) {
                entity = (AbstractEntity) objects.get(0);
            }
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return entity;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<? extends AbstractEntity> getObjectList(Class entityClass) throws Exception {
        List<? extends AbstractEntity> entityList = null;
        try {
            entityList = getHibernateTemplate().loadAll(entityClass);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return entityList;
    }

    public void saveList(List< ? extends AbstractEntity > entityList) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdateAll(entityList);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
	
    public void deleteList(List< ? extends AbstractEntity > entityList) throws Exception {
        try {
            getHibernateTemplate().deleteAll(entityList);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
    

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<? extends AbstractEntity> getObjectListByOneDateValue(Class clazz,String datePropertyName, Date datePropertyValue) throws Exception {
		List objects = null;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(clazz).add(Restrictions.eq(datePropertyName, datePropertyValue)) ;
			objects = getHibernateTemplate().findByCriteria(criteria);
		}
		catch (Exception e) {
			throw new Exception(e);
			
		}
		return objects;
	}
	
	@SuppressWarnings("rawtypes")
	public AbstractEntity getObjectByOneDateValue(Class clazz,String datePropertyName, Date datePropertyValue) throws Exception {
		AbstractEntity entity = null;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(clazz).add(Restrictions.eq(datePropertyName, datePropertyValue)) ;
			List objects = getHibernateTemplate().findByCriteria(criteria);
            if(objects != null && !objects.isEmpty()) {
                entity = (AbstractEntity) objects.get(0);
            }
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		return entity;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<? extends AbstractEntity> getObjectByToDateFromDatePropertyDateValue(Class clazz, String calculationDatePropertyName, Date fromDateValue, Date toDateValue) throws Exception {
		//List objects = getHibernateTemplate().findByNamedParam("from " + clazz, propertyName, propertyValue);
		List objects = null;
		try
		{
			DetachedCriteria criteria = DetachedCriteria.forClass(clazz).add(Restrictions.between(calculationDatePropertyName, fromDateValue, toDateValue));
			objects = getHibernateTemplate().findByCriteria(criteria);
			//objects = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.eq(propertyName, propertyValue)).list();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		return objects;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<? extends AbstractEntity> getObjectByPropertyNameAndValueAndDateRange(Class clazz, String propertyName, String propertyValue,String datePropertyName,Date fromDate, Date toDate) throws Exception {
		List objects = null;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(clazz).add(Restrictions.eq(propertyName, propertyValue)) ;
			criteria.add(Restrictions.between(datePropertyName, fromDate,toDate));
			objects = getHibernateTemplate().findByCriteria(criteria);
			//objects = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.eq(propertyName, propertyValue)).list();
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		return objects;
	}
	
	

	@SuppressWarnings({"rawtypes" })
	public Object getObjectByOid(Class clazz, String propertyName, String propertyValue) throws Exception {
		List objects = null;
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(clazz).add(Restrictions.eq(propertyName, propertyValue)) ; 
			objects = getHibernateTemplate().findByCriteria(criteria);
		}
		catch (Exception e) {
			throw new Exception(e);		
		}
		if(objects == null || objects.isEmpty() == true) {
			return null;
		}
		return objects.get(0);
	}

	
	@SuppressWarnings("rawtypes")
	public  List selectSQLQuery(String sql) throws Exception {
        List list = null;
        Transaction transaction = null;
        try {
            Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql);
            list = query.list();
            transaction.commit();
        }
        catch(Exception e) {
            transaction.rollback();
            throw new Exception(e);
        }
        return list;
    }

}