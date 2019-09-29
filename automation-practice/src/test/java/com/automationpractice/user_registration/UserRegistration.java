package com.automationpractice.user_registration;

import org.openqa.selenium.WebDriver;

import driver_factory.Driver;
import utils.AppProperties;

/**
 * September 22, 2019
 * 
 * @author emini
 *
 */

public class UserRegistration extends Driver {

	public static void main(String[] args) {

		WebDriver driver = getDriver(AppProperties.BROWSER_TYPE);
		driver.get(AppProperties.BASE_URL);
		
	}

}
