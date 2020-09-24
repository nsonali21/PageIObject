package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclasses.TestBase;

public class HomePage extends TestBase{
@FindBy(xpath = "//span[contains(text(),'Abc Abc')]") //span[@class='user-display']
WebElement UserNameLabel;

@FindBy(xpath = "//a//span[contains(text(),'Contacts')]")
WebElement contacts;

@FindBy(xpath = "//span[contains(text(),'Deals')]")
WebElement deals;

@FindBy(xpath = "//span[contains(text(),'Tasks')]")
WebElement tasks;

@FindBy(xpath = "//button[contains(text(),'New')]")
WebElement NewContactBtn;
 public HomePage(){
	PageFactory.initElements(driver, this);
}
 public String verifyHomePageTitle() {
	 return driver.getTitle();
 }
 public boolean verifyCorrectUserName() {
	return UserNameLabel.isDisplayed();
 }
 
 public ContactsPage clickOnContact(){
	 contacts.click();
	 return new ContactsPage();
 }
 
 public DealsPage clickOnDeals() {
	 deals.click();
	 return new DealsPage();
 }
 
 public TasksPage clickOnTasks() {
	 tasks.click();
	 return new TasksPage();
 }
 
 public void clickOnNewContactBtn() {
	 NewContactBtn.click();
 }
 
}
