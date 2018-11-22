package com.ancaiyun.weChat.service;

import com.ancaiyun.weChat.WechatMessageUtil;
import com.ancaiyun.weChat.WechatNewsMessage;
import com.ancaiyun.weChat.WechatTextMessage;
import com.ancaiyun.weChat.entity.WechatUser;
import com.ancaiyun.weChat.util.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/** 
 * 核心服务类 
 *  
 * @author liufeng 
 * @date 2013-05-20 
 */  
public class CoreService {
	private static Logger log = LoggerFactory.getLogger(CoreService.class);
	 
	/** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";
  
            // xml请求解析  
            Map<String, String> requestMap = WechatMessageUtil.parseXml(request);
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");
            
            String createTime = requestMap.get("CreateTime");
            
            log.debug("CreateTime是："+createTime);
            log.debug("fromUserName是："+fromUserName);
            
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");
            log.debug("toUserName==="+toUserName);
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            // 回复文本消息  
            WechatTextMessage textMessage = new WechatTextMessage();
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(WechatMessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);
            
            // 回复图文消息  
            WechatNewsMessage newsMessage = new WechatNewsMessage();
            newsMessage.setToUserName(fromUserName);  
            newsMessage.setFromUserName(toUserName);  
            newsMessage.setCreateTime(new Date().getTime());  
            newsMessage.setMsgType(WechatMessageUtil.RESP_MESSAGE_TYPE_NEWS);  
            newsMessage.setFuncFlag(0);
  
            // 文本消息  
            if (msgType.equals(WechatMessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                respContent = "您发送的是文本消息！";
            }  
            // 图片消息  
            else if (msgType.equals(WechatMessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";         
            }  
            // 地理位置消息  
            else if (msgType.equals(WechatMessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            }  
            // 链接消息  
            else if (msgType.equals(WechatMessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            }  
            // 音频消息  
            else if (msgType.equals(WechatMessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";  
            }  
            // 事件推送  
            else if (msgType.equals(WechatMessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");
                log.debug("Event类型是："+eventType);
                // 订阅  
                if (eventType.equals(WechatMessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                	//首次订阅，创建用户
                	String nickName = WechatUtil.getUserInfo(fromUserName);
                	if (nickName != null)
                	{
	                    respContent = "谢谢您的关注云微柜！使用云微柜请使用微信扫一扫微柜上的二维码。";
                    }
                	
                    //查询数据库是否已保存用户信息
                	WechatUser wuser = new WechatUser(fromUserName);


                    //如果用户没有关注公众号则保存用户信息

                	
                }  
                // 取消订阅  
                else if (eventType.equals(WechatMessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                	log.debug("我取消关注那");
                	//将用户标记为未关注
                	WechatUser user = new WechatUser(fromUserName,0);

                	
                }
                else if (eventType.equals(WechatMessageUtil.EVENT_TYPE_SCAN)) {  
                    // TODO 扫一扫
                	//scene_id 即生成二维码填充的scene_id字符串，这里代表lockerId
                	 String eventKey = requestMap.get("EventKey");
                	 Integer lockerId = Integer.valueOf(eventKey);	
                	 
                	 log.debug("lockerId柜子的ID=++=++="+eventKey);

                }
                // 自定义菜单点击事件  
                else if (eventType.equals(WechatMessageUtil.EVENT_TYPE_CLICK)) {  
                    // TODO 自定义菜单权没有开放，暂不处理该类消息  
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");  
  
                    if (eventKey.equals("11")) {  
                        respContent = "小时杯菜单项被点击！";
                    }
                    else if (eventKey.equals("21")) {  
                        respContent = "存包菜单项被点击！";
                        //存包
                        //JSONObject object = LockerBoxUtils.openBoxForStorageBag(fromUserName,1);
                        
                    }else if(eventKey.equals("666")){
                    	respContent = "<a href='http://www.ywg.100estore.net/jeesite/f/sys/abc?fromUserName="+fromUserName+"&time="+sdf.format(new Date())+"'>点击取包</a>"; 
                    }
                    else if (eventKey.equals("31")) {  
                        //respContent = "取包菜单项被点击！";
                        //取包
                    	/*LockerBoxUtils.saveCallRecord(fromUserName);
                    	long begin = System.currentTimeMillis(); 
                        JSONObject json = LockerBoxUtils.openBoxForGetBag(fromUserName);
                        String errorMsg = json.getString("errorMsg");
                        String boxId = json.getString("boxId");
                        String lockerId = json.getString("lockerId");
                        
                        try   
	                	{   
                        	Thread.currentThread().sleep(1500);//毫秒   
	                	}   
	                	catch(Exception e){}
                        
                        if (boxId != null && lockerId != null &&errorMsg == null)
                        {
                        	Integer boxSerId = Integer.valueOf(boxId);
                        	Integer lockId = Integer.valueOf(lockerId);
	                    	//从数据库取结果
	                    	String sucOrder = CheckCodeUtil.creatOpenSuccessRevOrder(boxSerId, lockId);
	                    	Date sucTime = LockerBoxUtils.getTimeFromRevMsgByMsgAndLockerId(lockId, sucOrder);
	                    	Date nowTime = new Date();
	                    	
	                    	if (((sucTime != null)&& (nowTime.getTime() - sucTime.getTime())< 3000))
	                    	{
                    			//小于3s，打开成功
                    			//写数据到数据库
                    			LockerBoxUtils.updateBox(lockId, boxSerId, fromUserName, 2);
                    			respContent = "开箱成功,您的"+boxId+"号箱子已经打开！";
                        		JSONObject object = LockerBoxUtils.getReturnWeChatInfo(String.valueOf(lockId));
                        		String reclaimImageUrl = object.getString("reclaimImageUrl");
                        		String reclaimWord = object.getString("reclaimWord");
                        		String reclaimLink = object.getString("reclaimLink");
                        		
                        		List<Article> articleList = new ArrayList<Article>();
                                Article article = new Article();  
                                article.setTitle(respContent);  
                                article.setDescription(reclaimWord);  
                                article.setPicUrl("http://"+request.getServerName()+reclaimImageUrl);  
                                article.setUrl(reclaimLink);  
                                articleList.add(article);  
                                // 设置图文消息个数  
                                newsMessage.setArticleCount(articleList.size());  
                                // 设置图文消息包含的图文集合  
                                newsMessage.setArticles(articleList);  
                                // 将图文消息对象转换成xml字符串                                        
                                respMessage = WechatMessageUtil.newsMessageToXml(newsMessage);

                                long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
                                log.debug("取包    耗时：" + end + "毫秒");
                                return respMessage;
	                    	
	                    	}
	                    	else
	                    	{
	                    		//打开失败，请等待十秒再试	                    		
	                    		respContent = "当前操作太频繁,请过十秒后再操作!";
	                    	}*/
                         	
                        /*}
                        else
                        {
                        	respContent = errorMsg;
                        }*/
                        
                        //long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
                       // log.debug("取包    耗时：" + end + "毫秒");                        
                        
                    }
                    else
                    {
                    	// do nothing
                    }
     
            }
            }
           
            textMessage.setContent(respContent);  
            respMessage = WechatMessageUtil.textMessageToXml(textMessage);
            //log.debug(respMessage);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    } 
    
}
