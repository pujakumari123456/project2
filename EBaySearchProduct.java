package com.learn.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EBaySearchProduct {
	WebDriver driver;
	String url = "https://www.ebay.com/";
	public static void main(String[] args) {
		try {
			

			EBaySearchProduct ebay=new EBaySearchProduct();
			ebay.invokeBrowser();
			
//			Click the Search button.
//			Write a method to print the result of the product.
			ebay.searchProduct("Apple watch", "Consumer Electronics");
//			Write a method to print Nth product say 10th Product. (This should be a generic method)
			ebay.getNthProduct(10);
//			Write a method to print all products from 1st page.
			ebay.getAllProducts();
//			Write a method to print all products along with scroll down.
			ebay.getAllProductsViaScrollDown();
			//ebay.getAllProductsViaScrollDownViaJS();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
	
	public void invokeBrowser(){
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
    	ChromeOptions  opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		
		
	}
	
	public void searchProduct(String product, String category){
		
		driver.findElement(By.id("gh-ac")).sendKeys(product);
		
		WebElement dropdown = driver.findElement(By.id("gh-cat"));
		Select selectCategory = new Select(dropdown);
		
		selectCategory.selectByVisibleText(category);
		
		driver.findElement(By.id("gh-btn")).click();
		
		String result = driver.findElement(By.xpath("//h1[contains(text(),' results for ')]")).getText();
		
		System.out.println("Result :: "+ result);
	}
	
	public void getNthProduct(int itemNumber){
		String productXpath = String.format("//div[@id='srp-river-main']/div/ul/li[%d]", itemNumber);
		
		String nthProduct = driver.findElement(By.xpath(productXpath)).getText();
		
		System.out.println("Nth Product :: "+ nthProduct);
	}
	
	public void getAllProducts(){
	List<WebElement> allProduct = driver.findElements(By.xpath("//div[@id='srp-river-main']/div/ul/li"));
	
	for(WebElement product: allProduct){
		System.out.println(product.getText());
		
		System.out.println("-----------------------------------------");
	}
	}
	
	public void getAllProductsViaScrollDown(){
	 List<WebElement> allProduct = driver.findElements(By.xpath("//div[@id='srp-river-main']/div/ul/li"));
		Actions action = new Actions(driver);
		
		for(WebElement product: allProduct){
			
			action.moveToElement(product).build().perform();
			
			System.out.println(product.getText());
			
			System.out.println("-----------------------------------------");
		}
		}
	}