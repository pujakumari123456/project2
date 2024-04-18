package com.learn.selenium;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingwrokingwithnewBrowserTab {

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
			
		    WebElement browserwindowbutton	=d.findElement(By.xpath("//button[text()='New Browser Tab']"));
		    browserwindowbutton.click();
		    
		    Set<String>allwindow=d.getWindowHandles();
		     
		    ArrayList<String> l=new ArrayList<>(allwindow);
		    d.switchTo().window(l.get(1));//for child tab(1)		    
		    System.out.println("switch to new tab : "+d.getTitle());
		    d.close();
		    d.switchTo().window(l.get(0)); //for parent tab(0)
		    System.out.println("switch to parent tab : "+d.getTitle());
		    
		    
		    d.close();
		    
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
