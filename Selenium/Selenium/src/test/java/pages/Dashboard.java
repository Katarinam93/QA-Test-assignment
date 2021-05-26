package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {

	private WebDriver driver;

	public Dashboard(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// the card with the recruitment dropdown menu
	public WebElement recruitmentCard() {
		return Utils.waitForElementPresence(driver, 50, By.xpath("//*[@id ='menu_recruitment_viewRecruitmentModule']"));
	}

	// the card that opens the candidates page
	public WebElement candidates() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id ='menu_recruitment_viewCandidates']"));
	}
	
	//User dropdown menu from which we are gonna logout
	public WebElement getUserDropdown() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id ='user-dropdown']"));
	}
	
	//Logout option in the dropdown menu
	public WebElement getLogOutOption() {
		return Utils.waitForElementPresence(driver, 10, By.xpath("//*[@id ='logoutLink']"));
	}
	
	//Performing the logout action
	public void logout() {
		getUserDropdown().click();
		getLogOutOption().click();
	}
	
}
