package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Advance_8_Assigenment {

	public static void main(String[] args) {
		try {
//			Open link : https://online.actitime.com/test3/login.do
            ChromeOptions  opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver(opt);
			driver.get("https://online.actitime.com/text1/login.do");
			driver.manage().window().maximize();
			//2. Login To Application
			WebElement username=driver.findElement(By.name("username"));
			username.sendKeys("pujakumaripihu1995@gmail.com");
			
			WebElement password=driver.findElement(By.name("pwd"));
			password.sendKeys("Text@123");
			
			WebElement button=driver.findElement(By.xpath("//div[text()='Login ']"));
			button.click();
			//3. Verify Dashboard Page Opened	
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
						By.xpath("//a[@class='content users'] //div[@class='label']")));


//          4. Click On USer Tab			
			WebElement users=driver.findElement(By.xpath("//a[@class='content users'] //div[@class='label']"));
			users.click();
//          5. Click On New User	
			WebElement Newusers=driver.findElement(By.xpath("//div[contains(text(),'New User')]"));
			Newusers.click();
//          6. Create the User
			Thread.sleep(2000);
			WebElement firstname=driver.findElement(By.xpath("//input[@id='createUserPanel_firstNameField']"));				
			
			firstname.sendKeys("MyName");
			WebElement lastname=driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']"));				
			lastname.sendKeys("Is Puja");
//			7. Fill The Email ID
			WebElement email=driver.findElement(By.xpath("//input[@id='createUserPanel_emailField']"));				
			email.sendKeys("mynameispuja@gmail.com");
//			8. Save the user and verify user got create
			WebElement save=driver.findElement(By.xpath("//div[contains(text(),'Save & Send Invitation')]"));				
			save.click();
			Thread.sleep(3000);
			WebElement actualUser=driver.findElement(By.xpath("//div[contains(text(),'Account for MyName Is Puja has been created.')]"));
			String actualUserSuccessfullMsg= actualUser.getText();
			//System.out.println(actualUserSuccessfullMsg);
			
			if(actualUserSuccessfullMsg.contains("Account for MyName Is Puja has been created."))
			{
				System.out.println("user created successfully : "+actualUserSuccessfullMsg);
			}else {
				System.out.println("invalid");
			}	
			//driver.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
