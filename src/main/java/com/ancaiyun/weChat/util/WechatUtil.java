package com.ancaiyun.weChat.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;  
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.ConnectException;  
import java.net.HttpURLConnection;
import java.net.URL;  
import java.util.Date;
import java.util.List;
  
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;  
import javax.net.ssl.SSLContext;  
import javax.net.ssl.SSLSocketFactory;  
import javax.net.ssl.TrustManager;


import com.ancaiyun.weChat.entity.WeixinUserInfo;
import com.ancaiyun.weChat.pojo.AccessToken;
import com.ancaiyun.weChat.pojo.Menu;
import jdk.nashorn.internal.objects.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


/** 
 * 公众平台通用接口工具类 
 *  
 * @author liuyq 
 * @date 2013-08-09 
 */  
public class WechatUtil {
	
	 private static Logger log = LoggerFactory.getLogger(WechatUtil.class);
	  
	// 获取access_token的接口地址（GET） 限200（次/天）  
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET"; 
	 
	// 菜单创建（POST） 限100（次/天）  
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  

	// 菜单创建（POST） 限50000（次/天）  
	public static String get_user_info_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";  

	// 生成临时二维码ticket（POST） 最长有效期30天  
	// {"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
	public static String creat_temporary_qr_code_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";  

	// 生成永久二维码ticket（POST） 最多10w个
	// {"action_name": "QR_LIMIT_STR_SCENE", "action_info": {"scene": {"scene_str": "123"}}}
	public static String creat_perpetual_qr_code_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";  
	
