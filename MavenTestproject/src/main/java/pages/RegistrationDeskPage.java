package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationDeskPage extends AbstractPage{

	public RegistrationDeskPage(WebDriver driver) {
		super(driver);
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
		txtFirstName.sendKeys("abc");
		txtLastName.sendKeys("xyz");
		btnConfirm.click();
		
	}
	

}
