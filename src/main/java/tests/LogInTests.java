/**
 * Created by Shahar Sheinfeld on 23/12/2019.
 **/
package tests;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import tests.logIn.LogIn;
import utils.CapabilitiesHelper;

import java.net.URL;

import static tests.FileHelpers.LOCAL_IOS_DEBUG_APP_PATH;

public class LogInTests extends TestSetup
{
	
	/* https://kanghealthio.atlassian.net/browse/KE-5604 */
	@Test (groups = { "Sanity" })
	public void LoginWithPhoneNumber()
	{
		LogIn logIn = new LogIn(driver);
		String phoneCode = "000150";
		String phoneNumber = "+972540" + phoneCode;
		logIn.alreadyHaveKaccountButton();
		logIn.clickOnAcceptButton();
		logIn.insertPhoneNumber(phoneNumber);
		logIn.insertCode(phoneCode);
		logIn.isMeButtonDisplayed();
	}
	
	
	@Test
	public void loginUserWithEmail() throws InterruptedException
	{
		String email;
		String password;
		if (isIos)
			email = "qa.khealth@yahoo.com";
		else
			email = "qa.khealth1@yahoo.com";
		password = "QaAutomation123!";
		newIOSDriverWithWebCapabilities(port, emulator);
		LogIn logIn = new LogIn(driver);
		logIn.switchToBrowser();
		logIn.goToEmailPage();
		logIn.seBrowsertEmailAddress(email);
		logIn.setBrowserEmailPassword(password);
		logIn.deleteAllEmails();
		logIn.switchToNativeApp();
		logIn.alreadyHaveKaccountButton();
		logIn.clickOnAcceptButton();
		logIn.clickOnLoginWithEmailLink();
		logIn.setEmailAddress(email);
		logIn.clickNextButton();
		logIn.isTextFoundOnEmailScreen(email);
		logIn.switchToBrowser();
		logIn.openEmailLinkToApp();
		logIn.switchToNativeApp();
		logIn.verifySearchSymptomWindow();
	}
	
//	@AfterMethod
//	public static void afterTest()
//	{
//		if (isIos)
//		{
//			driver.removeApp(appPackageName);
//			driver.installApp(appPath);
//		}
//	}

	public static void newIOSDriverWithWebCapabilities(String port, String emulator)
	{
		if (isIos)
		{
			try
			{
				driver.quit();
				DesiredCapabilities capabilities = CapabilitiesHelper.capabilitiesForIphoneWebSimulator(LOCAL_IOS_DEBUG_APP_PATH, emulator, port);
				driver = new IOSDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
