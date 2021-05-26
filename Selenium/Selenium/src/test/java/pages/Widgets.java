package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Widgets {

	private WebDriver driver;

	public Widgets(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement toolTipsCard() {
		return Utils.waitForElementPresence(driver, 10,
				By.xpath("//*[@class='element-list collapse show']//li[@id='item-6']"));
	}
	
	public void scroolDownThePage(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	
	// hover input text field
	public WebElement hoverTxtField() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id = 'toolTipTextField']"));
	}
	
	
	// hover button
	public WebElement hoverBtn() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id = 'toolTipButton']"));
	}
	
	//the text from the pop up that appears after you hover the button
	public String popUpText() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@role = 'tooltip']")).getText();
	}
	
	//performing the hover action over the element we pass 
	public void performingTheHoverAction(WebElement hoverElement) {
		
		 Actions builder = new Actions(driver);
		 builder.moveToElement(hoverElement).build().perform();
		 System.out.println(popUpText());

	}
}
