package com.learn.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingWithAlertPopUp {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
	        d.get("https://nxtgenaiacademy.com/alertandpopup/");
			d.manage().window().maximize();
			
			
			
		    WebElement simplealt	=d.findElement(By.xpath("//button[text()='Alert Box']"));
		    simplealt.click();
		    Thread.sleep(2000);
		    //alert handling code
		   Alert alt= d.switchTo().alert();
		   String alttext = alt.getText();
		   System.out.println("alert text : "+ alttext);
		    Thread.sleep(2000);
		   alt.accept();
		   
		   System.out.println("**************************confirm Alert BOx****************");
		  
		   WebElement confirmalt =d.findElement(By.xpath("//button[text()='Confirm Alert Box']"));
		   confirmalt.click();
		    Thread.sleep(2000);
		    // confirm alert handling code
		   Alert alt2= d.switchTo().alert();
		   String alttext2 = alt2.getText();
		   System.out.println("alert text : "+ alttext2);
		   alt2.dismiss();
		   
		   
		   System.out.println("**************************Prompt Alert Box****************");
			  
		   WebElement promalt =d.findElement(By.xpath("//button[text()='Prompt Alert Box']"));
		   promalt.click();
		    Thread.sleep(2000);
		    // prompt alert handling code
		   Alert alt3= d.switchTo().alert();
		   String alttext3 = alt3.getText();
		   System.out.println("alert text : "+ alttext3);
		   alt3.sendKeys("yes");
		   Thread.sleep(2000);
		   alt3.accept();
		   
		   Thread.sleep(2000);
		   
		   d.close();
		   
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
