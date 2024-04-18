package com.learn.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intermediate_11_Assigenment {

	public static void main(String[] args) {
		// Verify all the checkbox are selected
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
		//	1.Launch to Application : https://courses.letskodeit.com/practice
			d.get("https://www.letskodeit.com/practice");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//	2.click on the checkboxes one by one and verify all the checkboxes are selected
			List<WebElement> allCheck=d.findElements(By.xpath("//input[@type='checkbox']"));
			for(int i=0;i<allCheck.size();i++) {
		       //Thread.sleep(2000);
		      
			   allCheck.get(i).click();
			  
			  if(allCheck.get(i).isDisplayed() && allCheck.get(i).isEnabled()) {
					
			    //String checkboxName =allCheck.get(i).getText();
			    
                 System.out.println("check box is selected : " +i);
				}else {
				System.out.println("check box is  not selected");
				}
			}
			
			d.close();
		
		
	
				
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}

	}
}

