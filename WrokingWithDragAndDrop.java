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

public class WrokingWithDragAndDrop {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
	        d.get("https://www.globalsqa.com/demo-site/draganddrop/");
			d.manage().window().maximize();
			WebElement gsq=d.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
			WebDriverWait wait=new WebDriverWait(d,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(gsq));
			
			WebElement drag=d.findElement(By.xpath("//h5[text()='High Tatras']"));
			WebElement drop=d.findElement(By.xpath("//div[@id='trash']"));
			Thread.sleep(2000);
			Actions act=new Actions(d);
			act.clickAndHold().moveToElement(drag).release(drop);
			act.build().perform();
			Thread.sleep(2000);
			//d.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
