package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingwithDropDown {

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
			//if the tagname start from select
			WebElement cars = d.findElement(By.id("carselect"));
			Select sel = new Select(cars);
			sel.selectByIndex(2);
			Thread.sleep(2000);
			sel.selectByValue("benz");
			Thread.sleep(2000);
			sel.selectByVisibleText("BMW");
			d.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
