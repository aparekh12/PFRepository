package tests.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import util.Constants;
import util.ExtentManager;

public class BaseTest {
	
	//Global declaration of webdriver and reporting variables
	 public WebDriver driver = null;
	 
	 public ExtentReports eReport = ExtentManager.getInstance();
	 public ExtentTest eTest = null;
	
	

	public void openBrowser(String  browserType) {
		
		   if(browserType.equalsIgnoreCase("firefox")) {
			
			
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER);
			 driver = new FirefoxDriver();
			
			}else if(browserType.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
				 driver = new ChromeDriver();	
				
			}else if(browserType.equalsIgnoreCase("ie")){
				
				System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER);
				 driver = new InternetExplorerDriver();	
		
			}
		
		   //Below log code line for open browser
		   eTest.log(LogStatus.INFO,"Successfully opened the Browser  " + browserType);
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   
		   
		  }
	
	
	public void reportPass(String message) {
		
		eTest.log(LogStatus.PASS, message);
	}
	
	public void reportFail(String message) {
		
		eTest.log(LogStatus.FAIL, message);
		//take screenshot method is call which define in this below
		takeScreenshot();
		
		Assert.fail(message);
		
	}
	
	public void takeScreenshot() {
		
		//fileName of the screenshot
		
		Date d = new Date();
		
		String screenshotFile = d.toString().replace(":","_").replace("","_") + ".png";
		//store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			//common-io JAR needed
			FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		//put screenshot file into the report
	
		eTest.log(LogStatus.INFO,"SCREENSHOT- > " + eTest.addScreenCapture(System.getProperty("user.dir") + "//screenshots"+screenshotFile));
		
		
		
	}
	
	
}