package com.ancaiyun.weChat;

/** 
 * 图片消息 
 *  
 * @author liufeng 
 * @date 2013-05-19 
 */  
public class WechatImageMessage extends BaseWechatMessage {
	 // 图片链接  
    private String PicUrl;  
  
    public String getPicUrl() {  
        return PicUrl;  
    }  
  
    public void setPicUrl(String picUrl) {  
        this.PicUrl = picUrl;  
    }  
}
