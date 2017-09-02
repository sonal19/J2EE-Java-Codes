package com.nagarro.spring.flightdemo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;



/**
 * The Class ReadCSVFromStream is used to read the data from the byte stream
 * after storing the data into a temporary file.
 */
public class ReadCSVFromStream {

	/**
	 * Csv stream reader read the csv byte stream from the file and return the
	 * temp file for download.
	 *
	 * @param fileBytes
	 *            the file bytes is the lenght of the file that has to be
	 *            written
	 * @return the file is the temp file that is sending back to download
	 * @throws IOException 
	 */
	public static File csvStreamReader(final byte[] fileBytes) throws IOException {

		File temp = null;
		temp = File.createTempFile("tempfile.csv", ".tmp");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
			
			final CharBuffer chbuff = CharBuffer.allocate(1024 * 1024);
			for (int i = 0; i < fileBytes.length; i++) {
				chbuff.put(i, (char) fileBytes[i]);
				bw.write((char) fileBytes[i]);
				System.out.print((char) fileBytes[i]);
				//MyLoggingInterceptor.LOGGER.debug((char) fileBytes[i]);
			}
		} catch (final IOException e) {
			//MyLoggingInterceptor.LOGGER.debug(e);
		}

		return temp;
	}

}
