package com.learn.testNG;

import org.testng.annotations.Test;

public class SkippingATestCase {
	@Test(priority=1)
	public void login() {
		System.out.println("Login Successfully");
		
	}
	@Test(priority=3)
    public void addVender() {
    	System.out.println("Vender Added Successfully");
	}
	@Test(enabled=false)
    public void addProduct() {
    	System.out.println("Product Added Successfully");
	}
	@Test(priority=2)
    public void addCustomer() {
    	System.out.println("Customer Added Successfully");
	}
	@Test(priority=5)
    public void logout() {
    	System.out.println("Logout Successfully");
	}
}
