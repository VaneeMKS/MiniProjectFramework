package com.utility;

import java.io.*;
import java.util.Properties;

public class ConfigDataReader {
	
	Properties prop;
	
	public ConfigDataReader()
	{
		File src=new File("./Config/Config.properties");
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Not able to load config "+e.getMessage());
		}
		
	}
	
	public String getDataFromConfig(String keyToSearch)
	{
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getAppUrl()
	{
		return prop.getProperty("appUrl");
	}

}
