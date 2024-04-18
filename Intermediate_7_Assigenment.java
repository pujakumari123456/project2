package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intermediate_7_Assigenment {

	public static void main(String[] args) {
		//Get the text of the element from the application and verify
		try {
			//get all the links from Facebook login page
			 ChromeOptions opt =new ChromeOptions();	
			 opt.addArguments("--remote-allow-origins=*");
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver(opt);
			//1.Launch Spicejet Application : https://courses.letskodeit.com/practice
			driver.get("https://www.spicejet.com/");
			//3. Maximize or set size of browser window.
			driver.manage().window().maximize();
			//2.Get the text of the radiobuttons and verify dynamically and check whether radiobutton is clicked or not
			List<WebElement> allradio=driver.findElements(By.xpath("//div[contains(@data-testid,'radio-button')]"));
			for(int i=0;i<allradio.size();i++) {
			String text=allradio.get(i).getText();
			allradio.get(i).click();
		    Thread.sleep(3000);
			System.out.println(text);
			// validation for radio button is selected or not
			if(allradio.get(i).isDisplayed() && allradio.get(i).isEnabled()) {
				System.out.println("radio button is clicked : " + text );
			}else { 
				System.out.println("radio button is not selected");
			}
			}
			
//			for(int i=0;i<allradio.size();i++) {
//			String checkstatus =allradio.isSelected();
//			     if(checkstatus==true) {
//				System.out.println("check box is not selected");
//			     }else {
//				System.out.println("check box is selected");
//			 }
//			}
//			for(int i=0;i<allradio.size();i++) {
//		   String checkstatus =allradio.isSelected();
//			if(checkstatus)
//			{
//				System.out.println("selected the one way button");
//			}
//			else
//			{
//				System.out.println("one way button is not selected");
//			}
//			
//			}
			
			driver.quit();
		
		}
		
			catch (Exception e) {
			// TODO: handle exception
		}
		

		}

}
