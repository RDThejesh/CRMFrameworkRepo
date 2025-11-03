package com.crm.Contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;

public class CreateContactWithLastNameTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//create Object
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		String BR=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String UN=fLib.getDataFromPropertiesFile("username");
		String PWD=fLib.getDataFromPropertiesFile("password");
		
	String LastName = eLib.getDataFromExcel("contact", 1, 2);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		
		String ContConfirmmsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContConfirmmsg.contains(LastName))
		{
			System.out.println(LastName +" is created and pass");
		}
		else
		{
			System.out.println(LastName +" is not created and fail");
		}
			

	}

}
