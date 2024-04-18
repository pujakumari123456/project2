package com.learn.selenium;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class brokenLinks {
    
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
    	ChromeOptions  opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 List<WebElement>links=driver.findElements(By.tagName("a"));
	        int noOfLinks=links.size();
	    
	        System.out.println("total no of link : "+noOfLinks); 
	        
	        int brokenLink=0;
			  for(WebElement element:links)
			  {
				 String url= element.getAttribute("href");
				 
				 if(url==null || url.isEmpty())
				 {
					 System.out.println("URL is empty");
					 continue;
				 }
				 
				 URL link= new URL(url);
				 try {
				
					 HttpURLConnection httpcon= (HttpURLConnection) link.openConnection();
					 httpcon.connect();
					 
					 if(httpcon.getResponseCode()>=400)
					 {
						 System.out.println( httpcon.getResponseCode()+url+"broken links");
						 brokenLink++;
					 }
					 else
					 {
						 System.out.println(httpcon.getResponseCode()+url+"normal links");
					 }
				 
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			  System.out.println("no. of broken links"+ brokenLink);

	     
	        	
		
		
	}

}
