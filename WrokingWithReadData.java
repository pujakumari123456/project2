package com.learn.selenium;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrokingWithReadData {
static String filepath="C:\\Users\\Admin\\Desktop\\readdata.xlsx";

public void login() throws InterruptedException {
	   ArrayList<String> usrnm = readdata(0);
	   ArrayList<String> pswd = readdata(1);
	   
	   for(int i=0;i<usrnm.size();i++) {
		   ChromeOptions opt =new ChromeOptions();	
		   opt.addArguments("--remote-allow-origins=*");
		   WebDriverManager.chromedriver().setup();
			WebDriver d = new ChromeDriver(opt);
			//Launch google web page
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			//login code
		    WebElement  username= d.findElement(By.name("username"));
		    username.sendKeys(usrnm.get(i));
		    //Thread.sleep(2000);
			WebElement password = d.findElement(By.name("password"));
			password.sendKeys(pswd.get(i));
			//Thread.sleep(2000);
			WebElement button = d.findElement(By.xpath("//button[@type='submit']"));
			button.click();
			
			Thread.sleep(2000);
			
			d.close();
	   }
	   
}
	public static ArrayList<String> readdata(int i) {
		ArrayList<String>ls=new ArrayList<>();
		try {
			//raed the data from excel
			FileInputStream fis= new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh =wb.getSheet("Sheet1");
			Iterator<Row>row=sh.iterator();
			row.next();
			while(row.hasNext()) {
				ls.add(row.next().getCell(i).getStringCellValue());
				//System.out.println("************************");
				//System.out.println(row.next().getCell(1).getStringCellValue());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return ls;
	}
 public static void main(String[] args) throws InterruptedException {
	 WrokingWithReadData wrd= new WrokingWithReadData();
	 wrd.login();
	 
 }
}
