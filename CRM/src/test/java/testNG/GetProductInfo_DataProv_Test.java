package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.generic.fileUtility.ExcelUtility;

public class GetProductInfo_DataProv_Test 
{
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName, String productName)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("brandName",Keys.ENTER);

		String x ="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/a/span[1]/span/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}
	
	@DataProvider
	public Object[] [] getData() throws Throwable
	{
	ExcelUtility elib = new ExcelUtility();
	int rowcount = elib.getRowCount("product");
	Object[][] objArr = new Object[rowcount][2];
	
	for(int  i=0; i<rowcount;i++)
	{
	
	objArr[i][0] = elib.getDataFromExcel("product", i+1, 0);
	objArr[i][1] = elib.getDataFromExcel("product", i+1, 1);
	}
	return objArr;
				

}
}

