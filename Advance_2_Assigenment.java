package com.learn.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Advance_2_Assigenment {
 WebDriver driver;
 String url="https://www.zomato.com/";
	public static void main(String[] args) {
		Advance_2_Assigenment abc= new Advance_2_Assigenment();
		abc.browser();
     
	}
	public void browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions  opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		2. Click On "Order Online"
		driver.findElement(By.xpath("//p[text()='Order Online']")).click();

//		3. Click On "Filters"
		driver.findElement(By.xpath("//div[text()='Filters']")).click();
//		4. Click On "Sort By"
//		5. Click On "Rating High to Low"
		driver.findElement(By.xpath("//span[text()='Rating: High to Low']")).click();
//		6. Click On Apply Button
		driver.findElement(By.xpath("//span[text()='Apply']")).click();
//		7. Verify products appeared as "High to low" rating
		List<WebElement> hightlow= driver.findElements(By.xpath("//div[@class='sc-1q7bklc-5 kHxpSk']"));
		int sz =hightlow.size();
		System.out.println(sz);
		for(int i=0;i<sz;i=i+1) {
			String ratingtext=hightlow.get(i).getText();
			System.out.println("rating of the product : "+ratingtext);
		}
	}
	


}
