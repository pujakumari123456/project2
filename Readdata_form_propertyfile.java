package com.learn.selenium;

import java.io.FileInputStream;
import java.util.Properties;

public class Readdata_form_propertyfile {
//static String filepath="C:\\Users\\Admin\\Desktop\\learn java\\LearnSelenium\\src\\com\\learn\\selenium\\readdata.properties";
	//this(2) path can work everyones system
static String filepath=System.getProperty("user.dir")+"\\src\\com\\learn\\selenium\\readdata.properties";
	public static void main(String[] args) {
		try {
			FileInputStream fis =new FileInputStream(filepath);
			Properties prop=new Properties();
			prop.load(fis);
			String value= prop.getProperty("username");
			System.out.println("value is : " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
