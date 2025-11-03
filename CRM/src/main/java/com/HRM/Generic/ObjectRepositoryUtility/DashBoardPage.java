package com.HRM.Generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage 
{
	@FindBy(xpath="//a[text()='Projects']")
	private WebElement projectsBtn;
	
	@FindBy(xpath="//a[text()='Employees']")
	private WebElement EmployeesBtn;
	
	public DashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}
	
	public void ClickOnProjectsBtn()
	{
		  projectsBtn.click();
	}
	
	public void ClickOnEmployeesBtn()
	{
		 EmployeesBtn.click();
	}
	

}
