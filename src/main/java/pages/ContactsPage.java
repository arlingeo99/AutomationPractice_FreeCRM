package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.BaseTest;

public class ContactsPage extends BaseTest {

	// define page factory

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span")
	WebElement contactsLabel;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[1]")
	WebElement filterLabel;
	
	@FindBy(name = "first_name")
	WebElement firstname;
	
	@FindBy(name ="last_name")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
    WebElement email;
	
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement saveBtn;
	
//initialize page factory
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// actions
	public boolean verifycontactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void filterLabelClick() {
		filterLabel.click();
	}

	public void selectContactsByName() {
		String boxname = prop.getProperty("checkboxname");
		WebElement findBox = driver
				.findElement(By.xpath("//a[normalize-space()='"+boxname+"']/ancestor::tr//label"));
		
		// Scroll into view because the check box is not able to be interacted
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", findBox);
		
		// Click using Actions for reliability
	    Actions actions = new Actions(driver);
	    actions.moveToElement(findBox).click().perform();		

	}
	
	public void createNewContacts(String fname , String lname, String mailaddress )
	{
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[5]/div[1]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[5]/div[1]/div/div/div[2]/div[3]/span")).click();
		
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(mailaddress);
		saveBtn.click();
	}

}
