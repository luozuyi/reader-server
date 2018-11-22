package com.ancaiyun.weChat.util;

/**
 * 通过开启线程的形式发送短信
 */
import java.io.UnsupportedEncodingException;

public class MessageSend implements Runnable {
	
	private String phone = "";
	private String content = "";
	
	public MessageSend(String phone, String content) {
		this.phone = phone;
		this.content = content;
	}
//	public static String send(String phone, String content) {
//		String sn = "SDK-WSZ-010-00183";
//		String pwd = "757656";
//		String result_mt = "jetsum";
//		try {
//			Client client = new Client(sn, pwd);
//			result_mt = client.mt(phone, content, "", "", "");
//			System.out.println(result_mt);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return result_mt;
//	}

	@Override
	public void run() {
		String sn = "SDK-WSZ-010-00183";
		String pwd = "757656";
		try {
			Client client = new Client(sn, pwd);
			String result_mt = client.mt(phone, content, "", "", "");
			//System.out.println("" + result_mt);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
