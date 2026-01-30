package pages;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement taskTitle;
	
	@FindBy(xpath = "//button[text()= \"Public\"]")
	WebElement accessBtn; 
	
	@FindBy(xpath = "//div[text()= \"Select users allowed access.\"]")
	WebElement userDrop;
	
	@FindBy(name ="completion")
	WebElement completionRate;
	
	
	 
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
		
		public void createNewTask(String title, String cRate)
		{
			taskTitle.sendKeys(title);
			completionRate.sendKeys(cRate);
			accessBtn.click();
			userDrop.click();
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[2]/div/div/div[2]/div/div[2]/div"));
			driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();
			
		}

}
