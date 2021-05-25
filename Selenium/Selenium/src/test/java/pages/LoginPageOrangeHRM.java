package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageOrangeHRM {

	private WebDriver driver;

	public LoginPageOrangeHRM(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement usernameField() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id ='txtUsername']"));
	}
	
	public WebElement passwordField() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id ='txtPassword']"));
	}
	
	//Login button and since the fields are already autofiled we are just gonna be pressing this button
	public WebElement loginBtn() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id ='btnLogin']"));
	}
}
//