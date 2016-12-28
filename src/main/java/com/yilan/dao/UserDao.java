package com.yilan.dao;


import com.yilan.annotation.MyBatisRepository;
import com.yilan.vo.UserVo;

@MyBatisRepository
public interface UserDao {
	
	/**
	 * 按userId或openId查找用户
	 * @param user
	 * @return
	 */
	public UserVo findUser(UserVo user);

	public int addUser(UserVo user);
}
