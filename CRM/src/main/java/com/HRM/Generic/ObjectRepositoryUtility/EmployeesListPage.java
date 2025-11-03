package com.HRM.Generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeesListPage 
{
	@FindBy(xpath="//span[text()='Add New Employee']")
	private WebElement AddNewEmpBtn;
	
	@FindBy(xpath="//label[text()='Name*']/../input")
	private WebElement NameTfield;
	
	@FindBy(xpath="//label[text()='Email*']/../input")
	private WebElement EmailTfield;
	
	@FindBy(xpath="//label[text()='Phone*']/../input")
	private WebElement PhoneTfield;
	
	@FindBy(xpath="//label[text()='Username*']/../input")
	private WebElement UserNameTfield;
	
	@FindBy(xpath="//label[text()='Designation*']/../input")
	private WebElement DesignationTfield;
	
	@FindBy(xpath="//label[text()='Experience*']/../input")
	private WebElement ExperienceTfield;
	
	@FindBy(xpath="//select[@name='project']")
	private WebElement selectProjectDD;
	
	@FindBy(xpath="//input[@value='Add']")
	private WebElement AddBtn;
	
	@FindBy(xpath="(//input[@value='Cancel'])[3]")
	private WebElement CancelBtn;
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement SelectEmpbyTypeDD;
	
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	private WebElement SearchEmpTfield;
	
	public EmployeesListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}

	public WebElement getAddNewEmpBtn() {
		return AddNewEmpBtn;
	}

	public WebElement getNameTfield() {
		return NameTfield;
	}

	public WebElement getEmailTfield() {
		return EmailTfield;
	}

	public WebElement getPhoneTfield() {
		return PhoneTfield;
	}

	public WebElement getUserNameTfield() {
		return UserNameTfield;
	}

	public WebElement getDesignationTfield() {
		return DesignationTfield;
	}

	public WebElement getExperienceTfield() {
		return ExperienceTfield;
	}

	public WebElement getSelectProjectDD() {
		return selectProjectDD;
	}

	public WebElement getAddBtn() {
		return AddBtn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getSelectEmpbyTypeDD() {
		return SelectEmpbyTypeDD;
	}

	public WebElement getSearchEmpTfield() {
		return SearchEmpTfield;
	}

	
	
	
	
	
}
