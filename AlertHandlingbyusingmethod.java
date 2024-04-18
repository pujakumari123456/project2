package com.learn.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandlingbyusingmethod {
	static WebDriver d;
	static Alert alt;
	public static void differentalerthandling(String alertType) throws InterruptedException {
		if(alertType.equalsIgnoreCase("Alert Box")) {
		WebElement simplealt	=d.findElement(By.xpath("//button[text()='Alert Box']"));
	    simplealt.click();
	    Thread.sleep(2000);
	    //alert handling code
	   alt= d.switchTo().alert();
	   String alttext = alt.getText();
	   System.out.println("alert text : "+ alttext);
	   Thread.sleep(2000);
		alt.accept();
		
			
		}else if(alertType.equalsIgnoreCase("Confirm Alert Box")) {
			WebElement confirmalt =d.findElement(By.xpath("//button[text()='Confirm Alert Box']"));
		    confirmalt.click();
		    Thread.sleep(2000);
		    // confirm alert handling code
			   alt= d.switchTo().alert();
			   String alttext2 = alt.getText();
			   System.out.println("alert text : "+ alttext2);
		       alt.dismiss();
			
		}else if(alertType.equalsIgnoreCase("Prompt Alert Box")) {
			WebElement promalt =d.findElement(By.xpath("//button[text()='Prompt Alert Box']"));
		   promalt.click();
		    Thread.sleep(2000);
			    // prompt alert handling code			  
		   alt= d.switchTo().alert();
		   String alttext3 = alt.getText();
		   System.out.println("alert text : "+ alttext3);
		   alt.sendKeys("yes");
		   Thread.sleep(2000);
		   alt.accept();
		   	Thread.sleep(2000);
			d.close();
		}
		
	}

	public static void main(String[] args) {
		try {
			
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			d = new ChromeDriver(opt);
	        d.get("https://nxtgenaiacademy.com/alertandpopup/");
			d.manage().window().maximize();
			
			differentalerthandling("Alert Box");
			differentalerthandling("Confirm Alert Box");
			differentalerthandling("Prompt Alert Box");
			

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
