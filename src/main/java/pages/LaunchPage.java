package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;
import util.Constants;

public class LaunchPage extends BasePage {
	
	
	/*WebDriver driver = null;
	ExtentTest eTest = null;
	*/
	
	//Webelements of PSEG Launch page
	
	@FindBy(id = "PSEGCorporate")
	public WebElement PSEGCORPORATE;
	
	@FindBy(id = "NJPublic")
	public WebElement PSEGNJ;
	
	@FindBy(id="LIPublic")
	public WebElement PSEGLONGILAND;
	
	@FindBy(id="PSEGPower")
	public WebElement PSEGPOWER;
	
	@FindBy(className="nav-login")
	public WebElement PSEGRegisterLogin;
	
	//Constructor code below with below instance variable paraments define
	
	public LaunchPage(WebDriver driver, ExtentTest eTest) {
		
		this.driver = driver;
		this.eTest = eTest;
		
		
		
	}
	
	//Reusable methods of Launch Page
	
	
	
	public boolean gotoPSEGRegisterLoginPage() {
		
		//code take to the login page WITH url
		driver.get(Constants.APP_URL);
		eTest.log(LogStatus.INFO,"Application URL  " + Constants.APP_URL+ " got opened");
		//below webelement is define in upward
		PSEGRegisterLogin.click();
		eTest.log(LogStatus.INFO,"Click on Login Success");
		
		//after this we go to Login page so create object of LoginPage		
		LoginPage loginpage = new LoginPage(driver,eTest);
		//initialize he login page elements below code
		PageFactory.initElements(driver, loginpage);
		//calling method define in loginpage
		//flow is Launch page ro login page to myaccount home page
	   boolean loinstatus = 	loginpage.doMyAccountLogin();
		return loinstatus;
		
		}
	
     public void gotoPSEGLONGILANDPage() {
		
		//code take to the PSEGLONGILAND page
		
		
		
		}
	
     public void gotoPSEGNJPage() {
 		
 		//code take to the PSEGLONGNJ page
 		
 		
 		
 		}
     
     public void gotoPSEGCORPORATEPage() {
  		
  		//code take to the PSEGCORPORATE page
  		
  		
  		
  		}
     
     public void gotoPSEGPOWERPage() {
   		
   		//code take to the PSEGPOWER page
   		
   		
   		
   		}
	

}
