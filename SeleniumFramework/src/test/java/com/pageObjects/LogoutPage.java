package com.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	
	WebDriver driver;
	
	public LogoutPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	
	@FindBy(id="react-burger-menu-btn") WebElement menu;
	@FindBy(id="logout_sidebar_link") WebElement logout;
	
	public void logoutApp()
	{

		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//		menu.click();
		logout.click();
	}
	

}
