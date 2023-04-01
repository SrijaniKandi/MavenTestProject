package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
	
	protected @FindBy(xpath="//*[@id='username']") WebElement fldUserName;
	protected @FindBy(xpath="//*[@id='password']") WebElement fldPassword;
	protected @FindBy(xpath="//*[@id='loginButton']") WebElement btnLogin;
	protected @FindBy(id="Registration Desk") WebElement lnkRegistrationDesk;
	
	public LoginPage(WebDriver driver, boolean initDriver)
	{
		super(driver);
		
	}
	
	
	public RegistrationDeskPage doLogin() {
		
		fldUserName.sendKeys("Admin");
		fldPassword.sendKeys("Admin123");
		lnkRegistrationDesk.click();
		btnLogin.click();
		return new RegistrationDeskPage(driver);
	}

}
