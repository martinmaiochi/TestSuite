package main;

//import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//TEST-CASE: Verify if the user Victor exists in employees table 

public class TestCase7 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  boolean isPresent = true;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8888/Sentrifugo_2.1/index.php/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void test() throws Exception {
	driver.get(baseUrl + "/Sentrifugo_2.1/index.php/");
	driver.findElement(By.id("username")).sendKeys("EMPP0001");
	driver.findElement(By.id("password")).sendKeys("57152dbea8949");
	driver.findElement(By.id("loginsubmit")).click();
	driver.findElement(By.id("main_parent_3")).click();
	
	String pageCode = driver.getPageSource();
	assertThat(pageCode, Matchers.containsString("EMPP0005"));
  }
  @After
  public void quitMethod() {             
      driver.quit();
  }
}