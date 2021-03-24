package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;

import pages.LaunchPage;
import tests.base.BaseTest;
import util.Constants;


//This is a Login test

public class LoginTest extends BaseTest{
	
	//All test case is child class of BaseTest Class. See above extends key
	
	//write test cases code here. using TestNG
	//login  test case : launch app, click on login and singnin
	
	//Globalize paraments of reporting
	//move this below declaration in Base test Class as global for all test case class
	//ExtentReports eReport = null;
	//ExtentTest eTest = null;
	
	@Test
	public void testLogin() {
		
		//code to get report and since in ExtentManager class getInstance() method is static
		//we can call as below here in test case, classname.methodname
		
		
	//	eReport = ExtentManager.getInstance();		
		eTest = eReport.startTest("LoginTest");
		eTest.log(LogStatus.INFO, "Login Test has started");
	
	//openbrowser
		
		openBrowser(Constants.BROWSER_TYPE);
		
		
	//create LauncPage object because it is in together package class
	//pass driver and eTest by creating constructor in LAUNCH PAGE CLASS
		LaunchPage launchpage = new LaunchPage(driver, eTest);
		
		//Initialize ELEMENTS OF LAUNCH PAGE.
		PageFactory.initElements(driver, launchpage);
		
		boolean loginstatus = launchpage.gotoPSEGRegisterLoginPage();
		if(loginstatus) {
			//Pass the test case
			
			reportPass("LoginTest Testcase PASS");
			
			
		}else {
			//Fail the test case
			reportFail("LoginTest Testcase FAILED");
			
		}
		
				
		
	}

	@AfterMethod
	public void testClouser() {
		if(eReport!=null) {
			
			eReport.endTest(eTest);//ending report
			eReport.flush();//push logs block into report
			
			
		}
		
	  if(driver!=null) {
		  
		  driver.quit();
	  }
	
	
}
	
	}
