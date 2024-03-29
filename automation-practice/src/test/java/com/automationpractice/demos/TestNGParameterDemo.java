package com.automationpractice.demos;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver_factory.Driver;

public class TestNGParameterDemo extends Driver{

	@Parameters({"userid","password"})
	@Test
	public void Login_with_invalid_userid(String u, String p) {
	
//			Go to http://www.automationpractice.com
			driverHelper.openUrl("http://www.automationpractice.com");
		
//			Click Sign in button from top right corner of the page
			driverHelper.click(By.className("login"), 2);
			
//			Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
			driverHelper.sendKeys(By.id("email"), u, 2);
			
			driverHelper.sendKeys(By.id("passwd"), p, 2);
			
//			Click Sign in button
			driverHelper.clickByXpath("//button[@id='SubmitLogin']", 2);

		
	}
	
	
}
