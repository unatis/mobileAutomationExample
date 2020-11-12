/**
 * Created by Shahar Sheinfeld on 26/07/2020.
 **/
package tests.welcomeScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;
import utils.CapabilitiesHelper;

public class WelcomeScreen extends TestHelpers
{
	
	@AndroidFindBy(accessibility = "welcome.new")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"welcome.new\"`]")
	@iOSXCUITFindBy(accessibility = "welcome.new")
	MobileElement startButton;
	
	@AndroidFindBy(accessibility = "tos.accept")
	@iOSXCUITFindBy(accessibility = "tos.accept")
	MobileElement acceptButton;
	
	@AndroidFindBy(accessibility = "text_input_footer")
	@iOSXCUITFindBy(accessibility = "text_input_footer")
	MobileElement setUserName;
	
	@AndroidFindBy(accessibility = "submit_input_button")
	@iOSXCUITFindBy(accessibility = "submit_input_button")
	MobileElement submitInput;
	
	@AndroidFindBy(accessibility = "option_0")
	@iOSXCUITFindBy(accessibility = "option_0")
	MobileElement male;
	
	@AndroidFindBy(accessibility = "chat_screen.tapToRespond")
	@iOSXCUITFindBy(accessibility = "chat_screen.tapToRespond")
	MobileElement female, no, show_results, sure_lets_start;
	
	@AndroidFindBy(accessibility = "first_wheel_picker")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypePicker[`name == \"first_wheel_picker\"`]")
	@iOSXCUITFindBy(accessibility = "first_wheel_picker")
	MobileElement firstWheelPicker;
	
	@AndroidFindBy(accessibility = "wheelpicker-submit")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"wheelpicker-submit\"`]")
	@iOSXCUITFindBy(accessibility = "wheelpicker-submit")
	MobileElement wheelPickerSubmit;
	
	@AndroidFindBy(accessibility = "email_input_footer")
	@iOSXCUITFindBy(accessibility = "email_input_footer")
	MobileElement email;
	
	@AndroidFindBy(accessibility = "cancel_search")
	@iOSXCUITFindBy(accessibility = "cancel_search")
	MobileElement cancelSearch;
	
	
	@AndroidFindBy(accessibility = "footer.container")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"footer.container\"`]")
	@iOSXCUITFindBy(accessibility = "footer.container")
	MobileElement chatScreenfooterContainer;
	
	@AndroidFindBy(accessibility = "meAvatar")
	@iOSXCUITFindBy(accessibility = "meAvatar")
	MobileElement meButton;
	
	@AndroidFindBy(accessibility = "chat_screen.tapToRespond")
	@iOSXCUITFindBy(accessibility = "chat_screen.tapToRespond")
	MobileElement continueButton;
	
	@AndroidFindBy(accessibility = "screen.me")
	@iOSXCUITFindBy(accessibility = "screen.me")
	MobileElement screenMe;
	
	@AndroidFindBy(accessibility = "kmd_promo_button")
	@iOSXCUITFindBy(accessibility = "kmd_promo_button")
	MobileElement get_started;
	
	@AndroidFindBy(accessibility = "chatList")
	@iOSXCUITFindBy(accessibility = "chatList")
	MobileElement chatList;
	
	@AndroidFindBy(accessibility = "footer.container")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"footer.container\"`]")
	@iOSXCUITFindBy(accessibility = "footer.container")
	MobileElement footerContainer;
	
	@AndroidFindBy(accessibility = "last_answer")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"last_answer\"`]")
	@iOSXCUITFindBy(accessibility = "last_answer")
	MobileElement last_answer;
	
	@AndroidFindBy(accessibility = "welcome.employee.login")
	@iOSXCUITFindBy(accessibility = "welcome.employee.login")
	MobileElement k_logo;
	
	@AndroidFindBy(accessibility = "first_wheel_picker")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypePicker[`name == \"first_wheel_picker\"`]")
	@iOSXCUITFindBy(accessibility = "first_wheel_picker")
	MobileElement first_wheel_picker;
	
	@AndroidFindBy(accessibility = "symptom_search")
	@iOSXCUITFindBy(accessibility = "symptom_search")
	MobileElement symptomSearch;
	
	@AndroidFindBy(accessibility = "menu_button")
	@iOSXCUITFindBy(accessibility = "menu_button")
	MobileElement menu_button;
	
	@AndroidFindBy(accessibility = "language.button")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"language.button\"`]")
	@iOSXCUITFindBy(accessibility = "language.button")
	MobileElement language_button;
	
	@AndroidFindBy(accessibility = "navigation_back")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "navigation_back")
	MobileElement navigation_back;
	
	
	public WelcomeScreen(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void changeCountryOnDebugScreen(String country)
	{
		startButton.isDisplayed();
		sleep(4000);
		startButton.isDisplayed();
		WebElement elem = driver.findElementByAccessibilityId("welcome.employee.login");
		for (int i = 0; i < 5; i++)
		{
			elem.click();
		}
		driver.findElementByAccessibilityId("backendmodifier.debug").click();
		driver.findElementByAccessibilityId("debuginfo.menu.geoconfig").click();
		String state = driver.findElementByAccessibilityId("geo.toggle").getText();
		if (state.equals("OFF") || state.equals("0"))
			driver.findElementByAccessibilityId("geo.toggle").click();
		setWheelPickerValue(country, first_wheel_picker);
		wheelPickerSubmit.click();
		driver.findElementByAccessibilityId("selected.geo." + country.toUpperCase()).isDisplayed();
		navigation_back.click();
		sleep(500);
		navigation_back.click();
		resetApp();
	}
	
	public void changeLanguage(String language)
	{
		startButton.isDisplayed();
		language_button.click();
		setWheelPickerValue(language, first_wheel_picker);
		wheelPickerSubmit.click();
		sleep(3000);
		startButton.isDisplayed();
	}
	
	public void isButtonWithTextDisplayed(String buttonText)
	{
		checkIfTextEqualsToTextOnScreen(startButton, buttonText);
	}
	
	public void checkGlobusButtonText(String text)
	{
		checkIfTextEqualsToTextOnScreen(language_button, text);
	}
	
	public AppiumDriver newIOSDriverWithCapabilityNoResetTrue()
	{
		return newIOSDriverWithCapability(CapabilitiesHelper.capabilitiesForIphoneSimulatorNoReset(appPath, emulator, port));
	}
	
	public AppiumDriver defaultIOSDriverCapabilities()
	{
		return newIOSDriverWithCapability(CapabilitiesHelper.capabilitiesForIphoneSimulator(appPath, emulator, port));
	}
	
}
