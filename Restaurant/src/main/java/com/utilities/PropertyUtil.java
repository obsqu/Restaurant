package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

	public static final String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir + "/src/main/resources/";

	public Properties getAllProperties(String fileName)   {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(filePath + fileName);
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("url is :  " + prop.getProperty("url"));
		System.out.println("username is : " + prop.getProperty("username"));
		System.out.println("password is :" + prop.getProperty("password"));
		return prop;
	}
}
