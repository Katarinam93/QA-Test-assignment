package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Interactions {

	private WebDriver driver;

	public Interactions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// Droppable card in interactions section.
	public WebElement droppableCard() {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//*[@id = 'item-3']//*[contains(text(), 'Droppable')]"));
	}

	// Draggable element
	// Since the id's on this page are not unique I had to combine 2 id's to get the
	// selectors I need, and that apply's to most of the selectors from this page
	public WebElement draggableElement() {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//div[@id = 'droppableExample-tabpane-simple']//div[@id = 'draggable']"));
	}

	// Droppable element
	public WebElement droppableElement() {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//div[@id = 'droppableExample-tabpane-simple']//div[@id = 'droppable']"));
	}

	// the text of the drop here element which we will use later to assert if it has
	// changed
	public String dropHereText() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//div[@id = 'droppableExample-tabpane-simple']//p"))
				.getText();
	}

	// Widgets card from the left
	public WebElement widgetsCard() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//div[contains(text(), 'Widgets')]"));

	}

}
//