package com.acunnoconnect.common.support.encrypt;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;




public class ApplicationEcryptor {
	
	/**
	 * 
	 * @param passedString
	 * @param userId
	 * @return
	 * @throws IOException 
	 */
	public static String encryptString(String passedString, String userId) throws IOException{
		String encryptedString = passedString;
		encryptedString = encryptPassedString(encryptedString);
		return encryptedString;
	}
	
	
	
	/**
	 * 
	 * @param passedString
	 * @param userId
	 * @return
	 * @throws IOException 
	 */
	public static String decryptString(String passedString, String userId) throws IOException{
		String decryptedString = passedString;
		decryptedString = decryptPassedString(decryptedString);
		return decryptedString;
	}
	
	/**
	 * 
	 * @param passedString
	 * @return
	 * @throws IOException
	 */
	 private static String encryptPassedString(String passedString) throws IOException {
	        //encoding  byte array into base 64
		 BASE64Encoder baseEncoder = new BASE64Encoder();
	         String encoded = baseEncoder.encode(passedString.getBytes());     
	        return encoded;
	   	    }
	 
	 /**
	  * 
	  * @param passedString
	  * @return
	  * @throws IOException
	  */
	 private static String decryptPassedString(String passedString) throws IOException {
		 BASE64Decoder baseDecoder = new BASE64Decoder();
	        byte[] decoded = baseDecoder.decodeBuffer(passedString);      
	        return new String(decoded);
	    }
	 
	 	
}
