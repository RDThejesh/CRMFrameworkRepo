package com.crm.Practise;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseTest.BaseClass;

@Listeners(com.crm.ListnerUtility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass
{
	@Test
	public void createInvoiceTest()
	{
		System.out.println("Execute invoice Test");
		String actTitle=driver.getTitle();
		AssertJUnit.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	@Test
	public void createInvoiceWithContactTest()
	{
		System.out.println("ExecutecreateInvoiceWithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	}

}
