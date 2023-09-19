package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AccountSuccessfulPage;
import pages.Homepage;
import pages.RegisterAccountPage;

public class Register {
	

    WebDriver driver;
    private   RegisterAccountPage registerpage;
    
	 @Given("User open to register account page")
	 public void user_open_to_register_account_page() {
		 
	 driver = Driverfactory.getDriver();
	 
	  Homepage homepage = new Homepage(driver);
	  homepage.clickOnMyAccount();
	 
	 // driver.findElement(By.xpath("//span[text()='My Account']")).click();
	 
	    // RegisterAccountPage registerpage = new RegisterAccountPage(driver);
	      registerpage = new RegisterAccountPage(driver);
	     registerpage.ClickOnRegister();
	     
	   // driver.findElement(By.linkText("Register")).click(); 	
	}	
	    @When("User provides infomation into the below fields")
	    public void user_provides_infomation_into_the_below_fields(io.cucumber.datatable.DataTable dataTable) {
	    	
	       Map<String, String> dataMap =	 dataTable.asMap(String.class,String.class); 
	     
	       registerpage = new RegisterAccountPage(driver);
	       
	       registerpage.FirstNameText(dataMap.get("firstName"));
	       //driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(dataMap.get("firstName"));
	       
	       registerpage.LastnameText(dataMap.get("lastName"));
	      // driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(dataMap.get("lastName"));
	       
	       registerpage.EmailText(getEmailTimestamp());
	       //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(dataMap.get("email"));
	       //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getEmailTimestamp());
	       
	        registerpage.TelephoneText(dataMap.get("telephone"));
	    	//driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(dataMap.get("telephone"));
	        
	        registerpage.PasswordText(dataMap.get("password"));
	    	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataMap.get("password"));
	        
	        registerpage.ConfirmPassWord(dataMap.get("password"));
	    	//driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(dataMap.get("password"));
		 
	        
	    	//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(dataMap.get("firstName"));
	    	//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(dataMap.get("lastName"));
	    	//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getEmailTimestamp());
	    	//driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(dataMap.get("telephone"));
	    	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataMap.get("password"));
	    	//driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(dataMap.get("password"));
	    }
		 
		 
		 
	

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
		registerpage.SelectPrivacyPolicy();
		//driver.findElement(By.xpath("//input[@name='agree']")).click(); 
	}

	@When("User clicks continue button")
	public void user_clicks_continue_button() {
		
		
		registerpage.ClickoncontinueButtonOption();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("User account should create successfully")
	public void user_account_should_create_successfully() {
		
		AccountSuccessfulPage accountpage = new AccountSuccessfulPage(driver);
		
	    Assert.assertEquals("Your Account Has Been Created!",accountpage.RegisterAccountSucessfulMessageDisplay() );
	}

	@When("User not write any details into fields")
	public void user_not_write_any_details_into_fields() {
		registerpage = new RegisterAccountPage(driver);
	}

	@When("User shoult get important message for every blank fields")
	public void user_shoult_get_important_message_for_every_blank_fields() {
		 
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(registerpage.WarningMessageInfomation().contains("Warning: You must agree to the Privacy Policy!"));	
		
	   // Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText());
		//Assert.assertEquals("Last Name must be between 1 and 32 characters!",driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		//Assert.assertEquals("E-Mail Address does not appear to be valid!",driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		//Assert.assertEquals("Telephone must be between 3 and 32 characters!",driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
		//Assert.assertEquals("Password must be between 4 and 20 characters!",driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());



		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPasswordWarning());

		
		
		
		
	}
	 
    private String getEmailTimestamp() {
    Date date = new Date();
    return "rafiqueltaj"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";

    }
}
