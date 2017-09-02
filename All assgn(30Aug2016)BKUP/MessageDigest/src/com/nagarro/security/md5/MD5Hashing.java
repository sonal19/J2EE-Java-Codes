package com.nagarro.security.md5;

import java.security.MessageDigest;
import java.text.DecimalFormat;

public class MD5Hashing {
	
	public static void main(String[] args)throws Exception
    {
    	String password = "6E377";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0x00ff) + 0x100, 16).substring(1));
        }

        System.out.println("Digest(in hex format):: " + sb.toString());

        StringBuffer sbf = new StringBuffer();
        for( int i=0; i<byteData.length; i++ )     
        {
           byte b = byteData[ i ];
           String hex = Integer.toHexString((int) 0x00FF & b);
           if (hex.length() == 1) 
           {
              sbf.append("0");
           }
           sbf.append( hex );
        }
        System.out.println(sbf.toString());
        
        
        double answer = 5550345.342;
        DecimalFormat df = new DecimalFormat("###.###");
        System.out.println(df.format(answer));
        
    }
}
