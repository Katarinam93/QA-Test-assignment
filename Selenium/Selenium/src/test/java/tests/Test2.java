package tests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Google;

@TestInstance(Lifecycle.PER_CLASS)
public class Test2 {
	WebDriver driver;
	Google google;

	@Test
	public void cheeseGoogleSearch() {

		// performing the search action from the page Google with the word cheese
		google.searchAction("cheese");

		String expectedNumOfResults = "777";
		String actualNumOfResults = google.resultStats();

		// this assertion will fails since we are expecting to get only 777 ch
		assertTrue("There is too much cheese on the internet", expectedNumOfResults.equals(actualNumOfResults));
	}

	@BeforeAll
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");

		google = new Google(driver);

	}

	@AfterAll
	public void afterSuite() {
		driver.close();
	}
}
