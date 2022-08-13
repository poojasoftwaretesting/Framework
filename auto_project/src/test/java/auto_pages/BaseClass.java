package auto_pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import auto_utility.Broswer_factory;
import auto_utility.Cofclassprovider;
import auto_utility.ExcelDataProvider;
import auto_utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public Cofclassprovider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite()
	{
		excel=new ExcelDataProvider();
		config=new Cofclassprovider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.driv")+"/Test_reports/classicCRMPRO.html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}


	
	@BeforeClass
	public void setup()
	{

		driver=Broswer_factory.startapplication(driver,config.getBrowser(),config.getStringurl());
	}

	@AfterClass
	public void teardown()
	{

		Broswer_factory.closeapplication(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenShot(driver);
		}
		report.flush();

	}
}
