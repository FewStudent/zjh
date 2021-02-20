package com.stylefeng.guns.core.enums;
/** 
* @author lakyjpan
* @version 创建时间：2019年10月10日 下午1:44:00 
*/
public enum ArrangeType {
	NONE("未安排", 0), OK("已安排", 1),ELSE("--",null);

	private String type;
	private Integer index;

	private ArrangeType(String type, Integer index) {  
        this.type = type;  
        this.index = index;  
    }

	public static String getTypeByIndex(Integer index) {
		if(index == null) {
			return ELSE.type;
		}
		return ArrangeType.values()[index].type;
	}

	public String getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}
}
