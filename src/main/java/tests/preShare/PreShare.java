/**
 * Created by Shahar Sheinfeld on 05/07/2020.
 **/
package tests.preShare;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;

import java.util.List;

public class PreShare extends TestHelpers
{
	
	@AndroidFindBy(accessibility = "popup_drawer_scroll")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"popup_drawer_scroll\"`]")
	@iOSXCUITFindBy(accessibility = "popup_drawer_scroll")
	MobileElement cta_disclaimer;
	
	@AndroidFindBy(accessibility = "first_wheel_picker")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypePicker[`name == \"first_wheel_picker\"`]")
	@iOSXCUITFindBy(accessibility = "first_wheel_picker")
	MobileElement first_wheel_picker;
	
	@AndroidFindBy(accessibility = "footer.container")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"footer.container\"`]")
	@iOSXCUITFindBy(accessibility = "footer.container")
	MobileElement footerContainer;
	
	
	@AndroidFindBy(accessibility = "wheelpicker-submit")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"wheelpicker-submit\"`]")
	@iOSXCUITFindBy(accessibility = "wheelpicker-submit")
	MobileElement wheelPickerSubmit;
	
	@AndroidFindBy(accessibility = "app")
	@iOSXCUITFindBy(accessibility = "app")
	MobileElement app;
	
	@AndroidFindBy(accessibility = "chat_screen.tapToRespond")
	@iOSXCUITFindBy(accessibility = "chat_screen.tapToRespond")
	MobileElement lastButton;
	
	@AndroidFindBy(accessibility = "open_camera_button")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"open_camera_button\"`]")
	@iOSXCUITFindBy(accessibility = "open_camera_button")
	MobileElement open_camera;
	
	@AndroidFindBy(accessibility = "phone_input_vnet")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeTextField[`name == \"phone_input_vnet\"`]")
	@iOSXCUITFindBy(accessibility = "phone_input_vnet")
	MobileElement phone_input_vnet;
	
	@AndroidFindBy(accessibility = "phone_input")
	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeTextField[`name == \"phone_input\"`]")
//	@iOSXCUITFindBy(accessibility = "phone_input")
	MobileElement phone_input;
	
	@AndroidFindBy(accessibility = "next_button_account_phone")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"next_button_account_phone\"`]")
	@iOSXCUITFindBy(accessibility = "next_button_account_phone")
	MobileElement next_button_account_phone;
	
	@AndroidFindBy(accessibility = "phone_prompt_next_button")
	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"phone_prompt_next_button\"`]")
//	@iOSXCUITFindBy(accessibility = "phone_prompt_next_button")
	MobileElement phone_prompt_next_button;
	
	
	@AndroidFindBy(accessibility = "take_picture_button")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"take_picture_button\"`]")
	@iOSXCUITFindBy(accessibility = "take_picture_button")
	MobileElement take_picture_button;
	
	@AndroidFindBy(accessibility = "latest_response_0")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"latest_response_0\"`]")
	@iOSXCUITFindBy(accessibility = "latest_response_0")
	MobileElement general_information_window, last_response;
	
	@AndroidFindBy(accessibility = "offer_item_card_plan")
	@iOSXCUITFindBy(accessibility = "offer_item_card_plan")
	MobileElement offer_item_card_plan;
	
	@AndroidFindBy(accessibility = "chatList")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"chatList\"`]")
	@iOSXCUITFindBy(accessibility = "chatList")
	MobileElement chatList;
	
	@AndroidFindBy(accessibility = "offer_screen")
	@iOSXCUITFindBy(accessibility = "offer_screen")
	MobileElement offer_screen;
	
	@AndroidFindBy(accessibility = "navigation_back")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "navigation_back")
	MobileElement back_erow;
	
	@AndroidFindBy(accessibility = "kmd_promo_tos_scroll")
	@iOSXCUITFindBy(accessibility = "kmd_promo_tos_scroll")
	MobileElement vip_offer_disclaimer;
	
	@AndroidFindBy(accessibility = "latest_response_1")
	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"latest_response_1\"`]")
