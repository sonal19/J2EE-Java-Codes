package com.nagarro.hibernate.flightdemo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The Class MD5Hashing.
 */
public class MD5Hashing {

	/**
	 * Md5 hashing.
	 *
	 * @param string
	 *            the string
	 * @return the string buffer
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 */
	public static StringBuffer md5Hashing(final String string) throws NoSuchAlgorithmException {
		final MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(string.getBytes());

		final byte byteData[] = md.digest();

		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0x00ff) + 0x100, 16).substring(1));
		}
		return sb;
	}

}
