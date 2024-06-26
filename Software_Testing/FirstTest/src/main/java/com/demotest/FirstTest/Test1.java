package com.demotest.FirstTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://artoftesting.com/samplesiteforselenium");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("fname")).sendKeys(" Welocome to Pune");
		driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"AlertBox\"]/button")).click();
		
		Alert alert = driver.switchTo().alert(); 
		alert.accept();
	
		
		Actions act = new Actions(driver);

		//Double click on element
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"dblClkBtn\"]")); 
		act.doubleClick(ele).perform();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert2 = driver.switchTo().alert(); 
		alert2.accept();
		

		WebElement ele2 = driver.findElement(By.id("testingDropdown"));
		Select list = new Select(ele2);
		
		driver.close(); 
	}
}	
