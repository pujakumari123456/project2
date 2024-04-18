package com.learn.selenium;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;


public class Beginner_Assigenment {

	public static void main(String[] args) {
		try {
			
			//Beginner_1_OpenGodaddycomandmaximizebrowserwindow();
			//Beginner_2_OpenGodaddycomandPrintitsPagetitle();
			//Beginner_3_OpenGodaddycomandValidatePageTitle();
			//Beginner_4_Automate_first_Menu_link_of_amazonin_and_print_page_title();
			Beginner_5_Automate_all_the_Menu_links_of_techlisticcom();
			//Beginner_6_Automate_all_the_Menu_links_of_amazonin_and_Verify_page_titles();
			//Beginner_7_Verify_Radiobutton_checkboxes_textbox_is_enabled_selected_and_displayed_or_not_respectively();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void Beginner_1_OpenGodaddycomandmaximizebrowserwindow() {
		// 1.Launch browser of your choice say., Firefox, chrome etc. 
		 ChromeOptions opt =new ChromeOptions();	
		 opt.addArguments("--remote-allow-origins=*");
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver(opt);
		//2.https://www.godaddy.com/en-in
		driver.get("https://www.godaddy.com/en-in");
		//3. Maximize or set size of browser window.
		driver.manage().window().maximize();
		//4. Close browser.
		driver.close();
		
	}
	public static void Beginner_2_OpenGodaddycomandPrintitsPagetitle() {
		// 1.Launch browser of your choice say., Firefox, chrome etc. 
				 ChromeOptions opt =new ChromeOptions();	
				 opt.addArguments("--remote-allow-origins=*");
				 WebDriverManager.chromedriver().setup();
				 WebDriver driver = new ChromeDriver(opt);
				//2.https://www.godaddy.com/en-in
				driver.get("https://www.godaddy.com/en-in");
				//3. Maximize or set size of browser window.
				driver.manage().window().maximize();
				//get title of page and print it
				String Title =driver.getTitle();
				System.out.println("Title of the page is  :"+Title);
				//get URl of current page and print it
				String curl=driver.getCurrentUrl();
				System.out.println("current url page is :"+curl);
				//6. Close browser.
				driver.close();
		
	}
	public static void Beginner_3_OpenGodaddycomandValidatePageTitle() {
		// 1.Launch browser of your choice say., Firefox, chrome etc. 
			   ChromeOptions opt =new ChromeOptions();	
				 opt.addArguments("--remote-allow-origins=*");
				 WebDriverManager.chromedriver().setup();
				 WebDriver driver = new ChromeDriver(opt);
				//2.https://www.godaddy.com/en-in
				driver.get("https://www.godaddy.com/en-in");
				//3. Maximize or set size of browser window.
				driver.manage().window().maximize();
				//4. Get Title of page and validate it with expected value.
			    String Title =driver.getTitle();
				System.out.println("Title of the page is  :"+Title);
				String expectedTitle ="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
				if(Title.equalsIgnoreCase(expectedTitle)){
					System.out.println("Title Matched");
				}else {
					System.out.println("Title didn't match");
				}
				//5. Get URL of current page and validate it with expected value.
		        String curl=driver.getCurrentUrl();
				System.out.println("current url page is :"+curl);
				String expectedcurl ="https://www.godaddy.com/en-in";
				//Assert.assertequals(curl, "https://www.godaddy.com/en-in" ); // for adject value match
				//assert.assertTrue(curl.contains("https://www.godaddy.com/en-in"))// for ture value 
				                      //or
				if(curl.equalsIgnoreCase(expectedcurl)){
					System.out.println("current url is Matched");
				}else {
					System.out.println("current url is not match");
				}
				
				//6.Get Page source of web page.
				//7. And Validate that page title is present in page source.
				String pagesource=driver.getPageSource();
				System.out.println("pagesource is : "+pagesource);
			//	Assert.assertTrue(pagesource.contains(Title));
			/*	if(pagesource.equalsIgnoreCase("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN"))
				{
					System.out.println("yes......title is present in page source");
					}else {
						System.out.println("no.....title is present in page source");
					}*/
				    
				//6. Close browser.
				driver.close();
		
	}
	public static void Beginner_4_Automate_first_Menu_link_of_amazonin_and_print_page_title() {
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
		//9. Close the browser.
		driver.close();
	}
	public static void Beginner_5_Automate_all_the_Menu_links_of_techlisticcom() {
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
		String extitle=driver.getTitle();
		System.out.println("title is :" + extitle);
		String actualtitle="Techlistic: Java Tutorial for Beginners";
		if(actualtitle.equalsIgnoreCase(extitle))
			System.out.println("yes.....title match");
		else 
			System.out.println("no.....title is not match");
		//5. Navigate back to Home Page.
		 driver.navigate().back();
		//6. Click on 'Selenium Tutorial' link and validate page title.
		 WebElement mousehover2 = driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[@class='dropbtn'][normalize-space()='Automation']"));
		 Actions act2 = new Actions(driver);
		 act.moveToElement(mousehover).perform();
		 WebElement m2=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[normalize-space()='Selenium WebDriver with Java']"));
		 m2.click();
		 String title2=driver.getTitle();
		 System.out.println("title is :" + title2);
			/*String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			if(title.equalsIgnoreCase(expectedtitle)) {
				System.out.println("yes.....title match");
			}else {
				System.out.println("no.....title is not match");
			}*/
			
		//7. Navigate back to Home Page.
		 driver.navigate().back();
		//8. Click on 'Selenium Blogs' link and validate page title.
		 WebElement mousehover3 = driver.findElement(By.xpath(""));
		 Actions act3= new Actions(driver);
		 act.moveToElement(mousehover).perform();
		 WebElement m3=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[normalize-space()='JAVA Tutorial: A Complete Guide']"));
		 m.click();
		 String title3=driver.getTitle();
		 System.out.println("title is :" + title3);
		 /*String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			if(title.equalsIgnoreCase(expectedtitle)) {
				System.out.println("yes.....title match");
			}else {
				System.out.println("no.....title is not match");
			}*/
			
		 
		//9. Navigate back to Home Page.
		 driver.navigate().back();
		//10. Click on 'TestNG Blogs' link and validate page title.
		 WebElement mousehover4 = driver.findElement(By.xpath(""));
		 Actions act4= new Actions(driver);
		 act.moveToElement(mousehover).perform();
		 WebElement m4=driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[normalize-space()='JAVA Tutorial: A Complete Guide']"));
		 m.click();
		 String title4=driver.getTitle();
		 System.out.println("title is :" + title4);
		 /*String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			if(title.equalsIgnoreCase(expectedtitle)) {
				System.out.println("yes.....title match");
			}else {
				System.out.println("no.....title is not match");
			}*/
			
		//11. Close the browser. 
		 driver.close();
	}
	public static void Beginner_6_Automate_all_the_Menu_links_of_amazonin_and_Verify_page_titles() {
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
	}
	public static void Beginner_7_Verify_Radiobutton_checkboxes_textbox_is_enabled_selected_and_displayed_or_not_respectively() {
		 ChromeOptions opt =new ChromeOptions();	
		 opt.addArguments("--remote-allow-origins=*");
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver(opt);
		//2.https://www.amazon.in/
		 driver.get("https://www.letskodeit.com/");
		 
		//3.verify radiobutton is enabled or not, if enabled click it
		 WebElement radio =	driver.findElement(By.id("bmwradio"));
	     boolean radiostatus = radio.isEnabled();
		 if(radiostatus) {
				radio.click();
			}else {
				System.out.println("radio button is not enabled");
			}
		 
		//4.verify checkbox is selected or not, if not selected, click it
		 WebElement check = driver.findElement(By.id("bmwcheck"));
			boolean checkstatus =check.isSelected();
			if(!(checkstatus)) {
				check.click();	
			}else {
				System.out.println("check box is selected");
		//5.Verify textbox is displayed or not, if displayed then enter the data , click on hide buton and verify textbox got hidden
				WebElement Elementdis =driver.findElement(By.id("displayed-text"));

				if(Elementdis.isDisplayed()==true)
				{
			               			
					    Elementdis.sendKeys("test");
					    WebElement hidebutton=driver.findElement(By.id("hide-textbox"));
					    hidebutton.click();
						
						
						if(Elementdis.isDisplayed()==false)
						{
							System.out.println("successful");
					
						}
						
				   }
					
					driver.close();
	}
}
}