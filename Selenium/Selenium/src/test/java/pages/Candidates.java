package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@data-activates ='dropdown1']"));
	}

	// rows per page dropdown
	public WebElement show10Rows() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//a[contains(text(),'10')]"));
	}
	
	//Add new candidate button
	public WebElement addNewCandidate() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//a[@id='addItemBtn']"));
	}

		// In order to print out the number of candidates we are using substring method
	// explained more in the comments bellow
	public String numOfCandidates() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//div[@id='fromToOf']/div")).getText().substring(10);
	}

	// action of printing out the number of candidates
	// first we select the number of rows per page we want to show, after we are
	// sure that the first 9 characters of the string we are using are not gonna
	// change we can convert the string to int and print out the total number of candidates.
	public void printNumOfCandidates() {
		arrowDropdown().click();
		show10Rows().click();
		Integer.parseInt(numOfCandidates());
		System.out.println(numOfCandidates());
	}

}