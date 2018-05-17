package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @param : None
 *          Last modified by :
 * @author : Rupesh
 * created date :15 May 2018
 */

public class LandingPageTests {
	
	static BaseSetup baseSetup;
	static LandingPage landingPage;

	/**
     * This method is to test the search feature
     *
     * @param : None
     *          Last modified by :
     * @author : Rupesh
     * created date :15 May 2018
     */
	
	@Test
	public static void searchTest() {
		/*landingPage.searchForAnything("iPhone 6");
		WebElement searchHeader = baseSetup.androidDriver.findElement(By.id("com.ebay.mobile:id/textview_header_title"));
		String actualSearchHeader = searchHeader.getText();
		String expectedSearchHeader = "Shop by Colour";
		Assert.assertEquals(actualSearchHeader, expectedSearchHeader);*/

	}

}
