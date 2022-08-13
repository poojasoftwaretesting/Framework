package auto_utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Broswer_factory {
	
public static WebDriver startapplication(WebDriver driver, String browserName,String appURL)
{
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
	}else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/Firefoxdriver.exe");
		driver=new FirefoxDriver();
	}else if(browserName.equals("Edge"))
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
	
	}else
	{
		System.out.println("we do not support such browser");
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(appURL);
	return driver;
	
}

public static void closeapplication(WebDriver driver)
{
	driver.quit();
}
}
