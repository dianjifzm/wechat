package com.pingan.modules.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pingan.common.AbstractController;
import com.pingan.common.CommonUtils;
import com.pingan.common.ResponseVo;
import com.pingan.weixinVo.UserVo;

@Controller
@RequestMapping("user")
public class UserController extends AbstractController{

//	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="userRegisterIndex.do")
	public String redirect2Register(){
		return "user/userRegister";
	}
	
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
	
	
}
