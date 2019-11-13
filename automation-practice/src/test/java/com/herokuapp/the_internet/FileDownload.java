package com.herokuapp.the_internet;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

public class FileDownload extends NonStaticDriver {
	
	private int timeOutInSeconds = 15;
	
	@Test
	public void fileDwonloadTest1 () {
		driverHelper.openUrl(AppProperties.THE_INTERNET_BASE_URL + "/download");
		String fileName = "Life_Timesheet.xlsx";
		
		driverHelper.click(By.linkText(fileName), timeOutInSeconds);
		File file = new File(System.getProperty("user.home") + "/Downloads/" + fileName);
		//C://Users/TechCenture	 
//		System.out.println(file);
		
		boolean isFileExists = file.exists();
		int numberOfAttempts = 0;
		while ( !isFileExists && numberOfAttempts <= 5 ) {
			Common.sleep(1);
			isFileExists = file.exists();
			numberOfAttempts++;
		}
		
		Assert.assertTrue(isFileExists, 
				"File \"" + fileName + "\" not found in Download directory");
//		Common.deleteFiles(""); --> DO NOT RUN IN YOUR DOWNLOAD FOLDER
		Common.sleep(5);
	}
}
