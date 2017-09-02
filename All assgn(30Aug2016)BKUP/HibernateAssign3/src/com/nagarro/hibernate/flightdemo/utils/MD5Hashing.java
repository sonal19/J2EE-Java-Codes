package com.nagarro.hibernate.flightdemo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The Class MD5Hashing. is a widely used hash function producing a 128-bit hash
 * value. Although MD5 was initially designed to be used as a cryptographic hash
 * function but it can be used as checksum for database
 */
public class MD5Hashing {

	/**
	 * Md5 hashing creating the hash value which is nothing but checksum which
	 * is useful for comparing the updation in the database by comparing the
	 * hash values.
	 *
	 * @param string
	 *            the string whose checksum is generated
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
