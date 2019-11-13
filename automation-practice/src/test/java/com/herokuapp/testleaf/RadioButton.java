package com.herokuapp.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;

/**
 * September, 28 2019
 * @author TechCenture
 *
 */
public class RadioButton extends Driver {
	
	/**
	 * Test NG methods can not be static
	 */
	@Test
	public void test1 () {
		driver.get("http://testleaf.herokuapp.com/pages/radio.html");
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
		/*
		 * Explicit wait 
		 */
		WebElement yesElement = driver.findElement(By.id("yes"));
		WebElement noElement = driver.findElement(By.id("no"));
		
		webDriverWait.until(ExpectedConditions.visibilityOf(yesElement));
		yesElement.click();
		boolean isYesSelected = yesElement.isSelected();
		Assert.assertTrue(isYesSelected, "Yes radio button is not selected");
		driver.quit();
	}
}







