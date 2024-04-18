package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Assignment_drag_and_drop {

	public static void main(String[] args) {
		try {
			ChromeOptions  opt=new ChromeOptions();
			
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver(opt);
			driver.get("https://jqueryui.com/droppable/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//			Consider “Drag me to my target” as a source and “Drop here” as a target.
			
			//driver.switchTo().defaultContent();
			WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
			driver.switchTo().frame(frame);
			WebElement from =driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement to =driver.findElement(By.xpath("//div[@id='droppable']"));
			
//			Write a code to perform drag and drop operation from source to target.
			Actions act = new Actions(driver);
			String colorbeforedrop=to.getCssValue("color");
			//String beforedroped=to.getText();
			//act.moveToElement(from).clickAndHold().moveToElement(to).build().perform();
			
			Thread.sleep(2000);
//			Drag and Drop operation
			act.dragAndDrop(from, to).build().perform();
			String colorafterdrop=to.getCssValue("color");
			
			System.out.println("color before drag and drop :"+colorbeforedrop);
			System.out.println("color after drag and drop :"+colorafterdrop);
            //validating the text change
			String afterdroped=to.getText();
			//Assert.assertEquals(colorbeforedrop, colorafterdrop);
			//Assert.assertEquals(beforedroped, afterdroped);
			
			if(afterdroped.equals("Dropped!")) {
				
				System.out.println("Pass : source has droped to target place as expected and text got changed");
			}else {
				System.out.println("fail : source has not met to target as expected");
			}
			

//
//			After drag and drop verify the operation is successfully by checking the color property of CSS and also verify text change. (Use assert statement to verify that color and text are as expected.)

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
}
