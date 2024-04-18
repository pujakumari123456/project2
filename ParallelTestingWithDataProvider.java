package com.learn.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestingWithDataProvider {
  @Test(dataProvider ="orangeHRMData",dataProviderClass = GenericDataProvider.class)
  public void LoginOrangeHrm(String un,String pw) throws InterruptedException {
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
	    username.sendKeys(un);
	    Thread.sleep(2000);
		WebElement password = d.findElement(By.name("password"));
		password.sendKeys(pw);
		Thread.sleep(2000);
		WebElement button = d.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		Thread.sleep(2000);
		
	    String curl=d.getCurrentUrl();
	    System.out.println(curl);
	    if(curl.contains("dashboard")) {
		System.out.println("yes......loged in succesfully");
		}else {
			System.out.println("logged in falied");
		}
	    
	    d.close();
  }
  
  @Test(dataProvider ="ActitimeData",dataProviderClass = GenericDataProvider.class)
  public void LoginActitime(String un,String pw) throws InterruptedException {
	    FirefoxOptions opt =new FirefoxOptions();	
	    opt.addArguments("--user-agent=Mozilla/5.0()");
	    WebDriverManager.firefoxdriver().setup();
	    WebDriver d = new FirefoxDriver(opt);
		d.get("https://online.actitime.com/text1/login.do");
		d.manage().window().maximize();
//		Login To Actitime
		WebElement username=d.findElement(By.name("username"));
		username.sendKeys(un);
		
		WebElement password=d.findElement(By.name("pwd"));
		password.sendKeys(pw);
		
		WebElement button=d.findElement(By.xpath("//div[text()='Login ']"));
		button.click();
		//3. Verify Dashboard Page Opened	
		Thread.sleep(3000);
		
		String curUrl=d.getCurrentUrl();
		if(curUrl.contains("timetrack"))
		{
			System.out.println("Logged in successfully");
		}
		else
		{
			System.out.println("Login failed");
		}
		
	  d.quit();
  }
}
