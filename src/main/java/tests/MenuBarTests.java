package tests;

import menuBar.MenuBar;
import org.testng.annotations.Test;
import tests.logIn.LogIn;
import tests.onBoarding.OnBoarding;
import tests.welcomeScreen.WelcomeScreen;

/**
 * Created by Shahar Sheinfeld on 17/08/2020.
 **/

public class MenuBarTests extends TestSetup
{
	
	/* https://kanghealthio.atlassian.net/browse/KE-7846 */
	@Test(groups = {"Functional"})
	public void K_IL_LoginFromTheMenu()
	{
		String name = "K_IL_LoginFromTheMenu";
		String gender = "Male";
		String year = "1990";
		String phoneCode = "000160";
		String phoneNumber = "+972540" + phoneCode;
		resetAppiumDriverOnFailureIfIos = true;
		
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
		driver = welcomeScreen.newIOSDriverWithCapabilityNoResetTrue();
		if (isIos)
			welcomeScreen = new WelcomeScreen(driver);
		
		OnBoarding onBoarding = new OnBoarding(driver);
		
		welcomeScreen.changeCountryOnDebugScreen("IL");
		welcomeScreen.changeLanguage("עברית");
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.setName(name);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.setYear(year);
		onBoarding.closePopUp();
		onBoarding.clickSymptomSearch();
		onBoarding.cancelSymptomSearch();
		
		MenuBar menuBar = new MenuBar(driver);
		menuBar.clickOnMenuButton();
		menuBar.clickOnMenuAccount();
		menuBar.clickOnMenuAccountLogin();
		
		LogIn logIn = new LogIn(driver);
		logIn.insertPhoneNumber(phoneNumber);
		logIn.insertCode(phoneCode);
		menuBar.clickOnMenuButton();
		menuBar.checkIfMaccabiLoginButtonDisplayed();
	}
	
//	/* https://kanghealthio.atlassian.net/browse/KE-7845 */
//	@Test(groups = {"Functional"})
//	public void K_IL_CreatingAccountFromTheMenu()
//	{
//		String name = "K_IL_CreatingAccountFromTheMenu";
//		String gender = "Male";
//		String year = "1990";
//		String phoneCode = isIos ? "000155" : "000156";
//		String phoneNumber = "+972540" + phoneCode;
//		resetAppiumDriverOnFailureIfIos = true;
//
//		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
//		driver = welcomeScreen.newIOSDriverWithCapabilityNoResetTrue();
//		if (isIos)
//			welcomeScreen = new WelcomeScreen(driver);
//
//		OnBoarding onBoarding = new OnBoarding(driver);
//
//		welcomeScreen.changeCountryOnDebugScreen("IL");
//		welcomeScreen.changeLanguage("עברית");
//		onBoarding.clickOnStartButton();
//		onBoarding.clickOnAcceptButton();
//		onBoarding.setName(name);
//		onBoarding.selectMaleOrFemale(gender);
//		onBoarding.setYear(year);
////		onBoarding.closePopUp();
//		onBoarding.clickSymptomSearch();
//		onBoarding.cancelSymptomSearch();
//
//		MenuBar menuBar = new MenuBar(driver);
//		menuBar.clickOnMenuButton();
//		menuBar.clickOnMenuAccount();
//		menuBar.clickOnMenuCreateAccount();
//
//		LogIn logIn = new LogIn(driver);
//		logIn.insertPhoneNumber(phoneNumber);
//		logIn.insertCode(phoneCode);
//		menuBar.checkIfLogOutButtonIsDisplayed();
//	}
	
	/* https://kanghealthio.atlassian.net/browse/KE-7838 */
	@Test(groups = {"Functional"})
	public void K_IL_NoMaccabiButtonInTheMenuForGuestUsers()
	{
		String name = "K_IL_NoMaccabiButtonInTheMenuForGuestUsers";
		String gender = "Male";
		String year = "1990";
		String phoneCode = isIos ? "000155" : "000156";
		String phoneNumber = "+972540" + phoneCode;
		resetAppiumDriverOnFailureIfIos = true;
		
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
		driver = welcomeScreen.newIOSDriverWithCapabilityNoResetTrue();
		if (isIos)
			welcomeScreen = new WelcomeScreen(driver);
		
		OnBoarding onBoarding = new OnBoarding(driver);
		
		welcomeScreen.changeCountryOnDebugScreen("IL");
		welcomeScreen.changeLanguage("עברית");
		onBoarding.clickOnStartButton();
		onBoarding.clickOnAcceptButton();
		onBoarding.setName(name);
		onBoarding.selectMaleOrFemale(gender);
		onBoarding.setYear(year);
//		onBoarding.closePopUp();
		onBoarding.clickSymptomSearch();
		onBoarding.cancelSymptomSearch();
		
		MenuBar menuBar = new MenuBar(driver);
		menuBar.clickOnMenuButton();
		menuBar.isMaccabiLoginButtonDisplayed(false);
		menuBar.clickOnMenuAccount();
		menuBar.clickOnMenuCreateAccount();
		
		LogIn logIn = new LogIn(driver);
		logIn.insertPhoneNumber(phoneNumber);
		logIn.insertCode(phoneCode);
		menuBar.checkIfLogOutButtonIsDisplayed();
		menuBar.clickOnBackButton();
		menuBar.clickOnMenuButton();
		menuBar.isMaccabiLoginButtonDisplayed(true);
	}
	
}
