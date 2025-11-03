package com.crm.Practise;

import org.testng.annotations.Test;

public class ExpOnInvocationCount 
{
	@Test(invocationCount = 2)
    public void CreateContact() 
		{
        System.out.println("Create the  contact");
    	}
    @Test(invocationCount = 4)
    public void CreateOrganisation() 
    {
        System.out.println("Create the organisation");
   	 }
}
