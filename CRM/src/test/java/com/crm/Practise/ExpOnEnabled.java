package com.crm.Practise;

import org.testng.annotations.Test;

public class ExpOnEnabled 
{
	@Test(enabled=false)
    public void CreateContact() 
		{
        System.out.println("Create the  contact");
    	}
    @Test()
    public void CreateOrganisation() 
    {
        System.out.println("Create the organisation");
   	 }
}
