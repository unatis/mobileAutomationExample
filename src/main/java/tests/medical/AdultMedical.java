/**
 * Created by Shahar Sheinfeld on 22/03/2020.
 **/
package tests.medical;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import tests.FileHelpers;
import tests.TestHelpers;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.appium.java_client.MobileBy.ByAccessibilityId;
import static org.testng.Assert.assertEquals;

public class AdultMedical extends TestHelpers
{
	@AndroidFindBy(accessibility = "search_autocompletion_list")
	@iOSXCUITFindBy(accessibility = "search_autocompletion_list")
	MobileElement search_autocompletion_list;
	
	@AndroidFindBy(accessibility = "footer.container")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"footer.container\"`]")
	@iOSXCUITFindBy(accessibility = "footer.container")
	MobileElement footerContainer;
	
	@AndroidFindBy(accessibility = "chat_screen.tapToRespond")
	@iOSXCUITFindBy(accessibility = "chat_screen.tapToRespond")
	MobileElement lastButtonInFooter, notification_yes_button;
	
	@AndroidFindBy(accessibility = "chatList")
	@iOSXCUITFindBy(accessibility = "chatList")
	MobileElement chatList;
	
	@AndroidFindBy(accessibility = "kmd_promo_button")
	@iOSXCUITFindBy(accessibility = "kmd_promo_button")
	MobileElement kmd_promo_button;
	
	@AndroidFindBy(accessibility = "next.dontknow")
	@iOSXCUITFindBy(accessibility = "next.dontknow")
	MobileElement next_dont_know;
	
	@AndroidFindBy(accessibility = "latest_response_1")
