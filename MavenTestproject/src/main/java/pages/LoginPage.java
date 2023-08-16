package pages;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	protected @FindBy(xpath="//*[@id='hi']") WebElement fldFake;
	
	public LoginPage(boolean initDriver) throws MalformedURLException
	{
		super(initDriver);
		System.out.println(this.driver);
//		log.info("Initializing driver");
//        
		List<String> names = Arrays.asList(
	            "Reflection", "Collection", "Stream");
		List<String> show = names.stream().filter(x -> x.endsWith("n")).collect(Collectors.toList());
//		
		List<Double> number = Arrays.asList(2.0, 3.0, 4.0, 5.0);
		List<Double> show2 = number.stream().map(x -> x.doubleValue()).collect(Collectors.toList());
  
		//List<String> show3 = names.stream().map(x -> x.toUpperCase()).collect();
		//number.stream().filt
		
		names.stream().forEach(x -> System.out.println(x.toLowerCase()));
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
		//externalWait2(fldFake);
		return new RegistrationDeskPage(driver);
	}

}
