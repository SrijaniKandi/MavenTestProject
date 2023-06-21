package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import microsoft.exchange.webservices.*;
import selenium.AbstractPageBase;

public class LoginPage extends AbstractPageBase{
	
	//public WebDriver driver;
	//public static boolean initDriver;
	protected @FindBy(xpath="//*[@id='username']") WebElement fldUserName;
	protected @FindBy(xpath="//*[@id='password']") WebElement fldPassword;
	protected @FindBy(xpath="//*[@id='loginButton']") WebElement btnLogin;
	protected @FindBy(id="Registration Desk") WebElement lnkRegistrationDesk;
	
	public LoginPage(boolean initDriver)
	{
		super(initDriver);
		//System.out.println(this.driver);
		log.info("Initializing driver");

	}
	
	public void goLoginPage()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\srija\\chromedriver113.exe");
		//driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}
//	
	
	public RegistrationDeskPage doLogin() throws Exception {
		
		//System.out.println(this.driver);
		fldUserName.sendKeys("Admin");
		fldPassword.sendKeys("Admin123");
		takeScreenshot(driver,"img");
		lnkRegistrationDesk.click();
		btnLogin.click();
		return new RegistrationDeskPage(driver);
	}

}
