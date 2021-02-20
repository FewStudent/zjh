package com.stylefeng.guns.core.enums;
/** 
* @author lakyjpan
* @version 创建时间：2019年10月11日 上午11:00:23 
*/
public enum ReceiveAndSendType {
	NONE("未接送", 0), OK("已接送", 1),ELSE("--",null);

	private String type;
	private Integer index;

	private ReceiveAndSendType(String type, Integer index) {  
        this.type = type;  
        this.index = index;  
    }

	public static String getTypeByIndex(Integer index) {
		if(index == null) {
			return ELSE.type;
		}
		return ReceiveAndSendType.values()[index].type;
	}

	public String getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}
	
}
