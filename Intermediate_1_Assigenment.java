package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Intermediate_1_Assigenment {

	public static void main(String[] args) {
		try {
			    ChromeOptions opt =new ChromeOptions();	
			    opt.addArguments("--remote-allow-origins=*");
			    WebDriverManager.chromedriver().setup();
				WebDriver d = new ChromeDriver(opt);
				//Launch google web page
				d.get("https://ui.cogmento.com/");
				d.manage().window().maximize();
				d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				//login code
			    WebElement  email= d.findElement(By.name("email"));
			    email.sendKeys("pihupujakumari08@gmail.com");
			    Thread.sleep(2000);
				WebElement password = d.findElement(By.name("password"));
				password.sendKeys("Pihu@kumari");
				Thread.sleep(2000);
				WebElement button = d.findElement(By.xpath("//div[text()='Login']"));
				button.click();
				Thread.sleep(2000);
//				4. Click on Side menu "contacts"
				d.findElement(By.xpath("//span[normalize-space()='Contacts']")).click();
//				5. Click On Create button
				d.findElement(By.xpath("//button[normalize-space()='Create']")).click();
				
//				6. Enter mandatory fields 
				WebElement firstname=d.findElement(By.name("first_name"));
				firstname.sendKeys("viju");
				WebElement lastname=d.findElement(By.name("last_name"));
				lastname.sendKeys("reddy");
//				7. click on save button and verify user got created
				d.findElement(By.xpath("//button[text()='Save']")).click();
				String veri=d.findElement(By.xpath("//span[text()='viju reddy']")).getText();
				if(veri.contains("viju reddy")) {
					System.out.println("user got created : "+veri);
				}else {
					System.out.println("user got not created : ");
				}
				d.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
