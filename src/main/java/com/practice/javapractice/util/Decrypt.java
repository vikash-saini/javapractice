package com.practice.javapractice.util;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

//import org.apache.commons.lang3.exception.ExceptionUtils;

public class Decrypt {
	
	private Decrypt() {}

	public static String decrypt(String key, String initVector, String encrypted) {
		try {
			byte[] raw = key.getBytes(StandardCharsets.UTF_8);
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec,
					new GCMParameterSpec(128,initVector.getBytes(StandardCharsets.UTF_8)));
			byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

			return new String(original, StandardCharsets.UTF_8);

		} catch (Exception e) {
			System.out.println(e.getMessage());
//			ExceptionUtils.getStackTrace(e);
		}

		return null;
	}

	// Please use below code to encrypt db password
	public static String encrypt(String key, String initVector,String plainText)
	{
		try {

			byte[] raw = key.getBytes(StandardCharsets.UTF_8);
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec,
					new GCMParameterSpec(128,initVector.getBytes(StandardCharsets.UTF_8)));

			return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
