package com.HRM.Generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsListPage 
{
	
	@FindBy(xpath="//span[text()='Create Project']")
	private WebElement CreateProjectBtn;

	@FindBy(xpath="//input[@name='projectName']")
	private WebElement projectNameTfield;
	
	@FindBy(xpath="//input[@name='createdBy']")
	private WebElement projManTfield;
	
	@FindBy(xpath="(//select[@name='status'])[2]")
	private WebElement ProjStatusDD;
	
	@FindBy(xpath="//input[@value='Add Project']")
	private WebElement AddProjectBtn;
	
	@FindBy(xpath="(//input[@value='Cancel'])[3]")
	private WebElement CancelBtn;
	
	@FindBy(xpath="(//select[@class='form-control'])[1]")
	private WebElement SearchByDD;
	
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	private WebElement SearchByTfield;
	
	@FindBy(xpath="//tr[@class='tr']/td[2]")
	private WebElement createdProjectName;
	
	
	
	public ProjectsListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}

	public void getCreateProjectBtn() {
		 CreateProjectBtn.click();
	}

	public WebElement getProjectNameTfield() {
		return projectNameTfield;
	}

	public WebElement getProjManTfield() {
		return projManTfield;
	}

	public WebElement getProjStatusDD() {
		return ProjStatusDD;
	}

	public WebElement getAddProjectBtn() {
		return AddProjectBtn;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getSearchByDD() {
		return SearchByDD;
	}

	public WebElement getSearchByTfield() {
		return SearchByTfield;
	}

	public WebElement getCreatedProjectName() {
		return createdProjectName;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
