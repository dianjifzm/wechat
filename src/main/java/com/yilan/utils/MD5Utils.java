package com.yilan.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	public static String getMD5(byte[] src){
		
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};//用来将字节转换成 16 进制表示的字符
		
		
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(src);
			byte[] tar = md.digest();       // MD5 的计算结果是一个 128 位的长整数，用字节表示就是 16 个字节
			char str[] = new char[16*2]; // 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符
			
			int k =0  ;
			for(int i =0 ; i<tar.length ; i++){
				byte byte0 = tar[i];      //取第 i 个字节,如35：0010 0011
				str[k++] = hexDigits[byte0>>>4&0xf];   //取高4位 0010
				str[k++] = hexDigits[byte0 & 0xf];   //取低4位 0011
			}
			
			return new String(str);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main (String[] args){
		String src = "abc中国";
		String MD5str = MD5Utils.getMD5(src.getBytes());
		
		System.out.println(MD5str);
	}
	
}
