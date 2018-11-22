package com.ancaiyun.weChat.payment;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.springframework.stereotype.Controller;

/**
 * 微信支付调用统一接口
 * */
public class ObtainParameter {

	   public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
	        StringBuffer sb = new StringBuffer();
	        Set es = parameters.entrySet();
	        Iterator it = es.iterator();
	        while(it.hasNext()) {
	            Map.Entry entry = (Map.Entry)it.next();
	            String k = (String)entry.getKey();
	            Object v = entry.getValue();
	            if(null != v && !"".equals(v) 
	                    && !"sign".equals(k) && !"key".equals(k)) {
	                sb.append(k + "=" + v + "&");
	            }
	        }
	        //sb.append("key=" + ConfigUtil.API_KEY);
	        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
	        return sign;
	    }
	
}
