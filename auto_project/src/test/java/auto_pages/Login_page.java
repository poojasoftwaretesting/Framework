package auto_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page {
	WebDriver driver;


	public Login_page(WebDriver driver)
	{
	this.driver=driver;
	}


	@FindBy(name="username")
	WebElement uname;

	@FindBy(name="password")
	WebElement pass;

	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement loginButton;


	public  void loginCRM(String usernameApplication,String passwordApplication)
	{
	uname.sendKeys(usernameApplication);
	pass.sendKeys(passwordApplication);
	loginButton.click();
	}
}
