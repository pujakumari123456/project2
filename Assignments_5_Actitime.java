package com.learn.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignments_5_Actitime {
	WebDriver driver;
    String url="https://online.actitime.com/text1/login.do";
	public static void main(String[] args) {
		try {
			
			Assignments_5_Actitime act2 =new Assignments_5_Actitime();
			
			act2.lunchbrowser();
			act2.LoginToActitime();
			act2.deparment();

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
     public void deparment() throws InterruptedException {
    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
 		wait.until(ExpectedConditions.
 				elementToBeClickable(
 						By.xpath("//a[@class='content users'] //div[@class='label']")));
 		//Click on Users
 		WebElement users=driver.findElement(By.xpath("//a[@class='content users'] //div[@class='label']"));
		users.click();
//		Click on department
		driver.findElement(By.xpath("//div[@class='userList_manageButtons_component_manageGroupsButton']//div[@class='userList_manageButtons_component_groupItem department '][normalize-space()='Departments']")).click();
//		Count the each department number
		
		List<WebElement> departmentList=driver.findElements(By.xpath("//div[@id='groupManagementLightBox_groupContainer']//tr"));
		
			for(WebElement dept:departmentList)
			{
				String list=dept.getText();
				System.out.println(list);
			}
}
}
