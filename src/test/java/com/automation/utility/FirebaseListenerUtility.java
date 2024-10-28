package com.automation.utility;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.base.BaseTest;

public class FirebaseListenerUtility extends BaseTest implements ITestListener, ISuiteListener {

	private Logger mylog = LogManager.getLogger(FirebaseListenerUtility.class);
	private ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();

	@Override
	public void onStart(ITestContext context) {
		mylog.info(context.getName() + "started.........");
		extentReportUtility.startExtentReport();

	}

	@Override
	public void onFinish(ITestContext context) {
		mylog.info(context.getName() + "ended.........");
		extentReportUtility.endReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		mylog.info(result.getMethod().getMethodName() + "started...........");
		extentReportUtility.startSingleTestReport(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		mylog.info(result.getMethod().getMethodName() + "ended with success.........");
		extentReportUtility.logTestpassed(result.getMethod().getMethodName() + "ended with success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		mylog.error(result.getMethod().getMethodName() + "ended with failure.........");
		extentReportUtility.logTestFailedWithException(result.getThrowable());
		String filename=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(0));
		String path=Constants.SCRRENSHOTS_DIRECTORY_PATH+filename+".png";
		takeScreenshot(path);
		extentReportUtility.logTestWithscreenshot(path);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		mylog.warn(result.getMethod().getMethodName() + "skipped.........");
		extentReportUtility.logTestFailed(result.getMethod().getMethodName()+"skipped...");

	}
}