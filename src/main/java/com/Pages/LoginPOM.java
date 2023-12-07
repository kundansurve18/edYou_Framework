package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPOM {

	@FindBy(how = How.XPATH,using="//input[@name='email']")
	private WebElement email;
	
	@FindBy(how = How.XPATH,using="//input[@name='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH,using="//span[@class='checkmark']")
	private WebElement checkbox;
	
	@FindBy(how = How.XPATH,using="//button[@class='btnLogin mt-1 btn-social']")
	private WebElement loginbutton;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getButton() {
		return loginbutton;
	}
	
}
