package tests;

import org.testng.annotations.Test;
import tests.welcomeScreen.WelcomeScreen;

/**
 * Created by Shahar Sheinfeld on 19/11/2019.
 **/

public class WelcomeScreenTests extends TestSetup
{
	
	/* https://kanghealthio.atlassian.net/browse/KE-7476 */
	@Test (groups = { "Sanity" })
	public void K_US_SupportedLanguages()
	{
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
		welcomeScreen.isButtonWithTextDisplayed("Get started");
		welcomeScreen.checkGlobusButtonText("English");
		
		welcomeScreen.changeLanguage("עברית");
		welcomeScreen.isButtonWithTextDisplayed("התחלה");
		welcomeScreen.checkGlobusButtonText("עברית");
		
		welcomeScreen.changeLanguage("Español");
		welcomeScreen.isButtonWithTextDisplayed("Comenzar");
		welcomeScreen.checkGlobusButtonText("Español");
	}
	
	/* https://kanghealthio.atlassian.net/browse/KE-7482 */
	@Test (groups = { "Sanity" })
	public void K_IL_SupportedLanguages()
	{
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
		driver = welcomeScreen.newIOSDriverWithCapabilityNoResetTrue();
		welcomeScreen = new WelcomeScreen(driver);
		
		welcomeScreen.changeCountryOnDebugScreen("IL");
		welcomeScreen.changeLanguage("עברית");
		welcomeScreen.isButtonWithTextDisplayed("התחלה");
		welcomeScreen.checkGlobusButtonText("עברית");
		
		welcomeScreen.changeLanguage("English");
		welcomeScreen.isButtonWithTextDisplayed("Get started");
		welcomeScreen.checkGlobusButtonText("English");
		
		driver = welcomeScreen.defaultIOSDriverCapabilities();
	}
	
	/* https://kanghealthio.atlassian.net/browse/KE-7483 */
	@Test (groups = { "Sanity" })
	public void K_ID_SupportedLanguages()
	{
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
		driver = welcomeScreen.newIOSDriverWithCapabilityNoResetTrue();
		welcomeScreen = new WelcomeScreen(driver);
		
		welcomeScreen.changeCountryOnDebugScreen("ID");
		welcomeScreen.changeLanguage("Indonesia");
		welcomeScreen.isButtonWithTextDisplayed("Memulai");
		welcomeScreen.checkGlobusButtonText("Indonesia");
		
		driver = welcomeScreen.defaultIOSDriverCapabilities();
	}
}
