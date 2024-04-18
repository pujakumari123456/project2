package com.learn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Beginner_6_Assigenment {

	public static void main(String[] args) {
		//Beginner_6_Automate_all_the_Menu_links_of_amazonin_and_Verify_page_titles
		try {
			ChromeOptions opt =new ChromeOptions();	
			 opt.addArguments("--remote-allow-origins=*");
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver(opt);
			//2.https://www.amazon.in/
			 driver.get("https://www.amazon.in/");
			//3. Maximize or set size of browser window.
			driver.manage().window().maximize();
			//4. Get Title of page and print it.
		    String Title =driver.getTitle();
			System.out.println("Title of the page is  :"+Title);
			//5. Now, click on first menu link say 'Amazon Pay' (or choose any other link from the menu list)
			WebElement m=driver.findElement(By.xpath("//a[contains(text(),'Amazon Pay on Merchants')]"));
			m.click();
			//6. Get the page title and print it.
			String title2=driver.getTitle();
			System.out.println("title2 is :" + title2);
			//7. Navigate back to Home Page.
			driver.navigate().back();
			//8. Get the page title and print it. Verify that value matches with output of point no. 4
			String actualtitle =driver.getTitle();
			//System.out.println("title3 is :"+actualtitle);
			String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			if(actualtitle.equalsIgnoreCase(expectedtitle)) {
				System.out.println("yes.....title match");
			}else {
				System.out.println("no.....title is not match");
			}
			
			//9. Repeat steps 5 to 8 for other menu links.
			

			WebElement Au=driver.findElement(By.xpath("//a[text()='About Us']"));
			Au.click();
			String Autitle=driver.getTitle();
			System.out.println("Next page AuTitle:"+Autitle);
		
			driver.navigate().back();
			String titleback=driver.getTitle();
			System.out.println("Next page Title:"+titleback);
			if(Title.equals(titleback))
			{
				System.out.println("Passed");
			}
			else
			{
				System.out.println("Failed");
			}
			
			
			//10. Close the browser.
			driver.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
