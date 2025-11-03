package com.crm.Practise;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ExpOnDataProvider 
{
	@Test(dataProvider = "getData" )
    public void LoginToFBApp(String UName,String Job) 
	{
        System.out.println("Username is: "+ UName +"  And his job is: "+ Job);
    }
	
	 @DataProvider
	public Object[][] getData()
	{
		Object[][] objArray = new Object[3][2];
		objArray[0][0]="Raam";
		objArray[0][1]="CEO";
		objArray[1][0]="Pavan";
		objArray[1][1]="HR";
		objArray[2][0]="Lakshamn";
		objArray[2][1]="MD";
		return objArray;
	}
}
