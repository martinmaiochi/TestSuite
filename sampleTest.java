package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class sampleTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private boolean isPresent = true;
  
  //TEST-CASE: Inactive user can not login to the system

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8888/Sentrifugo_2.1/index.php/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void testSample() throws Exception {
	driver.get(baseUrl + "/Sentrifugo_2.1/index.php/");
	driver.findElement(By.id("username")).sendKeys("EMPP0005");
	driver.findElement(By.id("password")).sendKeys("ugyhyqaze");
	driver.findElement(By.id("loginsubmit")).click();
	
	isPresent = driver.findElements(By.id("configwizard")).size() > 0;
	
	if (!isPresent) {
		System.out.println("Usuário inativo não conseguiu acessar");
	} else {
		System.out.println("Usuário inativo conseguiu acessar");
	}
  }
}