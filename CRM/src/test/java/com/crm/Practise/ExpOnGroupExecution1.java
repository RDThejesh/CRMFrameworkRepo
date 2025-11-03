package com.crm.Practise;

import org.testng.annotations.Test;

public class ExpOnGroupExecution1 
{
	@Test(groups = {"smoke","regression"})
    public void LoginToFBApp() {
        System.out.println("User login successfully in facebook");
    }
	@Test(groups = "Regression")
    public void FB_PostImage() {
        System.out.println("Image posted successfully in facebook");
    }

}
