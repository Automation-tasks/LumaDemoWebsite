package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.CreateAccountPage;
import pageobjects.HomePage;
import pageobjects.MyAccountPage;

public class RegisterTest extends Base{
	
	public WebDriver driver;
	HomePage homePage;
	CreateAccountPage createAccountPage;
	MyAccountPage myAccountPage;
	
	@BeforeMethod
	public void setUp() {
		
		driver = browserSetUp();
	}
	
	@AfterMethod
	public void tearDown() {
		
		if(driver!=null) {
			
			driver.quit();
		}
	}
	
	@Test(priority=1)
	public void registerAccountWithValidData() {
		
		homePage = new HomePage(driver);
		createAccountPage = homePage.clickOnCreateAccount();
		
		createAccountPage.firstName().sendKeys("abc");
		createAccountPage.lastName().sendKeys("def");
		createAccountPage.emailField().sendKeys(generateUniqueEmail());
		createAccountPage.passwordField().sendKeys("abcdef@123");
		createAccountPage.confirmPasswordField().sendKeys("abcdef@123");
		
		myAccountPage = createAccountPage.createAccountButton();
		
		Assert.assertTrue(myAccountPage.accountSuccess().isDisplayed());
	}

}
