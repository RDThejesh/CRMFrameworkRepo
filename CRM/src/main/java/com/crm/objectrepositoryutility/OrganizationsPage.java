package com.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement Orgnametxtbox;
	
	@FindBy(id="phone")
	private WebElement Phonetxtbox;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void EnterOrgDetails(String Orgname)
	{
		Orgnametxtbox.sendKeys(Orgname);
		savebtn.click();
	}

}
