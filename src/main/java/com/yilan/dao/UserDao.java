package com.yilan.dao;


import com.yilan.vo.UserVo;

public interface UserDao {
	
	/**
	 * 按userId或openId查找用户
	 * @param user
	 * @return
	 */
	public UserVo findUser(UserVo user);

	public int addUser(UserVo user);
}
