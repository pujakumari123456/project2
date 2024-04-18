package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_Snapdeal {

	public static void main(String[] args) {
		try {
ChromeOptions  opt=new ChromeOptions();
			
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver(opt);
			driver.get("http://www.snapdeal.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//			– Move to Sign In Button and hold
			WebElement sing=driver.findElement(By.xpath("//span[text()='Sign In']"));
			Actions act = new Actions(driver);
			act.moveToElement(sing).build().perform();
			
//			– Move to the Sign In button and click Login_button 
			WebElement Login=driver.findElement(By.xpath("//a[text()='login']"));
			Login.click();
			WebElement fram=driver.findElement(By.id("loginIframe"));
			driver.switchTo().frame(fram);
			
		
//			– Enter valid Email Id and click continue.
			
			WebElement Loginsing=driver.findElement(By.id("userName"));
			Loginsing.sendKeys("pihupujakumari08@gmail.com");
			
			WebElement continu=driver.findElement(By.id("checkUser"));
			continu.click();
			WebElement pswd  =driver.findElement(By.id("j_password"));
			pswd.sendKeys("puja@123");
			WebElement num  =driver.findElement(By.id("j_number"));
			num.sendKeys("8547452172");
			WebElement name  =driver.findElement(By.id("j_name"));
			name.sendKeys("puja");
			WebElement pswdcontin  =driver.findElement(By.id("userSignup"));
			pswdcontin.click();


//			Snapdeal_login_section
//			– Enter the valid password and click LOGIN.
//
//			password
//			– Verify that the user is logged in successfully.
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
