package com.learn.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_handling {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
	        d.get("https://nxtgenaiacademy.com/multiplewindows/");
			d.manage().window().maximize();
			
			String pid=d.getWindowHandle();
			System.out.println("Parent window id is : "+pid);
			
		    WebElement browserwindowbutton	=d.findElement(By.xpath("//button[text()='New Browser Window']"));
		    browserwindowbutton.click();
		    
		    Set<String>allwindow = d.getWindowHandles();
		    System.out.println("Allwindow id is : " +allwindow);
		    
		    for(String c:allwindow) {
		    	if(!c.equalsIgnoreCase(pid)) {
		    	d.switchTo().window(c);
		    	System.out.println("Switched to child windows");
		    	String childwindowstille=d.getTitle();
		    	System.out.println("child window tittle is : "+childwindowstille);
		    	d.close();
		    	
		    }
		    }
		    Thread.sleep(2000);
		    d.switchTo().window(pid);
	    	System.out.println("Switched to parent windows");
	    	String parentdwindowstille=d.getTitle();
	    	System.out.println("parent window tittle is :"+parentdwindowstille);
	    	d.close();
		    
		    
		    
		  
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
