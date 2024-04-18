package com.learn.selenium;

import java.io.File;
import java.sql.Date;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingwiththeScreenshot {

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
			js.executeScript("arguments[0].scrollIntoView(true)", iframeex);
			Thread.sleep(2000);
			
			//take Current Date and Time

			//Screenshot code
			TakesScreenshot ts=  ((TakesScreenshot)d);
			File sourcefile = ts.getScreenshotAs(OutputType.FILE);
			//save the file in desired folder
			Thread.sleep(2000);
//			File DestFile=new File("‪‪C:\\Users\\Admin\\Desktop\\screenshot\\name.png");
			FileUtils.copyFile(sourcefile,new File("‪‪C:\\Users\\Admin\\Desktop\\learn java\\LearnSelenium\\screenshot\\name.png"));
			
			
			d.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
//long cts=System.currentTimeMillis();
//System.out.println(cts);
//Date dt =new Date();
