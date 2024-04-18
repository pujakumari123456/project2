package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Advance_6_Assigenment {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
		    opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//2.Login To application
		    WebElement  username= d.findElement(By.name("username"));
		    username.sendKeys("Admin");
		    //Thread.sleep(2000);
			WebElement password = d.findElement(By.name("password"));
			password.sendKeys("admin123");
			//Thread.sleep(2000);
			WebElement button = d.findElement(By.xpath("//button[@type='submit']"));
			button.click();
			//Thread.sleep(2000);
			//3. Verify Dashboard Page Opened
		    String curl=d.getCurrentUrl();
		    System.out.println(curl);
		    if(curl.contains("dashboard")) {
			System.out.println("yes......loged in succesfully");
			}else {
				System.out.println("logged in falied");
			}
          //4. Click On Admin Tab
		   WebElement admin = d.findElement(By.xpath("//span[text()='Admin']"));
		   admin.click();
		   //5. Search User with Existing User
		   WebElement userser = d.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
		   userser.sendKeys("Ehioze.Ebo");
		   Thread.sleep(3000);
		   
		   WebElement searchbutton = d.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
		   searchbutton.click();
		   WebElement recordfound = d.findElement(By.xpath("//span[text()='(1) Record Found']"));
		    String Rf= recordfound.getText();
		    if(Rf.equals("(1) Record Found")) {
		    	System.out.println("one record found and user is existing : "+ Rf);
		    	
		    	}else {
		    		System.out.println("user is not existing");
		    	}
		   //d.close();
		   
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
