package com.brillio.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {

	static WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		/*System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome Browser Instance Invoked !!");*/
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true); 
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "drivers/phantomjs.exe");          
        caps.setCapability("phantomjs.page.customHeaders.Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        caps.setCapability("phantomjs.page.customHeaders.Accept-Language", "en-GB,en-US;q=0.8,en;q=0.6");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
            "--web-security=false",
            "--ssl-protocol=any",
            "--ignore-ssl-errors=true"
        });
        driver  = new PhantomJSDriver(caps);
	}
	
	@Test
	public void test1(){
		try {
			Thread.sleep(4000);
			System.out.println("Maximizing chrome window !!");
			//driver.manage().window().maximize();
			driver.get("http://localhost:8080/Image-Validation");
			
			System.out.println("Target URL supplied to webdriver !!");
			
			WebElement jobName = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='job_Name']")));
			jobName.sendKeys("Job-"+new Date().getTime());
			driver.findElement(By.xpath("//*[@id='base_url']")).sendKeys("http://www.brillio.com");
			WebElement elem = driver.findElement(By.xpath("//*[@id='crawl_level']"));
			elem.clear();
			elem.sendKeys("1");
			
			WebElement elem1 = driver.findElement(By.xpath("//*[@id='threshold']"));
			elem1.clear();
			elem1.sendKeys("90");
			
			System.out.println(elem1.getLocation());
			System.out.println("Form Data Filled !!");
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//*[@id='screenShotButton']")).click();
			System.out.println("Job has been submitted !!");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("Process Done - Closing !!");
		driver.close();
		System.out.println("Driver Closed !!");
	}
	
}
