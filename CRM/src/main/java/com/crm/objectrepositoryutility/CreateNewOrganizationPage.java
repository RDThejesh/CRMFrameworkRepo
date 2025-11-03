package com.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage 
{
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement AddOrgPlusbtn;
	
	@FindBy(xpath="//img[@alt='Search in Organizations...']")
	private WebElement searchOrgsrchBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickAddOrgButton()
	{
		AddOrgPlusbtn.click();
	}

}
