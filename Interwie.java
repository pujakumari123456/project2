package com.learn.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Interwie {

	public static void main(String[] args) {
	 ChromeOptions opt =new ChromeOptions();
	 opt.addArguments("--remote-allow-origins=* ");
	 WebDriverManager.chromedriver().setup();
	 WebDriver d =new ChromeDriver(opt);
	 d.manage().window().maximize();
	 d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 d.get("https://www.amazon.in/");
	 d.findElement(By.xpath("//a[text()=' Electronics ']")).click();
	 WebElement fitnessband=d.findElement(By.xpath("//li[@id='sobe_d_b_3_2']//span[text()='Fitness trackers & smartwatches']"));
	 String Acttext =fitnessband.getText();
	        
	 System.out.println(Acttext);
	 String Expecttext="Fitness trackers & smartwatches";
	 Assert.assertEquals(Expecttext, Acttext,"both the donttext machted");
	 d.close();

	}

}
