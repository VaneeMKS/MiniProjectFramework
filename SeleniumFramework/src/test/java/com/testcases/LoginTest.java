package com.testcases;

import com.utility.ExcelDataReader;
import com.utility.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageObjects.BaseClass;
import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import com.utility.BrowserFactory;

public class LoginTest extends BaseClass{
	
	@Test(priority=1)
	public void loginApp()
	{
		
		logger=report.createTest("Login Test");
		logger.info("Started application");
		logger.info("Entered User name");
		LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
		loginPage.loginToApp(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		
		logger.info("Entered Password");
		logger.info("Logged in Successfully");
		
	}
	
	@Test(priority=2)
	public void logoutApp()
	{
		logger=report.createTest("Logout Test");
		LogoutPage logoutPage=PageFactory.initElements(driver,LogoutPage.class);
		logger.info("Click on Menu");
		logger.info("Select Logout");
		logoutPage.logoutApp();
		
		logger.info("Logged out Successfully");
		
	}
	

}
