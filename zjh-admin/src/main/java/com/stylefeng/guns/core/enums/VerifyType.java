package com.stylefeng.guns.core.enums;
/** 
* @author lakyjpan
* @version 创建时间：2019年10月10日 下午1:40:33 
*/
public enum VerifyType {
	
	NONE("未审核",0),OK("已审核",1),RETURN("已退回",2),ELSE("--",null);
	
	private String type;  
    private Integer index; 

    private VerifyType(String type, Integer index) {  
        this.type = type;  
        this.index = index;  
    }
    
    public static String getTypeByIndex(Integer index) {
    	if(index == null) {
    		return ELSE.type;
    	}
    	return VerifyType.values()[index].type;
    }
    
	public String getType() {
		return type;
	}
	public int getIndex() {
		return index;
	}
}
