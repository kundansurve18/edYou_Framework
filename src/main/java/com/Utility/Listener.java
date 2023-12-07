package com.Utility;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseClass implements ITestListener {

	ExtentReports extents = ExtendReportGenerator.getReports();
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		Library.test = extents.createTest(result.getTestClass().getName()+">>"+result.getMethod().getMethodName());
		extenttest.set(Library.test);
		
	}

	public void onTestSuccess(ITestResult result) {
		Library.test.log(Status.PASS, "Test Case Pass");
		Library.test.addScreenCaptureFromBase64String(getCapture());
		
	}

	public void onTestFailure(ITestResult result) {
		Library.test.log(Status.FAIL, "Test Case Fail");
		Library.test.addScreenCaptureFromBase64String(getCapture());
		
	}

	public void onTestSkipped(ITestResult result) {
		Library.test.log(Status.SKIP, "Test Case Skip");
		
	}

	public void onFinish(ITestContext context) {
		extents.flush();
		
	}
	
	public static String getCapture() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
		
	}
	
	public static String generateDynamicReportName() {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	        Date currentDate = new Date(0);
	        String timestamp = dateFormat.format(currentDate);
	        String filename = "report_" + timestamp + ".html";
	        System.out.println("Dynamic Report Filename: " + filename);
			return filename;
    }

}
