/**
 * Created by Shahar Sheinfeld on 23/12/2019.
 **/
package tests.logIn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tests.FileHelpers;
import tests.TestHelpers;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class LogIn extends TestHelpers
{
	public LogIn(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "login.email.input")
	@iOSXCUITFindBy(accessibility = "login.email.input")
	MobileElement loginEmailInput;
	
	@AndroidFindBy(accessibility = "login.with.email")
	@iOSXCUITFindBy(accessibility = "login.with.email")
	MobileElement loginWithEmail;
	
	@AndroidFindBy(accessibility = "login.next.button")
	@iOSXCUITFindBy(accessibility = "login.next.button")
	MobileElement loginNextButton;
	
	@AndroidFindBy(accessibility = "welcome.login")
	@iOSXCUITFindBy(accessibility = "welcome.login")
	MobileElement alreadyHaveKaccountButton;
	
	@AndroidFindBy(accessibility = "chat_screen.tapToRespond")
	@iOSXCUITFindBy(accessibility = "chat_screen.tapToRespond")
	MobileElement renewLogin;
	
	@AndroidFindBy(accessibility = "tos.accept")
	@iOSXCUITFindBy(accessibility = "tos.accept")
	MobileElement acceptButton;
	
	@AndroidFindBy(accessibility = "empty.chat.list.icon")
	@iOSXCUITFindBy(accessibility = "empty.chat.list.icon")
	MobileElement emptyChatListIcon;
	
	
	@AndroidFindBy(accessibility = "search_text_input")
	@iOSXCUITFindBy(accessibility = "search_text_input")
	MobileElement searchTextInput;
	
	@AndroidFindBy(accessibility = "waitForEmail")
	@iOSXCUITFindBy(accessibility = "waitForEmail")
	MobileElement waitForEmail;
	
	@AndroidFindBy(accessibility = "phone_input")
	@iOSXCUITFindBy(accessibility = "phone_input")
	MobileElement phone_input;
	
	@AndroidFindBy(accessibility = "phone_prompt_next_button")
	@iOSXCUITFindBy(accessibility = "phone_prompt_next_button")
	MobileElement phone_next_Button;
	
	@AndroidFindBy(accessibility = "meAvatar")
	@iOSXCUITFindBy(accessibility = "meAvatar")
	MobileElement meButton;
	
	
	public void goToEmailPage()
	{
		driver.get("https://login.yahoo.com/config/login?.src=fpctx&.intl=us&.lang=en-US&.done=https://mail.yahoo" +
						   ".com");
	}
	
	public void seBrowsertEmailAddress(String email)
	{
		waitForVisibility(By.id("login-username")).clear();
		waitForVisibility(By.id("login-username")).sendKeys(email);
		waitForClickabilityAndClick(By.name("signin"));
	}
	
	public void setBrowserEmailPassword(String password)
	{
		if (isIOS)
		{
			waitForVisibility(By.id("login-passwd")).sendKeys(password);
		}
		else
			waitForVisibility(By.id("login-passwd")).sendKeys(password);
		waitForClickabilityAndClick(By.name("verifyPassword"));
	}
	
	public void deleteAllEmails()
	{
		waitForVisibility(By.xpath("//*[@data-test-id='header-status-text']"));
		if (!driver.findElementsByXPath("//button[@data-test-id='icon-btn-checkbox']").isEmpty())
		{
			List<WebElement> elements = driver.findElementsByXPath("//button[@data-test-id='icon-btn-checkbox']");
			{
				elements.forEach(e -> e.click());
			}
			waitForClickabilityAndClick(By.xpath("//button[@data-test-id='contextual-delete']"));
		}
	}
	
	public void alreadyHaveKaccountButton()
	{
		alreadyHaveKaccountButton.click();
//		if (!isIOS)
//			sleep(500);
//		waitForClickabilityAndClick(alreadyHaveKaccountButton);
	}
	
	public void clickOnLoginWithEmailLink()
	{
		waitForClickabilityAndClick(loginWithEmail);
	}
	
	public void setEmailAddress(String email)
	{
		waitForVisibility(loginEmailInput).setValue(email);
	}
	
	public void clickNextButton() throws InterruptedException
	{
		waitForClickabilityAndClick(loginNextButton);
	}
	
	public void clickOnAcceptButton()
	{
		acceptButton.click();
//		if (!isIOS)
//			sleep(500);
//		waitForClickabilityAndClick(acceptButton);
	}
	
	public void openEmailLinkToApp() throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(3);
//		Thread.sleep(3000);
		driver.navigate().refresh();
		waitForClickabilityAndClick(By.xpath("//a[@data-test-id='message-item-main-content']"));
		if (isIOS)
		{
			String href = waitForVisibility(By.xpath("//a[contains(@href,'.khealth.xyz/app/login_email')]")).getAttribute("href");
			driver.get(href);
		}
		else
		{
			waitForClickabilityAndClick(By.xpath("//a[contains(@href,'.khealth.xyz/app/login_email')]"));
			driver.context("NATIVE_APP");
			if (waitForVisibility(By.id("android:id/button_once")).isEnabled())
			{
				if (waitForVisibility(By.id("android:id/title")).getText().contains("with K"))
					waitForClickabilityAndClick(By.id("android:id/button_once"));
				else
					waitForClickabilityAndClick(By.id("android:id/text1"));
			}
			else
			{
				if (waitForVisibility(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android" +
													   ".widget.FrameLayout/android.widget.ScrollView/android.widget" +
													   ".ListView/android.widget.LinearLayout[1]/android.widget" +
													   ".LinearLayout/android.widget.TextView")).getText().contains("K"))
					waitForClickabilityAndClick(By.xpath("//android.widget.FrameLayout/android.widget" +
																 ".LinearLayout/android.widget.FrameLayout/android" +
																 ".widget.ScrollView/android.widget.ListView/android" +
																 ".widget.LinearLayout[1]/android.widget" +
																 ".LinearLayout/android.widget.TextView"));
				else
					waitForClickabilityAndClick(By.xpath("//android.widget.FrameLayout/android.widget" +
																 ".LinearLayout/android.widget.FrameLayout/android" +
																 ".widget.ScrollView/android.widget.ListView/android" +
																 ".widget.LinearLayout[2]/android.widget" +
																 ".LinearLayout/android.widget.TextView"));
				
				waitForClickabilityAndClick(By.id("android:id/button_once"));
			}
		}
	}
	
	public void switchToNativeApp()
	{
		driver.activateApp(FileHelpers.appPackageName);
		driver.context("NATIVE_APP");
	}
	
	public void switchToBrowser() throws InterruptedException
	{
		if (isIOS)
			driver.activateApp("com.apple.mobilesafari");
		else
			driver.activateApp("com.android.chrome");
		while (driver.getContextHandles().size() != 2)
		{
			TimeUnit.SECONDS.sleep(1);
//			Thread.sleep(1000);
		}
		driver.context(setWebViewContext());
	}
	
	public void insertPhoneNumber(String phone)
	{
		phone_input.clear();
		phone_input.setValue(phone);
		phone_next_Button.click();
	}
	
	public void insertCode(String phone)
	{
		String attribute = isIOS ? "name" : "content-desc";
		for (int i = 1; i <= phone.length(); i++)
		{
			String num = String.valueOf(phone.charAt(i-1));
			driver.findElementByXPath("(//*[@" + attribute + "=\"code_input_field\"])[" + i + "]").sendKeys(num);
		}
	}
	
	public void isMeButtonDisplayed()
	{
		meButton.isDisplayed();
	}
	
	public void clickAllowNotificationPopUp()
	{
		allowNotificationPopUp();
	}
	
	
	public void verifySearchSymptomWindow()
	{
		waitForVisibility(searchTextInput);
	}
	
	public void isTextFoundOnEmailScreen(String text)
	{
		try
		{
			TimeUnit.SECONDS.sleep(2);
//			Thread.sleep(2000);
		}
		catch (Exception e)
		{
		}
		checkIfTextFoundOnScreen(text, 1, waitForEmail);
	}
}
