package com.secl.cbrm.manager;

import com.secl.cbrm.bean.BDDB2TextFilesDataUploadBean;
import com.secl.cbrm.bean.ResponseBean;

public interface BDDB2TextFilesDataUploadManager {

	public ResponseBean UploadBDDB2dataIntoDB(ResponseBean resBean, BDDB2TextFilesDataUploadBean model);
}
