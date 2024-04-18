package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intermediate_8_Assigenment {

	public static void main(String[] args) {
		//Verify the link of the forgotten password and click
		try {
		
			 ChromeOptions opt =new ChromeOptions();	
			 opt.addArguments("--remote-allow-origins=*");
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver(opt);
			//1.Launch orangeHRM Application : https://opensource-demo.orangehrmlive.com/index.php/auth/login
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		   //3. Maximize or set size of browser window.
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   //2.Verify the forgotten password link and click it. make sure you should use getAttribute()
		  WebElement forgotpass	= driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
		        Thread.sleep(3000);
		  if (forgotpass.isDisplayed() && forgotpass.isEnabled()) {
			      forgotpass.click();
			      Thread.sleep(3000);
		          }else {
		            	System.out.println("forgotpassword link is not click");
		            }
		    WebElement disptext= driver.findElement(By.name("username"));
			disptext.sendKeys("puja@24");
			String disptextvalue =disptext.getAttribute("value");
			System.out.println("Value of text box is :"+ disptextvalue);
			
		  driver.close();
		  
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

}
