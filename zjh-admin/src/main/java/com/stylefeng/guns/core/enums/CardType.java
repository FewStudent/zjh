package com.stylefeng.guns.core.enums;

/**
 * @author Hatcher Su
 * @version 创建时间：2019年10月11日 凌晨1点
 */
public enum CardType {
	VIP("贵宾证", 0), DG("嘉宾证", 1),VISIT("参观证",2),ELSE("--",null);

	private String type;
	private Integer index;

	private CardType(String type, Integer index) {
		this.type = type;
		this.index = index;
	}

	public static String getTypeByIndex(Integer index) {
		if(index == null){
			return null;
		}
		return CardType.values()[index].type;
	}

	public String getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}
}
