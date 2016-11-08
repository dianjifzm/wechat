package com.yilan.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractController {

	/** Logger available to subclasses */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public void writeJson(HttpServletResponse response,Object ob){
		
		response.setContentType("application/json");
		try {
			PrintWriter print = response.getWriter();
			print.print(jsonUtil.toJson(ob));
			logger.info(jsonUtil.toJson(ob));
			print.flush();
			print.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
}
