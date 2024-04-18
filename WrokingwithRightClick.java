package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingwithRightClick {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
	        d.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
			d.manage().window().maximize();
			WebElement rcm=d.findElement(By.xpath("//span[text()='right click me']"));
            Actions act =new Actions(d);
            act.contextClick(rcm);
            act.build().perform();
            WebElement copy=d.findElement(By.xpath("//span[text()='Copy']"));
            copy.click();
            Thread.sleep(2000);
            d.switchTo().alert().accept();
            Thread.sleep(2000);
            d.close();
            
            
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