//	@iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeOther[`name == \"latest_response_1\"`]")
	@iOSXCUITFindBy(accessibility = "latest_response_1")
	MobileElement latest_response_1;
	
	@AndroidFindBy(accessibility = "yes_no_popup.no")
	@iOSXCUITFindBy(accessibility = "yes_no_popup.no")
	MobileElement No;
	
	
	public AdultMedical(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void checkIfTextFoundOnSymptomSearchScreen(String text)
	{
		checkIfMultipleStringsSeperatedByPipeFoundOnScreen(search_autocompletion_list, "option+" + text.toLowerCase(), "content-desc");
	}
	
	public void checkIfTextFoundOnSymptomSearchScreen(String text, Integer repetitions)
	{
		String[] expectedTextArray = text.split(",");
		waitForClickability(new ByAccessibilityId("option+" + expectedTextArray[0].toLowerCase()));
		checkIfTextFoundOnScreen(text, repetitions, search_autocompletion_list);
	}
	
	
	public void checkTextContainedInHealthDialogBubble(String text)
	{
		if (!isIOS)
			footerContainer.isDisplayed();
		
		checkIfTextExistsOnScreen(latest_response_1, text);
		
//		if (!isIOS)
//			sleep(500);
	}

	
	public void isTextFoundInFooterContainer(String text)
	{
		String attribute = isIOS ? "label" : "text";
		if (!isIOS)
			footerContainer.isDisplayed();
		
		checkIfMultipleStringsSeperatedByPipeFoundOnScreen(footerContainer, text, attribute);
	}
	
	public void checkTextExistsInHealthDialogFooterContainer(String text)
	{
		if (!isIOS)
			footerContainer.isDisplayed();
		checkIfTextExistsOnScreen(footerContainer, text);
	}
	
	public void checkIfTextFoundOnHealthDialogScreen(String text)
	{
		waitForVisibility(lastButtonInFooter);
		checkIfTextFoundOnScreen(text, 1, latest_response_1);
	}
	
	public void checkIfTextFoundOnHealthDialogScreen(String text, Integer textRepetitions)
	{
		waitForClickability(lastButtonInFooter);
		checkIfTextFoundOnScreen(text, textRepetitions, chatList);
	}
	
	
	public void checkIfTextFoundOnHealthDialogScreen(String text, String buttonToWaitFor)
	{
		waitForClickability(new ByAccessibilityId(buttonToWaitFor));
		checkIfTextFoundOnScreen(text, 1, chatList);
	}
	
	public void buttonSelect(FileHelpers.buttons button)
	{
		driver.findElement(new ByAccessibilityId(button.toString())).click();
	}
	
	public void buttonSelect(By button)
	{
		waitForClickabilityAndClick(new ByAccessibilityId(button.toString()));
	}
	
	public void buttonSelect(String button)
	{
		waitForClickabilityAndClick(new ByAccessibilityId(button));
	}
	
	public void verifyButtonSelected(String expectedButtonText)
	{
		verifyButtonSelected(expectedButtonText, 1);
	}
	
	public void verifyButtonSelected(String expectedButtonText, Integer xpathButtonAnswerLineNumber)
	{
		waitForClickability(lastButtonInFooter);
		if (!isIOS)
		{
			try
			{
				TimeUnit.SECONDS.sleep(1);
//				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		verifyButtonSelectedFromHealthDialogScreen("\u200E" + expectedButtonText, xpathButtonAnswerLineNumber);
	}
	
	public void verifyButtonSelectedOnBubbleNumber(String expectedButtonText, Integer bubbleNumber)
	{
		String firstIosAnswerAddedText = "Tap an answer to edit ";
		waitForClickability(footerContainer);
		if (isIOS)
			expectedButtonText = firstIosAnswerAddedText + "\u200E" + expectedButtonText;
		else
			expectedButtonText = "\u200E" + expectedButtonText;
		verifyButtonSelectedFromHealthDialogScreen(expectedButtonText, bubbleNumber);
	}
	
	public void checkIfTextInFooterContainer(String text)
	{
		waitForVisibility(lastButtonInFooter);
		checkIfTextFoundOnScreen(text, 1, footerContainer);
	}
	
	public void clickOnFooterButton(String buttonText)
	{
//		if (!isIOS)
//			footerContainer.isDisplayed();
		clickOnButtonByText(footerContainer, buttonText);

//		if (!isIOS)
//			sleep(500);
	}
	
	
	public void clickOnImageNumberInFooterContainer(Integer imageNumberCountingFromLeft, String textUnderImage)
	{
		if (isIOS)
		{
			waitForClickabilityAndClick(By.xpath("//XCUIElementTypeOther[@name=\"" + textUnderImage + "\"]"));
		}
		else
			waitForClickabilityAndClick(By.xpath("//android.view.ViewGroup[@content-desc=\"footer.container\"]/android.view.ViewGroup[" + imageNumberCountingFromLeft + "]"));
	}
	
	
	public void notificationPopup()
	{
		if (isIOS)
			No.click();
	}
	
	
	public void allowIosNotification()
	{
		if (isIOS)
		{
			waitForClickabilityAndClick(notification_yes_button);
			allowNotificationPopUp2();
		}
	}
	
	public void checkTextOnButton(String button, String text)
	{
		waitForVisibility(new ByAccessibilityId(button));
		String actualButtonText = driver.findElementByAccessibilityId(button).getText();
		assertEquals(actualButtonText, text);
	}
	
	public void checkResultScreen(String text, Integer itemNumber)
	{
		MobileElement elem = waitForVisibility(AccessibilityId("resultItem-" + itemNumber));
		checkIfTextFoundOnScreen(text, 1, elem);
	}
	
	public void checkResultScreen(String text, Integer itemNumber, Integer itemRepetition)
	{
		MobileElement elem = waitForVisibility(AccessibilityId("resultItem-" + itemNumber));
		checkIfTextFoundOnScreen(text, itemRepetition, elem);
	}
	
	
	public void checkResultScreenAlpha(String text, Integer itemNumber)
	{
		MobileElement elem = waitForVisibility(AccessibilityId("alphaResultItem-" + itemNumber));
		checkIfTextFoundOnScreen(text, 1, elem);
	}
	
	public void selectAbdomAreaInDiagram(String text)
	{
		waitForClickability(next_dont_know);
		selectAbdomDiagram(text);
	}
	
}
