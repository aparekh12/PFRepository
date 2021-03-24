package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;
import util.Constants;

public class LoginPage extends BasePage {
	
/*	WebDriver driver = null;
	ExtentTest eTest = null;
*/	
	
	
	@FindBy(id="username")
	public WebElement txtusername;
	
	
	@FindBy(id="password")
	public WebElement txtpassword ;
	
	@FindBy(id="submit")
	public WebElement btnsubmit ;
	
	
	@FindBy(id="forgotUserPwdLink")
	public WebElement forgotUserPwdLink ;
	
	//Constructor
	
	public LoginPage(WebDriver driver, ExtentTest eTest) {
		
		this.driver = driver;
		this.eTest = eTest;
		
		
	}
	
	
	
	
	public boolean doMyAccountLogin() {
		
		txtusername.sendKeys(Constants.USERNAME);
		eTest.log(LogStatus.INFO,"username entered");
		txtpassword.sendKeys(Constants.PASSWORD);
		eTest.log(LogStatus.INFO,"password entered");
		btnsubmit.click();
		eTest.log(LogStatus.INFO,"Login button got click");
		
		//after this we get myaccount home page so object of that page created
		MyAccountHomePage myaccountHP = new MyAccountHomePage(driver,eTest);
		//initialize home page elements code below
		PageFactory.initElements(driver, myaccountHP);
		
		//verify login success or not
		
		boolean loginStatus = myaccountHP.verifyMyAccountLogin();
		return loginStatus;
		
		
		
	}
	

	

}
