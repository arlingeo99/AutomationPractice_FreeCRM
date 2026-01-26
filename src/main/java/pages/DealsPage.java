package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class DealsPage extends BaseTest {

	
	//define page factory
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span ")
	WebElement dealsLabel;
	
	@FindBy(name ="title")
	@CacheLookup
	WebElement dealTitle;
	
	@FindBy(name ="amount")
	@CacheLookup
	WebElement dealAmount;
	
	@FindBy(name ="commission")
	WebElement dealCommission;
	
	@FindBy(xpath ="//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement saveBtn;
	 
	
	//initialize page factory
		public DealsPage() {
			PageFactory.initElements(driver, this);
		}
	//actions
		public boolean verifydealsLabel() {
			return dealsLabel.isDisplayed();
		}
		
		
		public void selectDealsByName() {
			String dealnameA = prop.getProperty("deal1");
			WebElement findDealA = driver
					.findElement(By.xpath("//a[normalize-space()='"+dealnameA+"']/ancestor::tr//label"));
			
			
			// Scroll into view because the check box is not able to be interacted
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", findDealA);
			
			// Click using Actions for reliability
		    Actions actions = new Actions(driver);
		    actions.moveToElement(findDealA).click().perform();

		}
		
		public void createNewDeals(String title, String amt , String com)
		{
			dealTitle.sendKeys(title);
			dealAmount.sendKeys(amt);
			dealCommission.sendKeys(com);
			saveBtn.click();
		}

}



