package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;

public class LoginPageTest extends BaseTest{
	
	LoginPage loginpg;
	HomePage homepg;
	SoftAssert sfa;

	public LoginPageTest() throws IOException {
		super();// super class constructor is being called
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		Log.info("launching the browser and logging in to FREE CRM App");
		Log.warn("********* Don't close the browser being opened ******");
		initialization();
		loginpg = new LoginPage(); //creating the object of LoginPage class to access all the functions/methods of LoginPage class
	    sfa = new SoftAssert();
	}
	
	@Test(priority =1)
	public void validateLoginPageTitleTest()
	
	{   Log.info("Checking whether the page title matches");
	    Log.warn("********* Don't close the browser being opened ******");
		String title = loginpg.validateLoginPageTitle();
		sfa.assertEquals(title, "Free CRM", "Page Title does not match"); //the message will only be printed if the assertion/test case fails
		
	}
	
	@Test(priority =2)
	public void validLoginTest() throws IOException
	{
		Log.info("Checking whether the user login is valid or not");
		Log.warn("********* Don't close the browser being opened ******");
		homepg = loginpg.validLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}	
	
	@AfterMethod
	public void cleanUp()
	{
		Log.info("Closing the browser and quitting driver");
		sfa.assertAll();
		tearDown();
		
	}
}

