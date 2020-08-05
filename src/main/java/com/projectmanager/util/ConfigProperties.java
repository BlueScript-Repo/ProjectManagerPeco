package com.projectmanager.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.annotation.ManagedBean;

@ManagedBean
public class ConfigProperties {
	InputStream inputStream;

	public String getPropValues(String propertyName) throws IOException {
		return getProperty("config.properties", propertyName);

	}

	public String getStandardTypePorperties(String propertyName) {
		return getProperty("standard.properties", propertyName);
	}

	private String getProperty(String fileName, String propertyName) {
		String propertyVal = "";
		try {
			Properties prop = new Properties();
			String propFileName = fileName;

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			// get the property value and print it out
			propertyVal = prop.getProperty(propertyName);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return propertyVal;
	}
	
	public Set getStandardTypKeys()
	{
		try
		{
			Properties prop = new Properties();
			String propFileName = "standard.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			
			return prop.keySet();
		}
		catch(Exception ex)
		{
			
		}
		return null;
	}
}
