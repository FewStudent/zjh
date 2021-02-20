package com.stylefeng.guns.core.enums;

/**
 * @author lakyjpan
 * @version 创建时间：2019年10月10日 下午3:04:25
 */
public enum YesOrNo {
	NONE("否", 0), OK("是", 1),ELSE("--",null);

	private String type;
	private Integer index;

	private YesOrNo(String type, Integer index) {
		this.type = type;
		this.index = index;
	}

	public static String getTypeByIndex(Integer index) {
		if(index == null) {
			return ELSE.type;
		}
		return YesOrNo.values()[index].type;
	}

	public String getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}
}
