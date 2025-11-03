package com.crm.Orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.crm.objectrepositoryutility.HomePage;
import com.crm.objectrepositoryutility.LoginPage;
import com.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrgWithName {

	public static void main(String[] args) throws IOException 
	{
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		String BR=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String UN=fLib.getDataFromPropertiesFile("username");
		String PWD=fLib.getDataFromPropertiesFile("password");
	
	String orgname= eLib.getDataFromExcel("org", 1, 2);
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	
	LoginPage lp= new LoginPage(driver);
	lp.LoginToApp(URL,UN,PWD);
	
	HomePage hp = new HomePage(driver);
	hp.ClickOnOrganisationLink();
		
	CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	cnop.ClickAddOrgButton();
	
	OrganizationsPage Op= new OrganizationsPage(driver);
	Op.EnterOrgDetails("Face2Fce_Book");

	}
}
