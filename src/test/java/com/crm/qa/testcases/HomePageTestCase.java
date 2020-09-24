package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclasses.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTestCase extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	
	public HomePageTestCase() {
		super();
	}
//Test cases should be independent
	//before each test case launch the browser and after each test case close the browser...bcz if launch browser only once & 
	//excute 1000s of test cases browser will be exahusted or crash or blank page error can come
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil=new TestUtil();
	    loginPage=new LoginPage();
	   homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","home Page title is not matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest() {
	Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test(priority=3)
	public void verifyContactTest() {
		homePage.clickOnContact();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}