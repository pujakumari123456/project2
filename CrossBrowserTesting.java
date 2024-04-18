package com.learn.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
 WebDriver d ;
 @Parameters("browser")
 @BeforeClass
  public void openBrowser(String brow) {
	  if(brow.equalsIgnoreCase("chrome")) {
		    ChromeOptions opt =new ChromeOptions();	
		    opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			d = new ChromeDriver(opt);
	  }else if(brow.equalsIgnoreCase("firefox")) {
		    FirefoxOptions opt =new FirefoxOptions();	
		    opt.addArguments("--user-agent=Mozilla/5.0()");
		    WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver(opt);
		  }else {
			  System.out.println("No value set by user in xml file....");
		  }
	    d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().window().maximize();
	  
  }
  @Parameters({"usname","pword"})
  @Test
  public void login(String un,String pw) {
	    WebElement  username= d.findElement(By.name("username"));
	    username.sendKeys(un);
	   
		WebElement password = d.findElement(By.name("password"));
		password.sendKeys(pw);
		
		WebElement button = d.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		
		
	    String curl=d.getCurrentUrl();
	    System.out.println(curl);
	    if(curl.contains("dashboard")) {
		System.out.println("yes......loged in succesfully");
		}else {
			System.out.println("logged in falied");
		}
	  
  }
  @AfterClass
  public void closeBrowser() {
	  d.quit();
	  
  }
}
