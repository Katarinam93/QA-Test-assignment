package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Interactions {

	private WebDriver driver;

	public Interactions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// Droppable card in interactions section.
	public WebElement droppableCard() {
		return Utils.waitToBeClickable(driver, 50,
				By.xpath("//*[@class='element-list collapse show']//li[@id='item-3']"));
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
		return Utils.waitForElementPresence(driver, 30,
				By.xpath("//div[@id = 'droppableExample-tabpane-simple']//div[@id = 'droppable']"));
	}

	// the text of the drop here element which we will use later to assert if it has
	// changed
	public String dropHereText() {
		return Utils.waitForElementPresence(driver, 30, By.xpath("//div[@id = 'droppableExample-tabpane-simple']//p"))
				.getText();
	}

	// Widgets card from the left
	public WebElement widgetsCard() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//div[contains(text(), 'Widgets')]"));

	}

	public void dragAndDropAction() {
		// Creating object of Actions class to build composite actions
		Actions builder = new Actions(driver);

		// Building a drag and drop action
		Action dragAndDrop = builder.clickAndHold(draggableElement()).moveToElement(droppableElement())
				.release(droppableElement()).build();

		// Performing the drag and drop action
		dragAndDrop.perform();
	}
}
//