package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign In")
	WebElement loginOption;
	
	@FindBy(linkText="Create an Account")
	WebElement createAccountOption;
	
	public WebDriver clickOnSignIn() {
		
		loginOption.click();
		return driver;
	}
	
	public CreateAccountPage clickOnCreateAccount() {
		
		createAccountOption.click();
		return new CreateAccountPage(driver);
	}

}
