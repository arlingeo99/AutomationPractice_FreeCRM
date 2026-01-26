package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LoginPage extends BaseTest{
	
	//define Page Factory or OR
	
	@FindBy(name = "email")
	WebElement email;

	@FindBy(name ="password")
	WebElement pwd;
	
	@FindBy(xpath= "//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[normalize-space()='Sign Up']")
	WebElement signUpBtn;
	
	
	//initialize the Page Factory/ Objects
	
	public LoginPage() throws IOException//this is a constructor
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage validLogin(String uname, String pd) throws IOException
	{
		email.sendKeys(uname);
		pwd.sendKeys(pd);
		loginBtn.click();
		
		return new HomePage(); // home page is the landing page once you login successfully, so HomePage is returned for the login method
		
	}
}
