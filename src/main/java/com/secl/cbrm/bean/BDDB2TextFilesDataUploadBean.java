package com.secl.cbrm.bean;

import java.util.Date;
import java.util.List;


@SuppressWarnings("serial")
public class BDDB2TextFilesDataUploadBean extends AbstractBean {
	
	 private Long	BDDB2Id;
	 private String	br;
	 private String masterId;
	 private String name;
	 private String fullNo;
	 private String ccy;
	 private String lbal;
	 private String lbalFlag;
	 private String openDate;
	 private String aClas;
	 private String cRind;
	 private String cRate;
	 private String dRind;
	 private String dRate;
	 private String lf;
	 private String cAcflg;
	 private String ref;
	 private String rej;
	 private String sf;
	 private String nxtDate;
	 private String odLimit;
	 private String limLlag;
	 private String expDate;
	 private String fdMat;
	 private String staff;
	 private String dormant;
	 private String drdtLast;
	 private String crdtLast;
	 private String mgmCode;
	 private String seg;
	 private String prd;
	 private String bdTequiv;
	 private String bdtFlag;
	 private String crintBasis;
	 private String term;
	 private String dtfdRoll;
	 private String statCode;
	 private String supFlag;
	 private String intacType;
	 private String crintDue;
	 private String blank0;
	 private String crintacNo;
	 private String drintDue;
	 private String blank1;
	 private String drintacNo;
	 private String crTurnhalFyr;
	 private String drTurnhalFyr;
	 private String crt;
	 private String tax;
	 private String averageBal;
	 private String averageFlg;
	 private String avbpreCal;
	 private String avbpreFlg;
	 private String xRate;
	 private String wDay;
	 private String fdnpi;
	 private String tin;
	 private String tFacc;
	 private String miniTrans;
	 private String drLatxndt;
	 private String crLatxndt;
	 private String intPp;
	 private String notxnHyr;
	 private String nodrtPriod;
	 private String intp;
	 private String trnAccno;
	 private String drintBasis;
	 private String rBal;
	 private String balFlag;
	 private String avgQtrBal;
	 private String avgMonBal;
	 private String inSuspFlag;
	 private String ftpRate;
	 private String filePath;
	 
	 private List<BDDB2TextFilesDataUploadBean> EBBSTextFilesDataUploadList;
	 
     private Date createdOn;
	 private String createdBy;
	 private Date editedOn;
	 private String editedBy;
	 
	 
	 

	public Long getBDDB2Id() {
		return BDDB2Id;
	}

	public void setBDDB2Id(Long bDDB2Id) {
		BDDB2Id = bDDB2Id;
	}

	public String getBr() {
		return br;
	}

