package com.ancaiyun.weChat;

import com.ancaiyun.weChat.pojo.Music;
/** 
 * 音乐消息 
 *  
 * @author liufeng 
 * @date 2013-05-19 
 */ 
public class WechatMusicMessage extends BaseWechatMessage {
	 // 音乐  
    private Music Music;
  
    public Music getMusic() {  
        return Music;  
    }  
  
    public void setMusic(Music music) {  
        this.Music = music;  
    }  
}
