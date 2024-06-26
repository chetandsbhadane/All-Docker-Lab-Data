package com.demotest.FirstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://artoftesting.com/samplesiteforselenium");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("fname")).sendKeys(" Welocome to Pune");
		driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
	}
}
