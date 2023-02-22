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

public class MaintenancePage {
	
  WebDriver driver;
  @Test
  public void maintenancePage() {
	  
	  WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
	  userName.sendKeys("Admin");
	  
	  WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
	  password.sendKeys("admin123");
	  
	  WebElement loginButton = driver.findElement(By.tagName("button"));
      loginButton.click();
      
	  WebElement maintenance = driver.findElement(By.linkText("Maintenance"));
	  maintenance.click();
	  
	  WebElement passwords = driver.findElement(By.xpath("//input[@type=\"password\"]"));
	  passwords.sendKeys("admin123");
	  
	  WebElement submit = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	  submit.click();
	  
      boolean verify = driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]")).isDisplayed();
	  
	  if(verify==true) {
		 
		 System.out.println("maintenance Page is Displayed");
	  }
	  else {
		 
		 System.out.println("maintenance Page is Displayed");
	 
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
