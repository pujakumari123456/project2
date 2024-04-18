package com.learn.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Learntextng {
@BeforeSuite
public void m1() {
		System.out.println("this is m1 method annotated with before suite");
	}
@BeforeTest
public void m3() {
		System.out.println("this is m3 method annotated with before @Test");
	}

@BeforeClass
public void m5() {
	System.out.println("this is m5 method annotated with before class");
}

@AfterClass
public void m6() {
	System.out.println("this is m6 method annotated with after class");
}
@AfterTest
public void m4() {
		System.out.println("this is m4 method annotated with after Test");
	}
@BeforeMethod
public void m7() {
	System.out.println("this is m7 method annotated with before method ");
}
@AfterMethod
public void m8() {
	System.out.println("this is m8 method annotated with after method");
}
@Test
public void ram() {
	System.out.println("this is ram method annotated with @test");
	}
@Test
public void rahul() {
	System.out.println("this is rahul method annotated with @test");
	}
@AfterSuite
public void m2() {
		System.out.println("this is m2 method annotated with after suite");
	}
}
