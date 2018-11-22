package com.ancaiyun.weChat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenBoxMessage {
	
	private static Logger logger = LoggerFactory.getLogger(OpenBoxMessage.class);
	private static List<ConParam> conList = new ArrayList<ConParam>();

	
	/**
	 * 发生命令打开一个指定箱子
	 * @param lockerId ：柜子ID
	 * @param boxSerId ：箱子编号
	 */
	public void openTheBox( Integer lockerId, Integer boxSerId)
    {
		long begin = System.currentTimeMillis(); // 这段代码放在程序执行前
		Date nowTime = new Date();
		Integer conSize = conList.size();
		if (conSize < 1)
		{ //初始化
			for (int i = 0;i<lockerId;i++)
			{
				ConParam conParam = new ConParam();
				conParam.lockerId = i;
				conList.add(i, conParam);
			}
		}
		else if(conSize < lockerId)
		{
			
			for (int i = conSize;i<lockerId;i++)
			{
				ConParam conParam = new ConParam();
				conParam.lockerId = i;
				conList.add(i, conParam);
			}
		}
		
		ConParam conParam = conList.get(lockerId-1);
		if (conParam.lastTime == null)
		{
			conParam.lastTime = new Date();
			conParam.flag = -1;
		}
		else
		{
			conParam.flag = 0;
		}
		
		if ((nowTime.getTime() - conParam.lastTime.getTime())<200 && conParam.flag != -1)
		{
			//同组柜子操作开门时间小于200ms，延迟200ms
			try   
        	{   
				logger.debug("延迟200毫秒");
				Thread.currentThread().sleep(200);//毫秒   
        	}   
        	catch(Exception e){}
		}
		

		long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
		logger.debug("openTheBox   耗时：" + end + "毫秒");
        
        return;
    }
	
	static class ConParam{
		Integer lockerId;
		Date lastTime;
		Integer flag;
		ConParam(){	}
		
	}
}
