package com.learn.selenium;



import com.github.javafaker.Faker;

public class GenerateDynamicData {

	public static void main(String[] args) {
		Faker faker =new Faker();
		try {
		String colorname =faker.color().name();
		System.out.println(colorname);
	    String cityname=faker.address().cityName();		
	    System.out.println(cityname);
		String artistname=faker.artist().name();
		System.out.println(artistname);
		int num=faker.number().numberBetween(100, 500);
		System.out.println(num);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
