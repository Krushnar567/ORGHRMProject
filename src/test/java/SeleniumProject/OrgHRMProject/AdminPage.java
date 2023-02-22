package SeleniumProject.OrgHRMProject;

import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class AdminPage {
  WebDriver driver;
	
  @Test
  public void userManagement() throws InterruptedException {
	  
	  WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
	  userName.sendKeys("Admin");
	  
	  WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
	  password.sendKeys("admin123");
	  
	  WebElement loginButton = driver.findElement(By.tagName("button"));
      loginButton.click();
      
      Thread.sleep(3000);
      
      WebElement admin = driver.findElement(By.xpath("//a[@class=\"oxd-main-menu-item active\"]"));
      
      admin.click();
      
      boolean userMant = driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]")).isDisplayed();
      
      if(userMant=true) {
    	  
    	  System.out.println("User User Management page Displayed");
    	  
      }
      
      else {  
    	  
    	  System.out.println("User User Management page is not Displayed");
      }  
  }
  
  @Test
  public void addUser() throws InterruptedException {
	  
	  WebElement addButton =driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	  addButton.click();
	  
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
