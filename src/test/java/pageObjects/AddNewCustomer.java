package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	public WebDriver driver;

	  public AddNewCustomer(WebDriver driver)
	  {
		 this.driver = driver; 
		 PageFactory.initElements(driver, this);
		  
		}
	  
	  @FindBy(how = How.XPATH, using = "//a[contains(text(),'New Customer')]")
	  @CacheLookup
	  WebElement newCustomer;
	  
	  @FindBy(how = How.NAME, using = "name")
	  @CacheLookup
	  WebElement cusNames;
	  
	  
	  @FindBy(how = How.XPATH, using = "//input[@value = 'f']")
	  @CacheLookup
	  WebElement FRadio;
	  
	  @FindBy(how = How.NAME, using = "dob")
	  @CacheLookup
	  WebElement DOB;
	  
	  @FindBy(how = How.NAME, using = "addr")
	  @CacheLookup
	  WebElement Address;
	  
	  
	  @FindBy(how = How.NAME  , using= "city" )
	  @CacheLookup
	  WebElement city;
	  
	  @FindBy(how = How.NAME  , using = "state")
	  @CacheLookup
	  WebElement state;
	  
	  @FindBy(how = How.NAME , using = "pinno")
	 @CacheLookup
	 WebElement pin;
	  
	  @FindBy(how = How.NAME , using = "telephoneno")
	  @CacheLookup
	  WebElement telephone;
	  
	  @FindBy(how = How.NAME , using = "emailid")
	  @CacheLookup
	  WebElement email;
	  
	  @FindBy(how = How.NAME , using = "password")
	  @CacheLookup
	  WebElement password;
	  
	  @FindBy(how = How.XPATH , using = "//input[@value='Submit']")
	  @CacheLookup
	  WebElement submit;
	  
	  
	  
	  public void getClickNewCustomer()
	  {
		  newCustomer.click();
	  }
	  
	  public void getcusName(String cusname)
	  {
		  cusNames.sendKeys(cusname);
	  }
	  
	  public void getFRadio()
	  {
		  FRadio.click();
	  }
	  
	  public void getDOB(String dob)
	  {
		  DOB.sendKeys(dob);
	  }
	  
	  public void getAddress(String cname)
	  {
		  Address.sendKeys(cname);
	  }
	  
	  public void getcity(String cname)
	  {
		  city.sendKeys(cname);
	  }
	  
	  public void getState(String states)
	  {
		  state.sendKeys(states);
	  }
	  public void getpin(String cname)
	  {
		  pin.sendKeys(cname);
	  }
	  
	  public void getTelephone(String telephones)
	  {
		  telephone.sendKeys(telephones);
	  }
	  
	  
	  public void getemail(String cname)
	  {
		  email.sendKeys(cname);
	  }
	  
	  public void getPassword(String cname)
	  {
		  password.sendKeys(cname);
	  }
	  
	  
	  
	  public void getSubmit()
	  {
		  submit.click();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
