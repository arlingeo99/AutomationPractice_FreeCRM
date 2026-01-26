package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class TasksPage extends BaseTest{
	
	//define OR
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span ")
	WebElement tasksLabel;
	
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[2]/td[7]/button/i")
	WebElement deleteIcon;	
	
	@FindBy(xpath = "//button[@class='ui left floated button']")
	WebElement cancelIcon;
	 
	//initialize page factory
		public TasksPage() {
			PageFactory.initElements(driver, this);
		}
		
	//actions
		public boolean verifytasksLabel() {
			return tasksLabel.isDisplayed();
		}
		
		public void verifydeleteIcon()
		{
			deleteIcon.click();
			cancelIcon.click();
		}

}
