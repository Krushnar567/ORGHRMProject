package SeleniumProject.OrgHRMProject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class LeaveList {
WebDriver driver;
@Test
public void leaveList()  {
	  
 WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
 userName.sendKeys("Admin");
	  
 WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
 password.sendKeys("admin123");
	  
 WebElement loginButton = driver.findElement(By.tagName("button"));
 loginButton.click();
      
 WebElement leaveList = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]")) ;
 leaveList.click();
      	  
  }
      
 @Test
 public void assignLeave() {
	  
 WebElement assignButton = driver.findElement(By.tagName("button"));
 assignButton.click();
	  
 }
	  
@Test
public void nationality() {
WebElement nationality = driver.findElement(By.xpath("//button[@type=\"button\"]"));
nationality.click();
	  
WebElement name = driver.findElement(By.xpath("//input[@class=\"oxd-input oxd-input--active\"]"));
	  
name.sendKeys("India");
	  
WebElement save =driver.findElement(By.xpath("//button[@type=\"submit\"]"));
save.click();
	  
boolean  verify = driver.findElement(By.id("app")).isDisplayed();
	
if(verify==true) {
		
System.out.println("Nationality is Selected");
}
	
else{
		
System.out.println("Nationality is not Selected");

 }
	  
}
@BeforeClass
public void beforeClass() {
	  
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
