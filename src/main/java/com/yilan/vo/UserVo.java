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

	public UserVo setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public String getOpenId() {
		return openId;
	}

	public UserVo setOpenId(String openId) {
		this.openId = openId;
		return this;
	}

	public String getName() {
		return name;
	}

	public UserVo setName(String name) {
		this.name = name;
		return this;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public UserVo setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public UserVo setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getCreateTime() {
		return createTime;
	}

	public UserVo setCreateTime(String createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public UserVo setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public String getStt() {
		return stt;
	}

	public UserVo setStt(String stt) {
		this.stt = stt;
		return this;
	}

	@Override
	public String toString (){
		
		return "userVo[userId="+userId+",openId="+openId+",name="+name+",cellPhone="+cellPhone+
				",address="+address+",createTime="+createTime+",updateTime="+updateTime+
				",stt="+stt+"]";
	}
}
