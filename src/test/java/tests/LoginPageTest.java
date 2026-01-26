package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

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
		initialization();
		loginpg = new LoginPage(); //creating the object of LoginPage class to access all the functions/methods of LoginPage class
	    sfa = new SoftAssert();
	}
	
	@Test(priority =1)
	public void validateLoginPageTitleTest()
	{
		String title = loginpg.validateLoginPageTitle();
		sfa.assertEquals(title, "Free CRM", "Page Title does not match"); //the message will only be printed if the assertion/test case fails
		
	}
	
	@Test(priority =2)
	public void validLoginTest() throws IOException
	{
		homepg = loginpg.validLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}	
	
	@AfterMethod
	public void cleanUp()
	{
		sfa.assertAll();
		tearDown();
		
	}
}

