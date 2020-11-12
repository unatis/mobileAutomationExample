/**
 * Created by Shahar Sheinfeld on 01/12/2019.
 **/
package tests.onBoarding;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;

import java.util.Calendar;

import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.appium.java_client.MobileBy.ByAccessibilityId;

public class OnBoarding extends TestHelpers
{
	
	@AndroidFindBy(accessibility = "welcome.new")
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"welcome.new\"`]")
//	@iOSXCUITFindBy(accessibility = "welcome.new")
	MobileElement startButton;
	
	@AndroidFindBy(accessibility = "tos.accept")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"tos.accept\"`]")
	@iOSXCUITFindBy(accessibility = "tos.accept")
	MobileElement acceptButton;
	
	@AndroidFindBy(accessibility = "text_input_footer")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"text_input_footer\"`]")
	@iOSXCUITFindBy(accessibility = "text_input_footer")
	MobileElement setUserName;
	
	@AndroidFindBy(accessibility = "submit_input_button")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"submit_input_button\"`]")
	@iOSXCUITFindBy(accessibility = "submit_input_button")
	MobileElement submitInput;
	
	@AndroidFindBy(accessibility = "option_0")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Male\"`]")
	@iOSXCUITFindBy(accessibility = "option_0")
	MobileElement male;
	
	@AndroidFindBy(accessibility = "chat_screen.tapToRespond")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"chat_screen.tapToRespond\"`]")
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
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeTextField[`name == \"email_input_footer\"`]")
	@iOSXCUITFindBy(accessibility = "email_input_footer")
	MobileElement email;
	
	@AndroidFindBy(accessibility = "cancel_search")
	@iOSXCUITFindBy(accessibility = "cancel_search")
	MobileElement cancelSearch;
	
	
	@AndroidFindBy(accessibility = "footer.container")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"footer.container\"`]")
	@iOSXCUITFindBy(accessibility = "footer.container")
	MobileElement footerContainer;
	
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
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"symptom_search\"`]")
//	@iOSXCUITFindBy(accessibility = "symptom_search")
	MobileElement symptomSearch;
	
	@AndroidFindBy(accessibility = "menu_button")
	@iOSXCUITFindBy(accessibility = "menu_button")
	MobileElement menu_button;
	
	@AndroidFindBy(accessibility = "language.button")
	@iOSXCUITFindBy(accessibility = "language.button")
	MobileElement language_button;
	
	@AndroidFindBy(accessibility = "navigation_back")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "navigation_back")
	MobileElement navigation_back;
	
	@AndroidFindBy(accessibility = "home.menu.account")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "home.menu.account")
	MobileElement home_menu_account;
	
	@AndroidFindBy(accessibility = "chat_header_back_button")
	@iOSXCUITFindBy(accessibility = "chat_header_back_button")
	MobileElement chat_header_back_button;
	
	public OnBoarding(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void sleep(Integer sleepTimeInMilliseconds)
	{
		sleep(sleepTimeInMilliseconds);
	}
	
	public void clickOnStartButton()
	{
//		implicitWait(45000);
		startButton.click();
//		implicitWait(defaultWaitTime);
	}
	
	public void clickOnAcceptButton()
	{
		acceptButton.click();
	}
	
	public void clickOnSureLetsStart()
	{
		waitForClickabilityAndClick(sure_lets_start);
	}
	
	public void setName(String name)
	{
		setUserName.setValue(name);
		submitInput.click();
	}
	
	public void selectMaleOrFemale(String maleOrFemale)
	{
		switch (maleOrFemale.toLowerCase())
		{
			case "male":
//				clickOnButtonByText(footerContainer,"Male");
				male.click();
				break;
			case "female":
//				clickOnButtonByText(footerContainer,"Female");
				female.click();
		}
	}
	
	public void selectOnBoardigButtonSelection(String button)
	{
		waitForVisibility(footerContainer);
		waitForClickabilityAndClick(new ByAccessibilityId(button));
	}
	
	public void setYear(String year)
	{
		setWheelPickerValue(year, firstWheelPicker);
		wheelPickerSubmit.click();
		sleep(500);
	}
	
	public void checkCurrentYearMinus18Exists()
	{
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		setYear(String.valueOf(year - 18));
		checkUsersLastAnswer(String.valueOf(year - 18));
	}
	
	public void checkUsersLastAnswer(String text)
	{
		checkIfTextExistsOnScreen(last_answer, text);
	}
	
	public void changeYear(String yearToChange, String yearToChangeTo)
	{
		clickOnChatText("\u200E" + yearToChange);
//		waitForVisibility(wheelPicker);
		firstWheelPicker.isDisplayed();
		setWheelPickerValue(yearToChangeTo, firstWheelPicker);
		setWheelPickerValue(yearToChangeTo, firstWheelPicker);
		wheelPickerSubmit.click();
//		waitForClickabilityAndClick(wheelPickerSubmit);
	}
	
	public void setEmail(String emailAddress)
	{
		email.setValue(emailAddress);
		submitInput.click();
	}
	
	public void closePopUp()
	{
		if (isIOS)
			driver.context(setWebViewContext());
		else
			driver.context(setWebViewContext());
		
		waitForClickabilityAndClick(By.xpath("//div/a"), 5);
		driver.context("NATIVE_APP");
	}
	
	public void clickSymptomSearch()
	{
		symptomSearch.click();
	}
	
	public void isTextFoundOnOnBoardingScreen(String text)
	{
		waitForClickability(footerContainer);
		checkIfTextFoundOnScreen(text, 1, chatList);
	}
	
	public void isTextFoundOnOnBoardingScreen(String text, Integer repetitions)
	{
		waitForClickability(footerContainer);
		checkIfTextFoundOnScreen(text, repetitions, chatList);
	}
	
	public void changeChatNameValue(String nameToChange, String nameToChangeTo)
	{
		String newNameToChange;
		if (isIOS)
			newNameToChange = "Tap an answer to edit \u200E" + nameToChange;
		else
			newNameToChange = "\u200E" + nameToChange;
		changeChatInputText(newNameToChange, nameToChangeTo, setUserName);
//        submitInput.click();
		waitForClickabilityAndClick(submitInput);
	}
	
	public void changeChatEmailValue(String emailToChange, String emailToChangeTo)
	{
		String newEmailToChange;
		newEmailToChange = "\u200E" + emailToChange;
		
		waitForVisibility(symptomSearch);
		changeChatInputText(newEmailToChange, emailToChangeTo, email);
		waitForClickabilityAndClick(submitInput);
	}
	
	public void changeChatGender(String genderBeforeChange, String genderAfterChange)
	{
		MobileElement gender;
		if (genderAfterChange.toLowerCase().equals("female"))
			gender = female;
		else
			gender = male;
		
		clickOnChatText("\u200E" + genderBeforeChange);
		waitForClickabilityAndClick(gender);
	}
	
	public void cancelSymptomSearch()
	{
		cancelSearch.click();
//		waitForClickabilityAndClick(cancelSearch);
//		waitWhileElementIsDisplayed(cancelSearch, 5);
	}
	
	public void clickOnMeButton()
	{
		waitForClickabilityAndClick(meButton);
		waitForVisibility(screenMe);
	}
	
	
	public void coronaVirusAssesment()
	{
		if (isIOS)
			driver.context(setWebViewContext());
		else
			driver.context(setWebViewContext());
		
		waitForClickabilityAndClick(By.tagName("Button"));
		driver.context("NATIVE_APP");
		waitForClickabilityAndClick(AccessibilityId("coviddisclaimer_approve"));
		for (int i = 0; i < 5; i++)
		{
			waitForClickabilityAndClick(no);
		}
		waitForClickabilityAndClick(show_results);
		waitForClickabilityAndClick(get_started);
	}
	
	public void onBoard(String name, String gender, String year, String email)
	{
		clickOnStartButton();
		clickOnAcceptButton();
		setName(name);
		selectMaleOrFemale(gender);
		setYear(year);
		setEmail(email);
//		closePopUp();
	}
	
	public void checkMenuButtonDisplayed()
	{
		menu_button.isDisplayed();
	}
	
	public void navigateBackErow()
	{
		chat_header_back_button.click();
	}

//	public void checkEmailValidationErrorTextPresent() {
//		assertTextFromMobileElement(footerContainer, "This is not a valid email");
//	}
	
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
	
	public void clickOnMenuAccountButton()
	{
		home_menu_account.click();
	}
	
}
