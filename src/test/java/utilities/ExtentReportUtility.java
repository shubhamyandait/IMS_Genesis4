package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


import drivers.DriverFactory;

public class ExtentReportUtility implements ITestListener{

	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	String repName;
	String repPath;
	public void onStart(ITestContext context) {
		
		String timestamps = new JavaUtility().currentTimeStamps();
		repName = "Test-Report-"+ timestamps +".html"; 
		repPath = ConfigReader.getReportPath()+repName;
		
		//set the template the report
		sparkReporter = new ExtentSparkReporter(repPath); //specify the report location
		sparkReporter.config().setDocumentTitle("Genesis Automation Report"); //report title
		sparkReporter.config().setReportName("Functional Testing"); //name of report
		sparkReporter.config().setTheme(Theme.STANDARD); //theme of report (STANDARD/DARK)
		
		//add common info to report
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "Genesis");
		extent.setSystemInfo("Module", "People");
		extent.setSystemInfo("Sub-Module ", "Supplier");
		extent.setSystemInfo("User", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		//get os and browser name
		String os = context.getCurrentXmlTest().getParameter("os");
		String br = context.getCurrentXmlTest().getParameter("browser");
		
		extent.setSystemInfo("Operating system", os);
		extent.setSystemInfo("Browser", br);
		
		//get the group name
		List<String> includeGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includeGroups.toString());
		}
	}
	
	public void onTestStart(ITestResult result) {
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"got successfully executed");
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgpath = new ScreenshotUtility().captureScreenshot(DriverFactory.getDriver(),result.getName());
			test.addScreenCaptureFromPath(imgpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
}