	public void setBr(String br) {
		this.br = br;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullNo() {
		return fullNo;
	}

	public void setFullNo(String fullNo) {
		this.fullNo = fullNo;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public String getLbal() {
		return lbal;
	}

	public void setLbal(String lbal) {
		this.lbal = lbal;
	}

	public String getLbalFlag() {
		return lbalFlag;
	}

	public void setLbalFlag(String lbalFlag) {
		this.lbalFlag = lbalFlag;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getaClas() {
		return aClas;
	}

	public void setaClas(String aClas) {
		this.aClas = aClas;
	}

	public String getcRind() {
		return cRind;
	}

	public void setcRind(String cRind) {
		this.cRind = cRind;
	}

	public String getcRate() {
		return cRate;
	}

	public void setcRate(String cRate) {
		this.cRate = cRate;
	}

	public String getdRind() {
		return dRind;
	}

	public void setdRind(String dRind) {
		this.dRind = dRind;
	}

	public String getdRate() {
		return dRate;
	}

	public void setdRate(String dRate) {
		this.dRate = dRate;
	}

	public String getLf() {
		return lf;
	}

	public void setLf(String lf) {
		this.lf = lf;
	}

	public String getcAcflg() {
		return cAcflg;
	}

	public void setcAcflg(String cAcflg) {
		this.cAcflg = cAcflg;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getRej() {
		return rej;
	}

	public void setRej(String rej) {
		this.rej = rej;
	}

	public String getSf() {
		return sf;
	}

	public void setSf(String sf) {
		this.sf = sf;
	}

	public String getNxtDate() {
		return nxtDate;
	}

	public void setNxtDate(String nxtDate) {
		this.nxtDate = nxtDate;
	}

	public String getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(String odLimit) {
		this.odLimit = odLimit;
	}

	public String getLimLlag() {
		return limLlag;
	}

	public void setLimLlag(String limLlag) {
		this.limLlag = limLlag;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getFdMat() {
		return fdMat;
	}

	public void setFdMat(String fdMat) {
		this.fdMat = fdMat;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getDormant() {
		return dormant;
	}

	public void setDormant(String dormant) {
		this.dormant = dormant;
	}

	public String getDrdtLast() {
		return drdtLast;
	}

	public void setDrdtLast(String drdtLast) {
		this.drdtLast = drdtLast;
	}

	public String getCrdtLast() {
		return crdtLast;
	}

	public void setCrdtLast(String crdtLast) {
		this.crdtLast = crdtLast;
	}

	public String getMgmCode() {
		return mgmCode;
	}

	public void setMgmCode(String mgmCode) {
		this.mgmCode = mgmCode;
	}

	public String getSeg() {
		return seg;
	}

	public void setSeg(String seg) {
		this.seg = seg;
	}

	public String getPrd() {
		return prd;
	}

	public void setPrd(String prd) {
		this.prd = prd;
	}

	public String getBdTequiv() {
		return bdTequiv;
	}

	public void setBdTequiv(String bdTequiv) {
		this.bdTequiv = bdTequiv;
	}

	public String getBdtFlag() {
		return bdtFlag;
	}

	public void setBdtFlag(String bdtFlag) {
		this.bdtFlag = bdtFlag;
	}

	public String getCrintBasis() {
		return crintBasis;
	}

	public void setCrintBasis(String crintBasis) {
		this.crintBasis = crintBasis;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getDtfdRoll() {
		return dtfdRoll;
	}

	public void setDtfdRoll(String dtfdRoll) {
		this.dtfdRoll = dtfdRoll;
	}

	public String getStatCode() {
		return statCode;
	}

	public void setStatCode(String statCode) {
		this.statCode = statCode;
	}

	public String getSupFlag() {
		return supFlag;
	}

	public void setSupFlag(String supFlag) {
		this.supFlag = supFlag;
	}

	public String getIntacType() {
		return intacType;
	}

	public void setIntacType(String intacType) {
		this.intacType = intacType;
	}

	public String getCrintDue() {
		return crintDue;
	}

	public void setCrintDue(String crintDue) {
		this.crintDue = crintDue;
	}

	public String getBlank0() {
		return blank0;
	}

	public void setBlank0(String blank0) {
		this.blank0 = blank0;
	}

	public String getCrintacNo() {
		return crintacNo;
	}

	public void setCrintacNo(String crintacNo) {
		this.crintacNo = crintacNo;
	}

	public String getDrintDue() {
		return drintDue;
	}

	public void setDrintDue(String drintDue) {
		this.drintDue = drintDue;
	}

	public String getBlank1() {
		return blank1;
	}

	public void setBlank1(String blank1) {
		this.blank1 = blank1;
	}

	public String getDrintacNo() {
		return drintacNo;
	}

	public void setDrintacNo(String drintacNo) {
		this.drintacNo = drintacNo;
	}

	public String getCrTurnhalFyr() {
		return crTurnhalFyr;
	}

	public void setCrTurnhalFyr(String crTurnhalFyr) {
		this.crTurnhalFyr = crTurnhalFyr;
	}

	public String getDrTurnhalFyr() {
		return drTurnhalFyr;
	}

	public void setDrTurnhalFyr(String drTurnhalFyr) {
		this.drTurnhalFyr = drTurnhalFyr;
	}

	public String getCrt() {
		return crt;
	}

	public void setCrt(String crt) {
		this.crt = crt;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getAverageBal() {
		return averageBal;
	}

	public void setAverageBal(String averageBal) {
		this.averageBal = averageBal;
	}

	public String getAverageFlg() {
		return averageFlg;
	}

	public void setAverageFlg(String averageFlg) {
		this.averageFlg = averageFlg;
	}

	public String getAvbpreCal() {
		return avbpreCal;
	}

	public void setAvbpreCal(String avbpreCal) {
		this.avbpreCal = avbpreCal;
	}

	public String getAvbpreFlg() {
		return avbpreFlg;
	}

	public void setAvbpreFlg(String avbpreFlg) {
		this.avbpreFlg = avbpreFlg;
	}

	public String getxRate() {
		return xRate;
	}

	public void setxRate(String xRate) {
		this.xRate = xRate;
	}

	public String getwDay() {
		return wDay;
	}

	public void setwDay(String wDay) {
		this.wDay = wDay;
	}

	public String getFdnpi() {
		return fdnpi;
	}

	public void setFdnpi(String fdnpi) {
		this.fdnpi = fdnpi;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String gettFacc() {
		return tFacc;
	}

	public void settFacc(String tFacc) {
		this.tFacc = tFacc;
	}

	public String getMiniTrans() {
		return miniTrans;
	}

	public void setMiniTrans(String miniTrans) {
		this.miniTrans = miniTrans;
	}

	public String getDrLatxndt() {
		return drLatxndt;
	}

	public void setDrLatxndt(String drLatxndt) {
		this.drLatxndt = drLatxndt;
	}

	public String getCrLatxndt() {
		return crLatxndt;
	}

	public void setCrLatxndt(String crLatxndt) {
		this.crLatxndt = crLatxndt;
	}

	public String getIntPp() {
		return intPp;
	}

	public void setIntPp(String intPp) {
		this.intPp = intPp;
	}

	public String getNotxnHyr() {
		return notxnHyr;
	}

	public void setNotxnHyr(String notxnHyr) {
		this.notxnHyr = notxnHyr;
	}

	public String getNodrtPriod() {
		return nodrtPriod;
	}

	public void setNodrtPriod(String nodrtPriod) {
		this.nodrtPriod = nodrtPriod;
	}

	public String getIntp() {
		return intp;
	}

	public void setIntp(String intp) {
		this.intp = intp;
	}

	public String getTrnAccno() {
		return trnAccno;
	}

	public void setTrnAccno(String trnAccno) {
		this.trnAccno = trnAccno;
	}

	public String getDrintBasis() {
		return drintBasis;
	}

	public void setDrintBasis(String drintBasis) {
		this.drintBasis = drintBasis;
	}

	public String getrBal() {
		return rBal;
	}

	public void setrBal(String rBal) {
		this.rBal = rBal;
	}

	public String getBalFlag() {
		return balFlag;
	}

	public void setBalFlag(String balFlag) {
		this.balFlag = balFlag;
	}

	public String getAvgQtrBal() {
		return avgQtrBal;
	}

	public void setAvgQtrBal(String avgQtrBal) {
		this.avgQtrBal = avgQtrBal;
	}

	public String getAvgMonBal() {
		return avgMonBal;
	}

	public void setAvgMonBal(String avgMonBal) {
		this.avgMonBal = avgMonBal;
	}

	public String getInSuspFlag() {
		return inSuspFlag;
	}

	public void setInSuspFlag(String inSuspFlag) {
		this.inSuspFlag = inSuspFlag;
	}

	public String getFtpRate() {
		return ftpRate;
	}

	public void setFtpRate(String ftpRate) {
		this.ftpRate = ftpRate;
	}

	public List<BDDB2TextFilesDataUploadBean> getEBBSTextFilesDataUploadList() {
		return EBBSTextFilesDataUploadList;
	}

	public void setEBBSTextFilesDataUploadList(
			List<BDDB2TextFilesDataUploadBean> eBBSTextFilesDataUploadList) {
		EBBSTextFilesDataUploadList = eBBSTextFilesDataUploadList;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getEditedOn() {
		return editedOn;
	}

	public void setEditedOn(Date editedOn) {
		this.editedOn = editedOn;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	@Override
	public String getOperation() {
		return operation;
	}

	@Override
	public void setOperation(String operation) {
		this.operation=operation;
		
	}

	@Override
	public String getOid() {
		return oid;
	}

	@Override
	public void setOid(String oid) {
		this.oid=oid;
		
	}

	@Override
	public LoginBean getLoginBean() {
		return loginBean;
	}

	@Override
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean=loginBean;
		
	}

	
	
}
