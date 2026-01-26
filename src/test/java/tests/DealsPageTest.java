package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestUtils;

public class DealsPageTest extends BaseTest {
	LoginPage loginpg;
	HomePage homepg;
	DealsPage dealspg;
	SoftAssert sfa;
	
	String sheetname = "Deals";
	
	
	public DealsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		//now we need to login to the crm to access home page, for that we need to create LoginPage class object and access the login method
		loginpg = new LoginPage() ;
		sfa = new SoftAssert();
		homepg = loginpg.validLogin(prop.getProperty("username"),prop.getProperty("password"));
		dealspg = homepg.clickOnDeals();
	}
	
	@Test(priority =1)
	public void verifydealsLabelTest()
	{
		sfa.assertTrue(dealspg.verifydealsLabel(), "The deals label is not displayed");
	}
	
	@Test(priority =2)
	public void selectDealsByNameTest()
	{
		dealspg.selectDealsByName();	
	}
		
	
	@DataProvider
	public Object[][] getCRMDeals()
	{
		Object testdata[][] = TestUtils.getDeals(sheetname);
		return testdata;
	}
	
	@Test(priority= 3, dataProvider ="getCRMDeals" )
	public void createNewDealsTest(String dtitle, String damt, String dcom)
	{
		homepg.clickOnAddDeals();
		dealspg.createNewDeals(dtitle, damt, dcom);
		
	}
	
	@AfterMethod
	public void cleanUp()
	{
		sfa.assertAll();
		tearDown();
	}
}
