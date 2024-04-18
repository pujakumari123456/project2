package com.learn.testNG;

import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test(priority=1)
	public void login() {
		System.out.println("Login Successfully");
		
	}
	@Test(dependsOnMethods= {"login"})
    public void addVender() {
    	System.out.println("Vender Added Successfully");
	}
	@Test(dependsOnMethods= {"addVender"},alwaysRun= true)//if addvender test is fail also it be run because of alwaysRun= true
    public void addProduct() {
    	System.out.println("Product Added Successfully");
	}
	@Test(dependsOnMethods= {"addProduct"})
    public void addCustomer() {
    	System.out.println("Customer Added Successfully");
	}
	@Test(dependsOnMethods= {"addCustomer"})
    public void logout() {
    	System.out.println("Logout Successfully");
	}
}
