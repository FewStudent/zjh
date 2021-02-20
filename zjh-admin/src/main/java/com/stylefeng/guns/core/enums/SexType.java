package com.stylefeng.guns.core.enums;

/**
 * @author lakyjpan
 * @version 创建时间：2019年10月10日 下午2:31:38
 */
public enum SexType {
	MAN("男", 0), WOMAN("女", 1),ELSE("--",null);

	private String type;
	private Integer index;

	private SexType(String type, Integer index) {
		this.type = type;
		this.index = index;
	}

	public static String getTypeByIndex(Integer index) {
		if(index == null) {
    		return ELSE.type;
    	}
		return SexType.values()[index].type;
	}

	public String getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}
}
