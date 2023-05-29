package com.yatra.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\extentreport\\MyReport.html");
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		htmlreporter.config().setDocumentTitle("YatraTrip");
		htmlreporter.config().setReportName("yatra.com");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "MyPC");
		extent.setSystemInfo("OS", "Window 10");
		extent.setSystemInfo("author", "Pardeep");
		
	}
	public static void endExtent() {
		extent.flush();
	}

}
