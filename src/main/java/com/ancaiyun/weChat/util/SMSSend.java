package com.ancaiyun.weChat.util;


/**
 * 发送短信
 * @param phone 手机号 
 * @param content 发送内容
 * @author Daley 
 *
 */
public class SMSSend {
	private static int times =0;

	public static void  send(String phone, String content) {
		System.out.println("times:"+times);
		if(times<500)
		{
			MessageSend ms = new MessageSend(phone, content);
			Thread thread = new Thread(ms);
			thread.run();
			times++;
		}
		
			
	}
	

}

