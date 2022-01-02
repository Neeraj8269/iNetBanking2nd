package testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.BaseClass;
import utilities.XLUtils;

public class TC_LoginDataDriven_003 extends BaseClass{
     
	@Test(dataProvider="LoginData")
	public void LoginData(String user, String pwd) throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.setUserName(user);
		logger.info("Username is provided");
		login.setPassword(pwd);
		logger.info("Password is Provided");
		login.setclickSubmit();
		logger.info("Clicked on Login button");
		Thread.sleep(3000);
		
		if(isAlertPresnt()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Success");
			login.setclickLogout();
			Thread.sleep(3000);
			logger.info("Clicked on Logout link");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	
	}
	
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}