package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest{
	LoginPage loginpg;
	HomePage homepg;
	ContactsPage contactspg;
	SoftAssert sfa;

	public HomePageTest()
	{
		super();
	}
	
	//each test cases should be separated/independent of each other
	//before each test case execution, launch the browser and login 
	//then execute the test case
	//after each test case, close the browser
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		//now we need to login to the crm to access home page, for that we need to create LoginPage class object and access the login method
		loginpg = new LoginPage() ;
		contactspg = new ContactsPage();
		sfa = new SoftAssert();
		homepg = loginpg.validLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void validateHomePageTitleTest()
	{
		String homeTitle = homepg.validateHomePageTitle();
		sfa.assertEquals(homeTitle, "Free CRM", "Page Title does not match"); 
	}
	
	@Test(priority = 2)
	public void verifyvalidUserLabelTest()
	{
	  sfa.assertTrue(homepg.verifyvalidUserLabel(), "The user label does not match");
	}
	@Test(priority = 3)
	public void clickOnContactTest() throws IOException
	{
		contactspg = homepg.clickOnContacts();
	}
	
	@AfterMethod
	public void cleanUp()
	{
		sfa.assertAll();
		tearDown();
	}
}
