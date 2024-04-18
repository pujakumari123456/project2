package com.learn.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intermediate_9_Assigenment {

	public static void main(String[] args) {
		//Get  all the values from the dropdown
		try {
		
			 ChromeOptions opt =new ChromeOptions();	
			 opt.addArguments("--remote-allow-origins=*");
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver(opt);
			//1.Launch Application : https://courses.letskodeit.com/practice
			driver.get("https://www.letskodeit.com/practice");
			//3. Maximize or set size of browser window.
			driver.manage().window().maximize();
			//2.Get the values from the dropdown and verify. you should use getOption() as well as without getOption()
			WebElement cars = driver.findElement(By.id("carselect"));
		    Select sel =new Select(cars);
		    List<WebElement> carsdd = sel.getOptions();
		    for(int i=0;i<carsdd.size();i++) {
		    	Thread.sleep(2000);
		    	String carsddtext= carsdd.get(i).getText();
		    	System.out.println("Cars DD text are " +carsddtext);
		    }
		    // without getoption
		    
		   System.out.println("***************With out getOptions**********");
			 List<WebElement> optionElements = cars.findElements(By.tagName("option"));

		      // Iterate through the list of option elements and retrieve the text of each option
		        for (WebElement option : optionElements) {
		            String optionText = option.getText();
		            System.out.println(optionText);
		        }
		    
		driver.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
