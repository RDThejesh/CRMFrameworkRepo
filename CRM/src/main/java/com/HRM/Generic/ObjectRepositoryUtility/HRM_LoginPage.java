package com.HRM.Generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRM_LoginPage 
{
	@FindBy(xpath="//input[@id='username']")
	private WebElement usernameEdt;
	
	@FindBy(xpath="//input[@id='inputPassword']")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement SignInbtn;
	
	public HRM_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}
	
	public void LoginToHRMApp(String url, String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		SignInbtn.click();
	}
	
	

}
