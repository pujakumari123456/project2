package com.learn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingwithDatePicker {

	public static void main(String[] args) throws InterruptedException {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		String expmonth ="December 2023";
		String expdate ="14";
		ChromeOptions opt =new ChromeOptions();	
		opt.addArguments("--remote-allow-origins=*");
	    WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver(opt);
        d.get("https://www.makemytrip.com/");
		d.manage().window().maximize();
		//click on departure box
		WebElement dept=d.findElement(By.xpath("//label[@for='departure']"));
		dept.click();
		//pick the current focused date
	   
       while(true) {
    	   Thread.sleep(2000);
    	   WebElement currentmonth=d.findElement(By.xpath("//div[@class='DayPicker-Months']/div/div[@role='heading']/div"));
    	   String currentmonthtext = currentmonth.getText();
    	   if(currentmonthtext.equalsIgnoreCase(expmonth)) {
    		   break;
    	   }else {
    		   Thread.sleep(2000);
    		   WebElement nextbutton=d.findElement(By.xpath("//span[@aria-label='Next Month']"));
    		   nextbutton.click();
    	   }
       }
      Thread.sleep(2000);
      WebElement datetotravel= d.findElement(By.xpath("//div[@class='DayPicker-Week']//p[text()='14']"));
      datetotravel.click();
      

	}

}
