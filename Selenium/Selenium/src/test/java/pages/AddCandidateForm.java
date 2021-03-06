package pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.CHAR_ARRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import okio.Timeout;
import setup.Log;

public class AddCandidateForm {

	private WebDriver driver;

	public AddCandidateForm(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// we are getting the resume button
	public WebElement addResume() {
		return Utils.waitForElementPresence(driver, 15, By.xpath("//*[@id='addCandidate_resume']"));
	}

	// we are getting the first name input field
	public WebElement getFirstName() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='addCandidate_firstName']"));
	}

	// we are getting the last name input field
	public WebElement getLastName() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='addCandidate_lastName']"));
	}

	// we are getting the email input field
	public WebElement getEmail() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='addCandidate_email']"));
	}

	// Vacancy dropdown meny
	public WebElement vacancyDropdown() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='textarea_addCandidate_vacancy']"));
	}

	// search of vacancy dropdown menu
	public WebElement vacancySearch() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='modalAddCandidate']//input[@class='employee-search validate']"));
	}

	// getting the first option based on the words we typed in (since the style of
	// the HTML elements is changeable we are looking for the first option that has
	// its style set to display because we only need the option that corresponds
	// with our search input text)
	public WebElement searchedVacancyOption(String searchWord) {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//*[@id='modalAddCandidate']//p[contains(text(),'" +searchWord + "')]"));
	}

	// Software QA Engineer option from the vacancy dropdown menu
	public WebElement qaEngeneerOption() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='DTdzm_search_44']"));
	}

	// getting the date field
	public WebElement date() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='applied_date']"));
	}

	// getting today on the calendar (since writing only the today's button id
	// selector is not unique I had to first find the id of the
	// addCandidateForm and find the today button that is the descendant of the
	// form on which we are working right now)
	public WebElement dateTodayBtn() {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//div[@id='modalAddCandidate']//*[@class='btn-flat picker__today']"));
	}

	// Save button
	public WebElement saveBtn() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id='saveCandidateButton']"));
	}

//------------------------------------------- setting the required fields---------------------------------------

	// setting the resume field
	// I am parametrising the path to the resume file so it is not local dependent
	public String getFile() {
		return new File("./LoremIpsumResume.pdf").getAbsolutePath();
	}

	// the action of uploading the resume file from my root folder
	public void uploadResume() {
		WebElement choosefile = addResume();
		System.out.println(getFile());
		choosefile.sendKeys(getFile());
		Log.info("Adding a resume");
	}

	// setting the first name
	public void setFirstName(String fName) {
		WebElement firstName = getFirstName();
		firstName.clear();
		firstName.sendKeys(fName);
		Log.info("Entering a first name");
	}

	// setting the last name
	public void setLastName(String lName) {
		WebElement lastName = getLastName();
		lastName.clear();
		lastName.sendKeys(lName);
		Log.info("Entering a last name");
	}

	// setting the email
	public void setEmail(String email) {
		WebElement sEmail = getEmail();
		sEmail.clear();
		sEmail.sendKeys(email);
		Log.info("Entering email");
	}

	// setting the vacancy search field and selecting the typed option
	public void setVacancy(String vacancyInput, String searchWord) {
		this.vacancyDropdown().click();
//		this.vacancySearch().clear();
		this.vacancySearch().sendKeys(vacancyInput);
		this.searchedVacancyOption(searchWord).click();
		Log.info("Setting vacansy email");
	}

	// setting the date
	public void setDate() {
		date().click();
		dateTodayBtn().click();
		Log.info("Setting date");
	}

	// The action of adding new candidate
	public void addNewCandidate(String fName, String lName, String email, String vacancyInput, String searchWord) throws InterruptedException {
		setFirstName(fName);
		setLastName(lName);
		setEmail(email);
		setVacancy(vacancyInput, searchWord);
		setDate();
		uploadResume();
		saveBtn().click();
		Log.info("Saving new candidate");
	}
}