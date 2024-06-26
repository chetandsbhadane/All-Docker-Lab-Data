package CDACDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JenkinsLogin {
	
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
	public void testLogin() throws InterruptedException {
		        
        driver = new ChromeDriver();
        
        // Open the web application, using locally installed Jenkins web UI 
        driver.get("http://localhost:8080");
           
        // Maximize the browser window
        driver.manage().window().maximize();

        // Wait for elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            
        // Find the username input field and enter the username
        WebElement usernameField = driver.findElement(By.id("j_username"));
        usernameField.sendKeys("admin");
        
        // Find the password input field and enter the password
        WebElement passwordField = driver.findElement(By.id("j_password"));
        passwordField.sendKeys("Abc#123");
        
        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.name("Submit"));
        loginButton.click();
        
        // Wait for elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        Assert.assertEquals(driver.getTitle(),"Dashboard [Jenkins]");                    
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}		
}      
	

