package com.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.LoginPOM;
import com.Utility.BaseClass;
import com.Utility.Library;

public class TestCase_1 extends BaseClass{

	@Test
	public void verify_login() {
		
		LoginPOM login = PageFactory.initElements(driver , LoginPOM.class);
		
		Library.custom_sendkeys(login.getEmail(), "testalli@yopmail.com");
		Library.custom_sendkeys(login.getPassword(), "12345678");
		Library.custom_click(login.getCheckbox());
		Library.custom_click(login.getButton());
		
		
		
	}
	
}
