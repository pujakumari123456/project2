package com.learn.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Openbrower {

	public static void main(String[] args) {
		//Launch chrome web browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
	   ChromeOptions opt =new ChromeOptions();	
	  opt.addArguments("--remote-allow-origins=*");
	   WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		//Launch google web page
		driver.get("https://www.google.com/");
	

	}

}
