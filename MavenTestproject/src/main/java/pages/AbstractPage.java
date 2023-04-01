package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver)
	{
		this(driver,true);
	}
	
	public AbstractPage(WebDriver wdp, boolean initDriver )
	{
		this.driver = wdp;
		if(this.driver==null && initDriver==true)
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\srija\\chromedriver110.exe");
			this.driver = new ChromeDriver();
		}
		PageFactory.initElements(driver, this);	
		//driver.get("https://www.saucedemo.com/");
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}
	

}