//	@iOSXCUITFindBy(accessibility = "latest_response_1")
	MobileElement latest_response_1;
	
	
	public PreShare(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void checkTextFoundOnCTADisclaimer(String text)
	{
		if (!isIOS)
			cta_disclaimer.isDisplayed();
		
		checkIfTextExistsOnScreen(cta_disclaimer, text);
		sleep(500);
	}
	
	public void checkTextFoundOnOfferCardBecomeAvipLearnMoreDisclaimer(String text)
	{
		if (!isIOS)
			vip_offer_disclaimer.isDisplayed();
		
		checkIfTextExistsOnScreen(vip_offer_disclaimer, text);
	}
	
	public void checkIfDoctorUnavailableMessageFoundOnScreen(String text)
	{
		if (!isIOS)
			lastButton.isDisplayed();
		
		checkIfTextExistsOnScreen(app, text);
	}
	
	public void clickOnPreShareDisclaimerAcceptButton()
	{
		driver.findElementByAccessibilityId("info_disclaimer_button").click();
		sleep(500);
	}
	
	public void isWheelPickerDisplayed()
	{
		first_wheel_picker.isDisplayed();
	}
	
	
	public void clickOnGotItButton()
	{
		lastButton.click();
		sleep(500);
	}
	
	public void checkStatePickerVisible()
	{
		first_wheel_picker.isDisplayed();
	}
	
	public void changeState(String language)
	{
		setWheelPickerValue(language, first_wheel_picker);
		wheelPickerSubmit.click();
		sleep(500);
	}
	
	public void clickOnFooterButton(String buttonText)
	{
		if (!isIOS)
			footerContainer.isDisplayed();
		clickOnButtonByText(footerContainer, buttonText);
//		sleep(500);
	}
	
	public void clickOnOpenCameraButton()
	{
		open_camera.isDisplayed();
		open_camera.click();
		sleep(500);
	}
	
	public void clickBackErow()
	{
		back_erow.click();
	}
	
	public void allowTakePicture()
	{
		if (!isIOS)
		{
			try
			{
				driver.findElementByXPath("//android.widget.Button[1]").click();
				sleep(500);
			}
			catch (Exception e)
			{
			
			}
		}
	}
	
	public void closeCameraWithX()
	{
		if (isIOS)
			driver.findElementByAccessibilityId("Close").click();
		else
			driver.findElementById("defaultBackButton").click();
		
		sleep(500);
		
		driver.findElementByAccessibilityId("skip_scan_id_button").click();
	}
	
	public void userDetails(String firstName, String lastName)
	{
		driver.findElementByAccessibilityId("first_name_text_input").sendKeys(firstName);
		driver.findElementByAccessibilityId("last_name_text_input").sendKeys(lastName);
		driver.findElementByAccessibilityId("date_touchable_input").click();
		sleep(500);
		if (isIOS)
			wheelPickerSubmit.click();
		else
			lastButton.click();
		sleep(500);
		driver.findElementByAccessibilityId("next_button_account_details").click();
		sleep(500);
		driver.findElementByAccessibilityId("next_button_account_email").click();
		sleep(500);
	}
	
	public void insertPhoneNumberUS(String phone)
	{
		if (isIOS)
			next_button_account_phone.click();
		phone_input_vnet.clear();
		phone_input_vnet.setValue(phone);
		next_button_account_phone.click();
	}
	
	public void insertPhoneNumberIL(String phone)
	{
//		if (isIOS)
//			next_button_account_phone.click();
		phone_input.clear();
		phone_input.setValue(phone);
		phone_prompt_next_button.click();
	}
	
	public void insertCode(String phone)
	{
		String attribute = isIOS ? "name" : "content-desc";
		for (int i = 1; i <= phone.length(); i++)
		{
			String num = String.valueOf(phone.charAt(i - 1));
			driver.findElementByXPath("(//*[@" + attribute + "=\"code_input_field\"])[" + i + "]").sendKeys(num);
		}
	}
	
	public void takeAPicture()
	{
		if (isIOS)
			driver.findElementByAccessibilityId("OK").click();
		
		take_picture_button.click();
		driver.findElementByAccessibilityId("review_picture_button").click();
		sleep(500);
	}
	
	public void isButtonWithTextDisplayed(String buttonText)
	{
		if(!isIOS)
			footerContainer.isDisplayed();
		String[] expectedTextArray = buttonText.split("\\|");
		
		for (int i = 0; i < expectedTextArray.length; i++)
			checkIfTextEqualsToTextOnScreen(footerContainer, expectedTextArray[i]);
	}
	
	public void clickByTextInGeneralInformationWindow(String text)
	{
		clickOnButtonByText(general_information_window, text);
	}
	
	public void checkTextFoundOnPreShareOptionPlan(String text)
	{
		String attribute = isIOS ? "label" : "text"; //for iOS it can be: "value" and "name"
		if (!isIOS)
			offer_item_card_plan.isDisplayed();
		
		checkIfMultipleStringsSeperatedByPipeFoundOnScreen(offer_item_card_plan, text, attribute);
	}
	
	public void clickOnTextFoundOnPreShareOptionPlan(String text)
	{
		String attribute = isIOS ? "label" : "text"; //for iOS it can be: "value" and "name"
		if (!isIOS)
			offer_item_card_plan.isDisplayed();
		
		if (isIOS)
		{
			List<WebElement> elements = driver.findElementsByXPath("//*[@" + attribute + "=\"" + text + "\"]");
			elements.get(1).click();
		}
		else
			offer_item_card_plan.findElementByXPath("//*[@" + attribute + "=\"" + text + "\"]").click();


//		clickOnButtonByText(offer_item_card_plan, text);
//		sleep(500);
	}
	
	public void clickOnContinueButtonOnOptionPlanScreen()
	{
		driver.findElementByAccessibilityId("offer_screen_continue_button").click();
//		sleep(500);
	}
	
	public void addNewCardAndPay()
	{
		if (isIOS)
		{
			driver.findElementByAccessibilityId("card number").sendKeys("4242424242424242");
			driver.findElementByAccessibilityId("expiration date").sendKeys("0424");
			driver.findElementByAccessibilityId("CVC").sendKeys("242");
			implicitWait(2000);
			try
			{
				driver.findElementByAccessibilityId("Zip Code").sendKeys("42424");
			}
			catch (Exception e)
			{
				driver.findElementByAccessibilityId("Postal Code").sendKeys("42424");
			}
			implicitWait(defaultWaitTime);
			driver.findElementByAccessibilityId("Done").click();
		}
		else
		{
			driver.findElementById("payment_methods_add_payment_container").click();
			driver.findElementById("et_add_source_card_number_ml").sendKeys("4242424242424242");
			driver.findElementById("et_add_source_expiry_ml").sendKeys("0424");
			driver.findElementById("et_add_source_cvc_ml").sendKeys("242");
			driver.findElementByAccessibilityId("OK").click();
		}
		if (!isIOS)
		{
			driver.findElementById("masked_card_info_view").isDisplayed();
			driver.findElementByAccessibilityId("OK").click();
		}
		driver.findElementByAccessibilityId("confirm_payment_button").click();
	}
	
	public void checkTextContainedInHealthDialog(String text)
	{
		last_response.isDisplayed();
		checkIfTextExistsOnScreen(chatList, text);
	}
	
	public void checkTextContainedInHealthDialogBubble(String text)
	{
		if (!isIOS)
			footerContainer.isDisplayed();
		
		checkIfTextExistsOnScreen(latest_response_1, text);

//		if (!isIOS)
//			sleep(500);
	}
	
}
