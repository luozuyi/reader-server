package com.ancaiyun.weChat;

import com.ancaiyun.weChat.pojo.*;
import com.ancaiyun.weChat.util.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 菜单管理器类 
 *  
 * @author liufeng 
 * @date 2013-08-08 
 */  
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
  
    public void createWechatMenu() {  
    	
        //稍后修改
        String appid="";String appSecret="";
    	
        // 调用接口获取access_token  
        AccessToken at = WechatUtil.getAccessToken(appid,appSecret);
        if (null != at) {  
            // 调用接口创建菜单  
            int result = WechatUtil.createMenu(getMenu(), at.getToken());  
  
            // 判断菜单创建结果  
            if (0 == result)  
                log.info("菜单创建成功！");  
            else  
                log.info("菜单创建失败，错误码：" + result);  
        }  
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
        CommonButton btn11 = new CommonButton();
        btn11.setName("云V柜");  
        btn11.setType("click");  
        btn11.setKey("11");  
    
  
        CommonButton btn21 = new CommonButton();  
        btn21.setName("存包");  
        btn21.setType("scancode_push");  
        btn21.setKey("21");  
  
  
        CommonButton btn31 = new CommonButton();  
        btn31.setName("取包");  
        btn31.setType("scancode_push");  
        btn31.setKey("31");  
   
  
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("云V柜介绍");  
        mainBtn1.setSub_button(new CommonButton[] { btn11 });  
  
        ComplexButton mainBtn2 = new ComplexButton();  
        mainBtn2.setName("存包");  
        mainBtn2.setSub_button(new CommonButton[] { btn21 });  
  
        ComplexButton mainBtn3 = new ComplexButton();  
        mainBtn3.setName("取包");  
        mainBtn3.setSub_button(new CommonButton[] { btn31 });  
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
  
        return menu;  
    }  
    public static void main(String [] args){
    	new MenuManager().createWechatMenu();
    }
}  
