package driver_factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppProperties;

public class Driver {
	
	protected static WebDriver driver;
	
	static {
		if ( driver == null ) driver = getDriver(AppProperties.BROWSER_TYPE);
	}
	
	protected Driver () {}
	
	protected static WebDriver getDriver ( String browserType ) {
		WebDriver driver = null;
		switch ( browserType ) {
			case "chrome":
				driver = getChromeDriver();
				break;
			case "firefox":
				driver = getFirefoxDriver();
				break;
			default: System.out.println("Browser type " + browserType + " invalid");
				break;
				
				
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;
	}
	
	private static ChromeDriver getChromeDriver () {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	
	private static FirefoxDriver getFirefoxDriver () {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
}