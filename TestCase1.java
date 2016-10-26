package main;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;

//TEST-CASE: Inactive user can not login to the system

public class TestCase1 {
  public WebDriver driver;
  public String baseUrl;
  public boolean acceptNextAlert = true;
  public StringBuffer verificationErrors = new StringBuffer();
  public boolean isPresent = true;
  
  @Parameters("browser")
  @BeforeClass
  public void beforeTest(String browser) {
 
	  if(browser.equalsIgnoreCase("firefox")) {
		  driver = new FirefoxDriver();	  
	 
	  }else if (browser.equalsIgnoreCase("Chrome")) { 
		  
		  System.setProperty("webdriver.chrome.driver", "/Users/martinmaiochi/Downloads/chromedriver");
		  driver = new ChromeDriver();
	  }
	  
	 baseUrl = "http://localhost:8888/Sentrifugo_2.1/index.php/";
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void testSample() throws Exception {

	driver.get(baseUrl + "/Sentrifugo_2.1/index.php/");
	driver.findElement(By.id("username")).sendKeys("EMPP0003");
	driver.findElement(By.id("password")).sendKeys("hyjegysyn");
	driver.findElement(By.id("loginsubmit")).click();
	
	isPresent = driver.findElements(By.id("main_parent_1")).size() > 0;
	
	if (!isPresent) {
		System.out.println("Inactive user did not access the system");
	} else {
		Assert.fail("Inactive user did access the system");
	}
  }
  
  @AfterClass 
  public void afterTest() {  
	driver.quit();
	}
}