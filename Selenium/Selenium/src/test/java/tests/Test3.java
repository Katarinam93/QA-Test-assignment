package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;

import pages.AddCandidateForm;
import pages.Candidates;
import pages.Dashboard;
import pages.LoginPageOrangeHRM;
import setup.BaseClass;
import setup.Log;
import setup.ScreenshotTestRule;

@TestInstance(Lifecycle.PER_CLASS)
public class Test3 extends BaseClass {
	WebDriver driver;
	LoginPageOrangeHRM lpOrange;
	Dashboard dashboard;
	Candidates candidates;
	AddCandidateForm addCand;

	@Rule
    public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();
	
	@Test
	public void candidate() throws InterruptedException {

		// logging in(since the form is autofilled we are just pressing the login
		// button)
		lpOrange.loginBtn().click();
		Log.info("Logging in and ariving on " + driver.getCurrentUrl());

		// clicking the recruitment option
		dashboard.recruitmentCard().click();

		// clicking on the candidates card
		dashboard.candidates().click();
		Log.info("Clicking on candidates card and ariving on " + driver.getCurrentUrl());

		// switching to IFrame
		driver.switchTo().frame("noncoreIframe");

		// we are printing out the num of candidates before we add a new one
		int numOfCandidatesBefore = candidates.numOfCandidatesInt();
		System.out.println(numOfCandidatesBefore);

		// clicking the addNewCandidate button
		candidates.addNewCandidate().click();

		// adding a new candidate action from the page AddCandidateForm
		addCand.addNewCandidate("QA", "Automation", "email@email.com", "QA", "QA");

		// Now we are asserting if we get the success message for creating a new
		// candidate
		String actualMessage = candidates.toastMessage();
		String expectedMessage = "Successfully Saved";

		assertEquals(expectedMessage, actualMessage);

		// we are printing the num of candidates after adding a new one
		int numOfCandidatesRightNow = candidates.numOfCandidatesInt();
		System.out.println(numOfCandidatesRightNow);

		// we are asserting that the number has increased
		assertTrue("The number should be the number of candidates + 1",
				numOfCandidatesRightNow == (numOfCandidatesBefore + 1));

		// performing the action of our candidate deletion
		candidates.deleteCandidate();

		// I needed longer time for the page to load again after deleting the candidate
		// and since the elements I needed after the deletion are already present I
		// wasn't able to find another way.
		Thread.sleep(2500);

		// asserting that we successfully deleted the candidate
		assertTrue("The message should be Successfully Deleted",
				candidates.toastMessage().equals("Successfully Deleted"));

		int numOfCandidatesAfter = candidates.numOfCandidatesInt();
		System.out.println(numOfCandidatesAfter);

		// asserting that the number of candidates is smaller by 1
		assertTrue("The number should be the numOfCandidatesRightNow - 1",
				numOfCandidatesAfter == (numOfCandidatesRightNow - 1));
	}

	@BeforeAll
	public void beforeSuite() throws IOException {
		driver = initDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// in here the wait time for the page to load is a lot longer than in other
		// tests in order to be sure that the page is surely gonna load
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
		Log.info("Navigating to " + driver.getCurrentUrl());
		
		lpOrange = new LoginPageOrangeHRM(driver);
		dashboard = new Dashboard(driver);
		candidates = new Candidates(driver);
		addCand = new AddCandidateForm(driver);

	}
	

	@AfterAll
	public void afterSuite() {

		// logging out and closing the window
		dashboard.logout();
		driver.close();
	}
}
