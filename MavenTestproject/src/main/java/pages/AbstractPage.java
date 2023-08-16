package pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import selenium.SeleniumTest;
import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.MutableCapabilities;


public class AbstractPage{
	
	protected WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	
	public AbstractPage(WebDriver driver) throws MalformedURLException
	{
		this(driver,true);
	}
	
	public AbstractPage(WebDriver wdp, boolean initDriver) throws MalformedURLException
	{
		this.driver = wdp;
		String USERNAME = "oauth-srijaniguptak-20ba2";
		String ACCESS_KEY = "bdf165ae-7a10-4410-9937-121af436bb6b";
		String urlPAth = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub";
		String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
	    String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";
		
		MutableCapabilities sauce = new MutableCapabilities();
		sauce.setCapability("seleniumVersion", "3.141.0");
		sauce.setCapability("username", USERNAME);
		sauce.setCapability("accesskey", ACCESS_KEY);
		//sauce.setCapability("name",name);
		
		
		URL url = new URL(urlPAth);
		if(this.driver==null && initDriver==true)
		{
			/*
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\srija\\chromedriver114.exe");
			driver = new ChromeDriver();
			driver.get("https://demo.openmrs.org/openmrs/login.htm");*/
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setCapability("sauce:options",sauce);
			browserOptions.setAcceptInsecureCerts(true);
			browserOptions.setCapability("platformName","Windows 10");
			browserOptions.setCapability("browserName", "Chrome");
			browserOptions.setCapability("browserVersion","latest");
			

			this.driver = new RemoteWebDriver(url, browserOptions);
			driver.get("https://demo.openmrs.org/openmrs/login.htm");
		}
		PageFactory.initElements(driver, this);
		
	}
	

}
