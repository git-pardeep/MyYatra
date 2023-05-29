package com.yatra.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.yatra.base.BaseDriver;
import com.yatra.pages.HomePage;
import com.yatra.utilities.Log;

public class HomePageTest extends BaseDriver {
	private HomePage homepage ;
	@BeforeClass
	public void setUp() {
		launchBrowser();
	}
	@AfterClass
	public void tearDown() {
		getDriver().close();
	}
	@Test
	public void gettitle() {
		homepage=new HomePage();
		Log.startTest("My title");
		String title = homepage.getTitle();
		Log.endTest("MyTitle");
		System.out.println(title);
	}
	
	@Test
	public void searchFlight() throws InterruptedException {
		Log.startTest("searchFlight");
		homepage.searchFlight();
		Assert.assertEquals(false, true);
		Log.endTest("searchFlight");
	}

}
