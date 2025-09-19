package com.tutorialninja.qa.listnerExtendReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportManger implements ITestListener {
	
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // common info on the report
	public ExtentTest test; // creating test case entries in report with Status
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReports.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functionl Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Browser Name", "Chorme");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", "QA");
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS,"Test Case is Passed : " + result.getName());
	  }
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL,"Test Case is Failed : " + result.getName());
		test.log(Status.FAIL, "its failed because of : " + result.getThrowable());
	  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }
	

}
