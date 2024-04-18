package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmail_Assigenment {

	
	public static void main(String[] args) {
		try {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
	    	ChromeOptions  opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriver driver=new ChromeDriver(opt);
			//ChromeOptions  opt=new ChromeOptions();
			
			//opt.addArguments("--remote-allow-origins=*");
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver=new ChromeDriver(opt);
			driver.get("https://gmail.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement username=driver.findElement(By.id("identifierId"));
			username.sendKeys("pihupujakumari08@gmail.com");
			WebElement next=driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
			next.click();
			Thread.sleep(2000);
			WebElement password=driver.findElement(By.xpath("//input[@name='Passwd']"));
			password.sendKeys("Pujakumari@123");
			Thread.sleep(2000);
			WebElement next1=driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
			next1.click();
			//validation for gmail loggded in
			String title=driver.getTitle();
			if(title.contains("Gmail")) {
				
				System.out.println("Logged in successfully");
			}else {
				System.out.println("logged in failed");
			}
			
			WebElement compose=driver.findElement(By.xpath("//div[contains(text(),'Compose')]"));
			compose.click();
			Thread.sleep(2000);
			// validation for compose box
			WebElement newMessage=driver.findElement(By.xpath("//span[contains(text(),'New Message')]"));
			String messageTitle=newMessage.getText();
            if(messageTitle.contains("New Message")) {
				
				System.out.println("Compose box opened");
			}else {
				System.out.println("compose box not opening");
			}
           Thread.sleep(2000);
           WebElement to= driver.findElement(By.xpath("//input[@role='combobox']"));
           to.sendKeys("pujakumaripihu1995@gmail.com");
           WebElement subject= driver.findElement(By.xpath("//input[@name='subjectbox']"));
           subject.sendKeys("Learning Automation");
           Thread.sleep(2000);
           WebElement body= driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"));
           body.sendKeys("Hi Puja, ");
           Thread.sleep(3000);
           WebElement send=driver.findElement(By.xpath("body > div:nth-child(40) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"));
           send.click();
           
           
           driver.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		

	}

}
