package com.nagarro.hibernate.flightdemo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// TODO: Auto-generated Javadoc
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
		final MessageDigest msgDigest = MessageDigest.getInstance("MD5");
		msgDigest.update(string.getBytes());

		final byte byteData[] = msgDigest.digest();

		final StringBuffer strBuffer = new StringBuffer();
		for (int index = 0; index < byteData.length; index++) {
			strBuffer.append(Integer.toString((byteData[index] & 0x00ff) + 0x100, 16).substring(1));
		}
		return strBuffer;
	}

}
