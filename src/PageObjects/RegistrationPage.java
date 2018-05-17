package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @param : None
 *          Last modified by :
 * @author : Rupesh
 * created date :15 May 2018
 */

public class RegistrationPage {

	static BaseSetup baseSetup;

	/**
     * This method is to enter registration button
     *
     * @param : None
     *          Last modified by :
     * @author : Rupesh
     * created date :15 May 2018
	 * @throws Exception 
     */
	
	public static void enterRegisterDetailsAndSubmit() throws Exception {
		baseSetup = new BaseSetup("user.dir" + "\\Default.properties");
		WebElement firstNameInput = baseSetup.androidDriver.findElement(baseSetup.getLocator("firstNameInput"));
		firstNameInput.isDisplayed();
		firstNameInput.sendKeys("firstname");

		WebElement lastNameInput = baseSetup.androidDriver.findElement(baseSetup.getLocator("lastNameInput"));
		lastNameInput.sendKeys("lastname");
		WebElement emailInput = baseSetup.androidDriver.findElement(baseSetup.getLocator("emailInput"));
		emailInput.sendKeys("email@gmail.com");
		WebElement password = baseSetup.androidDriver.findElement(baseSetup.getLocator("password"));
		password.sendKeys("password");

	}

	/**
     * This method is to click register button
     *
     * @param : None
     *          Last modified by :
     * @author : Rupesh
     * created date :15 May 2018
	 * @throws Exception 
     */
	
	public void clickRegister() throws Exception {
		WebElement registerBtn = baseSetup.androidDriver.findElement(baseSetup.getLocator("registerBtn"));
		registerBtn.click();

	}

}
