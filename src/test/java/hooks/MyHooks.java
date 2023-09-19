package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.messages.types.Duration;
import utils.configReader;

public class MyHooks {

	WebDriver driver;
	@Before
	public void setup() {
	
	 Properties prop = configReader.initializeProperties();
	 
	 
  // Driverfactory.initializeBrowser("chrome");
	 Driverfactory.initializeBrowser(prop.getProperty("browser"));
	 driver = Driverfactory.getDriver();
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	// driver.get("https://tutorialsninja.com/demo/");
     driver.get(prop.getProperty("url"));
	
	
	
	}	
	
	@After
	public void teardown() {

	driver.quit();	
		
	}	
		
		
		
		
		
		
		
}
