package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingwithGettextAndGetAttribute {

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
			//gettext of any lable
			WebElement RadioButtonLable =d.findElement(By.xpath("//legend[text()='Radio Button Example']"));
			String textname=RadioButtonLable.getText();
			System.out.println("test of radiobuttonlable :" +textname);
            // getting the attribute and verify it 
			System.out.println("**********************");
			WebElement disptext= d.findElement(By.id("displayed-text"));
			String phvalue= disptext.getAttribute("placeholder");
			if(phvalue.contains("Hide/Show Example")) {
				System.out.println("Place holder value is verified");
			}else {
				System.out.println("Place holder value is not verified");
			}
			//entring the value and try to get the enter value
			System.out.println("**********************");
			disptext.sendKeys("jave");
			String disptextvalue =disptext.getAttribute("value");
			System.out.println("Value of text box is :"+ disptextvalue);
			
			
			d.quit();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	  
      }
	}


