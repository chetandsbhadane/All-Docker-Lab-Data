package CDACDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setDriver()
	{
		/* Using WebDriverManager library of bonigarcia */		
		WebDriverManager.chromedriver().clearDriverCache().setup();
			
		/* Using preinstalled library of WebDriver 
		System.setProperty("webdriver.chrome.driver", "LOCAL PATH TO chromedriver.exe");
		*/
	}	
	
	@Test
	public void Login() throws InterruptedException {
		        
	    // Initialize the WebDriver	
		driver = new ChromeDriver();		
		
        // Open the web application
        driver.get("URL GOES HERE");
           
        // Maximize the browser window
        driver.manage().window().maximize();

        // Wait for elements to load        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));                    
            
        // Find the username input field and enter the username
        WebElement usernameField = driver.findElement(By.id("WEBELEMENT ID GOES HERE"));
        usernameField.sendKeys("USERNAME STRING GOES HERE");
        
        // Find the password input field and enter the password
        WebElement passwordField = driver.findElement(By.id("WEBELEMENT ID GOES HERE"));
        passwordField.sendKeys("PASSWORD STRING GOES HERE");
        
        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.name("WEBELEMENT ID GOES HERE"));
        loginButton.click();
        
        // Wait for elements to load        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Assertion to check test case status        
        Assert.assertEquals(driver.getTitle(),"Dashboard [Jenkins]");
        
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}	
}
