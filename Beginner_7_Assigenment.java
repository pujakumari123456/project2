package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Beginner_7_Assigenment {

	public static void main(String[] args) {
		//Beginner_7_Verify_Radiobutton_checkboxes_textbox_is_enabled_selected_and_displayed_or_not_respectively
		try {
			 ChromeOptions opt =new ChromeOptions();	
			 opt.addArguments("--remote-allow-origins=*");
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver(opt);
			//2.https://www.amazon.in/
			 driver.get("https://www.letskodeit.com/practice");
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			 
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
				}
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
	
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
