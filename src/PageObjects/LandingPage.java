package PageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This class is created to store element locators and functions of landing page
 *
 * @author : Rupesh
 * created date :15 May 2018
 */

public class LandingPage {

	static BaseSetup baseSetup;
	

	/**
	 * This method is used to click sign in button on landing page
	 *
	 * @param : None
	 *          Last modified by :
	 * @author : Rupesh
	 * created date :15 May 2018
	 * @throws Exception 
	 */

	public static void clickSignInbtn() throws Exception {

		baseSetup = new BaseSetup("user.dir" + "\\Default.properties");
		WebElement signInBtn = baseSetup.androidDriver.findElement(baseSetup.getLocator("signInBtnID"));
		signInBtn.isDisplayed();
		signInBtn.click();
	}

	/**
     * This method is to click register button on landing page
     *
     * @param : None
     *          Last modified by :
     * @author : Rupesh
     * created date :15 May 2018
     */
	
	public static void clickRegisterbtn() throws Exception {
		baseSetup = new BaseSetup("user.dir" + "\\Default.properties");
		WebElement registerBtn = baseSetup.androidDriver.findElement(baseSetup.getLocator("registerBtnID"));
		registerBtn.isDisplayed();
		registerBtn.click();
	}

	/**
     * This method is to search keyword
     *
     * @param : None
     *          Last modified by :
     * @author : Rupesh
     * created date :15 May 2018
	 * @throws Exception 
     */
	
	public static void searchForAnything(String keyword) throws Exception {
		baseSetup = new BaseSetup("user.dir" + "\\Default.properties");
		WebElement searchBox = baseSetup.androidDriver.findElement(baseSetup.getLocator("searchBox"));
		searchBox.sendKeys(keyword);
		WebElement serachResult = baseSetup.androidDriver.findElement(By.partialLinkText(keyword));
		serachResult.click();


	}


}
