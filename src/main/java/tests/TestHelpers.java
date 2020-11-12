/**
 * Created by Shahar Sheinfeld on 02/12/2019.
 **/
package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.apache.maven.shared.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.appium.java_client.MobileBy.iOSClassChain;
import static org.testng.Assert.assertEquals;

public class TestHelpers extends TestSetup
{
	
	public boolean isIOS = TestSetup.isIos;
//	public int defaultWaitTime = 20;
	//    public int defaultWaitTime = isIOS ? 25 : 15;
	
	protected AppiumDriver driver = TestSetup.driver;
	
	
	protected void implicitWait(Integer milliseconds)
	{
		driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
	}
	
	protected MobileElement waitForVisibility(By locator)
	{
		return waitForVisibility(locator, defaultWaitTime);
	}
	
	protected MobileElement waitForVisibility(By locator, int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return (MobileElement) driver.findElement(locator);
	}
	
	protected void waitForInvisibility(By locator)
	{
		waitForInvisibility(locator, defaultWaitTime);
	}
	
	protected void waitForInvisibility(By locator, int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	protected MobileElement waitForVisibility(WebElement element)
	{
		return waitForVisibility(element, defaultWaitTime);
	}
	
	protected MobileElement waitForVisibility(WebElement element, int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		return (MobileElement) element;
	}
	
	protected void waitForInvisibility(WebElement element)
	{
		waitForInvisibility(element, defaultWaitTime);
	}
	
	protected void waitForInvisibility(WebElement element, int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected void waitForClickabilityAndClick(By locator)
	{
		waitForClickabilityAndClick(locator, defaultWaitTime);
		if (!isIOS)
			sleep(1000);
	}
	
	protected By waitForClickability(By locator)
	{
		return waitForClickability(locator, defaultWaitTime);
	}
	
	protected void waitForClickabilityAndClick(WebElement locator)
	{
		waitForClickabilityAndClick(locator, defaultWaitTime);
		if (!isIOS)
			sleep(1000);
	}
	
	
	protected void waitForClickabilityAndClick(By locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	protected By waitForClickability(By locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return (locator);
	}
	
	
	protected MobileElement waitForClickability(WebElement locator)
	{
		return waitForClickability(locator, defaultWaitTime);
	}
	
	
	protected void waitForClickabilityAndClick(WebElement locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	
	protected MobileElement waitForClickability(WebElement locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return (MobileElement) locator;
	}
	
	protected void setWheelPickerValue(String valueToSelect, MobileElement wheelPicker)
	{
		if (isIos)
		{
			WebElement xcuiElementTypePickerWheel = wheelPicker.findElementByClassName("XCUIElementTypePickerWheel");
			while (!(xcuiElementTypePickerWheel.getAttribute("value").equals(valueToSelect)))
			{
				xcuiElementTypePickerWheel.sendKeys(valueToSelect);
			}
		}
		else
			wheelPicker.setValue(valueToSelect);
	}
	
	protected void waitForAlertToShow(AppiumDriver driver)
	{
		new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
	}
	
	protected void resetApp()
	{
		if (isIOS)
			driver.resetApp();
		else
		{
			driver.closeApp();
			driver.activateApp(FileHelpers.appPackageName);
		}
	}
	
	protected AppiumDriver newIOSDriverWithCapability(DesiredCapabilities capability)
	{
		if (isIos)
		{
			try
			{
				driver.quit();
				DesiredCapabilities capabilities = capability;
				driver = new IOSDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(defaultWaitTime, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	protected void checkIfMultipleStringsSeperatedByPipeFoundOnScreen(MobileElement element, String text, String attribute)
	{
		String[] expectedTextArray = text.split("\\|");
		for (int i = 0; i < expectedTextArray.length; i++)
		{
			if (isIOS)
				driver.findElement(iOSClassChain("**/XCUIElementTypeStaticText[`" + attribute + " == \"" + expectedTextArray[i] + "\"`]"));
			else
				element.findElementByXPath("//*[@" + attribute + "=\"" + expectedTextArray[i] + "\"]");
//			element.findElementByXPath("//*[contains(@" + androidAttribute + ", \"" + expectedTextArray[i] + "\")]");
		}
//		}
	}
	
	protected boolean checkIfTextFoundInElement(MobileElement element, String text, String attribute)
	{
		return checkIfTextFoundInElement(element, text, attribute, "XCUIElementTypeStaticText");
	}
	
	protected boolean checkIfTextFoundInElement(MobileElement element, String text, String attribute, String iosElementType)
	{
		implicitWait(0);
		try
		{
			if (isIOS)
				element.findElement(iOSClassChain("**/" + iosElementType + "[`" + attribute + " == \"" + text + "\"`]"));
			else
				element.findElementByXPath("//*[@" + attribute + "=\"" + text + "\"]");
		}
		catch (Exception e)
		{
			implicitWait(defaultWaitTime);
			return false;
		}
		implicitWait(defaultWaitTime);
		return true;
	}
	
	
	protected Boolean checkIfTextFoundOnScreen(String text, Integer repetition, MobileElement element)
	{
		Integer repetitionOfFoundText;
		String[] expectedTextArray = text.split(",");
		String screenText = null;
		
		if (isIOS)
			screenText = element.getText();
		
		for (int i = 0; i < expectedTextArray.length; i++)
		{
			if (isIOS)
				repetitionOfFoundText = StringUtils.countMatches(screenText, expectedTextArray[i]);
			else
				repetitionOfFoundText = element.findElements(By.xpath("//*[contains(@text,'" + expectedTextArray[i] + "')]")).size();
			
			assertEquals(repetitionOfFoundText, repetition);
		}
		return true;
	}
	
	protected void checkIfTextExistsOnScreen(MobileElement element, String text)
	{
		String attribute = isIOS ? "label" : "text";
		if (isIOS)
			driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@" + attribute + ", \"" + text + "\")]");
		else
			element.findElementByXPath("//*[contains(@" + attribute + ", \"" + text + "\")]");
	}
	
	protected void checkIfTextEqualsToTextOnScreen(MobileElement element, String text)
	{
		String attribute = isIOS ? "label" : "text";
		if (isIOS)
			driver.findElement(iOSClassChain("**/XCUIElementTypeStaticText[`" + attribute + " == \"" + text + "\"`]"));
		else
			element.findElementByXPath("//*[@" + attribute + "=\"" + text + "\"]");
	}

//	protected void checkIfTextContainedOnScreen(MobileElement locator, String buttonText)
//	{
//		String attribute = isIOS ? "name" : "text";
//		locator.getWrappedDriver().findElement(By.xpath("//*[@" + attribute + "=\"" + buttonText + "\"]"));
//	}
	
	protected void changeChatInputText(String textToChange, String textToChangeTo, MobileElement elem)
	{
		clickOnChatText(textToChange);
		waitForVisibility(elem).setValue(textToChangeTo);
	}
	
	protected void clickOnChatText(String textToChange)
	{
		String attribute = isIOS ? "label" : "text";
		driver.findElementByXPath("//*[@" + attribute + "=\"" + textToChange + "\"]");
	}
	
	protected void clickOnButtonByText(MobileElement element, String buttonText, boolean clickOnAndroidByDriver)
	{
		String attribute = isIOS ? "label" : "text";
		clickOnButtonByText(element, buttonText, attribute, clickOnAndroidByDriver);
	}
	
	protected void clickOnButtonByText(MobileElement element, String buttonText)
	{
		String attribute = isIOS ? "label" : "text";
		clickOnButtonByText(element, buttonText, attribute, false);
	}
	
	protected void clickOnButtonByTextContained(MobileElement element, String buttonText)
	{
		String attribute = isIOS ? "label" : "text";
		clickOnButtonByTextContained(element, buttonText, attribute);
	}
	
	protected void clickOnButtonByText(MobileElement element, String buttonText, String attribute, boolean clickOnAndroidByDriver)
	{
		if (isIOS)
			driver.findElement(iOSClassChain("**/*[`" + attribute + " == \"" + buttonText + "\"`]")).click();
		else
		{
			if (clickOnAndroidByDriver)
				driver.findElementByXPath("//*[@" + attribute + "=\"" + buttonText + "\"]").click();
			else
				element.findElementByXPath("//*[@" + attribute + "=\"" + buttonText + "\"]").click();
		}
		sleep(500);
	}
	
	
	protected void clickOnButtonByTextContained(MobileElement element, String buttonText, String attribute)
	{
		String xpath = "//*[contains(@" + attribute + ", \"" + buttonText + "\")]";
		if (isIOS)
			driver.findElementByXPath(xpath).click();
		else
			element.findElementByXPath(xpath).click();
		sleep(500);
	}
	
	public void sleep(int milliseconds)
	{
		try
		{
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		}
		catch (Exception e)
		{
		}
	}
	
	protected void waitWhileElementIsDisplayed(MobileElement element, int secondsToWait)
	{
		for (int i = 0; i < secondsToWait; i++)
		{
			try
			{
				if (element.isDisplayed())
					TimeUnit.SECONDS.sleep(1);
//					Thread.sleep(1000);
			}
			catch (NoSuchElementException | InterruptedException e)
			{
				break;
			}
		}
	}
	
	protected void allowNotificationPopUp()
	{
		waitForAlertToShow(driver);
		driver.switchTo().alert().accept();
	}
	
	protected void allowNotificationPopUp2()
	{
		waitForAlertToShow(driver);
	}
	
	public String setWebViewContext()
	{
		while (driver.getContextHandles().size() != 2)
		{
			sleep(1000);
		}
		
		String webViewContext = null;
		Object[] contextNames = driver.getContextHandles().toArray();
		for (int i = 1; i < contextNames.length; i++)
		{
			if (contextNames[i].toString().contains("WEBVIEW_"))
				webViewContext = contextNames[i].toString();
		}
		return webViewContext;
	}
	
	protected void verifyButtonSelectedFromHealthDialogScreen(String buttonTextExpected, Integer xpathButtonAnswerLineNumber)
	{
		String buttonTextFromScreen;
		if (isIOS)
		{
			buttonTextFromScreen = driver.findElementByXPath("(//XCUIElementTypeOther[@name=\"" + buttonTextExpected + "\"])[3]").getText();
		}
		else
		{
			buttonTextFromScreen = driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"chat_bubble\"])[" + xpathButtonAnswerLineNumber + "]/android.widget.TextView").getText();
		}
		assertEquals(buttonTextFromScreen, buttonTextExpected);
	}
	
	protected void selectAbdomDiagram(String text)
	{
		switch (text.toLowerCase())
		{
			case "lower abdom":
			{
				if (isIOS)
					driver.findElementByXPath("//XCUIElementTypeOther[2]/XCUIElementTypeOther[7]").click();
				else
					driver.findElementByXPath("//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView").click();
				
				MobileElement elem = waitForVisibility(AccessibilityId("rootContainer"));
				checkIfTextFoundOnScreen("Lower abdomen", 1, elem);
			}
		}
	}
	
	protected boolean isMobileElementDisplayed(MobileElement element, Integer millisecondsToWait)
	{
		implicitWait(millisecondsToWait);
		try
		{
			element.isDisplayed();
			implicitWait(defaultWaitTime);
			return true;
		}
		catch (NoSuchElementException e)
		{
			implicitWait(defaultWaitTime);
			return false;
		}
	}
	
	public void findTextInAllBubbles(String text)
	{
		Boolean found = false;
		MobileElement elem;
		String attribute = isIOS ? "name" : "text";
		driver.findElementByAccessibilityId("chat_screen.tapToRespond");
		implicitWait(0);
		for (int i = 3; i > 0; i--)
		{
			try
			{
				elem = (MobileElement) driver.findElementByAccessibilityId("latest_response_" + i);
				found = checkIfTextFoundInElement(elem, text, attribute, "XCUIElementTypeStaticText");
			}
			catch (Exception e)
			{
			}
			if (found)
				break;
		}
		implicitWait(defaultWaitTime);
		if (!found)
			Assert.fail("The test failed since the text: \"" + text + "\": was not found on screen");
	}
	
}
