package com.learn.selenium;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GettingTextFromUIByPassingDataFromUser {
	static WebElement d;
	public static void getCarstext(String value) {
		WebElement RadioButtonLable =d.findElement(By.xpath("//label[text()=' "+value+" ']"));
		String textname=RadioButtonLable.getText();
		System.out.println("text of radiobutton label is :" + textname);
	}

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://www.letskodeit.com/practice");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//Scanner s = new Scanner(System.in);
			//System.out.print( "Enter Value of a :" );
			//String userinput = s.next();
			
			getCarstext("BMW");
			
			
			d.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
