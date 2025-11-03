package com.HRM.EmployeeModule;

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
import com.HRM.Generic.WebDriverUtility.HRMWebDriverUtility;
import com.HRM.Generic.fileUtility.ExlUtility;
import com.HRM.Generic.fileUtility.PFileUtility;
import com.HRM.ProjectsModule.CreateProjects;

public class CreateEmployee 
{
	@Test(dependsOnMethods = "com.HRM.ProjectsModule.CreateProjects.ProjName")
	public void Creating_Employee() throws IOException, InterruptedException
	{
		PFileUtility PfLib = new PFileUtility();
		ExlUtility eLib = new ExlUtility();
		
		String BR=PfLib.getDataFromPropertiesFile("browser");
		String URL=PfLib.getDataFromPropertiesFile("url");
		String UN=PfLib.getDataFromPropertiesFile("username");
		String PWD=PfLib.getDataFromPropertiesFile("password");
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		HRM_LoginPage HRMlp= new HRM_LoginPage(driver);
		HRMlp.LoginToHRMApp(URL, UN, PWD);
	
		DashBoardPage dbp = new DashBoardPage(driver);
		dbp.ClickOnEmployeesBtn();
		Thread.sleep(1000);
		
		EmployeesListPage elp = new EmployeesListPage(driver);
		elp.getAddNewEmpBtn().click();
		String employeename="Raam";
		elp.getNameTfield().sendKeys(employeename);
		Thread.sleep(1000);
		
		elp.getEmailTfield().sendKeys("Raam@gmail.com");
		Thread.sleep(1000);
		
		elp.getPhoneTfield().sendKeys("9874569874");
		Thread.sleep(1000);
		
		elp.getUserNameTfield().sendKeys("Raam47");
		Thread.sleep(1000);
		
		elp.getDesignationTfield().sendKeys("TeamLead");
		Thread.sleep(1000);
		
		elp.getExperienceTfield().sendKeys("8");
		Thread.sleep(1000);
		
		HRMWebDriverUtility wdu = new HRMWebDriverUtility();
		wdu.select(elp.getSelectProjectDD(), CreateProjects.ProjName);
		
		Thread.sleep(1000);
		elp.getAddBtn().click();
		
		
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		
		wdu.select(elp.getSelectEmpbyTypeDD(), "Search by Name");
		
		elp.getSearchEmpTfield().sendKeys(employeename);
		
	Thread.sleep(6000);
		
		
		boolean flag=false;
		String actualEmpName = driver.findElement(By.xpath("//tr/td[3]")).getText();
		if(actualEmpName.equals(employeename))
		{
			System.out.println(" created employee is availble");
			flag=true;
		}
		else
		{
			System.out.println("created employee is not  availble");
		}
		Assert.assertEquals(flag, true);
		
		Thread.sleep(4000);
		driver.close();
}
}

//(dependsOnMethods = "com.HRM.ProjectsModule.CreateProjects.ProjName")