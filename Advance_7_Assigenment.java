package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Advance_7_Assigenment {

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
//		    4. Click On PIM Tab
		    d.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		    //5. Click On Add Employee Tab
		    d.findElement(By.xpath("//a[text()='Add Employee']")).click();
//		    6. Add The Employee
		  WebElement firstname =  d.findElement(By.name("firstName"));
		  firstname.sendKeys("anu");
		  WebElement middlename =  d.findElement(By.name("middleName"));
		  middlename.sendKeys("palli");
		  WebElement lastname =  d.findElement(By.name("lastName"));
		  lastname.sendKeys("ranjan");
		  //WebElement empId= d.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		  //empId.clear();
		 // empId.sendKeys("0270");
		  // 7.Save the employee
		 // Thread.sleep(2000);
		  WebElement savebutton =  d.findElement(By.xpath("//div[@class='oxd-form-actions']//button[@type='submit']"));
		  savebutton.click();
         //8. Search the employee
		  d.findElement(By.xpath("//a[text()='Employee List']")).click();
		  WebElement searuser =  d.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
		  searuser.sendKeys("anu palli ranjan");
		  
		  d.findElement(By.xpath("//button[@type='submit']")).click();
		  Thread.sleep(5000);
		  
		 // d.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
