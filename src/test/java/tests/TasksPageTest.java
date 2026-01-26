package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.TasksPage;

public class TasksPageTest extends BaseTest{
	
	LoginPage loginpg;
	HomePage homepg;
	TasksPage taskspg;
	SoftAssert sfa;
	
	public TasksPageTest()
	{
		super();
	}

	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		//now we need to login to the crm to access home page, for that we need to create LoginPage class object and access the login method
		loginpg = new LoginPage();
		sfa = new SoftAssert();
		homepg = loginpg.validLogin(prop.getProperty("username"),prop.getProperty("password"));
		taskspg = homepg.clickOnTasks();
	}
	
	@Test(priority =1)
	public void verifytasksLabelTest()
	{
		sfa.assertTrue(taskspg.verifytasksLabel(), "The tasks label is not displayed");
	}
	
	@Test(priority =2)
	
	public void verifydeleteIconTest()
	{
		taskspg.verifydeleteIcon();
	}
	@AfterMethod
	public void cleanUp()
	{
		sfa.assertAll();
		tearDown();
	}

}
