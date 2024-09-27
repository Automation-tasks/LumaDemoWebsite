package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	
	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement firstNameField;
	
	@FindBy(id="lastname")
	WebElement lastNameField;
	
	@FindBy(id="email_address")
	WebElement emailField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="password-confirmation")
	WebElement confirmPasswordField;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement createAccountButton;
	
	public WebElement firstName() {
		
		return firstNameField;
	}
	
	public WebElement lastName() {
		
		return lastNameField;
	}
	
	public WebElement emailField() {
		
		return emailField;
	}
	
	public WebElement passwordField() {
		
		return passwordField;
	}
	
	public WebElement confirmPasswordField() {
		
		return confirmPasswordField;
	}
	
	public MyAccountPage createAccountButton() {
		
		createAccountButton.click();
		return new MyAccountPage(driver);
	}
}
