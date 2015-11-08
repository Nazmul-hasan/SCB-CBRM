package com.secl.cbrm.manager.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.secl.cbrm.bean.BDDB2TextFilesDataUploadBean;
import com.secl.cbrm.bean.ResponseBean;
import com.secl.cbrm.manager.BDDB2TextFilesDataUploadManager;
import com.secl.cbrm.utils.Constant;


public class BDDB2TextFilesDataUploadManagerImpl extends ManagerImpl implements BDDB2TextFilesDataUploadManager, Constant 
{
	private Logger _logger = Logger.getLogger(this.getClass());
	
	@Override
	public ResponseBean UploadBDDB2dataIntoDB(ResponseBean resBean,BDDB2TextFilesDataUploadBean model) {
		final List<BDDB2TextFilesDataUploadBean> inputList = new ArrayList<>();
		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			fis = new FileInputStream(model.getFilePath());
			reader = new BufferedReader(new InputStreamReader(fis));
			String line = reader.readLine();
			while (line != null) {
				model.setBr(line.substring(0,2).trim()); //2
				model.setMasterId(line.substring(2,9).trim());//7
				model.setName(line.substring(9, 44).trim());//35
				model.setFullNo(line.substring(44, 55).trim());//11
				model.setCcy(line.substring(55, 57).trim());//2
				model.setLbal(line.substring(57, 70).trim());//13
				model.setLbalFlag(line.substring(70, 71).trim());//1
				model.setOpenDate(line.substring(71, 77).trim());//6
				model.setaClas(line.substring(77, 83).trim());//6
				model.setcRind(line.substring(83, 84).trim());//1
				model.setcRate(line.substring(84, 91).trim());//7
				model.setdRind(line.substring(91, 92).trim());//1
				model.setdRate(line.substring(92, 99).trim());//7
				model.setLf(line.substring(99, 100).trim());//1
				model.setcAcflg(line.substring(100, 101).trim());//1
				model.setRef(line.substring(101, 102).trim());//1
				model.setRej(line.substring(102, 103).trim());//1
				model.setSf(line.substring(103, 104).trim());//1
				model.setNxtDate(line.substring(104, 110).trim());//6
				model.setOdLimit(line.substring(110, 123).trim());//13
				model.setLimLlag(line.substring(123, 124).trim());//1
				model.setExpDate(line.substring(124, 130).trim());//6
				model.setFdMat(line.substring(130, 136).trim());//6
				model.setStaff(line.substring(136, 137).trim());//1
				model.setDormant(line.substring(137,138).trim());//1
				model.setDrdtLast(line.substring(138, 144).trim());//6
				model.setCrdtLast(line.substring(144, 150).trim());//6
				model.setMgmCode(line.substring(150, 152).trim());//2
				model.setSeg(line.substring(152, 154).trim());//2
				model.setPrd(line.substring(154, 157).trim());//3
				model.setBdTequiv(line.substring(157, 170).trim());//13
				model.setBdtFlag(line.substring(170, 171).trim());//1
				model.setCrintBasis(line.substring(171, 174).trim());//3
				model.setTerm(line.substring(174, 176).trim());//2
				model.setDtfdRoll(line.substring(176, 182).trim());//6
				model.setStatCode(line.substring(182, 186).trim());//4
				model.setSupFlag(line.substring(186, 187).trim());//1
				model.setIntacType(line.substring(187, 191).trim());//4
				model.setCrintDue(line.substring(191, 202).trim());//11
				model.setBlank0(line.substring(202, 205).trim());//3
				model.setCrintacNo(line.substring(205, 216).trim());//11
				model.setDrintDue(line.substring(216, 227).trim());//11
				model.setBlank1(line.substring(227, 230).trim());//3
				model.setDrintacNo(line.substring(230, 241).trim());//11
				model.setCrTurnhalFyr(line.substring(241, 254).trim());//13
				model.setDrTurnhalFyr(line.substring(254, 267).trim());//13
				model.setCrt(line.substring(267, 268).trim());//1
				model.setTax(line.substring(268, 269).trim());//1
				model.setAverageBal(line.substring(269,282).trim());//13
				model.setAverageFlg(line.substring(282,283).trim());//1
				model.setAvbpreCal(line.substring(283,296).trim());//13
				model.setAvbpreFlg(line.substring(296,297).trim());//1
				model.setxRate(line.substring(297, 304).trim());//7
				model.setwDay(line.substring(304, 310).trim());//6
				model.setFdnpi(line.substring(310, 316).trim());//6
				model.setTin(line.substring(316, 317).trim());//1
				model.settFacc(line.substring(317, 328).trim());//11
				model.setMiniTrans(line.substring(328, 339).trim());//1
				model.setDrLatxndt(line.substring(339, 345).trim());//6
				model.setCrLatxndt(line.substring(345, 351).trim());//6
				model.setIntPp(line.substring(351, 352).trim());//1
				model.setNotxnHyr(line.substring(352, 359).trim());//7
				model.setNodrtPriod(line.substring(359, 366).trim());//7
				model.setIntp(line.substring(366, 367).trim());//1
				model.setTrnAccno(line.substring(367, 378).trim());//11
				model.setDrintBasis(line.substring(378, 381).trim());//3
				model.setrBal(line.substring(381, 394).trim());//13
				model.setBalFlag(line.substring(394, 395).trim());//1
				model.setAvgQtrBal(line.substring(395, 408).trim());//13
				model.setAvgMonBal(line.substring(408, 421).trim());//13
				model.setInSuspFlag(line.substring(421, 422).trim());//1
				model.setFtpRate(line.substring(422, 429).trim());//7

				inputList.add(model);
				line = reader.readLine();
			}
			
			if (inputList.size() > 0) {
				InsertBddb2ByBatch(inputList,model);
				resBean.setSuccess(true);
				resBean.setMessage("Succesfully upload "+inputList.size()+" row's in DB from txt file");
			} else {
				resBean.setSuccess(true);
				resBean.setMessage("No record found for parsing");
			}
		} catch (Exception e) {
			resBean.setMessage("Unable to Parsed BDDB2 file in DB");
			_logger.error("An Exception occured while Parsed BDDB2 file in DB : ", e);
		}

		finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {

			}
		}
		return resBean;
	}
	
	

	private  void InsertBddb2ByBatch(final List<BDDB2TextFilesDataUploadBean> batchData,final BDDB2TextFilesDataUploadBean model) {
		
		TransactionDefinition transDef = new DefaultTransactionDefinition();
		TransactionStatus transStatus = springJdbcDao.getTransactionManager().getTransaction(transDef);
		
		  try {
				
				BatchPreparedStatementSetter pss = new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						BDDB2TextFilesDataUploadBean batch = batchData.get(i);
						
						ps.setString(1,batch.getBr());
						ps.setString(2,batch.getMasterId());
						ps.setString(3,batch.getName());
						ps.setString(4,batch.getFullNo());
						ps.setString(5,batch.getCcy());
						ps.setString(6,batch.getLbal());
						ps.setString(7,batch.getLbalFlag());
						ps.setString(8,batch.getOpenDate());
						ps.setString(9,batch.getaClas());
						ps.setString(10,batch.getcRind());
						ps.setString(11,batch.getcRate());
						ps.setString(12,batch.getdRind());
						ps.setString(13,batch.getdRate());
						ps.setString(14,batch.getLf());
						ps.setString(15,batch.getcAcflg());
						ps.setString(16,batch.getRef());
						ps.setString(17,batch.getRej());
						ps.setString(18,batch.getSf());
						ps.setString(19,batch.getNxtDate());
						ps.setString(20,batch.getOdLimit());
						
						ps.setString(21,batch.getLimLlag());
						ps.setString(22,batch.getExpDate());
						ps.setString(23,batch.getFdMat());
						ps.setString(24,batch.getStaff());
						ps.setString(25,batch.getDormant());
						ps.setString(26,batch.getDrdtLast());
						ps.setString(27,batch.getCrdtLast());
						ps.setString(28,batch.getMgmCode());
						ps.setString(29,batch.getSeg());
						ps.setString(30,batch.getPrd());
						ps.setString(31,batch.getBdTequiv());
						ps.setString(32,batch.getBdtFlag());
						ps.setString(33,batch.getCrintBasis());
						ps.setString(34,batch.getTerm());
						ps.setString(35,batch.getDtfdRoll());
						ps.setString(36,batch.getStatCode());
						
						ps.setString(37,batch.getSupFlag());
						ps.setString(38,batch.getIntacType());
						ps.setString(39,batch.getCrintDue());
						ps.setString(40,batch.getBlank0());
						ps.setString(41,batch.getCrintacNo());
						ps.setString(42,batch.getDrintDue());
						ps.setString(43,batch.getBlank1());
						ps.setString(44,batch.getDrintacNo());
						ps.setString(45,batch.getCrTurnhalFyr());
						ps.setString(46,batch.getDrTurnhalFyr());
						ps.setString(47,batch.getCrt());
						ps.setString(48,batch.getTax());
						ps.setString(49,batch.getAverageBal());
						ps.setString(50,batch.getAverageFlg());
						ps.setString(51, batch.getAvbpreCal());
						ps.setString(52, batch.getAvbpreFlg());
						
						ps.setString(53,batch.getxRate());
						ps.setString(54,batch.getwDay());
						ps.setString(55,batch.getFdnpi());
						ps.setString(56,batch.getTin());
						ps.setString(57,batch.gettFacc());
						ps.setString(58,batch.getMiniTrans());
						ps.setString(59,batch.getDrLatxndt());
						ps.setString(60,batch.getCrLatxndt());
						ps.setString(61,batch.getIntPp());
						ps.setString(62,batch.getNotxnHyr());
						ps.setString(63,batch.getNodrtPriod());
						ps.setString(64,batch.getIntp());
						ps.setString(65,batch.getTrnAccno());
						ps.setString(66,batch.getDrintBasis());
						ps.setString(67,batch.getrBal());
						ps.setString(68,batch.getBalFlag());
						ps.setString(69,batch.getAvgQtrBal());
						
						ps.setString(70,batch.getAvgMonBal());
						ps.setString(71,batch.getInSuspFlag());
						ps.setString(72,batch.getFtpRate());
						ps.setTimestamp(73,new Timestamp(new Date().getTime()));
						ps.setString(74,model.getLoginBean().getLoginId());
						
					}
					
					@Override
					public int getBatchSize() {
						return batchData.size();
					}
				};
				springJdbcDao.saveBatchUpate(queryManager.bddb2BatchUpload(), pss);
				springJdbcDao.getTransactionManager().commit(transStatus);
				_logger.info("Succesfully Parsed Bddb2 text file in DB");
			} catch (Exception e) {
				 springJdbcDao.getTransactionManager().rollback(transStatus);
				_logger.error("An Exception occured while Parsed BDDB2 file in DB : ", e);
				
	   }
  }
	
}