package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Diganta
 *
 */
public class GetPropertyValues {
	/**
	 * 
	 * @param filepath
	 * @param key
	 * @return
	 */
	public static String getPropertyValue
	(String filepath, String key)
	{
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(new File(filepath)));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String data = prop.getProperty(key);
		
		return data;
	}
}
