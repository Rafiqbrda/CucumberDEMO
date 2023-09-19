package stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;
import pages.SearchCriteria;

public class Search {
	WebDriver driver;
	private Homepage homepage;
	
	
	@Given("Users open the application")
	public void users_open_the_application() {
	driver =  Driverfactory.getDriver();
	}

	   @When("Users enter valid product {string} into search bos fields")
	    public void users_enter_valid_product_into_search_bos_fields(String validproductText ) {
		   
	    homepage = new Homepage(driver);
		homepage.SearchValidProducd(validproductText);
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(validproductText);
	}

	@When("Users click on search button")
	public void users_click_on_search_button() {
		
		homepage = new Homepage(driver);
		homepage.ClickOnSearchButton();
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}
	
	@Then("Users should get valid product on display")
	public void users_should_get_valid_product_on_display() {
		
		SearchCriteria search = new SearchCriteria(driver);
		Assert.assertTrue(search.SearchProducdDisplay());
		
	 // Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("Users enter invalid product {string} into search bos fields")
	public void users_enter_invalid_product_into_search_bos_fields(String invalidproductText) {
		
		homepage = new Homepage(driver);
		homepage.SearchInvalidProduct(invalidproductText);
		
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(invalidproductText); 
	}

	@Then("Users should get warning message for product no matching")
	public void users_should_get_warning_message_for_product_no_matching() {
		
		homepage = new Homepage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.", homepage.WarningMessageOnDisplay());

	  // Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText());
	}

	@When("Users do not  enter any product name into search box field")
	public void users_do_not_enter_any_product_name_into_search_box_field() {
		homepage = new Homepage(driver);
	}




}
