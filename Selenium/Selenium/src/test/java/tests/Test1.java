package tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import pages.Google;
import pages.Interactions;
import pages.LandingPageDemoQA;
import pages.Utils;
import pages.Widgets;
import setup.BaseClass;
import setup.Log;
import setup.ScreenshotTestRule;

@TestInstance(Lifecycle.PER_CLASS)
public class Test1 extends BaseClass {
	
	@Rule
    public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();

	WebDriver driver;
	Google google;
	LandingPageDemoQA landingPageDQA;
	Interactions interactions;
	Widgets widgets;

	@Test
	public void demoQaTest() throws Exception {

		// searching the google
		google.searchAction("demoqa.com");
		Log.info("Performing a Google search and ariving on " + driver.getCurrentUrl());
		
		// clicking the first result
		google.firstResult().click();
		Log.info("Clicking on the first result and ariving on " + driver.getCurrentUrl());

		// going to interactions page
		landingPageDQA.interactionsCard().click();

		// scrolling down the page using the scroll action from the widgets page and
		// passing the interactions webElement
		widgets.scroolDownThePage(interactions.droppableCard());

		// clicking the droppable card on the left
		interactions.droppableCard().click();
		
		Thread.sleep(1000);
		
		//performing the drag and drop action
		interactions.dragAndDropAction();
		Log.info("Draging and droping element");

		// printing the text from the drop here box which should now be Dropped!
		System.out.println(interactions.dropHereText());

		// asserting that the text has changed to Dropped!
		assertTrue("The text of the drop here box should be Dropped", interactions.dropHereText().equals("Dropped!"));

		// Taking a screenshot
		Utils.takeSnapShot(driver, "./Screenshots/dragAndDropScreenshot.png");

		// clicking on the widgets section
		interactions.widgetsCard().click();

		// scroll down the page
		widgets.scroolDownThePage(widgets.toolTipsCard());

		// clicking the toolTips Card
		widgets.toolTipsCard().click();

		// performing the hover action over the button element
		widgets.performingTheHoverAction(widgets.hoverBtn());
		Log.info("Performing a hover action");

		// asserting if the text is what we expect
		assertTrue("The toolTip text should be You hovered over the Button ",
				widgets.popUpText().equals("You hovered over the Button"));
	}

	@BeforeAll
	public void beforeSuite() throws IOException {
		driver = initDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");

		google = new Google(driver);
		landingPageDQA = new LandingPageDemoQA(driver);
		interactions = new Interactions(driver);
		widgets = new Widgets(driver);
	}
	

	@AfterAll
	public void afterSuite() {
		driver.close();
	}

}
