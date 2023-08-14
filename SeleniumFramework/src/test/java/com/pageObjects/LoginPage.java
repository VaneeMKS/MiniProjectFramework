package com.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="user-name") WebElement username;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(id="login-button") WebElement loginBtn;
	
	public void loginToApp(String uname,String pwd)
	{
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
