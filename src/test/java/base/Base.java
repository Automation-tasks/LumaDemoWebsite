package base;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.Utilities;

public class Base {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver browserSetUp() {
		
		prop = Utilities.loadPropertiesFile();		
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public String generateUniqueEmail() {
		
		Date date = new Date();
		String emailID = date.toString().replace(" ", "_").replace(":", "_").concat("@gmail.com");
		return emailID;
	}
}
