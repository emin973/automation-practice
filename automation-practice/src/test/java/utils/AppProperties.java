package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * September 22, 2019
 * 
 * @author emini
 *
 */


public class AppProperties {

	 private static Properties properties = getProperties();
	    public static final String BASE_URL = getProperties().getProperty("base_url");
	    public static final String BROWSER_TYPE = getProperties().getProperty("browser_type");
	    
	    private static Properties getProperties() {
	        Properties properties =  new Properties();
	    
	    
	        try {
	            String filePath=System.getProperty("user.dir") +                     "/src/test/resources/properties/config.properties";
	            InputStream inputStream = new FileInputStream(filePath);
	            properties.load(inputStream);
	        }catch( IOException e) {
	            System.out.println("File not found");
	            e.printStackTrace();
	        }
			return properties;
	        
	    }
	}