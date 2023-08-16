package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.lang.*;
import java.net.MalformedURLException;

import pages.AbstractPage;
import pages.LoginPage;
import selenium.SeleniumTest;

public class AbstractTest extends SeleniumTest{
	
	public static LoginPage login;

	public void beforeClazz(Class<?> testClass) throws MalformedURLException
	{
		System.out.println("TestClass is"+testClass.getSimpleName());
		String testName = testClass.getSimpleName();
		initTestName(testName);
		System.out.println(login);
		if(login==null) {
			login = new LoginPage(true);
		}
			
	}
	
	
	public void createReporting(boolean status) {
		String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
	    String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";
		//driver.get("https://www.saucedemo.com/");
		ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        extent.attachReporter(spark);

        if(status==true) {
        extent.createTest("ScreenCapture")
        		.log(Status.PASS, "This is passed", MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());
                //.addScreenCaptureFromPath("extent.png")
                //.pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());
        }
        if(status==false) {
        extent.createTest("ScreenCapture")
		.log(Status.FAIL, "This is failed", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\srija\\git\\MavenTestProject\\MavenTestproject\\screenshots").build());
        }
        extent.createTest("LogLevels")
                .info("info")
                .pass("pass")
                .warning("warn")
                .skip("skip")
                .fail("fail");

        extent.createTest("CodeBlock").generateLog(
                Status.PASS,
                MarkupHelper.createCodeBlock(CODE1, CODE2));
        extent.flush();
	}
	
	
	
}
