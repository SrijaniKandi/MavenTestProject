package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import selenium.SeleniumTest;


public class AbstractPage{
	
	protected WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	
	public AbstractPage(WebDriver driver)
	{
		this(driver,true);
	}
	
	public AbstractPage(WebDriver wdp, boolean initDriver)
	{
		this.driver = wdp;
		if(this.driver==null && initDriver==true)
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\srija\\chromedriver114.exe");
			driver = new ChromeDriver();
			driver.get("https://demo.openmrs.org/openmrs/login.htm");
		}
		PageFactory.initElements(driver, this);
		
	}
	


}