	//获取二维码图片
	public static String get_qr_code_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";  
	
	
	 /** 
	     * 发起https请求并获取结果 
	     *  
	     * @param requestUrl 请求地址 
	     * @param requestMethod 请求方式（GET、POST） 
	     * @param outputStr 提交的数据 
	     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
	     */  
	    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
	        JSONObject jsonObject = null;  
	        StringBuffer buffer = new StringBuffer();  
	        try {  
	            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
	            TrustManager[] tm = { new MyX509TrustManager() };  
	            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
	            sslContext.init(null, tm, new java.security.SecureRandom());  
	            // 从上述SSLContext对象中得到SSLSocketFactory对象  
	            SSLSocketFactory ssf = sslContext.getSocketFactory();  
	  
	            URL url = new URL(requestUrl);  
	            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
	            httpUrlConn.setSSLSocketFactory(ssf);  
	  
	            httpUrlConn.setDoOutput(true);  
	            httpUrlConn.setDoInput(true);  
	            httpUrlConn.setUseCaches(false);  
	            // 设置请求方式（GET/POST）  
	            httpUrlConn.setRequestMethod(requestMethod);  
	  
	            if ("GET".equalsIgnoreCase(requestMethod))  
	                httpUrlConn.connect();  
	            
	            // 当有数据需要提交时  
	            if (null != outputStr) {  
	                OutputStream outputStream = httpUrlConn.getOutputStream();  
	                // 注意编码格式，防止中文乱码  
	                outputStream.write(outputStr.getBytes("UTF-8"));  
	                outputStream.close();  
	            }  
	  
	            // 将返回的输入流转换成字符串  
	            InputStream inputStream = httpUrlConn.getInputStream();  
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
	  
	            String str = null;  
	            while ((str = bufferedReader.readLine()) != null) {  
	                buffer.append(str);  
	            }  
	            bufferedReader.close();  
	            inputStreamReader.close();  
	            // 释放资源  
	            inputStream.close();  
	            inputStream = null;  
	            httpUrlConn.disconnect();
	           jsonObject = JSONObject.parseObject(buffer.toString());
	           
	        } catch (ConnectException ce) {  
	            log.error("Weixin server connection timed out.");  
	        } catch (Exception e) {  
	            log.error("https request error:{}", e);  
	        }  
	        return jsonObject;  
	    }
	    
	    
		 /** 
	     * 发起https请求并获取结果 
	     *  
	     * @param requestUrl 请求地址 
	     * @param requestMethod 请求方式（GET、POST）
	     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
	     */  
	    public static String httpRequestRqCode(String requestUrl, String requestMethod, String lockerName) 
	    {  
	         
	        try {  
	            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
	            TrustManager[] tm = { new MyX509TrustManager() };  
	            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
	            sslContext.init(null, tm, new java.security.SecureRandom());  
	            // 从上述SSLContext对象中得到SSLSocketFactory对象  
	            SSLSocketFactory ssf = sslContext.getSocketFactory();  
	  
	            URL url = new URL(requestUrl);  
	            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
	            httpUrlConn.setSSLSocketFactory(ssf);  
	  
	            httpUrlConn.setDoOutput(true);  
	            httpUrlConn.setDoInput(true);  
	            httpUrlConn.setUseCaches(false);  
	           	  
	            // 将返回的输入流转换成字符串  
	            InputStream inputStream = httpUrlConn.getInputStream();
	         // 设置数据缓冲  
	            byte[] bs = new byte[1024 * 3];  
	            // 读取到的数据长度  
	            int len;  
	            // 输出的文件流保存图片至本地
	            String realPath = "WechatImage";
				//FileUtils.createDirectory(FileUtils.path(realPath));
				Long time = new Date().getTime();
				String fileName = time.toString();
				String path = realPath+"/"+fileName+lockerName+".png";

				OutputStream os = new FileOutputStream(path);
				while ((len = inputStream.read(bs)) != -1) {
					os.write(bs, 0, len);
				}
				os.close();

				// 释放资源
	            inputStream.close();  
	            inputStream = null;
	            return fileName+lockerName+".png";
	           
	        } catch (ConnectException ce) {  
	            log.error("Weixin server connection timed out.");  
	        } catch (Exception e) {  
	            log.error("https request error:{}", e);  
	        }  
	        return null;  
	    }
	    
	    /** 
	     * 获取access_token 
	     *  

	     * @return 
	     */  
	    public static AccessToken getAccessToken(String appIds,String appSecrets) {  
	        AccessToken accessToken = null;
	     // 第三方用户唯一凭证  
	        String appId = appIds;  
	        // 第三方用户唯一凭证密钥  
	        String appSecret = appSecrets;
	      
	        String requestUrl = access_token_url.replace("APPID", appId).replace("APPSECRET", appSecret);  
	        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);  
	        // 如果请求成功  
	        if (null != jsonObject) {  
	            try {  
	                accessToken = new AccessToken();  
	                accessToken.setToken(jsonObject.getString("access_token"));  
	                accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));  
	            } catch (JSONException e) {  
	                accessToken = null;  
	                // 获取token失败  
	                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));  
	            }  
	        }  
	        return accessToken;  
	    } 
	    
	    /** 
	     * 创建菜单 
	     *  
	     * @param menu 菜单实例 
	     * @param accessToken 有效的access_token 
	     * @return 0表示成功，其他值表示失败 
	     */  
	    public static int createMenu(Menu menu, String accessToken) {
	        int result = 0;  
	        // 拼装创建菜单的url  
	        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);  
	        // 将菜单对象转换成json字符串  
	        String jsonMenu = JSONObject.toJSONString(menu);  
	        // 调用接口创建菜单  
	        JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);  
	      
	        if (null != jsonObject) {  
	            if (0 != jsonObject.getIntValue("errcode")) {  
	                result = jsonObject.getIntValue("errcode");  
	                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));  
	            }  
	        }  
	      
	        return result;  
	    } 
	    
	    /**
	     * 获取用户信息  
	     * @param openId 微信OpenId
	     * @return 返回用户的昵称
	     */
	    public static String getUserInfo(String openId) {  
	        String result = null;
	        // 调用接口获取access_token 
	        
	        //稍后修改
	        String appid="";String appSecret="";
	        
	        AccessToken at = WechatUtil.getAccessToken(appid,appSecret);
	        if (at != null)
	        {
	        	String accessToken = at.getToken();
	        	// 拼装创建菜单的url  
		        String requestUrl = get_user_info_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		        // 调用接口创建菜单
		        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		        // 如果请求成功  
		        if (null != jsonObject) {  
		            try {  
		                 log.debug(jsonObject.getString("nickname"));
		                 result = jsonObject.getString("nickname");
	            } catch (JSONException e) {  
		                accessToken = null;  
		                // 获取token失败  
		                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));  
		            }  
		        } 
	        }
	      
	        return result;  
	    }
	    
	    /**
	     * 获取用户信息
	     * 
	     * @param accessToken 接口访问凭证
	     * @param openId 用户标识
	     * @return WeixinUserInfo
	     */
	    public static WeixinUserInfo getUserInfo(String accessToken, String openId) {
	      WeixinUserInfo weixinUserInfo = null;
	      // 拼接请求地址
	      String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
	      requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
	      // 获取用户信息
	      JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
	      if (null != jsonObject) {
	        try {
	          weixinUserInfo = new WeixinUserInfo();
	          // 用户的标识
	          weixinUserInfo.setOpenId(jsonObject.getString("openid"));
	          // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
	          weixinUserInfo.setSubscribe(jsonObject.getInteger("subscribe"));
	          // 用户关注时间
	          weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
	          // 昵称
	          weixinUserInfo.setNickname(jsonObject.getString("nickname"));
	          // 用户的性别（1是男性，2是女性，0是未知）
	          weixinUserInfo.setSex(jsonObject.getInteger("sex"));
	          // 用户所在国家
	          weixinUserInfo.setCountry(jsonObject.getString("country"));
	          // 用户所在省份
	          weixinUserInfo.setProvince(jsonObject.getString("province"));
	          // 用户所在城市
	          weixinUserInfo.setCity(jsonObject.getString("city"));
	          // 用户的语言，简体中文为zh_CN
	          weixinUserInfo.setLanguage(jsonObject.getString("language"));
	          // 用户头像
	          weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
	        } catch (Exception e) {
	          if (0 == weixinUserInfo.getSubscribe()) {
	            log.error("用户{}已取消关注", weixinUserInfo.getOpenId());
	          } else {
	            int errorCode = jsonObject.getInteger("errcode");
	            String errorMsg = jsonObject.getString("errmsg");
	            log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
	          }
	        }
	      }
	      return weixinUserInfo;
	    }
	    
	    /**
	     * 创建二维码图片链接
	     * @param lockerId：柜子ID
	     * @param lockerName：柜子编号
	     * @return
	     */
	    public static String createQuickResCode(Integer lockerId, String lockerName,String appid) {  
	        String result = null;
	     // lin{"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
	        
	        JSONObject jsonObj = new JSONObject();
	        JSONObject jsonSce = new JSONObject();
	        JSONObject jsonInfo = new JSONObject();
	        JSONObject jsonScene = new JSONObject();
	        
	        jsonSce.put("scene_str", lockerId.toString());
	        jsonScene.put("scene", jsonSce);
	        //jsonInfo.put("action_info", jsonScene);
	        
	        //jsonObj.put("expire_seconds", 604800);
	        jsonObj.put("action_name", "QR_LIMIT_STR_SCENE");
	        jsonObj.put("action_info", jsonScene);
	        
	        
	        log.debug("jsonObj===="+jsonObj.toJSONString());
		     // 调用接口获取access_token 
	        


	        AccessToken at = new AccessToken();
	        
	        if (at != null)
	        {
		        // 拼装创建临时二维码ticket的url  
		        //String url = creat_temporary_qr_code_url.replace("ACCESS_TOKEN", at.getToken());
	        	
		        // 拼装创建永久二维码【最多10w个】ticket的url
	        	String url = creat_perpetual_qr_code_url.replace("ACCESS_TOKEN", at.getToken());
		        
		        // 将菜单对象转换成json字符串  
		        String jsonQrCode = jsonObj.toJSONString();  
		        // 调用接口创建二维码Ticket  
		        JSONObject jsonObject = httpRequest(url, "POST", jsonQrCode);  
		      
		        if (null != jsonObject) {
		        	String ticket = jsonObject.getString("ticket");
		        	log.debug("ticket===="+ticket);
		        	// 拼装创建二维码图片的url
		        	String encodeTicket = java.net.URLEncoder.encode(ticket);
			        String imageUrl = get_qr_code_url.replace("TICKET", encodeTicket);  
			        String rqcodeUrl = httpRequestRqCode(imageUrl, "GET", lockerName);
		            return rqcodeUrl;
		        }
	        }
	      
	        return result;  
	    }
	    
	    /** 
	     * 获取jsapi_ticket
	     *  

	     * @return 
	     */ 
	    public static String getTicket(String access_token) {  
	        String ticket = null;  
	        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ access_token +"&type=jsapi";//这个url链接和参数不能变  
	        try {  
	            URL urlGet = new URL(url);  
	            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();  
	            http.setRequestMethod("GET"); // 必须是get方式请求  
	            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
	            http.setDoOutput(true);  
	            http.setDoInput(true);  
	            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
	            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
	            http.connect();  
	            InputStream is = http.getInputStream();  
	            int size = is.available();  
	            byte[] jsonBytes = new byte[size];  
	            is.read(jsonBytes);  
	            String message = new String(jsonBytes, "UTF-8");  
	            JSONObject demoJson = JSONObject.parseObject(message);  
	            System.out.println("JSON字符串："+demoJson);  
	            ticket = demoJson.getString("ticket");  
	            is.close();  
	        } catch (Exception e) {  
	                e.printStackTrace();  
	        }  
	        return ticket;  
	    } 
	    
	    /**
	     * 创建A存B取柜子二维码
	     * */
		/**
		 * 生成二维码
		 * @param srcValue 二维码信息 qrcodePicfilePath 二维码生成路径
		 * */
		public static boolean encode(String srcValue, String qrcodePicfilePath){
			//设置最大数据长度 200
			int MAX_DATA_LENGTH = 300;
			//将二维码信息转化为字节数组
			byte[] d = srcValue.getBytes();
			//获取数组长度
			int dataLength = d.length;
			//设置图片的宽度 113
			int imageWidth = 600; //原始数据300
			//设置图片的高度     
			int imageHeight = imageWidth;
			/*
			 * BufferedImage 子类描述具有可访问图像数据缓冲区的 Image
			 * TYPE_INT_RGB表示一个图像，它具有合成整数像素的 8 位 RGB 颜色分量。
			 * */
			BufferedImage bi = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);
			//创建一个 Graphics2D，可以将它绘制到此 BufferedImage 中   
			Graphics2D g = bi.createGraphics();
			//设置画布的背景颜色     
			g.setBackground(Color.WHITE);
			//通过使用当前绘图表面的背景色进行填充来清除指定的矩形
			g.clearRect(0, 0, imageWidth, imageHeight);
			//将此图形上下文的当前颜色设置为指定颜色     
			g.setColor(Color.BLACK);
			//如果数据长度大于0,并且长度小于等于设置的最大数据长度     

			return true;
			}
}
