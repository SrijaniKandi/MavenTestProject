package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//import org.junit.After;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AbstractPage;
import pages.LoginPage;
import pages.PatientRegistrationPage;
import pages.RegistrationDeskPage;

@RunWith(JUnit4.class)
public class PatientRegistrationTest extends AbstractTest{
	
//public WebDriver driver;
AbstractTest at = new AbstractTest();
//LoginPage login;

	@BeforeClass
	public void setUp() throws Exception{
		beforeClazz(PatientRegistrationTest.class);
	}
	
	@BeforeMethod
	public void before() {
		System.out.println(login);
		login.goLoginPage();
	}
	
	@Test
	public void verifyPatentRegistration() throws Exception
	{
		RegistrationDeskPage rd  = login.doLogin();
		rd.doClickRegisterPatient();
		rd.doEnterPatientDetails();
	}
	
	@AfterTest
	public void getResult(){
		
		ITestResult result = Reporter.getCurrentTestResult();
		System.out.println(result);
		ITestContext con = result.getTestContext();
		System.out.println(con);
		System.out.println(con.getFailedTests());
		IResultMap res = con.getFailedTests();
		if(res.size()>0) {
			at.createReporting(false);
		}
		
		//at.createReporting(status);
	}

}
