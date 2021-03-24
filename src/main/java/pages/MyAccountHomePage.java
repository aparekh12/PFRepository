package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.relevantcodes.extentreports.ExtentTest;

import base.BasePage;

public class MyAccountHomePage extends BasePage{
	
/*	WebDriver driver = null;
	ExtentTest eTest = null;
*/	
	@FindBy(id="taskEmergenciesspan-0")
	public WebElement PayMyBill;
	
	
	@FindBy(id="taskEmergenciesspan-1")
	public WebElement ReportOutage;
	
	
	/*@FindBy(linkText ="LOGOUT")
	public WebElement logout;*/
	
	@FindBy(id ="accountLogoutLink")
	public WebElement logout;
	
	
	@FindBy(id="MyAccount")
	public WebElement myaccount;
	
	
	@FindBy(className ="Ways to Pay")
	public WebElement WaystoPay;
	
	//Constructor code
	
	public MyAccountHomePage(WebDriver driver, ExtentTest eTest) {
		
		this.driver = driver;
		this.eTest = eTest;
	}
	
	
	
	//verify method define
	
	public boolean verifyMyAccountLogin() {
		
		//below methind call is define in Base Page- parent=optimize code
		
		return isElementPresent(myaccount);
	
		
		/*
		boolean displaystatus = myaccount.isDisplayed();
		if(displaystatus) {
			return true;
		}else {
			return false;
		}*/
		
	}
	
	public void gotoMyAccount() {
		
		//selenium code
	
		
		
	}
	
	public void logout(WebDriver driver) {
		
		//Selenium code
		
		logout.click();
		
			}

	
public void gotoWaystoPay() {
		
		//selenium code
		
	

}




}
