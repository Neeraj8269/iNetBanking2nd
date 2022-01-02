package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.beust.jcommander.Parameters;

import pageObjects.LoginPage;



public class BaseClass{
	
	ReadConfig readConfig = new ReadConfig();
	
	public static WebDriver driver;
	public static Properties prop;
	public String uname = readConfig.getUserName();
	public String pwd = readConfig.getPassword();
	public static Logger logger;
	
	@BeforeClass
	public WebDriver InitializeDriver() throws IOException {
	
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./"+"\\Configuration\\config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
	    System.out.println(browserName);
	    
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	else if(browserName.contains("firefox"))
			{   
		       System.setProperty("webdriver.firefox.driver", "./"+"\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			
			}
	
	logger = Logger.getLogger("eBanking");
	PropertyConfigurator.configure("log4j.properties");
	
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    return driver;
    
	}
	@AfterClass
	public WebDriver teardown()
	{
		driver.quit();
		return driver;
	}
	
	public void Takeascreenshot(String result) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("./"+"\\Screenshots\\"+result+ "Screnshot.png"));
		
	}

	public WebDriver manageAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return driver;
	}
	
	public WebDriver Login()
	{
		LoginPage logins = new LoginPage(driver);
		logins.setUserName(uname);
		logins.setPassword(pwd);
		logins.setclickSubmit();
		return driver;
	
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("./Screenshots\\"+ tname + ".png" ));
		System.out.println("Screenshot Taken");
	}
	
	public boolean isAlertPresnt()
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(e);
			return false;
		}
		
	   
	}
	
}
