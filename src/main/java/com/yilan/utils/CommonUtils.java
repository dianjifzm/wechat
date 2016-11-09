package com.yilan.utils;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class CommonUtils {
	
	/**
	 * 对象是否为空
	 * @param ob
	 * @return
	 */
	public static boolean isEmpty(Object ob){
		if(ob instanceof String){
			String target = (String)ob;
			return target.trim().length()==0;
			
		}else if (ob instanceof Collection){
			
			return CollectionUtils.isEmpty(((Collection)ob));	
			
		}else if (ob instanceof Map){
			
			return CollectionUtils.isEmpty(((Map)ob));	
			
		}else  return ob==null;	
	}
}
