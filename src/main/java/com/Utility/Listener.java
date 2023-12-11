package com.Utility;

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
		try {
			Library.test.addScreenCaptureFromBase64String(getCapture());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		Library.test.log(Status.FAIL, "Test Case Fail");
		try {
			Library.test.addScreenCaptureFromBase64String(getCapture());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		Library.test.log(Status.SKIP, "Test Case Skip");
		
	}

	public void onFinish(ITestContext context) {
		extents.flush();
		
	}
	
	
	public static String getCapture() throws InterruptedException {
		Thread.sleep(26000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
		
	}
	
	
}


