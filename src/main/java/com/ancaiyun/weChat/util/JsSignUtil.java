package com.ancaiyun.weChat.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
  
/** 
 * 官方给的使用js的验证工具 
 * @author Administrator 
 * 
 */  
public class JsSignUtil {  

	
    public static String accessToken = null;  
    private static Logger log = LoggerFactory.getLogger(JsSignUtil.class); 
    public static Map<String, String> sign(String url) {
    	String array[] = url.split("=");
    	String appid = array[array.length-1];

    	 //1、获取AccessToken  
        accessToken = "1";
        //2、获取Ticket  
        String jsapi_ticket = WechatUtil.getTicket(accessToken);  
     
          
        Map<String, String> ret = new HashMap<String, String>();  
        String nonce_str = create_nonce_str();  
        String timestamp = create_timestamp();  
        String string1;  
        String signature = "";  
  
        //注意这里参数名必须全部小写，且必须有序  
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;  
        System.out.println("string1="+string1);  
  
        try  
        {  
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");  
            crypt.reset();  
            crypt.update(string1.getBytes("UTF-8"));  
            signature = byteToHex(crypt.digest());  
        }  
        catch (NoSuchAlgorithmException e)  
        {  
            e.printStackTrace();  
        }  
        catch (UnsupportedEncodingException e)  
        {  
            e.printStackTrace();  
        }  
  
        ret.put("url", url);  
        ret.put("jsapi_ticket", jsapi_ticket);  
        ret.put("nonceStr", nonce_str);  
        ret.put("timestamp", timestamp);  
        ret.put("signature", signature);  
        ret.put("appId", "6514654");
          
        return ret;  
    }  
      
      
    /** 
     * 随机加密 
     * @param hash 
     * @return 
     */  
    private static String byteToHex(final byte[] hash) {  
        Formatter formatter = new Formatter();  
        for (byte b : hash)  
        {  
            formatter.format("%02x", b);  
        }  
        String result = formatter.toString();  
        formatter.close();  
        return result;  
    }  
  
    /** 
     * 产生随机串--由程序自己随机产生 
     * @return 
     */  
    private static String create_nonce_str() {  
        return UUID.randomUUID().toString();  
    }  
  
    /** 
     * 由程序自己获取当前时间 
     * @return 
     */  
    private static String create_timestamp() {  
        return Long.toString(System.currentTimeMillis() / 1000);  
    }  
    
    
    
    public static String SHA1(String decript) {  
        try {  
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());  
            byte messageDigest[] = digest.digest();  
            // Create Hex String  
            StringBuffer hexString = new StringBuffer();  
            // 字节数组转换为 十六进制 数  
                for (int i = 0; i < messageDigest.length; i++) {  
                    String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);  
                    if (shaHex.length() < 2) {  
                        hexString.append(0);  
                    }  
                    hexString.append(shaHex);  
                }  
                return hexString.toString();  
       
            } catch (NoSuchAlgorithmException e) {  
                e.printStackTrace();  
            }  
            return "";  
    }
}  
