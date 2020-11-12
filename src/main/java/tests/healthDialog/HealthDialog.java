/**
 * Created by  Shahar Sheinfeld on 01/01/2020.
 **/
package tests.healthDialog;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;

public class HealthDialog extends TestHelpers
{
	@AndroidFindBy(accessibility = "search_text_input")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeTextField[`name == \"search_text_input\"`]")
	@iOSXCUITFindBy(accessibility = "search_text_input")
	MobileElement searchSymptomTextBox;
	
	@AndroidFindBy(accessibility = "search_autocompletion_list")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"search_autocompletion_list\"`]")
	@iOSXCUITFindBy(accessibility = "search_autocompletion_list")
	MobileElement search_autocompletion_list;
	
	@AndroidFindBy(accessibility = "chat_header_back_button")
	@iOSXCUITFindBy(accessibility = "chat_header_back_button")
	MobileElement chat_header_back_button;
	
	@AndroidFindBy(accessibility = "footer.container")
	@iOSXCUITFindAll(value = {
			@iOSXCUITBy(accessibility = "footer.container"), @iOSXCUITBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"footer.container\"`]"), @iOSXCUITBy(iOSNsPredicate =
			"name == \"footer.container\"")
	})
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"footer.container\"`]")
//	@iOSXCUITFindBy(accessibility = "footer.container")
	MobileElement footerContainer;
	
	@AndroidFindBy(accessibility = "latest_response_1")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"latest_response_1\"`]")
	@iOSXCUITFindBy(accessibility = "latest_response_1")
	MobileElement latest_response_1;
	
	@AndroidFindBy(accessibility = "latest_response_3")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"latest_response_1\"`]")
	@iOSXCUITFindBy(accessibility = "latest_response_3")
	MobileElement latest_response_3;
	
	@AndroidFindBy(accessibility = "input_popup_container")
	@iOSXCUITFindBy(accessibility = "input_popup_container")
	MobileElement radio_button_container;
	
	@AndroidFindBy(accessibility = "first_wheel_picker")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypePicker[`name == \"first_wheel_picker\"`]")
	@iOSXCUITFindBy(accessibility = "first_wheel_picker")
	MobileElement firstWheelPicker;
	
	@AndroidFindBy(accessibility = "wheelpicker-submit")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"wheelpicker-submit\"`]")
	@iOSXCUITFindBy(accessibility = "wheelpicker-submit")
	MobileElement wheelPickerSubmit;
	
	@AndroidFindBy(accessibility = "results.assessment_card")
	@iOSXCUITFindBy(accessibility = "results.assessment_card")
	MobileElement assessment_card;
	
	@AndroidFindBy(accessibility = "coviddisclaimer_approve")
	@iOSXCUITFindBy(accessibility = "coviddisclaimer_approve")
	MobileElement coviddisclaimer_approve;
	
	@AndroidFindBy(accessibility = "yes_no_popup.no")
	@iOSXCUITFindBy(accessibility = "yes_no_popup.no")
	MobileElement No;
	
	@AndroidFindBy(accessibility = "menu_button")
	@iOSXCUITFindBy(accessibility = "menu_button")
	MobileElement menu_button;
	
	@AndroidFindBy(accessibility = "corona.labs.banner")
	@iOSXCUITFindBy(accessibility = "corona.labs.banner")
	MobileElement corona_labs_banner;
	
	@AndroidFindBy(accessibility = "chat_screen.tapToRespond")
