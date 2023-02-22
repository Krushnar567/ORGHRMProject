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

public class LoginPage {
	
  WebDriver driver;
 @Test
  public void loginPageTest() {
	  

	  WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
	  userName.sendKeys("Admin");
	  
	  WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
	  password.sendKeys("admin123");
	  
	  WebElement loginButton = driver.findElement(By.tagName("button"));
      loginButton.click();
     
      String expectedTitle = "OrangeHRM";
		
      String actualTitle = driver.getTitle();
		
	  if(expectedTitle.equals(actualTitle))
		{
			
			System.out.println("User is Successfully Logged in");
		}
	
	 else {
			
			System.out.println("The Login has Failed");
		
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
