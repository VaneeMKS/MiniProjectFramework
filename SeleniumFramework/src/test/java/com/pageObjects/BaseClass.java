package com.pageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BrowserFactory;
import com.utility.ConfigDataReader;
import com.utility.ExcelDataReader;
import com.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataReader excel;
	public ConfigDataReader config;
	public ExtentReports report;
	public ExtentSparkReporter extent;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		
		Reporter.log("To print logs in console", true);
		excel=new ExcelDataReader();
		config=new ConfigDataReader();
		extent=new ExtentSparkReporter (new File("./Reports/Report_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void setUp(String browser, String url)
	{
		driver=BrowserFactory.startApplication(driver, browser, url);
	}
		
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	//To take screenshot after every tests
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Can use any steps below to capture screenshots
			
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver),"Test Failed");
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//Can use any steps below to capture screenshots
			
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//			logger.addScreenCaptureFromPath(Helper.captureScreenshot(driver),"Test Passed");
		}
		
		report.flush();
	}

}
