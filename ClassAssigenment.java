package com.learn.selenium;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassAssigenment {

	public static void main(String[] args) {
		//allradiobuttontext();
		//textwhosetagnameislinkinFacebook();
		//select_check_box_when_it_is_not_selected();
		//Display_the_box_passvalue_hidebox_verifyhide();
		text_userinput();
		
		}
	public static void allradiobuttontext() {
		try {
		ChromeOptions opt =new ChromeOptions();	
		opt.addArguments("--remote-allow-origins=*");
	    WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver(opt);
		//Launch google web page
		d.get("https://www.letskodeit.com/practice");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List <WebElement> AllRadioButtontext =d.findElements(By.xpath("//div[@id='radio-btn-example']//fieldset//label"));
		for(int i=0;i<AllRadioButtontext.size();i++) {
			Thread.sleep(2000);
			//AllRadioButtontext.get(i).getText();
			System.out.println("all radio button text is :"+AllRadioButtontext.get(i).getText());
		/*	if(i==1) {      //breaking the loop when we want only two value.
				break;
			}*/
		}
		d.quit(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void textwhosetagnameislinkinFacebook() {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://www.facebook.com/");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//get all the text whose tagname is link 
			List<WebElement> totallinks = d.findElements(By.tagName("a"));
			int count = totallinks.size();
		    System.out.println("number of links: "+count);//number of link
			//text which has link
			for(int i=0; i<count; i++)
			{
			System.out.println(totallinks.get(i).getText());
			}
			d.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void select_check_box_when_it_is_not_selected() {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://www.letskodeit.com/practice");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement check = d.findElement(By.id("bmwcheck"));
			boolean checkstatus =check.isSelected();
			if(!(checkstatus)) {
				check.click();	
			}else {
				System.out.println("check box is selected");
				}
			d.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	public static void Display_the_box_passvalue_hidebox_verifyhide() {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://www.letskodeit.com/practice");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement ed=d.findElement(By.id("displayed-text"));

			if(ed.isDisplayed()==true)
			{
		               			
					ed.sendKeys("test");
				    WebElement hidebutton=d.findElement(By.id("hide-textbox"));
				    hidebutton.click();
					Thread.sleep(2000);
					
					if(ed.isDisplayed()==false)
					{
						System.out.println("successful");
				
					}
					
			   }
			d.close();	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//getting the text from the application by user input.
	public static void text_userinput() {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://www.letskodeit.com/practice");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Scanner s = new Scanner(System.in);
			System.out.print( "Enter Value of a :" );
			String userinput = s.next();
			WebElement RadioButtonLable =d.findElement(By.xpath("//label[text()='"+userinput+"']"));
			String textname=RadioButtonLable.getText();
			System.out.println("text of radiobutton label is :"+textname);
			
			d.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
	

