package com.brillio.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		try {
			driver.manage().window().maximize();
			driver.navigate().to("http://testcoe:8080/Image-Validation");
			
			WebElement jobName = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='job_Name']")));
			jobName.sendKeys("Job-"+new Date().getTime());
			driver.findElement(By.xpath("//*[@id='base_url']")).sendKeys("http://www.brillio.com");
			WebElement elem = driver.findElement(By.xpath("//*[@id='crawl_level']"));
			elem.clear();
			elem.sendKeys("1");
			
			WebElement elem1 = driver.findElement(By.xpath("//*[@id='threshold']"));
			elem1.clear();
			elem1.sendKeys("90");

			Thread.sleep(4000);
	
			driver.findElement(By.xpath("//*[@id='screenShotButton']")).click();

			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
