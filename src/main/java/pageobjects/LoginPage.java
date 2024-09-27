package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="pass")
	WebElement passwordField;
	
	@FindBy(id="send2")
	WebElement signInButton;
	
	@FindBy(xpath="//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")
	WebElement errorText;
	
	@FindBy(id="email-error")
	WebElement emailErrorText;
	
	public WebElement enterEmailField() {
		
		return emailField;
	}
	
	public WebElement enterPassword() {
		
		return passwordField;
	}
	
	public WebDriver clickOnLogin() {
		
		signInButton.click();
		return driver;
	}
	
	public WebElement errorMessage() throws InterruptedException {
		
		Thread.sleep(500);
		return errorText;
	}
	
	public WebElement requiredFieldErrorMessage() {
		
		return emailErrorText;
	}
}
