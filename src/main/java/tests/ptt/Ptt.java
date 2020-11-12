/**
 * Created by Shahar Sheinfeld on 12/07/2020.
 **/
package tests.ptt;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;

public class Ptt extends TestHelpers
{
	@AndroidFindBy(accessibility = "ptt-menu-0")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ptt-menu-0\"`]")
	@iOSXCUITFindBy(accessibility = "ptt-menu-0")
	MobileElement ptt_menu_0;
	
	@AndroidFindBy(accessibility = "ptt-menu-1")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ptt-menu-1\"`]")
	@iOSXCUITFindBy(accessibility = "ptt-menu-1")
	MobileElement ptt_menu_1;
	
	@AndroidFindBy(accessibility = "ptt-menu-2")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ptt-menu-2\"`]")
	@iOSXCUITFindBy(accessibility = "ptt-menu-2")
	MobileElement ptt_menu_2;
	
	@AndroidFindBy(accessibility = "ptt-menu-3")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ptt-menu-3\"`]")
	@iOSXCUITFindBy(accessibility = "ptt-menu-3")
	MobileElement ptt_menu_3;
	
	@AndroidFindBy(accessibility = "ptt.menu")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"ptt.menu\"`]")
	@iOSXCUITFindBy(accessibility = "pttscroll")
	MobileElement ptt_menu;
	
	@AndroidFindBy(accessibility = "navigation_back")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "navigation_back")
	MobileElement back_erow;
	
	
	public Ptt(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void checkIfTextFoundOnSelectionX(String text, int selectionNumber)
	{
		switch (selectionNumber)
		{
			case 1:
				if (!isIOS)
					ptt_menu_0.isDisplayed();
				checkIfTextExistsOnScreen(ptt_menu_0, text);
				break;
			case 2:
				if (!isIOS)
					ptt_menu_1.isDisplayed();
				checkIfTextExistsOnScreen(ptt_menu_1, text);
				break;
			case 3:
				if (!isIOS)
					ptt_menu_2.isDisplayed();
				checkIfTextExistsOnScreen(ptt_menu_1, text);
				break;
			case 4:
				if (!isIOS)
					ptt_menu_3.isDisplayed();
				checkIfTextExistsOnScreen(ptt_menu_1, text);
				break;
		}
	}
	
	public void checkTextFoundOnPttScreen(String text)
	{
		checkIfTextExistsOnScreen(ptt_menu, text);
	}
	
	public void clickBackErow()
	{
		back_erow.click();
	}
}
