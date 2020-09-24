package com.crm.qa.testcases;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.baseclasses.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTestCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	public static String sheetName="Contacts";

	ContactsPageTestCase(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil=new TestUtil();
	    loginPage=new LoginPage();
	    contactsPage=new ContactsPage();
	    homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	    homePage.clickOnContact();
	}
	
	@Test(priority=1)
	public void verifyConatactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing");
	}
	
	@Test(priority=2)
	public void selectContact() {
		contactsPage.clickOnContactByName("boby naik");
	}
	
	@Test(priority=3)
	public void selectMultipleContacts() {
		contactsPage.clickOnContactByName("madhuri naik");
		contactsPage.clickOnContactByName("boby naik");
	}
	
	@DataProvider
	public Object[][] getCrmTestData() throws EncryptedDocumentException, IOException {
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=4,dataProvider="getCrmTestData")
	public void validateCreateNewContact(String Firstname,String Lastname,String Category) throws InterruptedException {
		homePage.clickOnContact();
		homePage.clickOnNewContactBtn();
		contactsPage.createNewContact(Firstname,Lastname,Category);
	}
	
	

	@AfterMethod
	public void tearDown(){
	 driver.quit();
	}
}
