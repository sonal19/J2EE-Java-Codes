package com.nagarro.hibernate.flightdemo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashing {
	
	public static StringBuffer md5Hashing(String string) throws NoSuchAlgorithmException{
		final MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(string.getBytes());

		final byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0x00ff) + 0x100, 16).substring(1));
		}
		return sb;
	}

}
