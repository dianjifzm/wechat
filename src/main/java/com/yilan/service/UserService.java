package com.yilan.service;

import com.yilan.dao.UserDao;
import com.yilan.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	public static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	public UserDao userDao ;
	
	public int addUser(UserVo user){
		//检查有没有同一微信号的重复注册
		UserVo uv = userDao.findUser(user);
		if (uv!=null) return 0;              //微信号未注册
		else return userDao.addUser(user);
	}
	
}
