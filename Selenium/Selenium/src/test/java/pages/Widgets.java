package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Widgets {

	private WebDriver driver;

	public Widgets(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement toolTipsCard() {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//*[@id = 'item-6']//*[contains(text(), 'Tool Tips')] "));
	}

	// hover button
	public WebElement hoverBtn() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id = 'toolTipButton']"));
	}
	
	// hover input text field
	public WebElement hoverTxtField() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id = 'toolTipTextField']"));
	}
	
	// input text field pop up that appears after hovering the text field
	public WebElement textFieldPopUp() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id = 'textFieldToolTip']"));
	}
}
