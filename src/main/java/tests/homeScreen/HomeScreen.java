/**
 * Created by Shahar Sheinfeld on 09/06/2020.
 **/
package tests.homeScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;

public class HomeScreen extends TestHelpers
{
	
	@AndroidFindBy(accessibility = "mm_buttons_scrollview")
	@iOSXCUITFindBy(accessibility = "mm_buttons_scrollview")
	MobileElement home_screen_buttons;
	
	@AndroidFindBy(accessibility = "coviddisclaimer_approve")
	@iOSXCUITFindBy(accessibility = "coviddisclaimer_approve")
	MobileElement accept_corona_disclaimer;
	
	@AndroidFindBy(accessibility = "homepage.intent.corona_assess")
	@iOSXCUITFindBy(accessibility = "homepage.intent.corona_assess")
	MobileElement coronavirus_tracking_button;
	
	@AndroidFindBy(accessibility = "homepage.intent.symptom_search")
	@iOSXCUITFindBy(accessibility = "homepage.intent.symptom_search")
	MobileElement check_my_symptom_button;
	
	@AndroidFindBy(accessibility = "home.menu.covid_asses")
	@iOSXCUITFindBy(accessibility = "home.menu.covid_asses")
	MobileElement menu_covid_assesment;
	
	@AndroidFindBy(accessibility = "corona.labs.webview")
	@iOSXCUITFindBy(accessibility = "corona.labs.webview")
	MobileElement corona_labs_webview;
	
	
	public HomeScreen(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnCoronaScreenButtonByText(String buttonText)
	{
		if (!isIOS)
			corona_labs_webview.isDisplayed();
		clickOnButtonByText(corona_labs_webview, buttonText);
		sleep(500);
	}
	
	public void clickOnCoronaScreenButtonByTextContained(String buttonText)
	{
		if (!isIOS)
			corona_labs_webview.isDisplayed();
		
		clickOnButtonByTextContained(corona_labs_webview, buttonText);
	}


//	public void clickOnCoronaScreenButtonByText(String buttonText, String elementType )
//	{
//		if (!isIOS)
//			corona_labs_webview.isDisplayed();
//
//		clickOnButtonByText(corona_labs_webview, buttonText, elementType);
//	}
	
	public void isTextDisplayedOnWebView(String text)
	{
		checkIfTextEqualsToTextOnScreen(corona_labs_webview, text);
	}
	
	public void searchForLabLocation(String location)
	{
		corona_labs_webview.isDisplayed();
		clickOnButtonByText(corona_labs_webview, "Search testing location address");
		if (isIOS)
			driver.findElementByXPath("*//XCUIElementTypeTextField").sendKeys(location);
		else
			driver.findElementByXPath("*//android.widget.EditText").sendKeys(location);
		sleep(500);
	}
	
	public void clickOnFirstTestingLocation()
	{
		if (isIOS)
			driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Coronavirus Testing Centers & Symptom Heat Map | K Health\"]/XCUIElementTypeOther[8]").click();
		else
			driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"corona.labs.webview\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit" +
											  ".WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View[1]\n").click();
		sleep(1000);
	}
	
	public void verifyTitleText(String text)
	{
		if (isIOS)
			driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"Coronavirus tracking\"])[3]").getText().equals(text);
		else
			driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"health_chat_new\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView").getText().equals(text);
	}
	
	public void clickOnHomeScreenButton_CheckMySymptoms()
	{
		check_my_symptom_button.click();
	}
	
	public void clickOnMenuCovidAssessment()
	{
		menu_covid_assesment.click();
	}
	
	public void clickOnHomeScreenButton_CoronavirusTracking()
	{
		coronavirus_tracking_button.click();
	}
	
	public void coronaVirusAcceptDisclaimer()
	{
//		if (!isIOS)
//			accept_corona_disclaimer.isDisplayed();
		
		accept_corona_disclaimer.click();
		sleep(500);
	}
}
