package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingWithFrameHandling {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
	        d.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
			d.manage().window().maximize();
			List<WebElement> allfram=d.findElements(By.tagName("iframe"));
			System.out.println(allfram.size());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
