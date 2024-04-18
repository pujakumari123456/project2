package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignments_4_Actitime {
        WebDriver driver;
	    String url="https://online.actitime.com/text1/login.do";
		public static void main(String[] args) {
			try {
				
				Assignments_4_Actitime act2 =new Assignments_4_Actitime();
				
				act2.lunchbrowser();
				act2.LoginToActitime();
				act2.createuser();

				} catch (Exception e) {
				e.printStackTrace();
			}

		}
	     public void lunchbrowser() {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
	     	ChromeOptions  opt=new ChromeOptions();
	 		opt.addArguments("--remote-allow-origins=*");
	 		driver=new ChromeDriver(opt);
	 		
	 		driver.get(url);
	 		driver.manage().window().maximize();
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     }
	     public void LoginToActitime() throws InterruptedException {
	    	 WebElement username=driver.findElement(By.name("username"));
				username.sendKeys("pujakumaripihu1995@gmail.com");
				
				WebElement password=driver.findElement(By.name("pwd"));
				password.sendKeys("Text@123");
				
				WebElement button=driver.findElement(By.xpath("//div[text()='Login ']"));
				button.click();
				//3. Verify Dashboard Page Opened	
				Thread.sleep(3000);
				
				String curUrl=driver.getCurrentUrl();
				if(curUrl.contains("timetrack"))
				{
					System.out.println("Logged in successfully");
				}
				else
				{
					System.out.println("Login failed");
				}
				
	    	 
	     }
	     public void createuser() throws InterruptedException {
	    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	 		wait.until(ExpectedConditions.
	 				elementToBeClickable(
	 						By.xpath("//a[@class='content users'] //div[@class='label']")));
	 		//Click on Users
	 		WebElement users=driver.findElement(By.xpath("//a[@class='content users'] //div[@class='label']"));
 			users.click();
            // click on created user
             driver.findElement(By.xpath("//span[text()='asdf, qwer']")).click();
          //assign department
             WebElement dept=driver.findElement(By.xpath("//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']"));
  			 dept.click();
  			 driver.findElement(By.xpath("//div[@class='item'][normalize-space()='Production']")).click();

}
	     }