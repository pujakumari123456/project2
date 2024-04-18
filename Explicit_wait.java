package com.learn.selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_wait {

	public static void main(String[] args) {
		try {
			ChromeOptions  opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver(opt);
			driver.get("https://online.actitime.com/text1/login.do");
			driver.manage().window().maximize();
			
			
			//To make the tool wait till the tasks link is loaded 
		    //driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//applicable for whose code this the draw back of iw

			// login code
			WebElement username=driver.findElement(By.name("username"));
			username.sendKeys("vipraharika@gmail.com");
			Thread.sleep(3000);
			WebElement password=driver.findElement(By.name("pwd"));
			password.sendKeys("Iloveusatya@123");
			
			WebElement button=driver.findElement(By.xpath("//div[text()='Login ']"));
			button.click();
			

			//verify that logged in or not	
			
			Thread.sleep(3000);
			
			String curUrl=driver.getCurrentUrl();
			if(curUrl.contains("timetrack"))
			{
				System.out.println("Logged in successfully");
			}
			else
			{
				System.out.println("Login failed");
			}
			
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.
				elementToBeClickable(
						By.xpath("//div[text()='Tasks'")));


					
		//	WebElement tasks=driver.findElement(By.xpath(""));
		//	tasks.click();
			
			driver.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
