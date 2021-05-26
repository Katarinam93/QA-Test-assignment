package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddCandidateForm;
import pages.Candidates;
import pages.Dashboard;
import pages.LoginPageOrangeHRM;


@TestInstance(Lifecycle.PER_CLASS)
public class Test3 {
	WebDriver driver;
	LoginPageOrangeHRM lpOrange;
	Dashboard dashboard;
	Candidates candidates;
	AddCandidateForm addCand;
	
	
	@Test
	public void candidate() throws InterruptedException {
		lpOrange.loginBtn().click();
		dashboard.recruitmentCard().click();
		dashboard.candidates().click();
		driver.switchTo().frame("noncoreIframe");
		candidates.printNumOfCandidates();
		candidates.addNewCandidate().click();
		addCand.addNewCandidate("QA", "Automation", "email@email.com", "QA", "QA");
		
		//Now we are asserting if we get the success message 
		String actualMessage = candidates.toastMessage();
		String expectedMessage = "Successfully Saved";
		
		assertEquals(expectedMessage, actualMessage);
	}

	@BeforeAll
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");

		lpOrange = new LoginPageOrangeHRM(driver);
		dashboard = new Dashboard(driver);
		candidates = new Candidates(driver);
		addCand = new AddCandidateForm(driver);
		
	}
	@AfterAll
	public void afterSuite() {
		driver.close();
	}
}
