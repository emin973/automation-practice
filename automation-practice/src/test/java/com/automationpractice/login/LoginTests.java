package com.automationpractice.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;

public class LoginTests extends Driver {

		@Test
		public void LoginWithInvalidUsedId() {

			//	Go to http://www.automationpractice.com

		driver.get("http://www.automationpractice.com");

			//		Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();

		
			//		Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
		
		driver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
		
			//		Click Sign in button
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		
			//		Verify error message displayed 'There is 1 error'
		String errorMsg = driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
	//	System.out.println(errorMsg);
		
		Assert.assertEquals(errorMsg, "There is 1 error");
		
			//		Verify error message displayed 'Password is required.' 
		
	}

}
