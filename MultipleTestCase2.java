package com.learn.testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MultipleTestCase2 {
	
	
	@Test
    public void deleteVender() {
    	System.out.println("Vender Delete Successfully");
	}
	@Test
    public void deleteProduct() {
    	System.out.println("Product Delete Successfully");
	}
	@Test
    public void deleteCustomer() {
    	System.out.println("Customer Delete Successfully");
	}
	
}
