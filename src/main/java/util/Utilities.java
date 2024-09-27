package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

    public static String captureScreenshot(WebDriver driver, String testName) {
    	
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + ".png";
        
        try {
			FileUtils.copyFile(screenshotFile, new File(screenshotFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
        return screenshotFilePath;
    }
    
    public static Properties loadPropertiesFile() {
    	
    	Properties prop = new Properties();
    	File propertiesFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\projectdata.properties");

    	try {
			FileReader fr = new FileReader(propertiesFile);
			prop.load(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return prop;
    }
}
