package PageObjects;

import org.testng.annotations.Test;

/**
 * @param : None
 *          Last modified by :
 * @author : Rupesh
 * created date :15 May 2018
 */

public class RegistrationTests extends BaseSetup{
	
	public RegistrationTests(String FilePath) {
		super(FilePath);
		// TODO Auto-generated constructor stub
	}

	static RegistrationPage registrationPage;
	static LandingPage landingPage;
	
	/**
     * This method is to test the register
     *
     * @param : None
     *          Last modified by :
     * @author : Rupesh
     * created date :15 May 2018
     */
	
	@Test
	public static void registerUser() throws Exception {
		
		landingPage.clickRegisterbtn();
		
		registrationPage.enterRegisterDetailsAndSubmit();
		registrationPage.clickRegister();
		
	}

}
