package com.yatra.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.yatra.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static FileInputStream fis;
	public static Properties prop;
@BeforeSuite
	public void loadConfig() throws IOException {
	ExtentManager.setExtent();
	DOMConfigurator.configure("log4j.xml");
		prop = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\config.properties");
		prop.load(fis);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public void launchBrowser() {
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else {
			System.out.println("Enter a Valid Browser name");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
//		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		getDriver().get(prop.getProperty("url"));
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endExtent();
	}
}
