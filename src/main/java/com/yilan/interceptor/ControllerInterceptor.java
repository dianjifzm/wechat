package com.yilan.interceptor;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerInterceptor extends HandlerInterceptorAdapter{
	
	public static final Logger logger = Logger.getLogger(ControllerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("baseURL", "http://localhost:8080/weixin/");
		
			return true;
	}

}
