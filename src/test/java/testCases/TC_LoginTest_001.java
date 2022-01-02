package testCases;


import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.LoginPage;
import utilities.BaseClass;


public class TC_LoginTest_001 extends BaseClass
{
    
	@Test
	public void loginTest() throws IOException 
	{   
		
			
		//logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("Entered username");
		
		lp.setPassword(pwd);
		logger.info("Entered password");
		
		lp.setclickSubmit();
		
		 
		
		
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		
		}
		else
		{   
			captureScreen(driver, "LoginTest");
			System.out.println(driver.getTitle());
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		
			
		}
		lp.setclickLogout();
		driver = manageAlert();
		
		

	}
}
