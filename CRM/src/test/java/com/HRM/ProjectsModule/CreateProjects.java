package com.HRM.ProjectsModule;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.Generic.ObjectRepositoryUtility.DashBoardPage;
import com.HRM.Generic.ObjectRepositoryUtility.EmployeesListPage;
import com.HRM.Generic.ObjectRepositoryUtility.HRM_LoginPage;
import com.HRM.Generic.ObjectRepositoryUtility.ProjectsListPage;
import com.HRM.Generic.WebDriverUtility.HRMWebDriverUtility;
import com.HRM.Generic.fileUtility.ExlUtility;
import com.HRM.Generic.fileUtility.JVUtility;
import com.HRM.Generic.fileUtility.PFileUtility;


public class CreateProjects 
{
 public static String ProjName=null;
	@Test
	public void Creating_Projects() throws IOException, InterruptedException
	{
		
		
		JVUtility jLib = new JVUtility();
		 ProjName = "Instakart_"+ jLib.getRandomNumber();
		
	PFileUtility PfLib = new PFileUtility();
	ExlUtility eLib = new ExlUtility();
	
	String BR=PfLib.getDataFromPropertiesFile("browser");
	String URL=PfLib.getDataFromPropertiesFile("url");
	String UN=PfLib.getDataFromPropertiesFile("username");
	String PWD=PfLib.getDataFromPropertiesFile("password");
//	String expectedProjName="AAAmazon";

	WebDriver driver = new FirefoxDriver();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


	HRM_LoginPage HRMlp= new HRM_LoginPage(driver);
	HRMlp.LoginToHRMApp(URL, UN, PWD);
	
	
	DashBoardPage dbp = new DashBoardPage(driver);
	dbp.ClickOnProjectsBtn();
	
	
	ProjectsListPage plp = new ProjectsListPage(driver);
	plp.getCreateProjectBtn();
	plp.getProjectNameTfield().sendKeys(ProjName);
	plp.getProjManTfield().sendKeys("AAAmazonProjManager");
	
	
	HRMWebDriverUtility wdu = new HRMWebDriverUtility();
	wdu.select(plp.getProjStatusDD(), "OnGoing");
	
	plp.getAddProjectBtn().click();
	
	Thread.sleep(5000);
	plp.getSearchByDD().click();
	wdu.select(plp.getSearchByDD(),"Search by Project Name");
	
	plp.getSearchByTfield().sendKeys(ProjName);
	boolean flag=false;
	
	String actualprojName = plp.getCreatedProjectName().getText();
	if(actualprojName.equals(ProjName))
	{
		System.out.println(" created Project is availble");
		flag=true;
	}
	else
	{
		System.out.println("created Project is not  availble");
	}
	Assert.assertEquals(flag, true);
	
	Thread.sleep(4000);
	dbp.ClickOnEmployeesBtn();
	Thread.sleep(1000);
	
	EmployeesListPage elp = new EmployeesListPage(driver);
	elp.getAddNewEmpBtn().click();
	String employeename="Raam_"+jLib.getRandomNumber();
	elp.getNameTfield().sendKeys(employeename);
	Thread.sleep(1000);
	
	elp.getEmailTfield().sendKeys("Raam"+jLib.getRandomNumber()+"@gmail.com");
	Thread.sleep(1000);
	
	elp.getPhoneTfield().sendKeys("9874569874");
	Thread.sleep(1000);
	
	elp.getUserNameTfield().sendKeys("Raam-"+jLib.getRandomNumber()+"CH");
	Thread.sleep(1000);
	
	elp.getDesignationTfield().sendKeys("TeamLead");
	Thread.sleep(1000);
	
	elp.getExperienceTfield().sendKeys("8");
	Thread.sleep(1000);
	
	//HRMWebDriverUtility wdu = new HRMWebDriverUtility();
	wdu.select(elp.getSelectProjectDD(), CreateProjects.ProjName);
	
	Thread.sleep(1000);
	elp.getAddBtn().click();
	
	
	Thread.sleep(5000);
	
	driver.navigate().refresh();
	
	wdu.select(elp.getSelectEmpbyTypeDD(), "Search by Name");
	
	elp.getSearchEmpTfield().sendKeys(employeename);
	
		Thread.sleep(6000);
	
	
	boolean flag1=false;
	String actualEmpName = driver.findElement(By.xpath("//tr/td[3]")).getText();
	if(actualEmpName.equals(employeename))
	{
		System.out.println(" created employee is availble");
		flag1=true;
	}
	else
	{
		System.out.println("created employee is not  availble");
	}
	Assert.assertEquals(flag, true);
	
	Thread.sleep(6000);
	driver.close();
}
}

