package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclasses.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {

	
	
	
	//pageFactory or ObjectRepository
	
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//span[@class='icon icon-xs mdi-chart-bar']")
	  WebElement LoginOpt;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement login_btn;
	
	@FindBy(xpath="//a[contains(@xpath='1')]")//doubtfull="/html[1]/body[1]/div[1]/main[1]/section[1]/a[1]"
	WebElement signUp;
	
	@FindBy(xpath="//div[@class='rd-navbar-panel']//span[contains(text(),'free')]")
	WebElement logo;
	
	//Initializing the PageObject
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPage() {
	return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
		}
	
	public HomePage login( String uname,String pwd) {
		LoginOpt.click();
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login_btn.click();
		return new HomePage();
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
