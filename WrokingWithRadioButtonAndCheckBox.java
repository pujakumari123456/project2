package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingWithRadioButtonAndCheckBox {

	public static void main(String[] args) {
		try {
			ChromeOptions opt =new ChromeOptions();	
			opt.addArguments("--remote-allow-origins=*");
		    WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://www.letskodeit.com/practice");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//radio
			WebElement radio =	d.findElement(By.id("bmwradio"));
			boolean radiostatus = radio.isEnabled();
			if(radiostatus) {
				radio.click();
			}else {
				System.out.println("radio button is not enabled");
			}
			
			WebElement check = d.findElement(By.id("bmwcheck"));
			boolean checkstatus =check.isSelected();
			if(!(checkstatus)) {
				check.click();	
			}else {
				System.out.println("check box is selected");
			}
			//displayed the box
//		WebElement elementdis =d.findElement(By.id("displayed-text"));
//		boolean show =elementdis.isDisplayed();
//		if(show==true) {
//				Thread.sleep(2000);
//				elementdis.sendKeys("puja");
//				Thread.sleep(2000);
//			    WebElement button = d.findElement(By.id("hide-textbox"));
//				button.click();
//				Thread.sleep(2000);
//				if(show==false)
//				      {
//					System.out.println("successful");
//				        }
//				
//			      }
			
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
			//d.quit(if same window is open)
			d.close();
		}catch (Exception e) {
			// TODO: handle exception
		}{
			
		}

	}

}
