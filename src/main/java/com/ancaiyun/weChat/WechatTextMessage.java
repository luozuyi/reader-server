package com.ancaiyun.weChat;

/** 
 * 文本消息 
 *  
 * @author liufeng 
 * @date 2013-05-19 
 */  
public class WechatTextMessage extends BaseWechatMessage {
	 // 消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        this.Content = content;  
    }  
}
