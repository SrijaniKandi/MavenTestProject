package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;

public class LoginTest {
	
	protected WebDriver driver;
	
	@Test
	public void verifyLoginSuccess()
	{
		LoginPage lp = new LoginPage(driver,true);
		lp.doLogin();
	}

}
