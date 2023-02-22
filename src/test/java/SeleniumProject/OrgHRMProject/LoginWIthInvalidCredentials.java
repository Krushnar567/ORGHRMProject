package SeleniumProject.OrgHRMProject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginWIthInvalidCredentials{
  WebDriver driver;
  @Test
  public void loginWIthInvalidCredentials() {
	  
	//Entering invalid Username & password and clicking on Login
	  
	  WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	  
      username.sendKeys("krushna");
      
      WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
      
      password.sendKeys("test123");
      
      WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
      
      login.click();
      
      //Verify that the invalid Credentials is visible or not
      
      WebElement error = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
      
      String ExpectedError = "Invalid credentials" ;
      
      String ActualError = error.getText();
      
      Assert.assertEquals(ExpectedError, ActualError);
  }
  
  @BeforeClass
  public void launchURL() {
	  
	    WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  
	}
	 

  @AfterClass
  public void afterClass() {
  }

}
