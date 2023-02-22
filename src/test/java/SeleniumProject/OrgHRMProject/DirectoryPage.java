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

public class DirectoryPage {
	  WebDriver driver;
  @Test
  public void directoryPage() {
	  WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
	  userName.sendKeys("Admin");
	  
	  WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
	  password.sendKeys("admin123");
	  
	  WebElement loginButton = driver.findElement(By.tagName("button"));
      loginButton.click();
      
      WebElement directory = driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]"));
      directory.click();
	  
      boolean verify = driver.findElement(By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")).isDisplayed();
	  
	  if(verify==true) {
		 
		 System.out.println("Directory Page is Displayed");
	  }
	  else {
		 
		 System.out.println("Directory Page is Displayed");
	 
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
