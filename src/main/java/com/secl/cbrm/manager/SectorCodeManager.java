package com.secl.cbrm.manager;


import javax.servlet.http.HttpServletRequest;

import com.secl.cbrm.bean.SectorCodeBean;
import com.secl.cbrm.bean.ResponseBean;

public interface SectorCodeManager {

	public ResponseBean SaveSectorCode(HttpServletRequest request,ResponseBean resBean, SectorCodeBean model);



	public ResponseBean getAllSectorCode(ResponseBean resBean, SectorCodeBean model);



	public ResponseBean getSectorCodeByOid(ResponseBean resBean, SectorCodeBean model);

}
