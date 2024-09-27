package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTest extends Base{

	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		
		driver = browserSetUp();
		homePage = new HomePage(driver);		
		homePage.clickOnSignIn();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(dataProvider="dataSupplier",priority=0)
	public void loginWithValidDetails(String Email, String Password) {
		
		loginPage = new LoginPage(driver);		
		loginPage.enterEmailField().sendKeys(Email);
		loginPage.enterPassword().sendKeys(Password);

		loginPage.clickOnLogin();
		
		Assert.assertEquals(driver.getTitle(), "Home Page");
	}
	
	@Test(dataProvider="invalidDataSupplier",priority=1)
	public void loginWithInvalidDetails(String Email, String Password) throws InterruptedException {
		
		loginPage = new LoginPage(driver);		
		loginPage.enterEmailField().sendKeys(Email);
		loginPage.enterPassword().sendKeys(Password);

		loginPage.clickOnLogin();
		
		Assert.assertTrue(loginPage.errorMessage().isDisplayed());
	}
	
	@Test(priority=2)
	public void loginWithNoDetails() {
		
		loginPage = new LoginPage(driver);
		loginPage.clickOnLogin();
	
			Assert.assertTrue(loginPage.requiredFieldErrorMessage().isDisplayed());
	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] loginData = {
								{"first_account@gmail.com","FirstPassword@123"},
								{"second_account@gmail.com","SecondPassword@123"},
								{"third_account@gmail.com","ThirdPassword@123"}
								};
		return loginData;
	}
	
	@DataProvider
	public Object[][] invalidDataSupplier() {
		
		Object[][] invalidLoginData = {
								{"first@gmail.com","FirstPassword@123"},
								{"second@gmail.com","SecondPassword@123"},
								};
		return invalidLoginData;
	}

}
