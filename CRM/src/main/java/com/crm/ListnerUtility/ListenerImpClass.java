package com.crm.ListnerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseTest.BaseClass;
import com.crm.generic.UtilityClassObject.UtilityClassObject;

public class ListenerImpClass implements ISuiteListener, ITestListener
{
	public ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		String time = new Date().toString().replace("", "").replace(":", "");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Add env information & create test
	    report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("result.getMethod().getMethodName()+ START");
	    test = report.createTest(result.getMethod().getMethodName());
	    UtilityClassObject.setTest(test);
	    test.log(Status.INFO, result.getMethod().getMethodName()+"STARTED");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("result.getMethod().getMethodName()+ END");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"COMPLETED");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		//String time = new Date().toString().replace("", "").replace(":", "");
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace("", "").replace(":", "");
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"FAILED");
	}
}
