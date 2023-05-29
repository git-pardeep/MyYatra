package com.yatra.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.base.BaseDriver;
import com.yatra.utilities.Log;

public class HomePage extends BaseDriver{
//	By origin = By.id("BE_flight_origin_city");
//	By arrival=By.id("BE_flight_arrival_city");
	@FindBy(id="BE_flight_origin_city") 
	private  WebElement origin;
	@FindBy(id="BE_flight_arrival_city") 
	private WebElement arrival;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	public String getTitle() {
		
		System.out.println("Yatra title is "+ getDriver().getTitle());
		return getDriver().getTitle();
		
	}
	public void searchFlight() throws InterruptedException {
//		WebElement org =getDriver().findElement(origin);
		Thread.sleep(2000);
		origin.click();
		Thread.sleep(2000);
		origin.sendKeys("Mumbai");
		Thread.sleep(2000);
		origin.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		origin.sendKeys(Keys.ENTER);
//		WebElement arl =getDriver().findElement(arrival);
		Thread.sleep(2000);
		arrival.click();
		Thread.sleep(2000);
		arrival.sendKeys("Delhi");
		Thread.sleep(2000);
		arrival.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		arrival.sendKeys(Keys.ENTER);
	}

}
