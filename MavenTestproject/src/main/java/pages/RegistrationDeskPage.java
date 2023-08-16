package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.AbstractPageBase;

public class RegistrationDeskPage extends AbstractPageBase{

	public RegistrationDeskPage(WebDriver driver) throws MalformedURLException {
		super(false);
		// TODO Auto-generated constructor stub
	}
	
	protected @FindBy(xpath="//a[contains(@id,'registerPatient')]") WebElement lnkRegisterPatient;
	protected @FindBy(xpath="//*[@name='givenName']") WebElement txtFirstName;
	protected @FindBy(xpath="//*[@name='familyName']") WebElement txtLastName;
	protected @FindBy(xpath="//*[@class='confirm right']") WebElement btnConfirm;
	
	
	public void doClickRegisterPatient()
	{
		lnkRegisterPatient.click();
	}
	
	public void doEnterPatientDetails()
	{
		//log.info("Hi");
		txtFirstName.sendKeys("abc");
		takeScreenshot(driver,"img");
		txtLastName.sendKeys("xyz");
		btnConfirm.click();
		
	}
	

}
