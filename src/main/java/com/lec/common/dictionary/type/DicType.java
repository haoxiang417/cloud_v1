package com.lec.common.dictionary.type;


/**
 * 数据字典类型枚举类
 * 
 * @author zhouhaij
 * 
 */
public enum DicType {
	//未知类型
	NO_MATCHING_TYPE("404"),
	//链接协议
	AGREEMENT("AGREEMENT")
	;

	private final String value;

    private DicType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
    
    public static DicType valuesOf(String type){
    	  for (DicType dicType : values()) {
              if (dicType.value.equals(type)) {
                  return dicType;
              }
          }
         System.err.println("No matching constant for [" + type + "]");
    	 return DicType.NO_MATCHING_TYPE;
    }
    
    /**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	public String toString() {
        return this.value;
    }
    
    

}
