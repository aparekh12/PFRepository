package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {

	
	public WebDriver driver = null;
	public ExtentTest eTest = null;
	
	public boolean isElementPresent(WebElement element) {
		
		boolean displayStatus = element.isDisplayed();
		if(displayStatus) {
			
			return true;
		}else {
			
			return false;
		}
		
		
	}
	
	
}
