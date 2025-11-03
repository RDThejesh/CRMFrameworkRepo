package com.crm.Practise;

import org.testng.annotations.Test;

public class ExpOnGroupExecution2 
{
	@Test(groups = "smoke")
    public void LoginToInstaApp() {
        System.out.println("User login successfully in Insta");
    }
	@Test(groups = "Regression")
    public void Insta_PostImage() {
        System.out.println("Image posted successfully in Insta");
    }
}
