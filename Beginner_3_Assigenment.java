package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Beginner_3_Assigenment {

	public static void main(String[] args) {
		//Beginner_3_Open_Godaddy.com_and_Validate_PageTitle
		try {
			// 1.Launch browser of your choice say., Firefox, chrome etc. 
			   ChromeOptions opt =new ChromeOptions();	
				 opt.addArguments("--remote-allow-origins=*");
				 WebDriverManager.chromedriver().setup();
				 WebDriver driver = new ChromeDriver(opt);
				//2.https://www.godaddy.com/en-in
				driver.get("https://www.godaddy.com/en-in");
				//3. Maximize or set size of browser window.
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//4. Get Title of page and validate it with expected value.
			    String Title =driver.getTitle();
				System.out.println("Title of the page is  :"+Title);
				String expectedTitle ="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
				if(Title.equalsIgnoreCase(expectedTitle)){
					System.out.println("Title Matched");
				}else {
					System.out.println("Title didn't match");
				}
				//5. Get URL of current page and validate it with expected value.
		        String curl=driver.getCurrentUrl();
				System.out.println("current url page is :"+curl);
				String expectedcurl ="https://www.godaddy.com/en-in";
				//Assert.assertequals(curl, "https://www.godaddy.com/en-in" ); // for adject value match
				//assert.assertTrue(curl.contains("https://www.godaddy.com/en-in"))// for ture value 
				                      //or
				if(curl.equalsIgnoreCase(expectedcurl)){
					System.out.println("current url is Matched");
				}else {
					System.out.println("current url is not match");
				}
				
				//6.Get Page source of web page.
				//7. And Validate that page title is present in page source.
			   String pagesource=driver.getPageSource();
	            //System.out.println("pagesource is : "+pagesource);
				//Assert.assertTrue(pagesource.contains("Title"));
			     if(pagesource.contains("title")){
				   System.out.println("yes......title is present in page source");
					}else {
						 System.out.println("no.....title is present in page source");
					     }
				    
				//6. Close browser.
				driver.close();
		
	
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
