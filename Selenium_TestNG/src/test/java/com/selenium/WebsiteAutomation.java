package com.selenium;

import org.testng.annotations.Test;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebsiteAutomation {
	
    WebDriver driver = new ChromeDriver();
  
 
  @Test(priority = 1)
  public void begin() {
	  System.out.println("Going to website");
      driver.get("http://automationpractice.com/index.php");
  }
  
  
  
  @Test(priority = 2)
  public void createAccount() {
	  System.out.println("Create an account");
	  driver.findElement(By.className("login")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("email_create")).sendKeys("bopjz7116da5@cuoly.com");
	  driver.findElement(By.id("SubmitCreate")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("customer_firstname")).sendKeys("Lakshmi");
	  driver.findElement(By.id("customer_lastname")).sendKeys("Priya");
	  driver.findElement(By.id("passwd")).sendKeys("abcde");
	  driver.findElement(By.id("address1")).sendKeys("Door no:8");
	  driver.findElement(By.id("city")).sendKeys("Albany");
	  Select dropdown = new Select(driver.findElement(By.id("id_state")));
	  dropdown.selectByValue("32");
	  driver.findElement(By.id("postcode")).sendKeys("00000");
	  driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
	  driver.findElement(By.id("submitAccount")).click();
	  System.out.println("Account created");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.className("logout")).click();
	  
	  
  }  
  
  
  @Test(priority = 3)
  public void login() {
	  boolean i=true;
	  System.out.println("Logging in");
	  //driver.get("http://automationpractice.com/index.php");
	  driver.findElement(By.className("login")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.name("passwd")).sendKeys("abc12345");
	  driver.findElement(By.id("email")).sendKeys("lpe199813@gmail.com");
	  driver.findElement(By.id("SubmitLogin")).click();
	  String actualUrl="http://automationpractice.com/index.php?controller=my-account";
      String expectedUrl= driver.getCurrentUrl();
      try {
    	  Assert.assertEquals(expectedUrl,actualUrl);
    	  
      }catch(AssertionError e) {
    	  System.out.println("Login Failed :("+ e.getMessage());
    	  i=false;
      }
      if(i)
    	  System.out.println("Logged in :)");
  }
  
  @Test(priority = 4)
  public void search() {
	  System.out.println("Searching for an item");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("search_query_top")).sendKeys("dress");
	  driver.findElement(By.name("submit_search")).click();
	  System.out.println("Item searched");
	  
	  
  }
  
  @Test(priority = 5)
  public void addtoCart() {
	  System.out.println("Add to cart operation");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@data-id-product='7']")).click();
	  System.out.println("Added to cart");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Starting the Test");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Ending the Test");
	  driver.close();
  }

}
