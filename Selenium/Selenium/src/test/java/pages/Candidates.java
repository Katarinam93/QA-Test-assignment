package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import setup.Log;

public class Candidates {

	private WebDriver driver;

	public Candidates(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// we are getting the text of the navbar heading of the page to make sure we are
	// on the right page
	public String navbarHeadingText() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//a[@id='navBarHeading']")).getText();
	}

	// rows per page dropdown
	public WebElement arrowDropdown() {
		return Utils.waitForElementPresence(driver, 30, By.xpath("//*[@data-activates ='dropdown1']"));
	}

	// rows per page dropdown
	public WebElement show10Rows() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//a[contains(text(),'10')]"));
	}

	// Add new candidate button
	public WebElement addNewCandidate() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//a[@id='addItemBtn']"));
	}

	// In order to print out the number of candidates we are using substring method
	// Since the number of candidates shown is automatically 50 per page, we can be
	// sure that the first 9 characters of the string we are using are not gonna
	// change so we can convert the string to int and later in the tests print out
	// the total number of
	// candidates.
	public String numOfCandidates() {
		return Utils.waitForElementPresence(driver, 50, By.xpath("//div[@id='fromToOf']/div")).getText().substring(10);
	}

	// we are parsing the string above to be able to subtract and add to it in later
	// tests
	public int numOfCandidatesInt() {
		return Integer.parseInt(numOfCandidates());
	}

	// Toast message (alert after saving or deleting a candidate) writing them for
	// later comparing the text could be : Successfully Saved
	// or Successfully Deleted
	public String toastMessage() {
		return Utils.waitForElementPresence(driver, 20, By.xpath("//*[@class='toast-message']")).getText();
	}

	public WebElement checkboxOfOurCandidate() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("(//td//label)[1]"));
	}

	// three dots in the upper right corner of the page
	public WebElement dotsDropdownMenu() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id ='ohrmList_Menu']"));
	}

	// the delete button from the dropdown menu
	public WebElement deleteBtn() {
		return Utils.waitToBeClickable(driver, 10,
				By.xpath("//*[@id='ohrmList_dropDownMenu']//a[@id='deleteItemBtn']"));
	}

	// confirming that we want to delete the candidate
	public WebElement confirmDelete() {
		return Utils.waitToBeClickable(driver, 20, By.xpath("//a[contains(text(), 'yes, delete')]"));
	}

	// performing the delete action
	public void deleteCandidate() {
		this.checkboxOfOurCandidate().click();
		this.dotsDropdownMenu().click();
		this.deleteBtn().click();
		this.confirmDelete().click();
		Log.info("Deleting the canidate");
	}
}