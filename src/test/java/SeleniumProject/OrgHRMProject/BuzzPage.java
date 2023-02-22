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

public class BuzzPage {
  WebDriver driver;
  @Test
  public void buzzPage() throws InterruptedException {
	  
	  WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
	  userName.sendKeys("Admin");
	  
	  WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
	  password.sendKeys("admin123");
	  
	  WebElement loginButton = driver.findElement(By.tagName("button"));
      loginButton.click();
      
      WebElement Buzz = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[10]"));
      Buzz.click();
      
      WebElement Text = driver.findElement(By.xpath("//textarea[@placeholder=\"What's on your mind?\"]"));
      
      Text.sendKeys("Welcome to selenium testing");
      
      WebElement Post = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
      Post.click();
      
      Thread.sleep(3000);
      
      //scenario for Delete the post
      
      WebElement Ellipsis = driver.findElement(By.xpath("(//button[@type=\"button\"])[7]"));
      Ellipsis.click();
      
      WebElement Delete = driver.findElement(By.xpath("(//li[@class=\"orangehrm-buzz-post-header-config-item\"])[1]"));
      Delete.click();
      
      
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
