package SeleniumProject.OrgHRMProject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ResetPassword {
  WebDriver driver;
  
  @Test
  public void resetPassword() {
	  
	  WebElement ForgotPassword = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
	  ForgotPassword.click();
	  
	  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	  Username.sendKeys("krushna123");
	  
	  WebElement reset = driver.findElement(By.xpath("//button[@type='submit']"));
	  reset.click();
	  
	  boolean verify = driver.findElement(By.xpath("//div[@class='orangehrm-card-container']")).isDisplayed();
	  
	  if(verify==true) {
		  
		  System.out.println("Reset Password link sent successfully on Email");
	  }
	  else {
		  
		  System.out.println("Reset Password link id not sent");
	  }
	  
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
	  
	  driver.close();
  }

}
