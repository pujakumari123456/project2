package com.learn.testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MultipleTestCase1 {
	
	@BeforeSuite
	public void login() {
		System.out.println("Login Successfully");
		
	}
	@Test
    public void addVender() {
    	System.out.println("Vender Added Successfully");
	}
	@Test
    public void addProduct() {
    	System.out.println("Product Added Successfully");
	}
	@Test
    public void addCustomer() {
    	System.out.println("Customer Added Successfully");
	}
	@AfterSuite
    public void logout() {
    	System.out.println("Logout Successfully");
	}
}
