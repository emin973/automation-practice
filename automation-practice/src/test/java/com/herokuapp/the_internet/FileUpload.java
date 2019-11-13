package com.herokuapp.the_internet;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import driver_factory.Driver;
import junit.framework.Assert;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;
/**
 * September, 29 2019
 * @author TechCenture
 *
 */
public class FileUpload extends Driver {
    
    private final int timeOutInSeconds = 15;
    
    @Test
    public void fileUpload () {
        driver.get(AppProperties.THE_INTERNET_BASE_URL);
        
        DriverHelper driverHelper = new DriverHelper(driver);
        driverHelper.click(By.linkText("File Upload"), timeOutInSeconds);
        
        String filePath = System.getProperty("user.dir") +  
                "/src/test/resources/files/Locators_table.pdf";
        String fileName = Paths.get(filePath).getFileName().toString();
        driverHelper.sendKeys(By.id("file-upload"), filePath, timeOutInSeconds);
        
        String uploadedFile = driverHelper.getElement(By.id("file-upload"), timeOutInSeconds)
                .getAttribute("value");
        uploadedFile = Paths.get(uploadedFile).getFileName().toString();
        Assert.assertEquals(/*"Uploaded file validation is Failed!",*/ fileName, uploadedFile);
        
        driverHelper.click(By.id("file-submit"), timeOutInSeconds);
        String actualHeader = driverHelper.getText(By.tagName("h3"), timeOutInSeconds);
        String actualUploadedFile = driverHelper.getText(By.id("uploaded-files"), timeOutInSeconds);
        
        Assert.assertEquals("File Uploaded!", actualHeader);
        Assert.assertEquals(fileName, actualUploadedFile);
        
        Common.sleep(5);
        driver.quit();
    }
    
}