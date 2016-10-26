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

//TEST-CASE: Verify if popup appears

public class TestCase8 {
  public WebDriver driver;
  public String baseUrl;
  public boolean acceptNextAlert = true;
  public StringBuffer verificationErrors = new StringBuffer();
  boolean isPresent = true;

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
  public void test() throws Exception {
	driver.get(baseUrl + "/Sentrifugo_2.1/index.php/");
	driver.findElement(By.id("username")).sendKeys("EMPP0001");
	driver.findElement(By.id("password")).sendKeys("57152dbea8949");
	driver.findElement(By.id("loginsubmit")).click();
	driver.findElement(By.id("main_parent_1")).click();
	driver.findElement(By.id("11")).click();
	driver.findElement(By.xpath("(//a[@name='1'])[3]")).click();
	isPresent = driver.findElement(By.id("popup_container")).isDisplayed();
	
  }
  @AfterClass
  public void quitMethod() {             
      driver.quit();
  }
}