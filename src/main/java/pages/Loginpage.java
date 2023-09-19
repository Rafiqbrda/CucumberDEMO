package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	 WebDriver driver;
	public  Loginpage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}	

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement invalidEmailaddres;
	
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement properWarningMessage;
	
	
	
	
	public void enterEmailAddres(String emailText) {
		emailField.sendKeys(emailText);
	
	}
	
	public void enterPassWordAddress(String passwordText) {
		passwordField.sendKeys(passwordText);
	
	}
     public void loginbuttonClick() {
    	 loginbutton.click();
	
     }
	public void enterInvalidemailAddress(String invalidemailText) {
		invalidEmailaddres.sendKeys(invalidemailText);
	
	}	
	
        public String displyWarningMessage() {
        return	 properWarningMessage.getText();
     
     }   
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
	
}
