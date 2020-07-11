package com.login.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtil {

	private Cipher cipher = null;

	@PostConstruct
	public Cipher getCipher() throws Exception {
		Signature sign = Signature.getInstance("SHA256withRSA");
		return cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

	}

	private KeyPair getKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048);
		return keyPairGen.generateKeyPair();
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public byte[] encryptData(String password) throws Exception {
		KeyPair pair = getKeyPair();
		PublicKey publicKey = pair.getPublic();
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] input = password.getBytes();
		cipher.update(input);
		return cipher.doFinal();

	}

	/**
	 * @param cipherText
	 * @return
	 * @throws Exception
	 */
	public String decryptData(byte[] cipherText) throws Exception {
		KeyPair pair = getKeyPair();
		cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
		byte[] decipheredText = cipher.doFinal(cipherText);
		return (new String(decipheredText));
	}

}
