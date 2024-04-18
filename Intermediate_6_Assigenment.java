package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intermediate_6_Assigenment {

	public static void main(String[] args) {
		try {
			//get all the links from Facebook login page
			 ChromeOptions opt =new ChromeOptions();	
			 opt.addArguments("--remote-allow-origins=*");
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver(opt);
			//1.Launch Facebook Application
			driver.get("https://www.facebook.com/");
			//3. Maximize or set size of browser window.
			driver.manage().window().maximize();
			//2.Fetch all the links from the login page and count it and print it
			List<WebElement> totallinks = driver.findElements(By.tagName("a"));
			int count = totallinks.size();
		    System.out.println("number of links: "+count);
			//4. Close browser.
		    driver.close();
		    } catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
