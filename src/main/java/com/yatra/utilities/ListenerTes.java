package com.yatra.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.yatra.base.BaseDriver;

public class ListenerTes extends ExtentManager implements ITestListener {
//	ScreenShot screenshot=new ScreenShot();
	public void onStart(ITestContext context) {	
		System.out.println("onStart method started");
		Log.info("onStart method started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
		Log.info("onFinish method started");
	}
	
		public void onTestStart(ITestResult result) {
			System.out.println("New Test Started" +result.getName());
			Log.info("New Test Started" +result.getName());
			test=extent.createTest("test started"+result.getName());
		}
		
		public void onTestSuccess(ITestResult result) {
			System.out.println("onTestSuccess Method" +result.getName());
			Log.info("onTestSuccess Method" +result.getName());
			if (result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS ,"pass the test is "+result.getName());
			}
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("onTestFailure Method" +result.getName());
			Log.info("onTestFailure Method" +result.getName());
//			try {
//				screenshot.captureShot();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL,"test is fail "+result.getName());
			Date date =new Date();
			String timestamp=date.toString().replace(":","-").replace(" ","-");
			File screenshot=((TakesScreenshot)BaseDriver.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot,new File(".\\Screenshot\\"+timestamp+ " " +result.getName()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

		}

		public void onTestSkipped(ITestResult result) {
			System.out.println("onTestSkipped Method" +result.getName());
			Log.info("onTestSkipped Method" +result.getName());
			if(result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP,"test is skipped  " + result.getName());
			}
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
			Log.info("onTestFailedButWithinSuccessPercentage" +result.getName());
			if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL," onTestFailedButWithinSuccessPercentage" +result.getName());
			}
		}
}

