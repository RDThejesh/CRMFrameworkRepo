package com.crm.BaseTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.generic.databaseUtility.DataBaseUtility;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.webDriverUtility.JavaUtility;
import com.crm.generic.webDriverUtility.WebDriverUtility;
import com.crm.objectrepositoryutility.HomePage;
import com.crm.objectrepositoryutility.LoginPage;

public class BaseClass
{
	public DataBaseUtility dblib = new DataBaseUtility(); 
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public HomePage hp;
	public static WebDriver sdriver = null;
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws SQLException
	{
		System.out.println("Connect to DB, Report config");
		dblib.getDbconnection();	
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws IOException
	{
		System.out.println("Launch the browser");
		String BROWSER = flib.getDataFromPropertiesFile("browser");	
		/*String BROWSER = 
		 System.getProperty("browser",flib.getDataFromPropertiesFile("browser"));*/
        if(BROWSER.equals("chrome"))
        {
        	driver = new ChromeDriver();
        }
        else if(BROWSER.equals("firefox"))
        {
        	driver = new FirefoxDriver();
        }
        else if(BROWSER.equals("edge"))
        {
        	driver = new EdgeDriver();
        }
        else 
        {
        	driver = new ChromeDriver();
        }
        sdriver = driver;
        //UtilityClassObject.setDriver(driver);
         hp = new HomePage(driver);
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException
	{
		System.out.println("Login to application");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		/*String URL = p..getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		*/
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL,USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() throws InterruptedException
	{
		System.out.println("Logout from application");	
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("Close the browser");
		driver.quit();
	}

	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException
	{
		System.out.println("close DB, Report backup");
		dblib.closeDbconnection();
		
	}
}

//,flib.getDataFromPropertiesFile("username")

//flib.getDataFromPropertiesFile("password")