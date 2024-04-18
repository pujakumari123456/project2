package com.learn.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingWithMouseHover {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
	        d.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
			d.manage().window().maximize();
			WebElement gsq=d.findElement(By.name("globalSqa"));
			WebDriverWait wait=new WebDriverWait(d,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(gsq));
			//code for mousehover
			WebElement all=d.findElement(By.xpath("//span[text()='All']"));
			Thread.sleep(2000);
			Actions act=new Actions(d);
			act.moveToElement(all);
			act.build().perform();
			
			Thread.sleep(2000);
			//forsingle element
//		    WebElement automation =d.findElement(By.xpath("//span[text()='All']/following-sibling::ul/li/div[text()='Automation'"));
//			act.moveToElement(automation);
//			act.click().build().perform();
//			Thread.sleep(2000);
			
			List<WebElement> automationlist =d.findElements(By.xpath("//span[text()='All']/following-sibling::ul/li/div"));
			for(int i=0;i<automationlist.size();i++) {
				act.moveToElement(automationlist.get(i));
				act.build().perform();
				System.out.println(automationlist.get(i).getText());
			}
		
			Thread.sleep(2000);
			d.close();
			
		} catch (Exception e) {
		e.printStackTrace();
		}

	}

}
