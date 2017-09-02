package com.nagarro.struts.hrmanager.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * The Class EncryptionDecryptionAES is used to encrypt a string by using AES
 * method and a fix secret key and chipper sequence.
 */
public class EncryptionDecryptionAES {

	/** The Constant ALGORITHM. */
	private static final String ALGORITHM = "AES";

	/** The Constant keyValue. */
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't',
			'K', 'e', 'y' };

	/**
	 * Encrypt the string in a unreadable string.
	 *
	 * @param valueToEnc
	 *            the value to enc
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public static String encrypt(final String valueToEnc) throws Exception {
		final Key key = generateKey();
		final Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.ENCRYPT_MODE, key);
		final byte[] encValue = c.doFinal(valueToEnc.getBytes());
		final String encryptedValue = new BASE64Encoder().encode(encValue);
		return encryptedValue;
	}

	/**
	 * Decrypt the encrypted string back to decrypted string which is again
	 * readable.
	 *
	 * @param encryptedValue
	 *            the encrypted value
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public static String decrypt(final String encryptedValue) throws Exception {
		final Key key = generateKey();
		final Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.DECRYPT_MODE, key);
		final byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
		final byte[] decValue = c.doFinal(decordedValue);
		final String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	/**
	 * Generate key which is the secret key and on the basis of this encryption
	 * and decryption is occurring.
	 *
	 * @return the key
	 * @throws Exception
	 *             the exception
	 */
	private static Key generateKey() throws Exception {
		final Key key = new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	}
}