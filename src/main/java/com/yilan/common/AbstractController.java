package com.yilan.common;

import com.yilan.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AbstractController extends SecureController{

	/** Logger available to subclasses */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	public void writeJson(HttpServletResponse response,Object ob){
		
		response.setContentType("application/json");
		try {
			PrintWriter print = response.getWriter();
			print.print(JsonUtil.toJSON(ob));
			logger.info(JsonUtil.toJSON(ob));
			print.flush();
			print.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
}
