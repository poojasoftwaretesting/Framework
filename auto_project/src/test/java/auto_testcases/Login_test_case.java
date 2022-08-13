package auto_testcases;

import java.sql.Driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import auto_pages.BaseClass;
import auto_pages.Login_page;
import auto_utility.Broswer_factory;
import auto_utility.ExcelDataProvider;

public class Login_test_case extends BaseClass{

	
	
	@Test
	public void loginapp()
	{
		logger=report.createTest(" login to CRMPRO");
	    excel.getStringData("login", 0, 0);
		Login_page lp=PageFactory.initElements(driver, Login_page.class);
		logger.info("starting application");
	    lp.loginCRM(excel.getStringData("login", 0, 0),excel.getStringData("login", 0, 1));
	    logger.pass("login sucessfull");
		
		
	}
}
