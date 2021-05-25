package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCandidateForm {

	private WebDriver driver;

	public AddCandidateForm(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// we are getting the resume button
	public WebElement addResumeBtn() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='addCandidate_resume']"));
	}

	// we are getting the first name input field
	public WebElement addFirstName() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='addCandidate_firstName']"));
	}

	// we are getting the last name input field
	public WebElement addLastName() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='addCandidate_lastName']"));
	}

	// we are getting the email input field
	public WebElement addEmail() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='addCandidate_email']"));
	}

	// Vacancy dropdown meny
	public WebElement vacancyDropdown() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='textarea_addCandidate_vacancy']"));
	}

	// Software QA Engineer option from the vacancy dropdown menu
	public WebElement qaEngeneerOption() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='DTdzm_search_44']"));
	}

	// getting the date field
	public WebElement date() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='applied_date']"));
	}

	// getting today on the callender(since the selector gets three results I had to
	// insert [0])
	public WebElement dateTodayBtn() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("(//*[@class='btn-flat picker__today'])[0]"));
	}

	// Save button
	public WebElement saveBtn() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='saveCandidateButton']"));
	}
	
//------------------------------------------- setting the required fields---------------------------------------
	
	//setting the resume field
	
}
//