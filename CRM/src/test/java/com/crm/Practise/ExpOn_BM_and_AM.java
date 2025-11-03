package com.crm.Practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpOn_BM_and_AM 
{
	
	@BeforeClass
	public void OpenBrowser()
	{
		System.err.println("Launch Browser++++@BC annotation++++");
	}
	@AfterClass
	public void CloseBrowser()
	{
		System.err.println("Close Browser++++@AC annotation++++");
	}
	@AfterMethod
	public void LogOut()
	{
		System.out.println("Executing Logout ----@AM annotation----");
	}
	
	@BeforeMethod
	public void LogIn()
	{
		System.out.println("Executing Log In ----@BM annotation----");
	}
	@Test
	public void Post_IMG_FB()
	{
		System.out.println("Posting an image in facebook");
	}
	@Test
	public void Post_Quote_FB()
	{
		System.out.println("Posting an quote  in FB");
	}
}
