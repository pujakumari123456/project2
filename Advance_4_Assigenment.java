package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Advance_4_Assigenment {
	WebDriver driver;
	String url="https://www.espncricinfo.com/";
	public static void main(String[] args) throws InterruptedException {
		
		Advance_4_Assigenment abc= new Advance_4_Assigenment();
				abc.browser();
				abc.ipl2023();
				

			}
	public void browser() {
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions  opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("disable-notifications");
		driver=new ChromeDriver(opt);
				
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		}
	public void ipl2023() throws InterruptedException {
//		2.Click On IPL2023
		WebElement ipl2023=driver.findElement(By.xpath("//a[text()='IPL 2023']"));
		ipl2023.click();
		Thread.sleep(2000);
//		3. Make sure "IPL2023" Is In Bold Letter Once Clicked
		String fontweight=driver.findElement(By.xpath("//a[text()='IPL 2023']")).getCssValue("font-weight");
		if(fontweight.contains("700")) {
			System.out.println("text is bold");
		}
		else {
		System.out.println("text is not bold");
		}
//		4. Hover On IPL2023
		Actions act= new Actions(driver);
		WebElement hover=driver.findElement(By.xpath("//a[text()='IPL 2023']"));
		act.moveToElement(hover).build().perform();
		Thread.sleep(5000);
		
//		5. Click On "Fixture and Results"
		WebElement fixresult=driver.findElement(By.xpath("//span[contains(text(),'Fixtures and Results')]"));
		Thread.sleep(5000);
		fixresult.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebElement sat1apr=driver.findElement(By.xpath("//div[normalize-space()='Sat, 01 Apr']"));
//		js.executeScript("arguments[0].scollIntoView(false)", sat1apr);
//		6. click On any Finished Match
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Punjab Kings won by 7 runs (DLS method)']")).click();
		
//		7. Verify Who Won and In How much run the team won and the difference
		
	}
	}


