package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestUtils;

public class ContactsPageTest extends BaseTest {

	LoginPage loginpg;
	HomePage homepg;
	ContactsPage contactspg;
	SoftAssert sfa;
	String sheetname ="Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		// now we need to login to the crm to access home page, for that we need to
		// create LoginPage class object and access the login method
		loginpg = new LoginPage();
		contactspg = new ContactsPage();
		sfa = new SoftAssert();
		homepg = loginpg.validLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactspg = homepg.clickOnContacts();
	}

	@Test(priority = 1)
	public void verifycontactsLabelTest() {
		sfa.assertTrue(contactspg.verifycontactsLabel(), "The contact label is not displayed");
	}

	@Test(priority = 2)
	public void filterLabelClickTest() {
		contactspg.filterLabelClick();
	}

	@Test(priority = 3)
	public void selectContactsByNameTest() {
		contactspg.selectContactsByName();
	}

	@DataProvider
	public Object[][] getCRMTestData() throws FileNotFoundException{
		Object testData[][]= TestUtils.getContacts(sheetname);
		return testData;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData" )
	public void validatecreateNewContactsTest( String firstname, String lastname , String email) {
		homepg.clickOnAddContacts();
		//contactspg.createNewContacts("John", "Doe", "jd88@gmail.com");
		contactspg.createNewContacts(firstname, lastname, email);
	}

	@AfterMethod
	public void cleanUp() {
		sfa.assertAll();
		tearDown();
	}
}
