package main;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateUserTC {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8888/Sentrifugo_2.1/index.php/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void CreateUserTC() throws Exception {
	driver.get(baseUrl + "/Sentrifugo_2.1/index.php/");
	driver.findElement(By.id("username")).sendKeys("EMPP0001");
	driver.findElement(By.id("password")).sendKeys("57152dbea8949");
    driver.findElement(By.id("loginsubmit")).click();
    driver.findElement(By.id("main_parent_3")).click();
    driver.findElement(By.cssSelector("input.sprite.addrecord")).click();
    driver.findElement(By.id("firstname")).sendKeys("FirstNameTest");
    driver.findElement(By.id("lastname")).sendKeys("LastNameTest");
    driver.findElement(By.id("emailaddress")).sendKeys("test@gmail.com");
    driver.findElement(By.cssSelector("img.ui-datepicker-trigger")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.linkText("30")).click();
    driver.findElement(By.id("submitbutton")).click();
  }
}