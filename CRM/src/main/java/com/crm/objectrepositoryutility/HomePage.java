package com.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	@FindBy(xpath="(//a[text()='Calendar'])[1]")
	private WebElement Calendarlink;
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement Organizationslink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement Contactslink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickOnOrganisationLink()
	{
		Organizationslink.click();
	}
	
	

}
