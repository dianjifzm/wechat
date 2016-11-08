package com.yilan.vo;

import java.io.Serializable;

public class UserVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2368249945665622582L;
	
	private int userId; //主键
	private String openId;
	private String name;
	private String cellPhone;
	private String address;
	private String createTime;
	private String updateTime;
	private String stt;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}  
	
	@Override
	public String toString (){
		
		return "userVo[userId="+userId+",openId="+openId+",name="+name+",cellPhone="+cellPhone+
				",address="+address+",createTime="+createTime+",updateTime="+updateTime+
				",stt="+stt+"]";
	}
}
