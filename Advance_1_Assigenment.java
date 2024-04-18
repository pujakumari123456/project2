package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Advance_1_Assigenment {
	WebDriver driver;
    String url ="https://www.amazon.in/";
	public static void main(String[] args)  {
		Advance_1_Assigenment abc = new Advance_1_Assigenment();
		abc.browser();
		abc.productsearch();
		//abc.mousehover();

	}


public void browser() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
	ChromeOptions  opt=new ChromeOptions();
	opt.addArguments("--remote-allow-origins=*");
	driver=new ChromeDriver(opt);
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
public void productsearch() {
WebElement serchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
serchbox.sendKeys("watch");
driver.findElement(By.xpath("//span[text()='es for women']")).click();
//WebElement serch = driver.findElement(By.id("nav-search-submit-button"));
//serch.click();
	driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal']")).click();

	
	Actions act=new Actions(driver);
	WebElement mouseho =driver.findElement(By.xpath("//div[@id='averageCustomerReviews']//i[@class='a-icon a-icon-star a-star-4-5 cm-cr-review-stars-spacing-big']"));
	act.moveToElement(mouseho).build().perform();
}
public void mousehover()  {
	Actions act=new Actions(driver);
	WebElement mouseho =driver.findElement(By.xpath("//div[@id='averageCustomerReviews']//i[@class='a-icon a-icon-star a-star-4-5 cm-cr-review-stars-spacing-big']"));
	act.moveToElement(mouseho).build().perform();
}


}