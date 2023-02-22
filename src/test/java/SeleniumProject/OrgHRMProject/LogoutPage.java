package SeleniumProject.OrgHRMProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LogoutPage {
  WebDriver driver;
  @Test
  public void logoutPage() throws InterruptedException {
	  

	  WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
	  userName.sendKeys("Admin");
	  
	  WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
	  password.sendKeys("admin123");
	  
	  WebElement loginButton = driver.findElement(By.tagName("button"));
      loginButton.click();
      
      
      //Logout 
      WebElement ellipses = driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]"));
      
      ellipses.click();
      WebElement Logout = driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]"));
      
      Logout.click();
      
      //Verify that the user is landed on login page
      
      String ExpectedTitle = "OrangeHRM";
      
      String ActualTitle = driver.getTitle();
      
      Assert.assertEquals(ExpectedTitle, ActualTitle);
      
      Thread.sleep(3000);
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
