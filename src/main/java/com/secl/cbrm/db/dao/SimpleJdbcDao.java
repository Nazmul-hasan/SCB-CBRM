package com.secl.cbrm.db.dao;

import java.util.List;

public interface SimpleJdbcDao {

    @SuppressWarnings("rawtypes")
	public void saveObjectList(String sql, List entityList) throws Exception;
    
    
}