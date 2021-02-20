package com.stylefeng.guns.core.enums;

/**
 * @author lakyjpan
 * @version 创建时间：2019年10月10日 下午1:43:06
 */
public enum EndType {
	NONE("未结束", 0), OK("已结束", 1),ELSE("--",null);

	private String type;
	private Integer index;

	private EndType(String type, Integer index) {  
        this.type = type;  
        this.index = index;  
    }

	public static String getTypeByIndex(Integer index) {
		if(index == null) {
			return ELSE.type;
		}
		return EndType.values()[index].type;
	}

	public String getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}
}
