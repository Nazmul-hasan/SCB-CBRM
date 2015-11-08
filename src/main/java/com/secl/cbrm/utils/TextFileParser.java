package com.secl.cbrm.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.secl.cbrm.bean.BDDB2TextFilesDataUploadBean;
import com.secl.cbrm.db.dao.SpringJdbcDao;
import com.secl.cbrm.querymanager.QueryManager;

public class TextFileParser {

	
	public static void ParseText(BDDB2TextFilesDataUploadBean model,QueryManager queryManager,SpringJdbcDao springJdbcDao) 
	{
		final List<BDDB2TextFilesDataUploadBean> inputList = new ArrayList<>();
		TransactionDefinition transDef = new DefaultTransactionDefinition();
		TransactionStatus transStatus = springJdbcDao.getTransactionManager().getTransaction(transDef);
				
		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			fis = new FileInputStream(model.getFilePath());
			reader = new BufferedReader(new InputStreamReader(fis));
			String line = reader.readLine();
			while (line != null) {
				model.setBDDB2Id(100000L);
				model.setBr(line.substring(0, 2).trim());
				model.setMasterId(line.substring(0, 2).trim());
				model.setName(line.substring(9, 44).trim());
				model.setFullNo(line.substring(44, 55).trim());
				model.setCcy(line.substring(55, 57).trim());
				model.setLbal(line.substring(57, 70).trim());
				model.setLbalFlag(line.substring(70, 71).trim());
				model.setOpenDate(line.substring(71, 77).trim());
				model.setaClas(line.substring(77, 83).trim());

				model.setcRind(line.substring(83, 84).trim());
				model.setcRate(line.substring(84, 91).trim());
				model.setdRind(line.substring(91, 92).trim());
				model.setdRate(line.substring(92, 99).trim());
				model.setLf(line.substring(99, 100).trim());
				model.setcAcflg(line.substring(100, 101).trim());
				model.setRef(line.substring(101, 102).trim());
				model.setRej(line.substring(102, 103).trim());
				model.setSf(line.substring(103, 104).trim());

				model.setNxtDate(line.substring(104, 110).trim());
				model.setOdLimit(line.substring(110, 123).trim());
				model.setLimLlag(line.substring(123, 124).trim());
				model.setExpDate(line.substring(124, 130).trim());
				model.setFdMat(line.substring(130, 136).trim());
				model.setStaff(line.substring(136, 137).trim());
				model.setDormant(line.substring(138, 144).trim());
				model.setDrdtLast(line.substring(102, 103).trim());
				model.setCrdtLast(line.substring(144, 150).trim());

				model.setMgmCode(line.substring(150, 152).trim());
				model.setSeg(line.substring(152, 154).trim());
				model.setPrd(line.substring(154, 157).trim());
				model.setBdTequiv(line.substring(157, 170).trim());
				model.setBdtFlag(line.substring(170, 170).trim());
				model.setCrintBasis(line.substring(171, 174).trim());
				model.setTerm(line.substring(174, 176).trim());
				model.setDtfdRoll(line.substring(176, 182).trim());
				model.setStatCode(line.substring(182, 186).trim());

				model.setSupFlag(line.substring(186, 187).trim());
				model.setIntacType(line.substring(187, 191).trim());
				model.setCrintDue(line.substring(191, 202).trim());
				model.setBlank0(line.substring(202, 205).trim());
				model.setCrintacNo(line.substring(205, 216).trim());
				model.setDrintDue(line.substring(216, 227).trim());
				model.setBlank1(line.substring(227, 230).trim());
				model.setDrintacNo(line.substring(230, 241).trim());
				model.setCrTurnhalFyr(line.substring(241, 254).trim());

				model.setDrTurnhalFyr(line.substring(254, 267).trim());
				model.setCrt(line.substring(267, 268).trim());
				model.setTax(line.substring(268, 269).trim());
				model.setAverageBal(line.substring(269, 282).trim());
				model.setAverageFlg(line.substring(282, 283).trim());
				model.setxRate(line.substring(297, 304).trim());
				model.setwDay(line.substring(304, 310).trim());
				model.setFdnpi(line.substring(310, 316).trim());
				model.setTin(line.substring(316, 317).trim());

				model.settFacc(line.substring(317, 328).trim());
				model.setMiniTrans(line.substring(328, 339).trim());
				model.setDrLatxndt(line.substring(339, 345).trim());
				model.setCrLatxndt(line.substring(345, 351).trim());
				model.setIntPp(line.substring(351, 352).trim());
				model.setNotxnHyr(line.substring(352, 359).trim());
				model.setNodrtPriod(line.substring(359, 366).trim());
				model.setIntp(line.substring(366, 367).trim());
				model.setTrnAccno(line.substring(367, 378).trim());

				model.setDrintBasis(line.substring(378, 381).trim());
				model.setrBal(line.substring(381, 394).trim());
				model.setBalFlag(line.substring(394, 395).trim());
				model.setAvgQtrBal(line.substring(395, 408).trim());
				model.setAvgMonBal(line.substring(408, 421).trim());
				model.setInSuspFlag(line.substring(421, 422).trim());
				model.setFtpRate(line.substring(422, 429).trim());

				inputList.add(model);
				line = reader.readLine();
			}

			if (inputList.size() > 0) {
				InsertBddb2ByBatch(inputList,model,springJdbcDao,queryManager);
				springJdbcDao.getTransactionManager().commit(transStatus);

			} else {
				
			}
		} catch (Exception e) {
			springJdbcDao.getTransactionManager().rollback(transStatus);

		}

		finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {

			}
		}

	}
	
	
	
	private static void InsertBddb2ByBatch(final List<BDDB2TextFilesDataUploadBean> batchData,final BDDB2TextFilesDataUploadBean model,SpringJdbcDao springJdbcDao,QueryManager queryManager) {
		  try {
				
				BatchPreparedStatementSetter pss = new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						BDDB2TextFilesDataUploadBean batch = batchData.get(i);
						ps.setLong(1,batch.getBDDB2Id());
						ps.setString(2,batch.getBr());
						ps.setString(3,batch.getMasterId());
						ps.setString(4,batch.getName());
						ps.setString(5,batch.getFullNo());
						ps.setString(6,batch.getCcy());
						ps.setString(7,batch.getLbal());
						ps.setString(8,batch.getLbalFlag());
						ps.setString(9,batch.getOpenDate());
						
						ps.setString(10,batch.getaClas());
						ps.setString(11,batch.getcRind());
						ps.setString(12,batch.getcRate());
						ps.setString(13,batch.getdRind());
						ps.setString(14,batch.getdRate());
						ps.setString(15,batch.getLf());
						
						ps.setString(16,batch.getcAcflg());
						ps.setString(17,batch.getRef());
						ps.setString(18,batch.getRej());
						ps.setString(19,batch.getSf());
						ps.setString(20,batch.getNxtDate());
						
						ps.setString(21,batch.getOdLimit());
						ps.setString(22,batch.getLimLlag());
						ps.setString(23,batch.getExpDate());
						ps.setString(24,batch.getFdMat());
						ps.setString(25,batch.getStaff());
						ps.setString(26,batch.getDormant());
						ps.setString(27,batch.getDrdtLast());
						ps.setString(28,batch.getCrdtLast());
						ps.setString(29,batch.getMgmCode());
						ps.setString(30,batch.getSeg());
						ps.setString(31,batch.getPrd());
						ps.setString(32,batch.getBdTequiv());
						ps.setString(33,batch.getBdtFlag());
						ps.setString(34,batch.getCrintBasis());
						ps.setString(35,batch.getTerm());
						ps.setString(36,batch.getDtfdRoll());
						ps.setString(37,batch.getStatCode());
						ps.setString(38,batch.getSupFlag());
						ps.setString(39,batch.getIntacType());
						ps.setString(40,batch.getCrintDue());
						ps.setString(41,batch.getBlank0());
						ps.setString(42,batch.getCrintacNo());
						
						
						ps.setString(43,batch.getDrintDue());
						ps.setString(44,batch.getBlank1());
						ps.setString(45,batch.getDrintacNo());
						ps.setString(46,batch.getCrTurnhalFyr());
						ps.setString(47,batch.getDrTurnhalFyr());
						ps.setString(48,batch.getCrt());
						ps.setString(49,batch.getTax());
						ps.setString(50,batch.getAverageBal());
						ps.setString(51,batch.getAverageFlg());
						ps.setString(52,batch.getxRate());
						ps.setString(53,batch.getwDay());
						ps.setString(54,batch.getFdnpi());
						ps.setString(55,batch.getTin());
						ps.setString(56,batch.gettFacc());
						ps.setString(57,batch.getMiniTrans());
						ps.setString(58,batch.getDrLatxndt());
						ps.setString(59,batch.getCrLatxndt());
						ps.setString(60,batch.getIntPp());
						ps.setString(61,batch.getNodrtPriod());
						ps.setString(62,batch.getCrintDue());
						ps.setString(63,batch.getIntp());
						ps.setString(64,batch.getTrnAccno());
						
						ps.setString(65,batch.getDrintBasis());
						ps.setString(66,batch.getrBal());
						ps.setString(67,batch.getBalFlag());
						ps.setString(68,batch.getAvgQtrBal());
						ps.setString(69,batch.getAvgMonBal());
						ps.setString(70,batch.getInSuspFlag());
						ps.setString(71,batch.getFtpRate());
						ps.setTimestamp(72,new Timestamp(new Date().getTime()));
						ps.setString(73,model.getLoginBean().getLoginId());
						
					}
					
					@Override
					public int getBatchSize() {
						return batchData.size();
					}
				};
				springJdbcDao.saveBatchUpate(queryManager.bddb2BatchUpload(), pss);
				
			} catch (Exception e) {
				
	   }
  }
	
}

