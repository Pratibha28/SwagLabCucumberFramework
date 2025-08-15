package utils;

	import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseclass.BaseClass;
import pojo.BugDetails;

public class CustomListener implements ITestListener  {
	 private static ExtentReports extent = ExtentReportManager.getExtentReports();
	    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();
	    
	    
	    private Map<String, BugDetails	> bugDetailsMap;
	 // No-arg constructor (implicit if no other constructors)
	    public CustomListener() {
	    }
	    // Constructor or setter to inject bug details map
	    public CustomListener(Map<String, BugDetails> bugDetailsMap) {
	        this.bugDetailsMap = bugDetailsMap;
	    }

	    
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("start test");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testReport.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("test pass");
	testReport.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest test = testReport.get(); // Use same test instance

        String testName = result.getMethod().getMethodName();
        String exceptionMessage = result.getThrowable() != null
                ? result.getThrowable().toString()
                : "No exception details available";
        // Get values from Hook
        String severity = TestContextSetup.getSeverity();
        //String bugIdFromTag = TestContextSetup.getBugId();

        BugDetails bug = new BugDetails();
        bug.setBugId("AUTO-" + System.currentTimeMillis());
        bug.setSummary("Automation failure in test: " + testName);
        bug.setSteps("1. Execute test: " + testName + "\n"
                   + "2. Environment: " + System.getProperty("env", "default") + "\n"
                   + "3. Severity: " + severity + "\n"
                   + "4. Observed failure: " + exceptionMessage);

        test.log(Status.FAIL, "Bug ID: " + bug.getBugId());
        test.log(Status.FAIL, "Summary: " + bug.getSummary());
        test.log(Status.FAIL, "Severity: " + severity);
        test.log(Status.FAIL, "Steps to Reproduce:\n" + bug.getSteps());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
	    extent.flush();

	}
	


}
