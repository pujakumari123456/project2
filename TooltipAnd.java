package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TooltipAnd {

	public static void main(String[] args) {
		try {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			d.get("https://www.globalsqa.com/demo-site/tooltip/");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebElement forms= d.findElement(By.xpath("//li[text()='Forms Based']"));
			forms.click();
			WebElement framename= d.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
			d.switchTo().frame(framename);
			WebElement firstname= d.findElement(By.id("firstname"));
			Actions act=new Actions(d);
			act.moveToElement(firstname).perform();
			act.build().perform();
			Thread.sleep(2000);
			WebElement tooltiptext= d.findElement(By.xpath("//div[@role='tooltip']//div"));
			if(tooltiptext.getText().equalsIgnoreCase("Please provide your firstname.")) {
				System.out.println(" yes tooptiptext is : "+tooltiptext.getText());
			}else {
				System.out.println(" no tooptiptext didnt find : ");
			}
			
			Thread.sleep(2000);
			d.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
