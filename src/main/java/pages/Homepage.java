package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
   WebDriver driver;	
	
  public Homepage(WebDriver driver) {
  this.driver = driver;
  PageFactory.initElements(driver, this);
	  
  }	  
	  
	  @FindBy(xpath = "//span[text()='My Account']")
	   private WebElement myAccountDropMenu;
	  
	  @FindBy(xpath = "//a[text()='Login']")
	  private WebElement loginoption;
	  
	  @FindBy(xpath = "//input[@name='search']")
	  private WebElement SearchField;
	  
	  @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	  private WebElement searchOption;
	  
	  @FindBy(xpath = "//input[@name='search']")
	  private WebElement SearchoptionField;
	  
	  @FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	  private WebElement warningMessage;
	  
	  
	       public void clickOnMyAccount() { 
		   myAccountDropMenu.click(); 
	       }
	  
	       public void ClickOnloginButton() {
		   loginoption.click();
	       }
	   
	      public void SearchValidProducd(String validproduct) {
		  SearchField.sendKeys(validproduct);	  
	}	  
		 public void ClickOnSearchButton() { 
			 searchOption.click();
		 }  
	 
		public void SearchInvalidProduct(String invalidproduct) {	 
			SearchoptionField.sendKeys(invalidproduct);	 
			 
		}	 
			 
		public String WarningMessageOnDisplay() {	 
		return	warningMessage.getText();	 
		}	 
	
		
		
		
		
}
