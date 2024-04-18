package com.learn.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intermediate_10_Assigenment {

	public static void main(String[] args) {
		//Verify the elements in dashboard page
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
			  //3.Verify the elements are present inside the dashboard and inside the Quicklaunch.
			   List<WebElement> delements=d.findElements(By.xpath("//div[@class='orangehrm-dashboard-widget-header']"));
			   System.out.println(delements.size());
			   String elementsName = null;
			   int size=delements.size();
			   for(int i=0;i<size;i++) {
			    	elementsName=delements.get(i).getText();
			    	//Thread.sleep(3000);
			    	  if(elementsName.equals("Time at Work") ||elementsName.equals("My Actions")||elementsName.equals("Quick Launch")  ||elementsName.equals("Buzz Latest Posts")  || elementsName.equals("Employees on Leave Today") || elementsName.equals("Employee Distribution by Sub Unit")||elementsName.equals("Employee Distribution by Location"))
					    { 
					     Thread.sleep(3000);
					   
					    System.out.println("element present inside the dashboard :" + elementsName);
					    }else{
					    System.out.println("Element not present in the dashboard");
					    }
					   
			    	
			    	
			    } 
			   
			   
			    List<WebElement> elements=d.findElements(By.xpath("//div[@class='orangehrm-quick-launch-heading']"));
			   
			    //System.out.println("No. of element present inside Quick lunch : "+ elements.size());
			    String elementsName1 = null;
			    int size1=elements.size();
			    //Thread.sleep(3000);
			   System.out.println("No. of element present inside Quick lunch : "+ size1);
			    for(int j=0;j<size1;j++) {
			    	elementsName1=elements.get(j).getText();
			    	//Thread.sleep(3000);
			    	  if(elementsName1.equals("Assign Leave") ||elementsName1.equals("Leave List")||elementsName1.equals("Timesheets")  ||elementsName1.equals("Apply Leave")  || elementsName1.equals("My Leave") || elementsName1.equals("My Timesheet"))
					    { 
					    Thread.sleep(3000);
					   // if(elementsName.contains("Assign Leave || Leave List || Timesheets || Apply Leave || My Leave || My Timesheet"))
					    System.out.println("element present inside the Quick lunch :" + elementsName1);
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
