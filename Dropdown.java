package com.learn.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--remote-allow-origins=* ");
		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver(opt);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("");
		
		
	}

}
