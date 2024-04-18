package com.learn.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingWithMultipleElement {

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
			//multiple element
			List<WebElement> allradio=d.findElements(By.xpath("//input[@type='radio']"));
			for(int i=0;i<allradio.size();i++) {
				Thread.sleep(2000);
				allradio.get(i).click();
			}
			d.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
