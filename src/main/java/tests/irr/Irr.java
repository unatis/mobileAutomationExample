/**
 * Created by Shahar Sheinfeld on 12/07/2020.
 **/
package tests.irr;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;

public class Irr extends TestHelpers
{
	
	@AndroidFindBy(accessibility = "resultItem-0")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"resultItem-0\"`]")
	@iOSXCUITFindBy(accessibility = "resultItem-0")
	MobileElement resultItem_0;
	
	@AndroidFindBy(accessibility = "resultItem-1")
	@iOSXCUITFindBy(accessibility = "resultItem-1")
	MobileElement resultItem_1;
	
	@AndroidFindBy(accessibility = "alphaResultItem-0")
	@iOSXCUITFindBy(accessibility = "alphaResultItem-0")
	MobileElement alphaResultItem_0;
	
	@AndroidFindBy(accessibility = "alphaResultItem-1")
	@iOSXCUITFindBy(accessibility = "alphaResultItem-1")
	MobileElement alphaResultItem_1;
	
	@AndroidFindBy(accessibility = "kmd_promo_content")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"kmd_promo_content\"`]")
	@iOSXCUITFindBy(accessibility = "kmd_promo_content")
	MobileElement kmd_promo_content;
	
	public Irr(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnIrrButton(int buttonNumber)
	{
		switch (buttonNumber)
		{
			case 1:
				resultItem_0.click();
				break;
			case 2:
				resultItem_1.click();
				break;
			case 3:
				alphaResultItem_0.click();
				break;
			case 4:
				alphaResultItem_1.click();
				break;
		}
	}
	
	public void checkTextContainedInIrrButton(String text, int selectionNumber)
	{
		switch (selectionNumber)
		{
			case 1:
				if (!isIOS)
					resultItem_0.isDisplayed();
				checkIfTextExistsOnScreen(resultItem_0, text);
				break;
			case 2:
				if (!isIOS)
					resultItem_1.isDisplayed();
				checkIfTextExistsOnScreen(resultItem_1, text);
				break;
			case 3:
				if (!isIOS)
					alphaResultItem_0.isDisplayed();
				checkIfTextExistsOnScreen(alphaResultItem_0, text);
				break;
			case 4:
				if (!isIOS)
					alphaResultItem_1.isDisplayed();
				checkIfTextExistsOnScreen(alphaResultItem_1, text);
				break;
		}
	}
	
	public void clickOnCTAButton(String buttonText)
	{
		if (!isIOS)
			resultItem_0.isDisplayed();
//		kmd_promo_content.isDisplayed();
//		kmd_promo_content.isEnabled();
//		sleep(500);
		clickOnButtonByText(kmd_promo_content, buttonText);
//		sleep(500);
	}
}
