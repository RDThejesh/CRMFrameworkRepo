package com.crm.Contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws IOException 
	{
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
		
		Date dateobj = new Date(0);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String startdate=sim.format(dateobj);
		
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String endDate = sim.format(cal.getTime());
		
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		WebElement SupSDWE=driver.findElement(By.name("support_start_date"));
		SupSDWE.clear();
		SupSDWE.sendKeys(startdate);
		
		WebElement SupEDWE=driver.findElement(By.name("support_end_date"));
		SupEDWE.clear();
		SupEDWE.sendKeys(endDate);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
		String ActStartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		
		if(ActStartdate.equals(startdate))
		{
			System.out.println(startdate +" is created and pass");
		}
		else
		{
			System.out.println(startdate +" is not created and fail");
		}
		
		
		String ActEnddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				
				if(ActEnddate.equals(endDate))
				{
					System.out.println(endDate +" is created and pass");
				}
				else
				{
					System.out.println(endDate +" is not created and fail");
				}
		
	}

}

