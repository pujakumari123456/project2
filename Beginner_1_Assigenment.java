package com.learn.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Beginner_1_Assigenment {

	public static void main(String[] args) {
		//Beginner_1_Open_Godaddy.com_and_maximize_browser_window
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
			//4. Close browser.
			driver.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
