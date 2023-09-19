package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.Homepage;
import pages.Loginpage;

public class login {
   
	WebDriver driver;
	
	/*
	 * WebDriver driver;
	 * 
	 * 
	 * @Before public void setup() {
	 * 
	 * driver = new ChromeDriver() ; driver.manage().deleteAllCookies();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //.... 1
	 * driver.get("https://tutorialsninja.com/demo/"); }
	 * 
	 * @After 
	 * public void teardown() { driver.quit();
	 * 
	 * }
	 */



    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
    	
    driver = Driverfactory.getDriver();
    
   Homepage homepage = new Homepage(driver);
   homepage.clickOnMyAccount();
   homepage.ClickOnloginButton();
	//driver.findElement(By.xpath("//span[text()='My Account']")).click();
	//driver.findElement(By.xpath("//a[text()='Login']")).click();
	
}

    @When("User enters email {string}  into field")
    public void user_enters_email_into_field(String username) {
    	
    	Loginpage loginpage = new Loginpage(driver);
    	loginpage.enterEmailAddres(username);
    	
	   // driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
}

        @Then("User enters password {string} into field")
        public void user_enters_password_into_field(String passw3ord) {
        	
        
        	Loginpage loginpage = new Loginpage(driver);
        	loginpage.enterPassWordAddress(passw3ord);
        	
           // driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passw3ord);
         }

     @Then("User clicks on login button")
     public void user_clicks_on_login_button() {
    	 
    	 Loginpage loginpage = new Loginpage(driver); 
    	 loginpage.loginbuttonClick();
    	 
	  // driver.findElement(By.xpath("//input[@value='Login']")).click();
}

        @Then("User should get successfully loggedin")
        public void user_should_get_successfully_loggedin() {
        	
    	AccountPage accountpage = new AccountPage(driver);
    	//accountpage.displayAccountinfomation();
    	
    	                    //or 
         Assert.assertTrue(accountpage.displayAccountinfomation()); 

     // Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed()); 

}

      @When("User enters invalidemail {string}  into field")
      public void user_enters_invalidemail_into_field(String username) {
    	  
    	  Loginpage loginpage = new Loginpage(driver); 
    	  loginpage.enterInvalidemailAddress(getEmailTimestamp());
    	  
	     // driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getEmailTimestamp());  
	
}
    @Then("User should get a proper warning message about credentials mismatch")
    public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
    
    	
    	Loginpage loginpage = new Loginpage(driver);
    	loginpage.displyWarningMessage();
    	
    	
    	//Loginpage loginpage = new Loginpage(driver); 
    	//loginpage.displyWarningMessage();
    	
      // Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));

    } 

    
    private String getEmailTimestamp() {
    Date date = new Date();
    return "rafiqueltaj"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";

    } 
    
    
    
}

	

