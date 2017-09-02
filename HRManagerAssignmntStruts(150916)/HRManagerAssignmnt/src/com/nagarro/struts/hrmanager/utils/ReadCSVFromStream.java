package com.nagarro.struts.hrmanager.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

public class ReadCSVFromStream {

	public static File csvStreamReader(byte[] fileBytes) throws IOException {
		
		File temp = File.createTempFile("tempfile.csv", ".tmp");
		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		CharBuffer chbuff = CharBuffer.allocate(1024 * 1024);
		for (int i = 0; i < fileBytes.length; i++) {
			chbuff.put(i, (char) fileBytes[i]);
			bw.write((char) fileBytes[i]);
			System.out.print((char) fileBytes[i]);
		}
		bw.close();
		return temp;
	}

}
