package com.learn.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Advance_5_Assigenment {

	public static void main(String[] args) {
	try {
		ChromeOptions opt =new ChromeOptions();	
	    opt.addArguments("--remote-allow-origins=*");
	    WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver(opt);
		//Launch google web page
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	//2.Login To application
	    WebElement  username= d.findElement(By.name("username"));
	    username.sendKeys("Admin");
	    Thread.sleep(2000);
		WebElement password = d.findElement(By.name("password"));
		password.sendKeys("admin123");
		Thread.sleep(2000);
		WebElement button = d.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		Thread.sleep(2000);
		
	    String curl=d.getCurrentUrl();
	    System.out.println(curl);
	    if(curl.contains("dashboard")) {
		System.out.println("yes......loged in succesfully");
		}else {
			System.out.println("logged in falied");
		}
	  
	   // Verify Quick launch having 6 elements
	    List<WebElement> elements=d.findElements(By.xpath("//div[@class='orangehrm-quick-launch-heading']"));
	   
	    //System.out.println("No. of element present inside Quick lunch : "+ elements.size());
	    String elementsName = null;
	    int size=elements.size();
	    //Thread.sleep(3000);
	   System.out.println("No. of element present inside Quick lunch : "+ size);
	   for(int i=0;i<size;i++) {
	    	elementsName=elements.get(i).getText();
	    	//Thread.sleep(3000);
	    	  if(elementsName.equals("Assign Leave") ||elementsName.equals("Leave List")||elementsName.equals("Timesheets")  ||elementsName.equals("Apply Leave")  || elementsName.equals("My Leave") || elementsName.equals("My Timesheet"))
			    { 
			    Thread.sleep(3000);
			   // if(elementsName.contains("Assign Leave || Leave List || Timesheets || Apply Leave || My Leave || My Timesheet"))
			    System.out.println("element present inside the Quick lunch :" + elementsName);
			    }else{
			    System.out.println("Element not present in the Quick lunch");
			    }
			   
	    	
	    	
	    	//System.out.println(elementsName);
	    } 
	    
	    d.close();
	
		
	} catch (Exception e) {
		// TODO: handle exception
	}

	}

}
