package com.learn.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Table.Cell;

public class Advance_3_Assigenment {
	WebDriver driver;
	 String url="https://www.espncricinfo.com/";
	 String  filepath="C:\\Users\\Admin\\Desktop\\Advanceass_3.xlsx";
	 String actualtext;
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Advance_3_Assigenment abc= new Advance_3_Assigenment();
	    abc.browser();
		abc.allvalues();
		abc.excelfiledataVerify(0);
		

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
	public void allvalues() throws InterruptedException {
		Actions act= new Actions(driver);
		WebElement hover=driver.findElement(By.xpath("//a[text()='IPL 2023']"));
		act.moveToElement(hover).build().perform();
		System.out.println(hover.getText());
		Thread.sleep(2000);
		
		List<String> webpageData = new ArrayList<>();
		List<WebElement> actualtext=driver.findElements(By.xpath("//div[@class='ds-px-2 ds-py-2']/ul/li[@class='ds-w-full ds-flex']"));
		
		int hoverElementsize =actualtext.size();
		System.out.println("values of Hovers \n"+hoverElementsize);
		for(int i=0;i<hoverElementsize;i++)
		{
			String data=actualtext.get(i).getText();
			System.out.println(data);
			webpageData.add(data);
		}
		
	}
	public void  excelfiledataVerify(int i) throws IOException {
		ArrayList<String>ls=new ArrayList<>();
		FileInputStream fis= new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh =wb.getSheet("Sheet1");
		Iterator<Row>row=sh.iterator();       
		//row.next();
		while(row.hasNext()) {
			
			System.out.println(row.next().getCell(0).getStringCellValue());
			
		}
		
	

		

	/*	if(ls.equals(actualtext))
		{
			System.out.println("true");
		}else
		{
			System.out.println("false");
		} */
		
		

}
	}
