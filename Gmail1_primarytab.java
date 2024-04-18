package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail1_primarytab {

	public static void main(String[] args) {
		try {
            ChromeOptions  opt=new ChromeOptions();
			
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver(opt);
			driver.get("https://gmail.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login to your Gmail with correct credentials.
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
//			Verify that by default “Primary” section is selected.
			
//			If not click on the Primary tab.
//			Get the count of the total number of emails in the Primary tab.
//			Get the name of the sender and subject of Nth Email of your inbox.
//			Write a method to get the name of the sender and subject of email of your inbox.
//			Please refer below screenshot for the same.
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
