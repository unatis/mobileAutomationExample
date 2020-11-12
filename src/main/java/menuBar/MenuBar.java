/**
 * Created by Shahar Sheinfeld on 17/08/2020.
 **/
package menuBar;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestHelpers;

import static org.testng.Assert.assertEquals;

public class MenuBar extends TestHelpers
{
	@AndroidFindBy(accessibility = "menu_button")
	@iOSXCUITFindBy(accessibility = "menu_button")
	MobileElement menu_button;
	
	@AndroidFindBy(accessibility = "menu.account.login")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "menu.account.login")
	MobileElement account_login;
	
	@AndroidFindBy(accessibility = "home.menu.account")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "home.menu.account")
	MobileElement menu_account;
	
	@AndroidFindBy(accessibility = "maccabi_login_button")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "maccabi_login_button")
	MobileElement maccabi_login_button;
	
	@AndroidFindBy(accessibility = "menu.account.signup")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "menu.account.signup")
	MobileElement menu_signup;
	
	@AndroidFindBy(accessibility = "account.logout")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "account.logout")
	MobileElement menu_account_logout;
	
	@AndroidFindBy(accessibility = "navigation_back")
//	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"navigation_back\"`]")
	@iOSXCUITFindBy(accessibility = "navigation_back")
	MobileElement navigation_back;
	
	
	public MenuBar(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnMenuButton()
	{
		menu_button.click();
	}
	
	public void clickOnMenuAccountLogin()
	{
		account_login.click();
	}
	
	public void clickOnMenuCreateAccount()
	{
		menu_signup.click();
	}
	
	public void clickOnMenuAccount()
	{
		menu_account.click();
	}
	
	public void checkIfMaccabiLoginButtonDisplayed()
	{
		maccabi_login_button.isDisplayed();
	}
	
	public void checkIfLogOutButtonIsDisplayed()
	{
		menu_account_logout.isDisplayed();
	}
	
	public void isMaccabiLoginButtonDisplayed(boolean shouldBeDisplayed)
	{
		boolean isDisplayed;
		isDisplayed = isMobileElementDisplayed(maccabi_login_button, 2000);
		assertEquals(isDisplayed,shouldBeDisplayed);
	}
	
	public void clickOnBackButton()
	{
		navigation_back.click();
	}
}
