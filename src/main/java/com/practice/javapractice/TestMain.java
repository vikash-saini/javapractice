package com.practice.javapractice;

//import java.awt.image.BufferedImage;

//import weblogic.apache.xerces.impl.dv.util.Base64;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.topaz.sigplus.SigPlus;
import java.beans.Beans;
import java.io.FileOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.*;
import org.apache.commons.codec.binary.Base64;

import com.practice.javapractice.util.DareConstants;
import com.practice.javapractice.util.Decrypt;


public class TestMain {

//	static String imageStr="FFFFFFFFB57652B10C00000007000000E9AA3CAAC11D565EC8E37F028C4C057F61A0619F1797B61716C8326575F672B69F5440613AA91C28381E1584F99B12B3B2528085C461623D8349ECF21E4B4920E9C738F1453CC9C3759347012470977E843C0287824AA6BE3138DDCC618ED07A";
	
	public static void main(String[] args) {

		String keyToBeEncrypted = "1PNID09cRhPGZlWWLyP4Nl/9x4PoiQmHI/U=";
		String decrypted = Decrypt.decrypt(DareConstants.LOGIN_DEC_KEY, DareConstants.LOGIN_INIT_VECTOR,
				keyToBeEncrypted);
//		System.out.println("Decryption successful for the provided key.");
		System.out.println(keyToBeEncrypted+" [Decryption TO ==> "+decrypted);
		///---------------------------------------------------------------///
		String keyToBeDecrypted = "svc-darapp";
		String encrypted = Decrypt.encrypt(DareConstants.LOGIN_DEC_KEY, DareConstants.LOGIN_INIT_VECTOR,
				keyToBeDecrypted);
		System.out.println(keyToBeDecrypted+" [ENCRYPTED TO ==> "+encrypted);
		///---------------------------------------------------------------///
		String imageStr="FFFFFFFFB57652B10C00000007000000E9AA3CAAC11D565EC8E37F028C4C057F61A0619F1797B61716C8326575F672B69F5440613AA91C28381E1584F99B12B3B2528085C461623D8349ECF21E4B4920E9C738F1453CC9C3759347012470977E843C0287824AA6BE3138DDCC618ED07A";
		
		String imgStr= new String(imageStr);
		byte[] b1;
		try {
			b1 = Base64.decode(imgStr.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b1);
        String extractStr1 = new String(b1);
        
//		createSigImage(imageStr);
	}
	
	private static void createSigImage(String imageStr, String imageFile, String html) {
		SigPlus sigObj = null;
		try {
		    ClassLoader cl = (com.topaz.sigplus.SigPlus.class).getClassLoader();
			if(StringUtils.isNotBlank(imageStr) && imageStr.length() > 2 ){
		    sigObj = (SigPlus) Beans.instantiate(cl,"com.topaz.sigplus.SigPlus");
		    sigObj.setTabletState(1);
		    sigObj.setSize(350, 140);
		    sigObj.autoKeyStart();
		    sigObj.setAutoKeyData(html);
		    sigObj.autoKeyFinish();
		    sigObj.setEncryptionMode(1);
		    sigObj.setSigCompressionMode(2);
		    sigObj.setImagePenWidth(8);
		    sigObj.setImageXSize(3000);
		    sigObj.setImageYSize(1000);
		    sigObj.setImagePenWidth(4);
		    sigObj.setImageJustifyMode(5);
		    sigObj.setSigString(imageStr);
		    BufferedImage sigImageTemp = sigObj.sigImage();
		    int wTemp = sigImageTemp.getWidth(null);
		    int hTemp = sigImageTemp.getHeight(null);
		    int[] pixelsTemp = new int[(wTemp * hTemp) * 2];
		    sigImageTemp.setRGB(0, 0, 0, 0, pixelsTemp, 0, 0);
		    FileOutputStream fos = new FileOutputStream(imageFile);
		    JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(fos);
		    jpeg.encode(sigImageTemp);
		    fos.close();
			}
		} catch (Exception e) {
		    logger(getExceptionDesc(e));
		}
	    }
}
