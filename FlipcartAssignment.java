package com.learn.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartAssignment {
WebDriver driver;
String url= "https://www.flipkart.com/";

	public static void main(String[] args) {
		try {
			FlipcartAssignment abc= new FlipcartAssignment();
			abc.browser();
			abc.totalcount();
			abc.linktextandurl();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	

	}
    public void browser() {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
    	ChromeOptions  opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
    }

    public  void totalcount() {

    	
        List<WebElement>links=driver.findElements(By.tagName("a"));
        int noOfLinks=links.size();
    
        System.out.println("total no of link : "+noOfLinks); 
    
    	//driver.close();
    } 
    public  void linktextandurl() {
    	 //Write another method to print link text and URLs of all the links on the page of Flipkart
    	List<WebElement>links=driver.findElements(By.tagName("a"));
        int noOfLinks=links.size();
    
       // System.out.println("total no of link : "+noOfLinks); 
        for(int i=0;i<noOfLinks;i++) {
        String alllink=	links.get(i).getText();
        System.out.println("url no : "+i+" url text : "+alllink);
        	
        }
        
    	
    }
   
    
}
