package com.secl.cbrm.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.tree.AbstractEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.secl.cbrm.db.dao.HibernateDao;
import com.secl.cbrm.db.dao.SimpleJdbcDao;
import com.secl.cbrm.db.dao.SpringJdbcDao;
import com.secl.cbrm.manager.IDGenerator;
import com.secl.cbrm.manager.Manager;
import com.secl.cbrm.manager.SessionManager;
import com.secl.cbrm.querymanager.CibReportQueryManager;
import com.secl.cbrm.querymanager.ClReportQueryManager;
import com.secl.cbrm.querymanager.DaynamicQueryReportQueryManager;
import com.secl.cbrm.querymanager.FinancialReportQueryManager;
import com.secl.cbrm.querymanager.QueryManager;
import com.secl.cbrm.querymanager.SBS3ReportQueryManager;
import com.secl.cbrm.utils.ReportUtil;


public class ManagerImpl implements Manager {
	
	protected QueryManager queryManager;
	
	protected CibReportQueryManager cibReportQueryManager;
	
	protected ClReportQueryManager clReportQueryManager;
	
	protected DaynamicQueryReportQueryManager daynamicQueryReportQueryManager;
	
	protected FinancialReportQueryManager financialReportQueryManager;
	
	protected SBS3ReportQueryManager sbs3ReportQueryManager;
	
	protected HibernateDao hibernateDao;
	
	protected IDGenerator idGenerator;
	
	protected SpringJdbcDao springJdbcDao;
    
	protected SimpleJdbcDao simpleJdbcDao;    
    
    protected DriverManagerDataSource dataSource;
    
    protected ReportUtil reportUtil;
    
    protected SessionManager sessionManager;
    
	protected List<AbstractEntity> entityList = new ArrayList<AbstractEntity>();

	public void setIdGenerator(IDGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	public void setHibernateDao(HibernateDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}

	public void setSpringJdbcDao(SpringJdbcDao springJdbcDao) {
		this.springJdbcDao = springJdbcDao;
	}

	public void setSimpleJdbcDao(SimpleJdbcDao simpleJdbcDao) {
		this.simpleJdbcDao = simpleJdbcDao;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	public void setCibReportQueryManager(CibReportQueryManager cibReportQueryManager) {
		this.cibReportQueryManager = cibReportQueryManager;
	}

	public void setClReportQueryManager(ClReportQueryManager clReportQueryManager) {
		this.clReportQueryManager = clReportQueryManager;
	}

	public void setDaynamicQueryReportQueryManager(
			DaynamicQueryReportQueryManager daynamicQueryReportQueryManager) {
		this.daynamicQueryReportQueryManager = daynamicQueryReportQueryManager;
	}

	public void setFinancialReportQueryManager(
			FinancialReportQueryManager financialReportQueryManager) {
		this.financialReportQueryManager = financialReportQueryManager;
	}
	public void setSbs3ReportQueryManager(
			SBS3ReportQueryManager sbs3ReportQueryManager) {
		this.sbs3ReportQueryManager = sbs3ReportQueryManager;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setReportUtil(ReportUtil reportUtil) {
		this.reportUtil = reportUtil;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}



}
