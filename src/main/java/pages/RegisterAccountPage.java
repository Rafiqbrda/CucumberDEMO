package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {
	
	
	WebDriver driver;
	
	public RegisterAccountPage (WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement FirstnameField;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastNameField;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@name='telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement PassWordField;
	
	@FindBy(xpath = "//input[@name='confirm']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyField;
	
	 @FindBy(xpath = "//input[@value='Continue']")  
	  private WebElement continuebuttonOn;
	
	
	 
	            @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	            private WebElement WarningmessageDisplay;
	
	
	 
	    @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
        private WebElement firstNameWarning;
   
        @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
        private WebElement lastNameWarning;
    
         @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
         private WebElement emailWarning;
   
         @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
         private WebElement telephoneWarning;
    
         @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
         private WebElement passwordWarning;
    
	
	
	
	
	    public void ClickOnRegister() {
		registerOption.click();
	    }
	    
	    public  void FirstNameText(String firstNameText) {
		FirstnameField.sendKeys(firstNameText);
	    }
	
	    public void LastnameText(String lastnameText) {
	    	LastNameField.sendKeys(lastnameText);
	    }
	
	    public void EmailText(String emailText) {
		emailField.sendKeys(emailText);
	    } 
	    
	    public void TelephoneText(String telephoneText) {
	    	telephoneField.sendKeys(telephoneText);
	    }   
	    
	    public void PasswordText(String passwordText) {
	    	PassWordField.sendKeys(passwordText);
	    }
	     
	    public void ConfirmPassWord(String confirmpassword) {
		confirmPasswordField.sendKeys(confirmpassword);
	    }  
	    public void SelectPrivacyPolicy() { 
	    privacyPolicyField.click();
	 
	    }
	    
	 public void ClickoncontinueButtonOption() {
		 continuebuttonOn.click();
	 }
	 
	public String WarningMessageInfomation() {
	return	  WarningmessageDisplay.getText(); 
	
	} 
	 
	       public String getFirstNameWarning() {
	        return firstNameWarning.getText();
	     }
	        public String getLastNameWarning() {
	        return lastNameWarning.getText();
	      }
	        public String getEmailWarning() {
	        return emailWarning.getText();
	     }
	        public String getTelephoneWarning() {
	        return	telephoneWarning.getText();
	     }   
	        public String getPasswordWarning() {
	        return passwordWarning.getText();
	     }
	     
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
