package com.learn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Beginner_5_Assigenment {

	public static void main(String[] args) {
		//Beginner_5_Automate_all_the_Menu_links_of_techlisticcom
		try {
			ChromeOptions opt =new ChromeOptions();	
			 opt.addArguments("--remote-allow-origins=*");
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver(opt);
			//2.https://www.amazon.in/
			driver.get("https://www.techlistic.com/");
			//3. Maximize or set size of browser window.
			driver.manage().window().maximize();
			//4. Click on 'Java Tutorial' link and validate page title.
			WebElement mousehover = driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[@class='dropbtn'][normalize-space()='Development']"));
			Actions act = new Actions(driver);
			act.moveToElement(mousehover).perform();
			WebElement m=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[normalize-space()='JAVA Tutorial: A Complete Guide']"));
			m.click();
			
			String actualtitle=driver.getTitle();
			System.out.println("title is :" + actualtitle);
			String extitle="Techlistic: Java Tutorial for Beginners";
			if(actualtitle.equalsIgnoreCase(extitle)) {
				System.out.println("yes.....title match");
			}else { 
				System.out.println("no.....title is not match");
			}
			
			//5. Navigate back to Home Page.
			 driver.navigate().back();
		    //6. Click on 'Selenium Tutorial' link and validate page title.
			 WebElement mousehover2 = driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[@class='dropbtn'][normalize-space()='Automation']"));
			 Actions act2 = new Actions(driver);
			 act2.moveToElement(mousehover2).perform();
			 WebElement m2=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[normalize-space()='Selenium WebDriver with Java']"));
			 m2.click();
			 String actualtitle2=driver.getTitle();
		     System.out.println("title is :" + actualtitle2);
			 String extitle2="Techlistic: Best Selenium WebDriver Tutorial";
				if(actualtitle2.equalsIgnoreCase(extitle2)) {
					System.out.println("yes.....title2 match");
				}else { 
					System.out.println("no.....title2 is not match");
				}
			 //7. Navigate back to Home Page.
			  driver.navigate().back();
			 //8. Click on 'Selenium Blogs' link and validate page title.
			 WebElement mousehover3 = driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[normalize-space()='Blogs']"));
			 Actions act3= new Actions(driver);
			 act3.moveToElement(mousehover3).perform();
			 WebElement m3=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Selenium Automation Blogs')]"));
			 m3.click();
			 String actualtitle3=driver.getTitle();
		     System.out.println("title is :" + actualtitle3);
			 String extitle3="Techlistic: Selenium Blogs";
				if(actualtitle3.equalsIgnoreCase(extitle3)) {
					System.out.println("yes.....title3 match");
				}else { 
					System.out.println("no.....title3 is not match");
				}
				
			 
			//9. Navigate back to Home Page.
			 driver.navigate().back();
			//10. Click on 'TestNG Blogs' link and validate page title.
			 WebElement mousehover4 = driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[@class='dropbtn'][normalize-space()='Automation']"));
			 Actions act4= new Actions(driver);
			 act4.moveToElement(mousehover4).perform();
			 WebElement m4=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[normalize-space()='TestNG Tutorial']"));
			 m4.click();
			 String actualtitle4=driver.getTitle();
		     System.out.println("title is :" + actualtitle4);
			 String extitle4="Techlistic: Selenium with TestNG Framework Tutorial";
				if(actualtitle4.equalsIgnoreCase(extitle4)) {
					System.out.println("yes.....title4 match");
				}else { 
					System.out.println("no.....title4 is not match");
				}
				
			//11. Close the browser. 
			 driver.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
