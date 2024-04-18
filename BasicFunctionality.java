package com.learn.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicFunctionality {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();
			 opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver d= new ChromeDriver(opt);
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			//maximize the window
			d.manage().window().maximize();
			//get current url
			String curl =d.getCurrentUrl();
			System.out.println("URL is : "+curl);
			String til= d.getTitle();
			System.out.println("title of the page  :"+ til);
			String sou= d.getPageSource();
			System.out.println("Page source is :"+sou);
			Thread.sleep(2000);
			//d.navigate().back();
			Thread.sleep(2000);
			d.navigate().forward();
			Thread.sleep(2000);
			d.navigate().refresh();
			Thread.sleep(2000);
			d.close();
			   
			
			}catch(Exception e) {
			
		}

	}

}
