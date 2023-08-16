package test;


import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.RegistrationDeskPage;

public class LoginTest extends AbstractTest{
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception{
		beforeClazz(LoginTest.class);
	}
	
	@BeforeMethod
	public void before() {
		System.out.println(login);
		login.goLoginPage();
	}
	
	@Test
	public void verifyLoginSuccess() throws Exception
	{
		RegistrationDeskPage rd  = login.doLogin();
	}

}
