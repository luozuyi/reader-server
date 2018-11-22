package com.ancaiyun.weChat.pojo;

/** 
 * 复杂按钮（父按钮） 
 *  
 * @author liufeng 
 * @date 2013-08-08 
 */  
public class ComplexButton extends Button {  
    private Button[] sub_button;  
    
    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private String type;
    private String key; 
  
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Button[] getSub_button() {  
        return sub_button;  
    }  
  
    public void setSub_button(Button[] sub_button) {  
        this.sub_button = sub_button;  
    }  
} 
