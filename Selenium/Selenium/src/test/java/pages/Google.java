package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Google {

	private WebDriver driver;

	public Google(WebDriver driver) {
		super();
		this.driver = driver;
	}

	//gettting the input field WebElement
	public WebElement getInputField() {
		return Utils.waitForElementPresence(driver, 10, (By.xpath("//*[@name='q']")));
	}

	//getting the search button element
	public WebElement searchBttn() {
		return Utils.waitForElementPresence(driver, 10, (By.xpath("//*[@name='btnK']")));
	}

	// the first result on the google results page
	public List<WebElement> firstResult() {
		return Utils.waitForElementsPresence(driver, 10, (By.xpath("(//*[@id ='rso'] //a)[0]")));

	}

	// the number of results on google
	public String resultStats() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id ='result-stats']")).getText()
				.substring(6,16);
	}
	//------------------------------------------------------------------------------------------------
	//Setting the input text field
	public void setInputField(String googleSearchInput) {
		WebElement inputSearch = getInputField();
		inputSearch.clear();
		inputSearch.sendKeys(googleSearchInput);
	}
	
	//Performing the search action
	public void searchAction(String googleSearchInput) {
		setInputField(googleSearchInput);
		searchBttn().click();
	}
	
}
