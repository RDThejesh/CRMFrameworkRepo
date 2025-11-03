package com.crm.Orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;

public class CreateOrgwithNameAndIndustry {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		String BR=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String UN=fLib.getDataFromPropertiesFile("username");
		String PWD=fLib.getDataFromPropertiesFile("password");
	
	String orgname= eLib.getDataFromExcel("org", 4, 1);
	String industryData =eLib.getDataFromExcel("org", 4, 3);
	String typeData=eLib.getDataFromExcel("org", 4, 4);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		
		//Industry DDown value selecting
		WebElement inddd= driver.findElement(By.xpath("//select[@name='industry']"));
		Select s = new Select(inddd);
		s.selectByVisibleText(industryData);
		
		//type DDown value selecting
		WebElement typeDD = driver.findElement(By.name("accounttype"));
		Select s1= new Select(typeDD);
		s1.selectByVisibleText(typeData);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String ind = driver.findElement(By.id("dtlview_Industry")).getText();
		if(ind.equals(industryData))
		{
			System.out.println(industryData +" info is available and pass");
		}
		else
		{
			System.out.println(industryData +" info is  not available and fail");
		}
	}

}
