package com.yilan.common;

public class ResponseVo {

	/**
	 * @see 返回码,0成功无异常,1输入参数不合法，2后台服务异常
	 */
	private String code;  
	private Object data;  //数据
	private String desc;  //描述
	
	public ResponseVo(Object data){
		this.code = "0";
		this.data = data;
	}

	public ResponseVo(String code, Object data, String desc) {
		super();
		this.code = code;
		this.data = data;
		this.desc = desc;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
