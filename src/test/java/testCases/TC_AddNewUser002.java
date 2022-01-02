package testCases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.AddNewCustomer;
import utilities.BaseClass;

public class TC_AddNewUser002 extends BaseClass {

	@Test
	public void AddingCustomers() throws IOException, AWTException, InterruptedException
	{  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(2);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Neeraj");
		Thread.sleep(2);
		List<WebElement> suggestion= driver.findElements(By.xpath("//div[@class=\"OBMEnb\"]/ul/li"));
		for (WebElement names:suggestion)
		{
			System.out.println(names.getText());
			if(names.getText().contains("Neeraj Pandey"))
			{
				names.click();	
				break;
			}
		}
//		
		
		
		
//		driver = InitializeDriver();
//		driver = Login();
//		AddNewCustomer addnew = new AddNewCustomer(driver);
//	    Robot robot = new Robot();
//	    robot.delay(1500);
//	    robot.mouseMove(300, 600);
//	    robot.delay(6000);
//	    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//	    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//	    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//	    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	    
//	     Thread.sleep(7000);
//		driver.get("http://demo.guru99.com/V4/manager/Managerhomepage.php");
//	    WebDriverWait wait = new WebDriverWait(driver, 15);
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("name")));
//		addnew.getClickNewCustomer();
//		addnew.getcusName("Neeraj");
//		addnew.getDOB("25041994");
//		addnew.getAddress("This is the address field");
//		addnew.getcity("Patna");
//		addnew.getState("Bihar");
//		addnew.getpin("800007");
//		String randomNo = "99346"+randomeNum();
//		addnew.getTelephone(randomNo);
//		String randomEmail = randomestring()+"@gmail.com";
//		addnew.getemail(randomEmail);
//		addnew.getPassword("Test@123");
//		addnew.getSubmit();
//		assertEquals(driver.findElement(By.cssSelector("p[class='heading3']")).getText(), "Customer Registered Successfully!!!");

	}
	

}
