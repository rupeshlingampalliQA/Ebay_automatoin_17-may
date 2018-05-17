package PageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @param : None
 *          Last modified by :
 * @author : Rupesh
 * created date :15 May 2018
 */

public class BaseSetup {

    private DesiredCapabilities capabilities = new DesiredCapabilities();
    public static AndroidDriver<MobileElement> androidDriver;
    Properties properties;
    private String appiumPort = "4723";
    private String serverIp = "127.0.0.1";
    
     /**
     * This method is initiating driver before every test class
     *
     * @param : None
     *          Last modified by :
     * @author : Rupesh
     * created date :15 May 2018
     * @throws InterruptedException 
     * @throws IOException 
     */
    
    
    @BeforeClass
    public void setup() throws InterruptedException, IOException{
        initDriver();
    }

    public static AndroidDriver<MobileElement> getDriver() {
    	System.out.println("get driver");
        return androidDriver;
    }
    
    
  
    private void initDriver() throws MalformedURLException{
        System.out.println("Inside initDriver method");

        capabilities.setCapability("AUTOMATION_NAME", "Appium");
        capabilities.setCapability("deviceName", "Redmi Note 4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");        
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
        capabilities.setCapability(MobileCapabilityType.APP, "E://Rupesh//appium//ebay11.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ebay.mobile.activities.MainActivity" );
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ebay.mobile");
        capabilities.setCapability("noReset", true);        
        String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";
       
        try
        {
            System.out.println("Argument to driver object : " + serverUrl);
            androidDriver = new AndroidDriver<MobileElement>(new URL(serverUrl), capabilities);
            androidDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        }
        catch (NullPointerException | MalformedURLException ex) {
            throw new RuntimeException("appium driver could not be initialised for device ");
        }
        System.out.println("Driver in initdriver is : "+androidDriver);

    }
    
    
    public BaseSetup(String FilePath) {

		try {
			FileInputStream Locator = new FileInputStream(FilePath);
			properties = new Properties();
			properties.load(Locator);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getData(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String data = properties.getProperty(ElementName);
		return data;
	}
    
	public By getLocator(String ElementName) throws Exception {
		// Read value using the logical name as Key
		String locatorType = properties.getProperty(ElementName);
		
		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorType);
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorType);
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return By.className(locatorType);
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return By.className(locatorType);
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorType);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorType);
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorType);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorType);
		else
			throw new Exception("Locator type '" + locatorType
					+ "' not defined!!");
		
	}
    
    /**
     * This method is closing driver after every test class
     *
     * @param : None
     *          Last modified by :
     * @author : Rupesh
     * created date :15 May 2018
     */

    @AfterClass
    public void tearDown(){
        androidDriver.quit();
    	
    }

}