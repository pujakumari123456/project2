package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignments_3_Actitime {
WebDriver driver;
String url ="https://online.actitime.com/text1/login.do";

	public static void main(String[] args) {
		try {
			Assignments_3_Actitime act3=new Assignments_3_Actitime();
			act3.lunchbrowser();
			act3.LoginToActitime();
			act3.permissionuncheck();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
   public void LoginToActitime() throws InterruptedException{
	   WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("pujakumaripihu1995@gmail.com");
		
		WebElement password=driver.findElement(By.name("pwd"));
		password.sendKeys("Text@123");
		
		WebElement button=driver.findElement(By.xpath("//div[text()='Login ']"));
		button.click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	 		wait.until(ExpectedConditions.
	 				elementToBeClickable(
	 						By.xpath("//a[@class='content users'] //div[@class='label']")));

   }
   
   public void permissionuncheck() throws InterruptedException {
      WebElement users=driver.findElement(By.xpath("//a[@class='content users'] //div[@class='label']"));
	  users.click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[@id='userListTableContainer']/div/table[1]/tbody/tr[1]/td[1]")).click();
	  Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@class='permissionsTab']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@class='userPanel_permissionRow active']//div[@class='name'][normalize-space()='Modify & Approve Users Time-Track']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@class='userPanel_permissionRow active']//div[normalize-space()='Manage Scope of Work']")).click();
      //Thread.sleep(2000);
     WebElement close= driver.findElement(By.xpath("//div[@class='edit_user_sliding_panel sliding_panel components_panelContainer']//div[@class='hideButton_panelContainer']"));
     close.click();
     //Thread.sleep(2000);
     driver.close();
     
   }
}
