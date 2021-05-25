package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageDemoQA {

	private WebDriver driver;

	public LandingPageDemoQA(WebDriver driver) {
		super();
		this.driver = driver;
	}
	//Bellow are listed all of the clickable webelements on the landing page
	public WebElement elementsCard() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[contains(text(), 'Elements')]"));
	}
	
	// 	WebElement Forms
	public WebElement formsCard() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[contains(text(), 'Forms')]"));
	}
	
	// 	WebElement Alerts, Frame & Windows
	public WebElement alertsFrameWindowsCard() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[contains(text(), 'Alerts, Frame & Windows')]"));
	}
	
	// 	WebElement Widgets
	public WebElement widgetsCard() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[contains(text(), 'Widgets')]"));
	}
	// 	WebElement Interactions
	public WebElement interactionsCard() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[contains(text(), 'Interactions')]"));
	}
	
	public WebElement bookStoreApplicationCard() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[contains(text(), 'Book Store Application')]"));
	}

	//Img WebElement that leads you to online Selenium training
	public WebElement seleniumTraining() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@alt='Selenium Online Training']"));
	}
	
	//Img WebElement that leads you to the main/landing page of the site
	public WebElement landingPageLink() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@href='https://demoqa.com']"));
	}
}
