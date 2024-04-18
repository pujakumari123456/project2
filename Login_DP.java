package com.learn.testNG;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_DP {
  @Test(dataProvider ="getData")
  public void login(String un,String pw) throws InterruptedException {
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
  @DataProvider	  
  public Object[][] getData(){
	  Object[][] obj =new Object[3][2];
	  obj[0][0]="LG";
	  obj[0][1]="LG1";
	  obj[1][0]="Nokia";
	  obj[1][1]="Nokia1";
	  obj[2][0]="Admin";
	  obj[2][1]="admin123";
	  return obj;
	  
  }
  }


