package com.stylefeng.guns.core.enums;
/** 
* @author lakyjpan
* @version 创建时间：2019年10月11日 上午12:42:39 
*/
public enum RoleType {
	MAIN("主持人", 0), SPEAKER("演讲嘉宾", 1),OTHER("观众",2),ELSE("--",null);

	private String type;
	private Integer index;

	private RoleType(String type, Integer index) {  
        this.type = type;  
        this.index = index;  
    }

	public static String getTypeByIndex(Integer index) {
		if(index == null) {
			return ELSE.type;
		}
		return RoleType.values()[index].type;
	}

	public String getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}
}
