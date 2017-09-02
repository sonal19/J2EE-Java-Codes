package com.nagarro.spring.flightdemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.nagarro.struts.hrmanager.constants.Constants;

/**
 * The Class ReadFromProperties. is used to read the parameters from the
 * properties file and can be used anywhere and can be changed anytime in the
 * properties file
 */
public class ReadFromProperties {

	/**
	 * Read properties used to read the parameters from the properties file and
	 * can be used anywhere and can be changed anytime in the properties file.
	 *
	 * @param propertyFile
	 *            the property file is the file in the resource folder
	 * @return the properties which is used to get the file properties with the
	 *         name corresponding to it
	 */
	public static Properties readProperties(final String propertyFile) {
		final String resourceName = Constants.RESOURCE_PATH + propertyFile;
		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
		final Properties props = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			props.load(resourceStream);
		} catch (final IOException ex) {
			//ex.printStackTrace();
		}
		return props;
	}
}
