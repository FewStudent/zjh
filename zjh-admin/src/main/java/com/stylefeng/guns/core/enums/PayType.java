package com.stylefeng.guns.core.enums;
/** 
* @author lakyjpan
* @version 创建时间：2019年10月10日 下午1:20:59 
*/
public enum PayType {

	SELF("自费",0),PUB("公费",1),OTHER("其他",2),ELSE("--",null);
	
	private String type;  
    private Integer index;  

    private PayType(String type, Integer index) {  
        this.type = type;  
        this.index = index;  
    }
    
    public static String getTypeByIndex(Integer index) {
    	if(index == null) {
    		return ELSE.type;
    	}
    	return PayType.values()[index].type;
    }
    
	public String getType() {
		return type;
	}
	public int getIndex() {
		return index;
	}
    
}
