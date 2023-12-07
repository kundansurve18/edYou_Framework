package com.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportGenerator {
	
	public static ExtentReports getReports() {
		
		String filepath = "D:\\vDoit Technologies\\edYou\\Automation\\Edyou_Framework\\Reports";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(filepath);
		reporter.config().setDocumentTitle("Automation Test Report");
		reporter.config().setReportName("edYou Test Report");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Project Name", "edYou");
		extent.setSystemInfo("Module Name", "Login Page");
		extent.setSystemInfo("Automation Tool", "Selenium with JAVA");
		extent.setSystemInfo("QA", "Kundan Surve");
		return extent;
	}

}
