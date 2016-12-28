package com.yilan.controller;


import com.yilan.common.AbstractController;
import com.yilan.common.ResponseVo;
import com.yilan.service.UserService;
import com.yilan.utils.CommonUtils;
import com.yilan.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController extends AbstractController {

//	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="userRegister.do")
	public void userRegister(HttpServletRequest request,HttpServletResponse response,UserVo user){
		
		logger.info("userRegister="+user);
		if(CommonUtils.isEmpty(user.getOpenId())) {
			writeJson(response,new ResponseVo("1", user, "缺少微信openId"));
			return ;
		}
		
		int result = userService.addUser(user);
		
		if (result == 0) writeJson(response,new ResponseVo("2", user, "后台服务异常"));
		else writeJson(response,new ResponseVo("2", user, "注册成功，影响"+result+"行！"));
		
	}

	@RequestMapping(value="userInformation")
	public void userInformation(HttpServletRequest request,HttpServletResponse response){
		writeJson(response,new ResponseVo("2", null, "获取用户个人信息！"));
	}
	
	
}
