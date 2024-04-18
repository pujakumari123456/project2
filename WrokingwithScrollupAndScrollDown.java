package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingwithScrollupAndScrollDown {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://www.letskodeit.com/practice");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//Wroking with scroll down(vertically) code
			JavascriptExecutor js = (JavascriptExecutor)d;
			js.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(2000);
			//scroll up
			js.executeScript("window.scrollBy(0,-1000)", "");
			Thread.sleep(2000);
			//scroll to particular element
			WebElement iframeex=d.findElement(By.xpath("//legend[text()='iFrame Example']"));
			js.executeScript("arguments[0].scollIntoView(true)", iframeex);
			Thread.sleep(2000);
			d.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
