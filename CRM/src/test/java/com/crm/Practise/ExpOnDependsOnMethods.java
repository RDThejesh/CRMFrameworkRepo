package com.crm.Practise;

import org.testng.annotations.Test;

public class ExpOnDependsOnMethods 
{
	   @Test()
	    public void ModifyContact() 
	{
	        System.out.println("Modify the contact");
	    	}
	    @Test(dependsOnMethods="ModifyContact")
	    public void DeleteContact() 
	{
	        System.out.println("Delete the contact");
	   	 }
}