//	@iOSXCUITFindAll(value = {
//			@iOSXCUITBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"chat_screen.tapToRespond\"`]"),
//			@iOSXCUITBy(accessibility = "chat_screen.tapToRespond"),
//			@iOSXCUITBy(iOSNsPredicate = "name == \"chat_screen.tapToRespond\"")
//	})
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"chat_screen.tapToRespond\"`]")
	@iOSXCUITFindBy(accessibility = "chat_screen.tapToRespond")
	MobileElement lastButtonInFooter;
	
	@AndroidFindBy(accessibility = "chatList")
	@iOSXCUITFindBy(accessibility = "chatList")
	MobileElement chatList;
	
	@AndroidFindBy(accessibility = "text_input_footer")
	@iOSXCUITFindBy(accessibility = "text_input_footer")
	MobileElement textInputFooter;
	
	@AndroidFindBy(accessibility = "submit_input_footer")
	@iOSXCUITFindBy(accessibility = "submit_input_footer")
	MobileElement submitInputFooter;
	
	@AndroidFindBy(accessibility = "last_answer")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"last_answer\"`]")
	@iOSXCUITFindBy(accessibility = "last_answer")
	MobileElement last_answer;
	
	@AndroidFindBy(accessibility = "symptom_search")
	@iOSXCUITFindBy(accessibility = "symptom_search")
	MobileElement symptomSearch;
	
	@AndroidFindBy(accessibility = "kmd_promo_content")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"kmd_promo_content\"`]")
	@iOSXCUITFindBy(accessibility = "kmd_promo_content")
	MobileElement kmd_promo_content;
	
	
	public HealthDialog(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clearSymptomSearchField()
	{
		searchSymptomTextBox.clear();
//		sleep(1000);
	}
	
	public void searchAndSelectSymptom(String symptom)
	{
		searchSymptomTextBox.setValue(symptom);
		String attribute = isIOS ? "name" : "content-desc";
		clickOnButtonByText(search_autocompletion_list, "option+" + symptom.toLowerCase(), attribute, false);
	}
	
	public void searchSymptom(String symptom)
	{
		searchSymptomTextBox.clear();
		searchSymptomTextBox.setValue(symptom);
		sleep(1000);
	}
	
	public void clickBackButton()
	{
		chat_header_back_button.click();
	}
	
	public void checkHealthDialogHeaderTitle(String text)
	{
		driver.findElementByAccessibilityId("header_title-" + text);
	}
	
	public void clickOnFooterButton(String buttonText, boolean clickOnAndroidByDriver)
	{
		clickOnFooterButton(buttonText, 1, clickOnAndroidByDriver);
	}
	
	public void clickOnFooterButton(String buttonText, Integer repetitions)
	{
		clickOnFooterButton(buttonText, repetitions, false);
	}
	
	public void clickOnFooterButton(String buttonText)
	{
		clickOnFooterButton(buttonText, 1, false);
	}
	
	public void clickOnFooterButton(String buttonText, Integer repetitions, Boolean clickOnAndroidByDriver)
	{
		for (int i = 0; i < repetitions; i++)
		{
			clickOnButtonByText(footerContainer, buttonText, clickOnAndroidByDriver);
		}
	}
	
	public void notificationPopup()
	{
		try
		{
			if (isIOS)
			{
				driver.findElementByAccessibilityId("chat_screen.tapToRespond").click();
//			No.click();
				sleep(500);
			}
		}
		catch (Exception e)
		{
		}
	}
	
	public void selectFromRadioButtonContainer(String buttonText)
	{
		if (!isIOS)
			radio_button_container.isDisplayed();
		
		clickOnButtonByText(radio_button_container, buttonText);
	}
	
	public void checkTextContainedInHealthDialogBubble(String text)
	{
//		if (!isIOS)
		footerContainer.isEnabled();
		
		checkIfTextExistsOnScreen(latest_response_1, text);
		sleep(500);
	}
	
	public void checkUsersLastAnswer(String text)
	{
		checkIfTextExistsOnScreen(last_answer, text);
	}
	
	public void setTemperature(String temperature)
	{
		firstWheelPicker.isDisplayed();
		setWheelPickerValue(temperature, firstWheelPicker);
		wheelPickerSubmit.click();
		
		sleep(500);
	}
	
	public void clickOnAssessmentCard()
	{
		assessment_card.click();
	}
	
	public void covidDisclaimerApprove()
	{
		coviddisclaimer_approve.click();
	}
	
	public void isTextFoundInFooterContainer(String text)
	{
		String attribute = isIOS ? "label" : "text";
		if (!isIOS)
			footerContainer.isDisplayed();
		
		checkIfMultipleStringsSeperatedByPipeFoundOnScreen(footerContainer, text, attribute);
	}
	
	public void clickOnMenuButton()
	{
		menu_button.click();
	}
	
	public void clickOnSeeLiveMapsBanner()
	{
		corona_labs_banner.click();
	}
	
	public void popup()
	{
		if (isIOS)
		{
			try
			{
				driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Allow While Using App\"`]")).click();
				driver.findElementByAccessibilityId("OK").click();
			}
			catch (Exception e)
			{
			}
//			sleep(1000);
		}
	}
	
	public void clickOnLastButtonInFooter(Integer repetitions)
	{
		for (int i = 0; i < repetitions; i++)
		{
			lastButtonInFooter.click();
			sleep(500);
		}
	}
	
	public void insertTextIntoTextField(String text)
	{
		textInputFooter.setValue(text);
		submitInputFooter.click();
		sleep(500);
	}
	
	public void runUntilTextIsDisplayedInFooterContainer(String buttonText)
	{
		String attribute1 = isIOS ? "name" : "content-desc";
		String attribute2 = isIOS ? "name" : "text";
		
		driver.findElementByAccessibilityId("chat_screen.tapToRespond");
		boolean isTextFound = checkIfTextFoundInElement(footerContainer, buttonText, attribute1);
		while (!isTextFound)
		{
			lastButtonInFooter.click();
			sleep(500);
			driver.findElementByAccessibilityId("chat_screen.tapToRespond");
			isTextFound = checkIfTextFoundInElement(footerContainer, buttonText, attribute2);
		}
	}
	
	public void runUntilBubbleWithTextIsDisplayed(String text)
	{
		String attribute1 = isIOS ? "name" : "content-desc";
		String attribute2 = isIOS ? "name" : "text";
		String iosElementType = "XCUIElementTypeStaticOther";
		String textPrefix = "\u200E";
		
		driver.findElementByAccessibilityId("chat_screen.tapToRespond");
		boolean isTextFound = checkIfTextFoundInElement(latest_response_1, textPrefix + text, attribute1, iosElementType);
		while (!isTextFound)
		{
			lastButtonInFooter.click();
			sleep(500);
			driver.findElementByAccessibilityId("chat_screen.tapToRespond");
			isTextFound = checkIfTextFoundInElement(latest_response_1, textPrefix + text, attribute2, iosElementType);
		}
	}
	
	public void checkIfTextFoundOnHealthDialogScreen(String text)
	{
		checkIfTextFoundOnScreen(text, 1, chatList);
	}
	
	public void checkIfTextFoundOnHealthDialogScreen(String text, Integer repetitions)
	{
		driver.findElementByAccessibilityId("chat_screen.tapToRespond");
		checkIfTextFoundOnScreen(text, repetitions, chatList);
	}
	
	public void checkIfHealthWarningMessageIsDisplayed(String text)
	{
		findTextInAllBubbles("\u200E" + text);
	}
	
}