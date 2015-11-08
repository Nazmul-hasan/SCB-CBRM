package com.secl.cbrm.rest.service;


import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

@Path("/file")
public class FileUploadService {
	
	@Context ServletContext servletContext;
	private final String ROOT_FOLDER_FILES = "BDDB2";
	private Logger _logger = Logger.getLogger(this.getClass());
 
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@Context HttpServletRequest req,@Context HttpServletResponse res) {
			
		String path = manageRequest(req, res);
		return Response.status(200).entity(path).build();
		
	}
 
	private String manageRequest(HttpServletRequest req, HttpServletResponse res)
    {
		String str = "";
		 try  {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				String rootPath = servletContext.getRealPath(ROOT_FOLDER_FILES);
				List items = null;
				items = upload.parseRequest(req);
				Iterator iter = items.iterator();
				
				  while (iter.hasNext()) {
				      FileItem item = (FileItem) iter.next();
				      if (item.isFormField()) { }
				      else {
				       if (!item.isFormField()) {
		
				        String fileName = item.getName();
				        File fullFile  = new File(item.getName());
				        File rootDirectory = new File(rootPath);
				        if (!rootDirectory.exists()) {  
			        		rootDirectory.mkdir();  
			             } 
				        File directory = new File(rootDirectory.getPath()+File.separator);
				        if (!directory.exists()) {  
			        		directory.mkdir();  
			            } 
				        File savedFile = new File(directory.getPath(), fullFile.getName());
				        
						item.write(savedFile);
						
						str = savedFile.getPath();
						return str;
				       }
				     }
				  
				  }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return str;
    }


	public Logger get_logger() {
		return _logger;
	}

	public void set_logger(Logger _logger) {
		this._logger = _logger;
	}
	
 
}
