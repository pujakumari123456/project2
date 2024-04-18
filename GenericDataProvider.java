package com.learn.testNG;

import org.testng.annotations.DataProvider;

public class GenericDataProvider {
	@DataProvider
	public  Object[][] orangeHRMData() {
		  Object[][] obj =new Object[3][2];
		  obj[0][0]="LG";
		  obj[0][1]="LG1";
		  obj[1][0]="Nokia";
		  obj[1][1]="Nokia1";
		  obj[2][0]="Admin";
		  obj[2][1]="admin123";
		  return obj;
		
	}
	@DataProvider
	public Object[][] ActitimeData() {
		Object[][] obj =new Object[3][2];
		  obj[0][0]="LG";
		  obj[0][1]="LG1";
		  obj[1][0]="Nokia";
		  obj[1][1]="Nokia1";
		  obj[2][0]="pujakumaripihu1995@gmail.com";
		  obj[2][1]="Text@123";
		  return obj;
		
	}

}
