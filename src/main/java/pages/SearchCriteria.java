package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCriteria {
	WebDriver driver;
	
	
	public SearchCriteria(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
		
		@FindBy(linkText = "HP LP3065")
		private WebElement Searchdisplay;
		
		
		
		
		public boolean SearchProducdDisplay() {
		return	Searchdisplay.isDisplayed();
	
		}		
			
			
			
			
			
			
			
			
			
			
}
