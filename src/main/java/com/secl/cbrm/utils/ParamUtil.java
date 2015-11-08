package com.secl.cbrm.utils;

import com.google.common.base.Joiner;

public class ParamUtil {
    
    public synchronized static Object[] getParamsWithoutObject(Object...obj)
    {
        return obj;
    }
    
    public synchronized static String getOids(String[] oids)
    {
        StringBuffer oid = new StringBuffer();
        oid.append("'");
        oid.append(Joiner.on("','").join(oids));
        oid.append("'");
        return oid.toString();
    }
    
}
