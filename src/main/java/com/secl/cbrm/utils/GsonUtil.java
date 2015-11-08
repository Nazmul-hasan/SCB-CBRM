package com.secl.cbrm.utils;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class GsonUtil {
	
	private static Logger _logger = Logger.getLogger(GsonUtil.class);
	private static Gson gson = new Gson();
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized static Object parseObject(String json, Class clazz) {
    	gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Object obj = null;
        try {
            obj = gson.fromJson(json, clazz);
        }
        catch(Exception e) {
            _logger.error("An Exception occured while parse Object : ", e);
        }
        return obj;
    }
	
	public synchronized static String getJson(Object obj) {
        String jsonString = null;
        try {
            jsonString = gson.toJson(obj);
        }
        catch(Exception e) {
            _logger.error("An Exception occured while get JSON String from any Object : ", e);
        }
        return jsonString;
    }
	
	public synchronized static JsonElement toJsonTree(Object obj) {
        JsonElement jsonString = null;
        try {
            jsonString = gson.toJsonTree(obj);
        }
        catch(Exception e) {
            _logger.error("An Exception occured while get JSON Element from any Object : ", e);
        }
        return jsonString;
    }
    	
}
