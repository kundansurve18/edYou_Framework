package com.Utility;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Library {
	
	public static ExtentTest test;
	
	public static void custom_sendkeys(WebElement element, String value) {
		
		try {
			element.sendKeys(value);
			test.log(Status.PASS, "Value successfully send = "+value);
		}catch (Exception e) {
		//	test.log(Status.FAIL, e.getMessage());
		}
		
	}
	
	public static void custom_click(WebElement element) {
		
		try {
			element.click();
			test.log(Status.PASS, "Clicked successfully");
		}catch (Exception e) {
			//test.log(Status.FAIL, e.getMessage());
		}
		
	}

}
