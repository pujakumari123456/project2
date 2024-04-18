package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignments_2_Actitime {
	WebDriver driver;
    String url="https://online.actitime.com/text1/login.do";
	public static void main(String[] args) {
		try {
			
			Assignments_2_Actitime act2 =new Assignments_2_Actitime();
			
			act2.lunchbrowser();
			act2.LoginToActitime();
			act2.createuser();

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


//           4. Click On USer Tab			
 			WebElement users=driver.findElement(By.xpath("//a[@class='content users'] //div[@class='label']"));
 			users.click();
//           5. Click On New User	
 			WebElement Newusers=driver.findElement(By.xpath("//div[contains(text(),'New User')]"));
 			Newusers.click();
 			
// 			Create the User with any department and verify all permission is enabled
//           6. Create the User
 			Thread.sleep(2000);
 			WebElement firstname=driver.findElement(By.xpath("//input[@id='createUserPanel_firstNameField']"));				
 			
 			firstname.sendKeys("MyName");
 			WebElement lastname=driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']"));				
 			lastname.sendKeys("Is Puja");
// 			7. Fill The Email ID
 			WebElement email=driver.findElement(By.xpath("//input[@id='createUserPanel_emailField']"));				
 			email.sendKeys("mynameispuja@gmail.com");
 			WebElement dept=driver.findElement(By.xpath("//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']"));
 			dept.click();
 			WebElement hrDept=driver.findElement(By.xpath("//div[@class='item'][normalize-space()='HR & Finance']"));
 			hrDept.click();
 			driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
 			Thread.sleep(2000);
 			driver.findElement(By.xpath("//div[@class='createUserPanel_accountCreatedContainer']//span[text()='Close']")).click();
 			driver.findElement(By.xpath("//tr[@class='userListRow accountPermission settingsPermission last newUser first']//div[@class='icon manageUsers']")).click();
 			Thread.sleep(2000);
 			WebElement permis=driver.findElement(By.xpath("//div[@id='editUserPanel']//div[@class='teamScopeCellContainer']//div[@class='userPanelScopeCell all disabled']"));
 			String permistext=permis.getText();
 			//System.out.println("text of permission"+permistext);
 			if(permistext.equalsIgnoreCase("All users")) {
 				System.out.println("all permission are enable for : "+permistext );
 			}else {
 				System.out.println("permission is disable for user");
 			}
 			
 			driver.close();
    	 
     }
}
