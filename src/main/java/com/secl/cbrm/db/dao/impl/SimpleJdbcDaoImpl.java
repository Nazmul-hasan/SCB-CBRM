
package com.secl.cbrm.db.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.secl.cbrm.db.dao.SimpleJdbcDao;


@SuppressWarnings("deprecation")
public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport implements SimpleJdbcDao{

    @SuppressWarnings("rawtypes")
    public void saveObjectList(String sql, List entityList) throws Exception 
    {
        try
        {
            //String sql = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (:custId, :name, :age)";
            SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(entityList.toArray());             
            getSimpleJdbcTemplate().batchUpdate(sql, params);
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }
    }
    
}
