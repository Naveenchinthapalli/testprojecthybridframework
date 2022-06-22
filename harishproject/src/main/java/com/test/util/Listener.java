package com.test.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.test.base.Base;

public class Listener extends Base implements ITestListener{
//public static com.relevantcodes.extentreports.ExtentTest test;

public static Logger log=Logger.getLogger(Listener.class.getName());

public void onTestStart(ITestResult result) {
	log.info("testcase start:"+result.getName());	
	//test=extent.startTest("test1 ");
	//test.log(LogStatus.INFO, "testcase started");
	
}

public void onTestSuccess(ITestResult result) {
	
	log.info("testcase success:"+result.getName());

	//test.log(LogStatus.PASS, "testcase successsed");
}

public void onTestFailure(ITestResult result) {
	log.error("testcase failed:"+result.getName());

	//test.log(LogStatus.FAIL, "testcase failed");
}

public void onTestSkipped(ITestResult result) {
	log.info("testcase skipped:"+result.getName());
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	
}

public void onStart(ITestContext context) {

	log.info("testcase onstart:"+context.getName());
	
}

public void onFinish(ITestContext context) {

log.info("testcase finished:"+ context.getName());
//extent.flush();
//test.log(LogStatus.INFO, "testcase finish");
}
}