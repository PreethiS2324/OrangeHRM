package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlreport;
	ExtentReports report;
	ExtentTest test;

	private WebDriver driver;

    public ITestListenerClass(WebDriver driver) {
        this.driver = driver;
    }
	@Override
	public void onStart(ITestContext context)
	{
		htmlreport = new ExtentSparkReporter(".\\test-output\\extentReport.html");
		htmlreport.config().setDocumentTitle("OrangeHRM Automation Testing");
		htmlreport.config().setReportName("OrangeHRM");
		htmlreport.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Operating system", System.getProperty("os.name"));
		report.setSystemInfo("Test Environment", "QA");
		report.setSystemInfo("Reporter Name", "Preethi");
	}
	
	 @Override
	    public void onTestStart(ITestResult result) {
		 
		 String methodName = result.getMethod().getMethodName();
		 test = report.createTest(methodName);
		 Reporter.log(methodName+"--Execution Started ",true);
	     System.out.println("Test started: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	 String methodName = result.getMethod().getMethodName();
	    	 test.log(Status.PASS, methodName+" Passed");
	    	 Reporter.log(methodName+"-- Execution Successfull",true);
	    	
	        System.out.println("Test passed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	String methodName = result.getMethod().getMethodName();
	    	try
	    	{
	    		String path = WebDriverUtils.takescreenshot(driver, methodName);
	    		test.addScreenCaptureFromPath(path);
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	test.log(Status.FAIL, methodName+ ": Failed");
	    	test.log(Status.FAIL, result.getThrowable());
	    	Reporter.log(methodName+ "--- Execution Failed");
	        System.out.println("Test failed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	       
	    	String methodName = result.getMethod().getMethodName();
	    	test.log(Status.SKIP, methodName + " Skipped");
	    	test.log(Status.SKIP, result.getThrowable());
	    	Reporter.log(methodName + " Execution Skipped");
	    	System.out.println("Test skipped: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	report.flush(); //ensures that the data is actually written to the designated file.
	    }
}
