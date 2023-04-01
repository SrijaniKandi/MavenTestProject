package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import pages.PatientRegistrationPage;
import pages.RegistrationDeskPage;

public class PatientRegistrationTest {
	
protected WebDriver driver;
	
	@Test
	public void verifyPatentRegistration()
	{
		LoginPage lp = new LoginPage(driver,true);
		RegistrationDeskPage rd  = lp.doLogin();
		rd.doClickRegisterPatient();
		rd.doEnterPatientDetails();
		
	}

}
