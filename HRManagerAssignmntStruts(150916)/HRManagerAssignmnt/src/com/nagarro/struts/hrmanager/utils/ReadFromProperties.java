package com.nagarro.struts.hrmanager.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.nagarro.struts.hrmanager.constants.Constants;

public class ReadFromProperties {

	public static Properties readProperties(String propertyFile) {
		String resourceName = Constants.RESOURCE_PATH + propertyFile;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			props.load(resourceStream);

			

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return props;
	}
}
