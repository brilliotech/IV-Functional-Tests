package com.brillio.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {

	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1(){
		driver.manage().window().maximize();
		driver.navigate().to("http://testcoe:8080/Image-Validation");
		driver.findElement(By.xpath("//*[@id='job_Name']")).sendKeys("Job-"+new Date().getTime());
		//driver.findElement(By.xpath("//*[@id='job_Name']")).sendKeys();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
