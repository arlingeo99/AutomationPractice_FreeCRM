package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest {

	// define Page Factory or OR

	@FindBy(xpath = "//span[text()= 'John Smith']")
	WebElement userLabel;

	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//span[text()='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[3]/button/i")
	WebElement addContactsLink;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[5]/button/i")
	WebElement addDealsLink;

//initializing page factory

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

//actions

	public boolean verifyvalidUserLabel() {
		return userLabel.isDisplayed();
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContacts() throws IOException {
		contactsLink.click();
		return new ContactsPage();

	}

	public DealsPage clickOnDeals() throws IOException {
		dealsLink.click();
		return new DealsPage();

	}

	public TasksPage clickOnTasks() throws IOException {
		tasksLink.click();
		return new TasksPage();

	}
	public void clickOnAddContacts()
	{
		 Actions actions = new Actions(driver);
		    actions.moveToElement(contactsLink).build().perform();
		    addContactsLink.click();
	}
	
	public void clickOnAddDeals()
	{
		Actions actions= new Actions(driver);
		actions.moveToElement(dealsLink).build().perform();
		addDealsLink.click();
		
	}

}
