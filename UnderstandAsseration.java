package com.learn.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnderstandAsseration {
    @Test 
	public void hardAssertion() {
    	ChromeOptions opt =new ChromeOptions();	
 	    opt.addArguments("--remote-allow-origins=*");
 	    WebDriverManager.chromedriver().setup();
 		WebDriver d = new ChromeDriver(opt);
 		//Launch google web page
 		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 		d.manage().window().maximize();
 		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
 		//login code
 	    WebElement  username= d.findElement(By.name("username"));
 	    username.sendKeys("Admin");
 	    //Thread.sleep(2000);
 		WebElement password = d.findElement(By.name("password"));
 		password.sendKeys("admin123");
 		//Thread.sleep(2000);
 		WebElement button = d.findElement(By.xpath("//button[@type='submit']"));
 		button.click();
 		//Thread.sleep(2000);
 		
 	    String curl=d.getCurrentUrl();
// 	    System.out.println(curl);
// 	    if(curl.contains("dashboard")) {
// 		System.out.println("yes......loged in succesfully");
// 		}else {
// 			System.out.println("logged in falied");
// 		}
 	    
 	    Assert.assertEquals(curl.contains("dashboard"), true);
 	    
 	    d.close();

	}
    @Test 
	public void softAssertion() {
    	ChromeOptions opt =new ChromeOptions();	
 	    opt.addArguments("--remote-allow-origins=*");
 	    WebDriverManager.chromedriver().setup();
 		WebDriver d = new ChromeDriver(opt);
 	
 		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 		d.manage().window().maximize();
 		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
 		
 	    WebElement  username= d.findElement(By.name("username"));
 	    username.sendKeys("Admin");
 	 
 		WebElement password = d.findElement(By.name("password"));
 		password.sendKeys("admin123");
 		
 		WebElement button = d.findElement(By.xpath("//button[@type='submit']"));
 		button.click();
 		
 		//String curl=d.getCurrentUrl();
      // Assert.assertEquals(d.getCurrentUrl().contains("dashboard"), true);
 		
 		SoftAssert sa = new SoftAssert();
 		sa.assertEquals(d.getCurrentUrl().contains("rashboard"), true);
 		
 		d.close();
 		
 		sa.assertAll();
		
	}
}
