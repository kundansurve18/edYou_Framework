package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ExtentReports extent = ExtendReportGenerator.getReports();
    public ExtentTest test;

	
	public static WebDriver driver;
	
	@BeforeMethod
	public void open() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("use-fake-ui-for-media-stream");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://devappsite.edyou.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void close() throws Exception {
		
		//driver.close();
		
		/*EmailUtils emailutils = new EmailUtils();
		Properties prop = new Properties();
		prop.load(new FileInputStream("D:\\vDoit Technologies\\edYou\\Automation\\Edyou_Framework\\Config\\Config.Properties"));
		List <String> attachments = new ArrayList<String>();
		attachments.add("D:\\vDoit Technologies\\edYou\\Automation\\Edyou_Framework\\test-output\\emailable-report.html");
		emailutils.sendUsingGmail(prop, "Test Execution Report", "Hi Team, Please find the attach test execution report.", attachments);*/
		
	}
}


