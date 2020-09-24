package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.baseclasses.TestBase;

public class ContactsPage extends TestBase {


	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement first_name;

	@FindBy(xpath="//input[@name='last_name']")
	WebElement last_name;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement SaveIcon;

	/*@FindBy(xpath = "//a[contains(text(),'boby naik')]")
	WebElement bobyContact;*/

	//inititalizing PageObject
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();	
	}


	public void clickOnContactByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]/preceding-sibling::td/div")).click();

	}

	public void createNewContact(String First_name,String Last_name,String role) throws InterruptedException {
		//driver.findElement(By.name("first_name")).sendKeys(First_name);
		first_name.sendKeys(First_name);
		last_name.sendKeys(Last_name);
       // driver.findElement(By.name("last_name")).sendKeys("Last_name");
	//	Select select=new Select(driver.findElement(By.xpath("//div[@class='ui field']")));
	//  select.selectByVisibleText(role);
	 /*   List<WebElement> list=driver.findElements(By.xpath("//div[@class='ui field']"));
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().contains(role)) {
				System.out.println(list.get(i).getText());
				list.get(i).click();
				Thread.sleep(3000);
				
			}*/
		driver.findElement(By.xpath("//div[@name='category']")).click();
		driver.findElement(By.xpath("//div//span[contains(text(),'"+role+"')]")).click();
		SaveIcon.click();
		
		}
			
	}

