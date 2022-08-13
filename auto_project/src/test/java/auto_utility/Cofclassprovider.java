package auto_utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Cofclassprovider {

	Properties pro;
	public Cofclassprovider()
	{
		File src=new File("./Configuration/conf.properties");
		try
		{
			FileInputStream fi=new FileInputStream(src);
			pro=new Properties();
			pro.load(fi);
			
		}
		catch(Exception e)
		{
			System.out.println("Unable to load config file"+e.getMessage());
		}
	}
	public String getBrowser()
	{
		//return pro.getProperty("Browser");
		
		return pro.getProperty("Browser");
		
	}
	public String getStringurl()
	{
		return pro.getProperty("qaUrl");
	}

}
