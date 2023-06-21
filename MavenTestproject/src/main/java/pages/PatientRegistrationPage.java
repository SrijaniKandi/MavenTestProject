package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientRegistrationPage extends AbstractPage{

	public PatientRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected @FindBy(xpath="//*[@name='givenName']") WebElement txtFirstName;
	protected @FindBy(xpath="//*[@name='familyName']") WebElement txtLastName;
	protected @FindBy(xpath="//*[@class='confirm right']") WebElement btnConfirm;
	
	public void doEnterPatientDetails()
	{
		log.info("Hi");
		txtFirstName.sendKeys("abc");
		txtLastName.sendKeys("xyz");
		btnConfirm.click();
		
	}

}
