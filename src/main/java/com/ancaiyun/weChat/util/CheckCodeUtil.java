package com.ancaiyun.weChat.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckCodeUtil {
	private static Integer CALIBRATION_NUM = 256; //0x0100
	private static Integer REV_MSG_LEN = 14; //关门上报信息长度
	private static Integer BOX_NUM = 24;
	private static Integer BOX_CHECK_NUM = 16777215; //2^24-1
	private static Logger logger = LoggerFactory.getLogger(CheckCodeUtil.class);
	//receiveCloseMessage 0001FFFE5F02A5
	/**
	 * 0001 :柜子ID
	 * FFFE :校验码
	 * 5F	:手动关门
	 * 02	:箱子ID
	 * A5	:校验码
	 */
	/**
	 * 关门收到的上报消息
	 * @param message ：消息
	 * @param revCode ：收到的命令码
	 * @param boxId	：箱子ID
	 * @param checkCode：校验码
	 * @return -1：异常  0：正常
	 */
	public static Integer checkRevMsg(String message,Integer revCode,Integer boxId,Integer checkCode)
	{
		Integer result = -1;
		//check msg length
		if ((message.length() == REV_MSG_LEN) &&
			((revCode+boxId+checkCode)== CALIBRATION_NUM) )
		{
			result = 0;
		}
		
		return result;
		
	}
	
	
//	/**
//	 * 检查打开箱门返回命令
//	 * @param message ：收到的开门返回命令
//	 * @param boxSerId：箱门ID
//	 * @return -1：异常  0：正常
//	 */
//	public static Integer checkRevOpenMsg(String message, Integer boxSerId)
//	{
//		Integer result = -1;
//		Integer boxId = Integer.valueOf(message.substring(10, 12),16).intValue();
//		Integer checkCode = Integer.valueOf(message.substring(12, 14),16).intValue();
//		Integer revCode = Integer.valueOf(message.substring(8, 10),16).intValue();
//		//check msg length
//		logger.debug("boxSerId======"+boxSerId.toString());
//		logger.debug("boxId======"+boxId.toString());
//		logger.debug("checkCode======"+checkCode.toString());
//		logger.debug("revCode======"+revCode.toString());
//		logger.debug("revCode+boxId+checkCode======"+(revCode+boxId+checkCode));
//		
//		if ((message.length() == REV_MSG_LEN) &&
//			((revCode+boxId+checkCode)== CALIBRATION_NUM) &&
//			(boxSerId == boxId))
//		{
//			result = 0;
//		}
//		
//		return result;
//		
//	}
	
	/**
	 * 合成发送开门指令：3701C7
	 * @param boxSerId ：箱子ID
	 * @return null 异常   ！null正常
	 */
	public String getSendOrder(Integer boxSerId)
	{
		Integer checkCode = 0;
		String result = null;
		Integer sendHexOrder = 55;
		String hexOrder ="37";
		
		if (boxSerId != null)
		{
			checkCode = CALIBRATION_NUM - boxSerId -sendHexOrder;
			String hexBoxId = intChangeToSpecHex(boxSerId,2);
			String hexCheckCode = intChangeToSpecHex(checkCode,2);
			result = hexOrder+hexBoxId+hexCheckCode;
			return result;
		}
		
		return null;
	}
	
	/**
	 * 合成开门成功的指令：0001FFFE5902A5
	 * @param boxSerId ：箱子ID
	 * @param lockerId ：柜子ID
	 * @return null 异常   ！null正常
	 */
	public static String creatOpenSuccessRevOrder(Integer boxSerId, Integer lockerId)
	{
		String lockOrder = CheckCodeUtil.intChangeToSpecHex(lockerId,4);//0001
		String lockCheckCode = CheckCodeUtil.intChangeToSpecHex((65535-lockerId),4);//FFFE
		String suOrder ="59";//十进制89
		String boxOrder = CheckCodeUtil.intChangeToSpecHex(boxSerId,2);//02
		String boxCheckCode = CheckCodeUtil.intChangeToSpecHex((256-89-boxSerId),2);//A5
		
		String result = lockOrder+lockCheckCode+suOrder+boxOrder+boxCheckCode;
		return result;
	}
	
	/**
	 * 整数转换为特定长度的十六进制数的字符串
	 * @param num 转换前的整数
	 * @param len 转换后字符串的长度
	 * @return
	 */
	public static String intChangeToSpecHex(Integer num, Integer len)
	{
		String result = null;
		String zero ="0000000000000000000000";
		Integer numLen = 0;
		//截取字符串，0000
		result = zero.substring(0, len);
		//获取转化十六进制后的字符串长度
		numLen = Integer.toHexString(num).toString().length();
		//字符串拼接
		result = result.substring(0, len-numLen) + Integer.toHexString(num).toString();
		
		return result;
	}
	
	/**
	 * 补齐二进制字符串
	 * @param len 转换后字符串的长度
	 * @return
	 */
	public static String intChangeToSpecBinStr(String binStr, Integer len)
	{
		String result = null;
		String zero ="000000000000000000000000";
		Integer strLen = 0;
		
		strLen = binStr.length();
		if (strLen < len)
		{
			result = zero.substring(0, len-strLen) + binStr;
		}
		else
		{
			result = binStr;
		}
		return result;
	}
	
	/**
	 * 处理上报的箱门信息
	 * @param message   收到的消息 0001  FFFE  1112   EFCEFF  000000  11
	 */
	public static void manageRevAllBoxMsg(String message) {
		Integer lockerId = Integer.valueOf(message.substring(0, 4), 16).intValue();
		String revCode = message.substring(8, 12);
		String frontBoxStatus = message.substring(12, 18);
		String backBoxStatus = message.substring(18, 24);
		String allBoxStatus = "";
		String oldstr = null;
		String binstr = null;
		String str = "";
		long begin = System.currentTimeMillis(); // 这段代码放在程序执行前

		logger.debug("frontBoxStatus=" + frontBoxStatus);

		if ((message.length() != 26) || !revCode.equals("1112")) {
			return;
		} else {
			//1.根据lockerId获取所有箱子的状态
			//2.解析收到的message里面的箱子状态
			//3.校验两套箱子的状态
			//校验规则：

			long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
			logger.debug("manageRevAllBoxMsg   耗时：" + end + "毫秒");

		}

	}
}
