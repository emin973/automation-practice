package com.herokuapp.testleaf;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

public class Checkbox extends NonStaticDriver {
	
	private int timeOutInSeconds = 15;
	
	@BeforeClass
	public void classSetUp () {
		driver.get(AppProperties.TEST_LEAF_BASE_URL);
	}
	
	String xpath = "//label[contains(text(),\"{0}\")]/following-sibling::input";
	
	@Test
	public void checkboxTest1 () {
		driverHelper.click(By.linkText("Checkbox"), timeOutInSeconds);
		//*[@id="contentblock"]/section/div[1]/input[1] --> auto generated by browser (chrome)
		
		String text = "Select the languages that you know?";
		String xpath = MessageFormat.format(this.xpath, text);
		
//		driverHelper.click(By.xpath("(" + xpath + ")[1]"), timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 1, timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 2, timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 3, timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 4, timeOutInSeconds);
		driverHelper.click(By.xpath(xpath), 5, timeOutInSeconds);
		driverHelper.takeScreenshot();
		Common.sleep(2);
		
		for ( int index = 0; index < driverHelper.getElements(By.xpath(xpath), timeOutInSeconds).size(); index++ ) {
			driverHelper.click(By.xpath(xpath), (index + 1), timeOutInSeconds);
		}
		driverHelper.takeScreenshot();
		Common.sleep(4);
	}
	
	@Test
	public void checkboxTest2 () {
		String xpath = MessageFormat.format(this.xpath, "Confirm Selenium is checked");
		boolean isChecked = driverHelper.getElement(By.xpath(xpath), timeOutInSeconds).isSelected();
		Assert.assertTrue(isChecked, "Selenium check box was checked.");
		driverHelper.takeScreenshot();
	}
}
